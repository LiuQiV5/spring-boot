package com.liuqi.springboot;

import com.liuqi.springboot.VO.ParentInfoVO;
import com.liuqi.springboot.VO.StuInfoVO;
import com.liuqi.springboot.dao.SchoolCourseScoreDao;
import com.liuqi.springboot.dao.SchoolRecruitParentDao;
import com.liuqi.springboot.dao.SchoolRecruitStuinfoDao;
import com.liuqi.springboot.dao.SchoolRecruitTestDao;
import com.liuqi.springboot.entity.SchoolCourseScore;
import com.liuqi.springboot.entity.SchoolRecruitParent;
import com.liuqi.springboot.entity.SchoolRecruitStuinfo;
import com.liuqi.springboot.entity.SchoolRecruitTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Date;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlTest {

    @Autowired
    private SchoolRecruitStuinfoDao schoolRecruitStuinfoDao;

    @Autowired
    private SchoolRecruitParentDao schoolRecruitParentDao;

    @Autowired
    private SchoolRecruitTestDao schoolRecruitTestDao;

    @Autowired
    private SchoolCourseScoreDao schoolCourseScoreDao;

    @Test
    public void saveData(){
        SchoolRecruitStuinfo info = new SchoolRecruitStuinfo();
        info.setAddress("江阴");
        info.setBirthday(new Date(1994-10-07));
        info.setClassname("初三一班");
        info.setHealth("健康");
        info.setHeight("1.7");
        info.setHonor("跑步第一名");
        info.setIdcard("565456465133312");
        info.setIntent("理科班");
        info.setName("小明");
        info.setNationality("sdfdsf");
        info.setPhone("4578997");
        info.setPolitical("团员");
        info.setPhoto("sdfvsdffdsf");
        info.setRecipient("士大夫士大夫的");
        info.setRecommend("隔热隔热隔热");
        info.setRegistration("sdfgertgcvbdfg");
        info.setSchoolcode("52154");
        info.setSchoolname("一中");
        info.setSex("男");
        info.setSpecialty("受到法国大使馆的");
        info.setTicketno("458674");
        info.setWeight("230");
        info.setZipcode("485512");
        schoolRecruitStuinfoDao.save(info);
    }

    @Test
    public void saveParent(){
//        SchoolRecruitParent parent1 = new SchoolRecruitParent();
//        parent1.setCompany("优胜");
//        parent1.setJob("开发");
//        parent1.setName("小张");
//        parent1.setPhone("544585485");
//        parent1.setStuinfoid(1);
//        parent1.setTitle("父亲");
//        schoolRecruitParentDao.save(parent1);

//        SchoolRecruitParent parent2 = new SchoolRecruitParent();
//        parent2.setCompany("海澜");
//        parent2.setJob("经理");
//        parent2.setName("小王");
//        parent2.setPhone("13800000064");
//        parent2.setStuinfoid(1);
//        parent2.setTitle("母亲");
//        schoolRecruitParentDao.save(parent2);

//        SchoolRecruitTest test1 = new SchoolRecruitTest();
//        test1.setClassRanking(1);
//        test1.setClassStunum(50);
//        test1.setGradeRanking(10);
//        test1.setGradeStunum(500);
//        test1.setStuinfoid(1);
//        test1.setTesttime("初一上");
//        test1.setTotalscore(350);
//        schoolRecruitTestDao.save(test1);
//
//        SchoolRecruitTest test2 = new SchoolRecruitTest();
//        test2.setClassRanking(1);
//        test2.setClassStunum(50);
//        test2.setGradeRanking(5);
//        test2.setGradeStunum(500);
//        test2.setStuinfoid(1);
//        test2.setTesttime("初一下");
//        test2.setTotalscore(380);
//        schoolRecruitTestDao.save(test2);

        SchoolCourseScore score1 = new SchoolCourseScore();
        score1.setCourse("语文");
        score1.setScore(90);
        score1.setTestid(1);
        score1.setTotalscore(100);
        schoolCourseScoreDao.save(score1);

        SchoolCourseScore score2 = new SchoolCourseScore();
        score2.setCourse("语文");
        score2.setScore(95);
        score2.setTestid(2);
        score2.setTotalscore(100);
        schoolCourseScoreDao.save(score2);

    }

    @Test
    public void select(){
        List<SchoolRecruitStuinfo> infos = schoolRecruitStuinfoDao.findAll();
        System.out.println("================="+infos.size());

        List<SchoolRecruitParent> parents = infos.get(0).getParents();
        System.out.println("================="+parents.size());

        List<SchoolRecruitParent> all = schoolRecruitParentDao.findAll();
        System.out.println("================="+all.size());

        System.out.println("================="+all.get(0).getStuinfo().getName());
        System.out.println("================="+all.get(1).getStuinfo().getSchoolname());

        System.out.println("tests====================="+infos.get(0).getTests().size());

        SchoolRecruitTest test1 = infos.get(0).getTests().get(0);
        SchoolRecruitTest test2 = infos.get(0).getTests().get(1);
        System.out.println("test1====================="+test1.getScores().size());
        System.out.println("test2====================="+test2.getScores().get(0).getScore());

    }

    @Test
    public void testParseEntity() throws Exception {
        StuInfoVO info = new StuInfoVO();
        List<ParentInfoVO> parents = new ArrayList<>();

        info.setZipcode("56467");
        info.setWeight("50");
        info.setTicketno("5645633");
        info.setSpecialty("阿斯顿发生");
        info.setSex("男");
        info.setSchoolname("一中");
        info.setSchoolcode("4878455");
        info.setRegistration("士大夫");
        info.setRecommend("而托管人托管");
        info.setRecipient("士大夫Greg");
        info.setPhoto("fgyhrtuhtut");
        info.setPolitical("少先队员");
        info.setPhone("545445");

        ParentInfoVO parent1 = new ParentInfoVO();
        parent1.setTitle("母亲");
        parent1.setPhone("5678897897");
        parent1.setName("小李");
        parent1.setJob("开发");
        parent1.setCompany("优胜");

        ParentInfoVO parent2 = new ParentInfoVO();
        parent2.setTitle("父亲");
        parent2.setPhone("485656");
        parent2.setName("小张");
        parent2.setJob("测试");
        parent2.setCompany("优胜");

        parents.add(parent2);
        parents.add(parent1);
        info.setParents(parents);

        //获取class对象
        Class<? extends StuInfoVO> infoClass = info.getClass();

        Field[] fields = infoClass.getDeclaredFields();

        if (fields!=null && fields.length>0) {

            for (Field field : fields) {
                System.out.println(field.getName().toUpperCase()+"======================"+field.getGenericType());
                if (field.getName().toUpperCase().equals("PARENTS")) {
                    System.out.println("-----------------------------------------------------------");
                    List<ParentInfoVO> ps = info.getParents();
                    for (ParentInfoVO p : ps) {
                        //获取class对象
                        Class<? extends ParentInfoVO> pClass = p.getClass();

                        Field[] pfields = pClass.getDeclaredFields();

                        for (Field pfield : pfields) {
                            System.out.println(pfield.getName().toUpperCase()+"======================"+pfield.getGenericType());
                            if (field.getName().toUpperCase().equals("TESTS")) {

                            } else {
                                Method m = (Method) pClass.getMethod("get" + getMethodName(pfield.getName()));
                                String value = (String) m.invoke(p, null);
                                System.out.println(m.getName()+"============"+value);
                            }
                        }
                    }
                } else {
                    Method m = (Method) infoClass.getMethod("get" + getMethodName(field.getName()));
                    String value = (String) m.invoke(info, null);
                    System.out.println(m.getName()+"============"+value);
                }
            }
        }
    }

    // 把一个字符串的第一个字母大写、效率是最高的、
    private static String getMethodName(String fildeName) throws Exception{
           byte[] items = fildeName.getBytes();
           items[0] = (byte) ((char) items[0] - 'a' + 'A');
           return new String(items);
    }

    @Test
    public void LongMap(){
        Map<Long,String> map = new HashMap<>(10);
        map.put(150L,"150");
        map.put(160L,"160");
        map.put(280L,"280");
        map.put(98L,"98");
        System.out.println(map.get(280L));
        System.out.println(map.get(160L));
        System.out.println(map.get(150L));
        System.out.println(map.get(98L));

    }

    @Test
    public void generateModel() throws Exception{
        Class<?> voClass = Class.forName("com.liuqi.springboot.recruit.vo.RecruitPlanVo");
        parse(voClass.newInstance(),"","0");
    }

    public static void parse(Object o,String infotype,String index) throws Exception{
        Class<? extends Object> objectClass = o.getClass();
        Field[] fields = objectClass.getDeclaredFields();
        List<Field> asList = Arrays.asList(fields);
        ArrayList<Field> fieldList = new ArrayList<>(asList);
        for (Field field : fieldList) {
            if(List.class.isAssignableFrom(field.getType())) {

                Type t = field.getGenericType();

                if (t instanceof ParameterizedType) {

                    ParameterizedType pt = (ParameterizedType) t;

                    //得到对象list中实例的类型
                    Class clz = (Class) pt.getActualTypeArguments()[0];

                    parse(clz.newInstance(),field.getName(),index+fieldList.indexOf(field));
                }
            } else if ("GroupClass".equals(field.getType().getSimpleName())) {
                PropertyDescriptor descriptor = new PropertyDescriptor(field.getName(), objectClass);
                Method method = descriptor.getReadMethod();
                Object object = method.invoke(o);
                parse(object,field.getName(),index+"0");
            } else{
                field.setAccessible(true);
                System.out.println(infotype+"===="+field.getName()+"===="+field.get(o)+"===="+index);
            }
        }
    }

    @Test
    public void test111(){
        Integer a=1;
        Integer b=2;
        Integer c=3;
        Integer d=3;
        Integer e=321;
        Integer f=321;
        Long g=3L;
        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));

    }

    @Test
    public void test2222(){
        Integer a1 = new Integer(12);
        Integer a2 = new Integer(12);
        Integer b1 = -129;
        Integer b2 = -129;
        Integer c1 = 128;
        Integer c2 = -128;
        System.out.println(a1 == a2);
        System.out.println(b1==b2);
        System.out.println(c1 == c2);
    }
}
