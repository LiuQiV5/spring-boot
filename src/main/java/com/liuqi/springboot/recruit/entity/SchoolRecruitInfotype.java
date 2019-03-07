package com.liuqi.springboot.recruit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_infotype", schema = "oaapp", catalog = "")
public class SchoolRecruitInfotype {
    private long id;
    private String comment;
    private String infotype;

    @Basic
    @Column(name = "INFOTYPE")
    public String getInfotype() {
        return infotype;
    }

    public void setInfotype(String infotype) {
        this.infotype = infotype;
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
        SchoolRecruitInfotype that = (SchoolRecruitInfotype) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(infotype, that.infotype) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment,infotype);
    }
}
