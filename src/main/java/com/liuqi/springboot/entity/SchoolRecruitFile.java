package com.liuqi.springboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_file", schema = "oaapp", catalog = "")
public class SchoolRecruitFile {
    private long id;
    private long planid;
    private String name;
    private Integer successnum;
    private Integer failnum;
    private Integer countnum;
    private String type;

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
    @Column(name = "SUCCESSNUM")
    public Integer getSuccessnum() {
        return successnum;
    }

    public void setSuccessnum(Integer successnum) {
        this.successnum = successnum;
    }

    @Basic
    @Column(name = "FAILNUM")
    public Integer getFailnum() {
        return failnum;
    }

    public void setFailnum(Integer failnum) {
        this.failnum = failnum;
    }

    @Basic
    @Column(name = "COUNTNUM")
    public Integer getCountnum() {
        return countnum;
    }

    public void setCountnum(Integer countnum) {
        this.countnum = countnum;
    }

    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitFile that = (SchoolRecruitFile) o;
        return id == that.id &&
                planid == that.planid &&
                Objects.equals(name, that.name) &&
                Objects.equals(successnum, that.successnum) &&
                Objects.equals(failnum, that.failnum) &&
                Objects.equals(countnum, that.countnum) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planid, name, successnum, failnum, countnum, type);
    }
}
