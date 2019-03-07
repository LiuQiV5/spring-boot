package com.liuqi.springboot.recruit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_result_detail", schema = "oaapp", catalog = "")
public class SchoolRecruitResultDetail {
    private long id;
    private long resultid;
    private Integer score;
    private String ranking;
    private String typename;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "RESULTID")
    public long getResultid() {
        return resultid;
    }

    public void setResultid(long resultid) {
        this.resultid = resultid;
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
    @Column(name = "RANKING")
    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    @Basic
    @Column(name = "TYPENAME")
    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitResultDetail that = (SchoolRecruitResultDetail) o;
        return id == that.id &&
                resultid == that.resultid &&
                Objects.equals(score, that.score) &&
                Objects.equals(ranking, that.ranking) &&
                Objects.equals(typename, that.typename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resultid, score, ranking, typename);
    }
}
