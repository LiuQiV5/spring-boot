package com.liuqi.springboot.recruit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_intent", schema = "oaapp", catalog = "")
public class SchoolRecruitIntent {
    private long id;
    private long planFormid;
    private String comment;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PLAN_FORMID")
    public long getPlanFormid() {
        return planFormid;
    }

    public void setPlanFormid(long planFormid) {
        this.planFormid = planFormid;
    }

    @Basic
    @Column(name = "COMMENT")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitIntent that = (SchoolRecruitIntent) o;
        return id == that.id &&
                planFormid == that.planFormid &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planFormid, comment);
    }
}
