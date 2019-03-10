package com.liuqi.springboot.recruit.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_plan", schema = "oaapp", catalog = "")
public class SchoolRecruitPlan {
    private Long id;
    private Long siteid;
    private String schoolguid;
    private String title;
    private Date startdate;
    private Date enddate;
    private String guide;
    private String description;
    private String note;
    private String examination;
    private String schoolcode;
    private Timestamp createdate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SITEID")
    public Long getSiteid() {
        return siteid;
    }

    public void setSiteid(Long siteid) {
        this.siteid = siteid;
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

    public Timestamp getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitPlan that = (SchoolRecruitPlan) o;
        return id == that.id &&
                Objects.equals(siteid, that.siteid) &&
                Objects.equals(schoolguid, that.schoolguid) &&
                Objects.equals(title, that.title) &&
                Objects.equals(startdate, that.startdate) &&
                Objects.equals(enddate, that.enddate) &&
                Objects.equals(guide, that.guide) &&
                Objects.equals(description, that.description) &&
                Objects.equals(note, that.note) &&
                Objects.equals(examination, that.examination) &&
                Objects.equals(createdate, that.createdate) &&
                Objects.equals(schoolcode, that.schoolcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, siteid, schoolguid, title, startdate, enddate, guide, description, note, examination, schoolcode,createdate);
    }
}
