package com.liuqi.springboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "school_review_import", schema = "oaapp", catalog = "")
public class SchoolReviewImport {
    private long id;
    private long fielid;
    private String name;
    private String idcard;
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
    @Column(name = "FIELID")
    public long getFielid() {
        return fielid;
    }

    public void setFielid(long fielid) {
        this.fielid = fielid;
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
    @Column(name = "IDCARD")
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
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
        SchoolReviewImport that = (SchoolReviewImport) o;
        return id == that.id &&
                fielid == that.fielid &&
                Objects.equals(name, that.name) &&
                Objects.equals(idcard, that.idcard) &&
                Objects.equals(result, that.result) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fielid, name, idcard, result, comment, status);
    }
}
