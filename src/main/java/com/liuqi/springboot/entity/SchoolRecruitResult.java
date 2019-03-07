package com.liuqi.springboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_result", schema = "oaapp", catalog = "")
public class SchoolRecruitResult {
    private long id;
    private long planid;
    private long fileid;
    private String name;
    private String ticketno;
    private String result;
    private String comment;
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
    @Column(name = "FILEID")
    public long getFileid() {
        return fileid;
    }

    public void setFileid(long fileid) {
        this.fileid = fileid;
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
    @Column(name = "TICKETNO")
    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno;
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
    @Column(name = "COMMENT")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        SchoolRecruitResult that = (SchoolRecruitResult) o;
        return id == that.id &&
                planid == that.planid &&
                fileid == that.fileid &&
                Objects.equals(name, that.name) &&
                Objects.equals(ticketno, that.ticketno) &&
                Objects.equals(result, that.result) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planid, fileid, name, ticketno, result, comment, status);
    }
}
