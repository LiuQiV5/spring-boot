package com.liuqi.springboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_review", schema = "oaapp", catalog = "")
public class SchoolRecruitReview {
    private long id;
    private long planid;
    private long stuinfoid;
    private long typeid;
    private String status;

    @Id
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
    @Column(name = "STUINFOID")
    public long getStuinfoid() {
        return stuinfoid;
    }

    public void setStuinfoid(long stuinfoid) {
        this.stuinfoid = stuinfoid;
    }

    @Basic
    @Column(name = "TYPEID")
    public long getTypeid() {
        return typeid;
    }

    public void setTypeid(long typeid) {
        this.typeid = typeid;
    }

    @Basic
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitReview that = (SchoolRecruitReview) o;
        return id == that.id &&
                planid == that.planid &&
                stuinfoid == that.stuinfoid &&
                typeid == that.typeid &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planid, stuinfoid, typeid, status);
    }
}
