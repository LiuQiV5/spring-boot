package com.liuqi.springboot.recruit.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_plan_notice", schema = "oaapp", catalog = "")
public class SchoolRecruitPlanNotice {
    private long id;
    private long planid;
    private String name;
    private String type;
    private String modelpath;
    private String content;
    private String visibility;
    private long operateuserid;
    private Date operatedate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PLANID")
    public long getPlanid() {
        return planid;
    }

    public void setPlanid(long planid) {
        this.planid = planid;
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
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    public Date getOperatedate() {
        return operatedate;
    }

    public void setOperatedate(Date operatedate) {
        this.operatedate = operatedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitPlanNotice that = (SchoolRecruitPlanNotice) o;
        return id == that.id &&
                planid == that.planid &&
                operateuserid == that.operateuserid &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(modelpath, that.modelpath) &&
                Objects.equals(content, that.content) &&
                Objects.equals(visibility, that.visibility) &&
                Objects.equals(operatedate, that.operatedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planid, name, type, modelpath, content, visibility, operateuserid, operatedate);
    }
}
