package com.liuqi.springboot.recruit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_form_detail", schema = "oaapp", catalog = "")
public class SchoolRecruitFormDetail {
    private long id;
    private long signid;
    private String fieldname;
    private String fieldvalue;
    private long infoid;
    private String groupid;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SIGNID")
    public long getSignid() {
        return signid;
    }

    public void setSignid(long signid) {
        this.signid = signid;
    }

    @Basic
    @Column(name = "FIELDNAME")
    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    @Basic
    @Column(name = "FIELDVALUE")
    public String getFieldvalue() {
        return fieldvalue;
    }

    public void setFieldvalue(String fieldvalue) {
        this.fieldvalue = fieldvalue;
    }

    @Basic
    @Column(name = "INFOID")
    public long getInfoid() {
        return infoid;
    }

    public void setInfoid(long infoid) {
        this.infoid = infoid;
    }

    @Basic
    @Column(name = "GROUPID")
    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitFormDetail that = (SchoolRecruitFormDetail) o;
        return id == that.id &&
                signid == that.signid &&
                Objects.equals(fieldname, that.fieldname) &&
                Objects.equals(fieldvalue, that.fieldvalue) &&
                Objects.equals(infoid, that.infoid) &&
                Objects.equals(groupid, that.groupid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, signid, fieldname, fieldvalue, infoid, groupid);
    }
}
