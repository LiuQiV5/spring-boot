package com.liuqi.springboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_resultdetail", schema = "oaapp", catalog = "")
public class SchoolRecruitResultdetail {
    private long id;
    private long resultid;
    private Integer score;
    private String ranking;
    private String type;

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
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitResultdetail that = (SchoolRecruitResultdetail) o;
        return id == that.id &&
                resultid == that.resultid &&
                Objects.equals(score, that.score) &&
                Objects.equals(ranking, that.ranking) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resultid, score, ranking, type);
    }
}
