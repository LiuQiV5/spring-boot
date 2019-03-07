package com.liuqi.springboot.recruit.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_notice_conf", schema = "oaapp", catalog = "")
public class SchoolRecruitNoticeConf {
    private long id;
    private Long initid;
    private String schoolguid;
    private String name;
    private String modelpath;
    private String type;
    private String content;
    private String visibility;


    @Id
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
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "VISIBILITY")
    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitNoticeConf that = (SchoolRecruitNoticeConf) o;
        return id == that.id &&
                Objects.equals(initid, that.initid) &&
                Objects.equals(schoolguid, that.schoolguid) &&
                Objects.equals(name, that.name) &&
                Objects.equals(modelpath, that.modelpath) &&
                Objects.equals(type, that.type) &&
                Objects.equals(content, that.content) &&
                Objects.equals(visibility, that.visibility);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, initid, schoolguid, name, modelpath, type, content, visibility);
    }
}
