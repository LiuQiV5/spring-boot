package com.liuqi.springboot.recruit.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_form", schema = "oaapp", catalog = "")
public class SchoolRecruitForm {
    private long id;
    private Long initid;
    private String schoolguid;
    private String modelpath;
    private String indexpath;
    private String imgpath;
    private String name;
    private String model;

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
    @Column(name = "INITID")
    public Long getInitid() {
        return initid;
    }

    public void setInitid(Long initid) {
        this.initid = initid;
    }

    @Basic
    @Column(name = "SCHOOLGUID")
    public String getSchoolguid() {
        return schoolguid;
    }

    public void setSchoolguid(String schoolguid) {
        this.schoolguid = schoolguid;
    }

    @Basic
    @Column(name = "MODELPATH")
    public String getModelpath() {
        return modelpath;
    }

    public void setModelpath(String modelpath) {
        this.modelpath = modelpath;
    }

    @Basic
    @Column(name = "INDEXPATH")
    public String getIndexpath() {
        return indexpath;
    }

    public void setIndexpath(String indexpath) {
        this.indexpath = indexpath;
    }

    @Basic
    @Column(name = "IMGPATH")
    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
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
    @Column(name = "MODEL")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitForm that = (SchoolRecruitForm) o;
        return id == that.id &&
                Objects.equals(initid, that.initid) &&
                Objects.equals(schoolguid, that.schoolguid) &&
                Objects.equals(modelpath, that.modelpath) &&
                Objects.equals(indexpath, that.indexpath) &&
                Objects.equals(imgpath, that.imgpath) &&
                Objects.equals(name, that.name) &&
                Objects.equals(model, that.model) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, initid, schoolguid, modelpath, indexpath, imgpath, name, model);
    }
}
