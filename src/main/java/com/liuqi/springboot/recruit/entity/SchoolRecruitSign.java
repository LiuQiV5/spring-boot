package com.liuqi.springboot.recruit.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_sign", schema = "oaapp", catalog = "")
public class SchoolRecruitSign {
    private long id;
    private long planid;
    private long formid;
    private String bindphone;
    private String idcard;
    private String result;
    private Timestamp adddate;

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
    @Column(name = "FORMID")
    public long getFormid() {
        return formid;
    }

    public void setFormid(long formid) {
        this.formid = formid;
    }

    @Basic
    @Column(name = "BINDPHONE")
    public String getBindphone() {
        return bindphone;
    }

    public void setBindphone(String bindphone) {
        this.bindphone = bindphone;
    }

    @Basic
    @Column(name = "IDCARD")
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Basic
    @Column(name = "RESULT")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Basic
    @Column(name = "ADDDATE")
    public Timestamp getAdddate() {
        return adddate;
    }

    public void setAdddate(Timestamp adddate) {
        this.adddate = adddate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitSign that = (SchoolRecruitSign) o;
        return id == that.id &&
                planid == that.planid &&
                formid == that.formid &&
                Objects.equals(bindphone, that.bindphone) &&
                Objects.equals(idcard, that.idcard) &&
                Objects.equals(result, that.result) &&
                Objects.equals(adddate, that.adddate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planid, formid, bindphone, idcard, result, adddate);
    }
}
