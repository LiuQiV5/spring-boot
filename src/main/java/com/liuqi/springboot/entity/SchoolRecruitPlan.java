package com.liuqi.springboot.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_plan", schema = "oaapp", catalog = "")
public class SchoolRecruitPlan {
    private long id;
    private long formid;
    private String title;
    private Date startdate;
    private Date enddate;
    private String url;
    private String guide;
    private String description;
    private String note;
    private String examination;
    private String schoolcode;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "STARTDATE")
    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Basic
    @Column(name = "ENDDATE")
    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @Basic
    @Column(name = "URL")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "GUIDE")
    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "NOTE")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "EXAMINATION")
    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    @Basic
    @Column(name = "SCHOOLCODE")
    public String getSchoolcode() {
        return schoolcode;
    }

    public void setSchoolcode(String schoolcode) {
        this.schoolcode = schoolcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitPlan that = (SchoolRecruitPlan) o;
        return id == that.id &&
                formid == that.formid &&
                Objects.equals(title, that.title) &&
                Objects.equals(startdate, that.startdate) &&
                Objects.equals(enddate, that.enddate) &&
                Objects.equals(url, that.url) &&
                Objects.equals(guide, that.guide) &&
                Objects.equals(description, that.description) &&
                Objects.equals(note, that.note) &&
                Objects.equals(examination, that.examination) &&
                Objects.equals(schoolcode, that.schoolcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, formid, title, startdate, enddate, url, guide, description, note, examination, schoolcode);
    }
}
