package com.liuqi.springboot.recruit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_field", schema = "oaapp", catalog = "")
public class SchoolRecruitField {
    private long id;
    private String comment;
    private String fieldname;
    private long infoid;

    @Basic
    @Column(name = "FIELDNAME")
    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
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

    @Basic
    @Column(name = "INFOID")
    public long getInfoid() {
        return infoid;
    }

    public void setInfoid(long infoid) {
        this.infoid = infoid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitField that = (SchoolRecruitField) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(fieldname, that.fieldname) &&
                Objects.equals(infoid, that.infoid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment,fieldname, infoid);
    }
}
