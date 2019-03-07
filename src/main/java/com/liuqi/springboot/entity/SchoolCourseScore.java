package com.liuqi.springboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "school_course_score", schema = "oaapp", catalog = "")
public class SchoolCourseScore {
    private long id;
    private long testid;
    private String course;
    private Integer score;
    private Integer totalscore;
    private SchoolRecruitTest test;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TESTID",nullable = false,insertable = false,updatable = false)
    public SchoolRecruitTest getTest() {
        return test;
    }

    public void setTest(SchoolRecruitTest test) {
        this.test = test;
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
    @Column(name = "TESTID")
    public long getTestid() {
        return testid;
    }

    public void setTestid(long testid) {
        this.testid = testid;
    }

    @Basic
    @Column(name = "COURSE")
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Basic
    @Column(name = "SCORE")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Basic
    @Column(name = "TOTALSCORE")
    public Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolCourseScore that = (SchoolCourseScore) o;
        return id == that.id &&
                testid == that.testid &&
                Objects.equals(course, that.course) &&
                Objects.equals(score, that.score) &&
                Objects.equals(totalscore, that.totalscore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, testid, course, score, totalscore);
    }
}
