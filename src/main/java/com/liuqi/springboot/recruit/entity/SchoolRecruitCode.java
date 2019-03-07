package com.liuqi.springboot.recruit.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_code", schema = "oaapp", catalog = "")
public class SchoolRecruitCode {
    private long id;
    private String phone;
    private String code;
    private Timestamp creatdate;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "CREATDATE")
    public Timestamp getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Timestamp creatdate) {
        this.creatdate = creatdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitCode that = (SchoolRecruitCode) o;
        return id == that.id &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(code, that.code) &&
                Objects.equals(creatdate, that.creatdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, code, creatdate);
    }
}
