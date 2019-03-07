package com.liuqi.springboot.recruit.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_init", schema = "oaapp", catalog = "")
public class SchoolRecruitInit {
    private long id;
    private String schoolguid;
    private String guide;
    private String description;
    private String note;
    private String examination;
    private long operateuserid;
    private Timestamp operatedate;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "OPERATEUSERID")
    public long getOperateuserid() {
        return operateuserid;
    }

    public void setOperateuserid(long operateuserid) {
        this.operateuserid = operateuserid;
    }

    @Basic
    @Column(name = "OPERATEDATE")
    public Timestamp getOperatedate() {
        return operatedate;
    }

    public void setOperatedate(Timestamp operatedate) {
        this.operatedate = operatedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitInit that = (SchoolRecruitInit) o;
        return id == that.id &&
                operateuserid == that.operateuserid &&
                Objects.equals(schoolguid, that.schoolguid) &&
                Objects.equals(guide, that.guide) &&
                Objects.equals(description, that.description) &&
                Objects.equals(note, that.note) &&
                Objects.equals(examination, that.examination) &&
                Objects.equals(operatedate, that.operatedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, schoolguid, guide, description, note, examination, operateuserid, operatedate);
    }
}
