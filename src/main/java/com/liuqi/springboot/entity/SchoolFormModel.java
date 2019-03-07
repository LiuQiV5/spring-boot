package com.liuqi.springboot.entity;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "school_form_model", schema = "oaapp", catalog = "")
public class SchoolFormModel {
    private long id;
    private String schoolguid;
    private String modelpath;
    private String modelimg;
    private String name;
    private String indexpath;
    private long operateuserid;
    private Timestamp operatedate;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SCHOOLGUID")
    public String getSchoolguid() {
        return schoolguid;
    }

    public void setSchoolguid(String schoolguid) {
        this.schoolguid = schoolguid;
    }

    @Basic
    @Column(name = "MODELPATH")
    public String getModelpath() {
        return modelpath;
    }

    public void setModelpath(String modelpath) {
        this.modelpath = modelpath;
    }

    @Basic
    @Column(name = "MODELIMG")
    public String getModelimg() {
        return modelimg;
    }

    public void setModelimg(String modelimg) {
        this.modelimg = modelimg;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "INDEXPATH")
    public String getIndexpath() {
        return indexpath;
    }

    public void setIndexpath(String indexpath) {
        this.indexpath = indexpath;
    }

    @Basic
    @Column(name = "OPERATEUSERID")
    public long getOperateuserid() {
        return operateuserid;
    }

    public void setOperateuserid(long operateuserid) {
        this.operateuserid = operateuserid;
    }

    @Basic
    @Column(name = "OPERATEDATE")
    public Timestamp getOperatedate() {
        return operatedate;
    }

    public void setOperatedate(Timestamp operatedate) {
        this.operatedate = operatedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolFormModel that = (SchoolFormModel) o;
        return id == that.id &&
                operateuserid == that.operateuserid &&
                Objects.equals(schoolguid, that.schoolguid) &&
                Objects.equals(modelpath, that.modelpath) &&
                Objects.equals(modelimg, that.modelimg) &&
                Objects.equals(name, that.name) &&
                Objects.equals(indexpath, that.indexpath) &&
                Objects.equals(operatedate, that.operatedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, schoolguid, modelpath, modelimg, name, indexpath, operateuserid, operatedate);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> sClass = Class.forName("com.liuqi.springboot.entity.SchoolFormModel");


        Object o = sClass.newInstance();
        Field[] fields = sClass.getDeclaredFields();
        System.out.println(fields.length);
        for (Field field : fields) {

            System.out.println(field.getGenericType().getClass());

            Class<? extends Field> fieldClass = field.getClass();
            Field child = fieldClass.newInstance();
            Field[] childFields = fieldClass.getDeclaredFields();
            System.out.println(childFields.length);
//            for (Field childField : childFields) {
//
//
//            }

            System.out.println(field.getName());
//            field.set(o,);
        }
        System.out.println((SchoolFormModel.class).getName());
        if ("com.liuqi.springboot.entity.SchoolFormModel".equals(SchoolFormModel.class.getName())) {
            System.out.println(11111111);
        }
    }
}
