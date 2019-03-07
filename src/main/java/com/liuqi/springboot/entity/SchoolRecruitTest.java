package com.liuqi.springboot.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_test", schema = "oaapp", catalog = "")
public class SchoolRecruitTest {
    private long id;
    private long stuinfoid;
    private String testtime;
    private Integer classRanking;
    private Integer classStunum;
    private Integer totalscore;
    private Integer gradeRanking;
    private Integer gradeStunum;
    private SchoolRecruitStuinfo stuinfo;
    private List<SchoolCourseScore> scores;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public List<SchoolCourseScore> getScores() {
        return scores;
    }

    public void setScores(List<SchoolCourseScore> scores) {
        this.scores = scores;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "STUINFOID",referencedColumnName = "ID",nullable = false,insertable = false,updatable = false)
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
    @Column(name = "TESTTIME")
    public String getTesttime() {
        return testtime;
    }

    public void setTesttime(String testtime) {
        this.testtime = testtime;
    }

    @Basic
    @Column(name = "CLASS_RANKING")
    public Integer getClassRanking() {
        return classRanking;
    }

    public void setClassRanking(Integer classRanking) {
        this.classRanking = classRanking;
    }

    @Basic
    @Column(name = "CLASS_STUNUM")
    public Integer getClassStunum() {
        return classStunum;
    }

    public void setClassStunum(Integer classStunum) {
        this.classStunum = classStunum;
    }

    @Basic
    @Column(name = "TOTALSCORE")
    public Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }

    @Basic
    @Column(name = "GRADE_RANKING")
    public Integer getGradeRanking() {
        return gradeRanking;
    }

    public void setGradeRanking(Integer gradeRanking) {
        this.gradeRanking = gradeRanking;
    }

    @Basic
    @Column(name = "GRADE_STUNUM")
    public Integer getGradeStunum() {
        return gradeStunum;
    }

    public void setGradeStunum(Integer gradeStunum) {
        this.gradeStunum = gradeStunum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitTest that = (SchoolRecruitTest) o;
        return id == that.id &&
                stuinfoid == that.stuinfoid &&
                Objects.equals(testtime, that.testtime) &&
                Objects.equals(classRanking, that.classRanking) &&
                Objects.equals(classStunum, that.classStunum) &&
                Objects.equals(totalscore, that.totalscore) &&
                Objects.equals(gradeRanking, that.gradeRanking) &&
                Objects.equals(gradeStunum, that.gradeStunum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stuinfoid, testtime, classRanking, classStunum, totalscore, gradeRanking, gradeStunum);
    }
}
