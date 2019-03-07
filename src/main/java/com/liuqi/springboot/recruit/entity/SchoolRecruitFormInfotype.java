package com.liuqi.springboot.recruit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_form_infotype", schema = "oaapp", catalog = "")
public class SchoolRecruitFormInfotype {
    private long id;
    private long formid;
    private long infoid;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FORMID")
    public long getFormid() {
        return formid;
    }

    public void setFormid(long formid) {
        this.formid = formid;
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
        SchoolRecruitFormInfotype that = (SchoolRecruitFormInfotype) o;
        return id == that.id &&
                formid == that.formid &&
                infoid == that.infoid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, formid, infoid);
    }
}
