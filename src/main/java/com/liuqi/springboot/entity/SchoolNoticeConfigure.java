package com.liuqi.springboot.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "school_notice_configure", schema = "oaapp", catalog = "")
public class SchoolNoticeConfigure {
    private long id;
    private String schoolguid;
    private String name;
    private String modelpath;
    private String modelimg;
    private String content;
    private String visibility;
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
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "VISIBILITY")
    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
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
        SchoolNoticeConfigure that = (SchoolNoticeConfigure) o;
        return id == that.id &&
                operateuserid == that.operateuserid &&
                Objects.equals(schoolguid, that.schoolguid) &&
                Objects.equals(name, that.name) &&
                Objects.equals(modelpath, that.modelpath) &&
                Objects.equals(modelimg, that.modelimg) &&
                Objects.equals(content, that.content) &&
                Objects.equals(visibility, that.visibility) &&
                Objects.equals(operatedate, that.operatedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, schoolguid, name, modelpath, modelimg, content, visibility, operateuserid, operatedate);
    }
}
