package com.liuqi.springboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_parent", schema = "oaapp", catalog = "")
public class SchoolRecruitParent {
    private long id;
    private long stuinfoid;
    private String title;
    private String name;
    private String company;
    private String job;
    private String phone;

    private SchoolRecruitStuinfo stuinfo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "STUINFOID",nullable = false,insertable = false,updatable = false)
    public SchoolRecruitStuinfo getStuinfo() {
        return stuinfo;
    }

    public void setStuinfo(SchoolRecruitStuinfo stuinfo) {
        this.stuinfo = stuinfo;
    }

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "COMPANY")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "JOB")
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Basic
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitParent that = (SchoolRecruitParent) o;
        return id == that.id &&
                stuinfoid == that.stuinfoid &&
                Objects.equals(title, that.title) &&
                Objects.equals(name, that.name) &&
                Objects.equals(company, that.company) &&
                Objects.equals(job, that.job) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stuinfoid, title, name, company, job, phone);
    }
}
