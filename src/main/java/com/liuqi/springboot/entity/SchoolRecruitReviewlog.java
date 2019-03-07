package com.liuqi.springboot.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_reviewlog", schema = "oaapp", catalog = "")
public class SchoolRecruitReviewlog {
    private long id;
    private long reviewid;
    private String oldstatus;
    private String newstatus;
    private String comment;
    private Long operdateuserid;
    private Timestamp operdatedate;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "REVIEWID")
    public long getReviewid() {
        return reviewid;
    }

    public void setReviewid(long reviewid) {
        this.reviewid = reviewid;
    }

    @Basic
    @Column(name = "OLDSTATUS")
    public String getOldstatus() {
        return oldstatus;
    }

    public void setOldstatus(String oldstatus) {
        this.oldstatus = oldstatus;
    }

    @Basic
    @Column(name = "NEWSTATUS")
    public String getNewstatus() {
        return newstatus;
    }

    public void setNewstatus(String newstatus) {
        this.newstatus = newstatus;
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
    @Column(name = "OPERDATEUSERID")
    public Long getOperdateuserid() {
        return operdateuserid;
    }

    public void setOperdateuserid(Long operdateuserid) {
        this.operdateuserid = operdateuserid;
    }

    @Basic
    @Column(name = "OPERDATEDATE")
    public Timestamp getOperdatedate() {
        return operdatedate;
    }

    public void setOperdatedate(Timestamp operdatedate) {
        this.operdatedate = operdatedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitReviewlog that = (SchoolRecruitReviewlog) o;
        return id == that.id &&
                reviewid == that.reviewid &&
                Objects.equals(oldstatus, that.oldstatus) &&
                Objects.equals(newstatus, that.newstatus) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(operdateuserid, that.operdateuserid) &&
                Objects.equals(operdatedate, that.operdatedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reviewid, oldstatus, newstatus, comment, operdateuserid, operdatedate);
    }
}
