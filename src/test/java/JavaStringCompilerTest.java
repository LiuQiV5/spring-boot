import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.liuqi.springboot.Application;
import com.liuqi.springboot.SpringUtil;
import compiler.JavaStringCompiler;
import on.the.fly.BeanProxy;
import on.the.fly.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class JavaStringCompilerTest {

    JavaStringCompiler compiler;

    private SessionFactory sessionFactory;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    private List<SessionFactory> sessionFactoryList = new ArrayList<SessionFactory>();

    @Before
    public void setUp() throws Exception {
        compiler = new JavaStringCompiler();
        sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }

    static final String SINGLE_JAVA = "/* a single java class to one file */  "
            + "package on.the.fly;                                            "
            + "public class UserProxy extends User implements BeanProxy {     "
            + "    boolean _dirty = false;                                    "
            + "    public void setId(String id) {                             "
            + "        super.setId(id);                                       "
            + "        setDirty(true);                                        "
            + "    }                                                          "
            + "    public void setName(String name) {                         "
            + "        super.setName(name);                                   "
            + "        setDirty(true);                                        "
            + "    }                                                          "
            + "    public void setCreated(long created) {                     "
            + "        super.setCreated(created);                             "
            + "        setDirty(true);                                        "
            + "    }                                                          "
            + "    public void setDirty(boolean dirty) {                      "
            + "        this._dirty = dirty;                                   "
            + "    }                                                          "
            + "    public boolean isDirty() {                                 "
            + "        return this._dirty;                                    "
            + "    }                                                          "
            + "}                                                              ";


    static final String JPA_JAVA = "/* a jpa java class to one file */  "
            + "package on.the.fly;                                            "
            + "import java.io.Serializable;                            "
            + "import javax.persistence.*;                            "
            + "@Entity                            "
            + "@Table(name=\"USER\")                           "
            + "public class UserJpa implements Serializable {     "
            + "@Id     "
            + "@GeneratedValue(strategy=GenerationType.IDENTITY)"
            + "    private Long id;"
            + "		private String name;"
            + "		private Long created;"
            + "    public void setId(Long id) {                             "
            + "        this.id=id;                                       "
            + "    }                                                          "
            + "    public Long getId() {									"
            + "			return id;													"
            + "		}                                                         "
            + "    public void setName(String name) {                         "
            + "        this.name=name;                                    "
            + "    }                                                          "
            + "    public String getName() {									"
            + "			return name;													"
            + "		}                                                         "
            + "    public void setCreated(Long created) {                     "
            + "        this.created=created;                           "
            + "    }                                                          "
            + "    public Long getCreated() {									"
            + "			return created;													"
            + "		}                                                         "
            + "}                                                              ";


    @Test
    public void testJpa() throws Exception {
        Map<String, byte[]> results = compiler.compile("UserJpa.java", JPA_JAVA);
        assertEquals(1, results.size());
        assertTrue(results.containsKey("on.the.fly.UserJpa"));
        Class<?> clazz = compiler.loadClass("on.the.fly.UserJpa", results);
        SessionFactory sessionFactory = obtainSessionFactory(clazz);
        Session session = sessionFactory.openSession();
        assertNotNull(session);
    }


    @Test
    public void testCompileSingleClass() throws Exception {
        Map<String, byte[]> results = compiler.compile("UserProxy.java", SINGLE_JAVA);
        assertEquals(1, results.size());
        assertTrue(results.containsKey("on.the.fly.UserProxy"));
        Class<?> clazz = compiler.loadClass("on.the.fly.UserProxy", results);
        // get method:
        Method setId = clazz.getMethod("setId", String.class);
        Method setName = clazz.getMethod("setName", String.class);
        Method setCreated = clazz.getMethod("setCreated", long.class);
        // try instance:
        Object obj = clazz.newInstance();
        // get as proxy:
        BeanProxy proxy = (BeanProxy) obj;
        assertFalse(proxy.isDirty());
        // set:
        setId.invoke(obj, "A-123");
        setName.invoke(obj, "Fly");
        setCreated.invoke(obj, 123000999);
        // get as user:
        User user = (User) obj;
        assertEquals("A-123", user.getId());
        assertEquals("Fly", user.getName());
        assertEquals(123000999, user.getCreated());
        assertTrue(proxy.isDirty());
    }

    static final String MULTIPLE_JAVA = "/* a single class to many files */   "
            + "package on.the.fly;                                            "
            + "import java.util.*;                                            "
            + "public class Multiple {                                        "
            + "    List<Bird> list = new ArrayList<Bird>();                   "
            + "    public void add(String name) {                             "
            + "        Bird bird = new Bird();                                "
            + "        bird.name = name;                                      "
            + "        this.list.add(bird);                                   "
            + "    }                                                          "
            + "    public Bird getFirstBird() {                               "
            + "        return this.list.get(0);                               "
            + "    }                                                          "
            + "    public static class StaticBird {                           "
            + "        public int weight = 100;                               "
            + "    }                                                          "
            + "    class NestedBird {                                         "
            + "        NestedBird() {                                         "
            + "            System.out.println(list.size() + \" birds...\");   "
            + "        }                                                      "
            + "    }                                                          "
            + "}                                                              "
            + "/* package level */                                            "
            + "class Bird {                                                   "
            + "    String name = null;                                        "
            + "}                                                              ";

    @Test
    public void testCompileMultipleClasses() throws Exception {
        Map<String, byte[]> results = compiler.compile("Multiple.java", MULTIPLE_JAVA);
        assertEquals(4, results.size());
        assertTrue(results.containsKey("on.the.fly.Multiple"));
        assertTrue(results.containsKey("on.the.fly.Multiple$StaticBird"));
        assertTrue(results.containsKey("on.the.fly.Multiple$NestedBird"));
        assertTrue(results.containsKey("on.the.fly.Bird"));
        Class<?> clzMul = compiler.loadClass("on.the.fly.Multiple", results);
        // try instance:
        Object obj = clzMul.newInstance();
        assertNotNull(obj);
    }

    /******************** 以下 方法只适用于对象是动态加载进JVM的情况******************************/
    /**
     * 获取Session工厂
     * 如果指定的model是动态加载到JVM中的，
     * 那么就更新当前的configuration，
     * 并重新创建一个Session工厂(因为Session工厂是全局单例的，所以创建好之后最好不要改动，容易出现事务安全问题)，
     * 以便能为该对象执行数据库访问操作
     * 该方法如果频繁使用，会增加系统开销
     * @param entityClass
     * @return
     */
    private SessionFactory obtainSessionFactory(Class<?> entityClass){
        Map<String,ClassMetadata> map = sessionFactory.getAllClassMetadata();
        Set<String> set = map.keySet();
        if(!set.contains(entityClass.getName())){
            for(SessionFactory factory : sessionFactoryList){
                Set<String> existSet = factory.getAllClassMetadata().keySet();
                //该sessionFactory包含了此实体，就用该SessionFactory
                if(existSet.contains(entityClass.getName())){
                    return factory;
                }
            }
            LocalSessionFactoryBean localSessionFactoryBean = (LocalSessionFactoryBean) SpringUtil.getApplicationContext().getBean("&sessionFactory");

            Configuration configuration = localSessionFactoryBean.getConfiguration();
            ServiceRegistry serviceRegistry = null;
            //避免并发操作导致configuration重复添加相同的entityClass
            synchronized(configuration){
                serviceRegistry = configuration.getStandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                Metadata metadata = (Metadata) new MetadataSources(serviceRegistry).getMetadataBuilder();
                if( metadata.getEntityBinding(entityClass.getName())==null){
                    configuration.addAnnotatedClass(entityClass);
                }
            }
            SessionFactory newSessionFactory = configuration.buildSessionFactory(serviceRegistry);
            sessionFactoryList.add(newSessionFactory);
            return newSessionFactory;
        }else{
            return sessionFactory;
        }
    }
}
