package com.liuqi.springboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_intent", schema = "oaapp", catalog = "")
public class SchoolRecruitIntent {
    private long id;
    private long planid;
    private String name;
    private String gradetype;

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
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "GRADETYPE")
    public String getGradetype() {
        return gradetype;
    }

    public void setGradetype(String gradetype) {
        this.gradetype = gradetype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitIntent that = (SchoolRecruitIntent) o;
        return id == that.id &&
                planid == that.planid &&
                Objects.equals(name, that.name) &&
                Objects.equals(gradetype, that.gradetype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planid, name, gradetype);
    }
}
