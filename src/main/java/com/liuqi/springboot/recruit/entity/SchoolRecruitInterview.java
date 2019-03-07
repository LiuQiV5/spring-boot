package com.liuqi.springboot.recruit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_interview", schema = "oaapp", catalog = "")
public class SchoolRecruitInterview {
    private long id;
    private long fileid;
    private String name;
    private String idcard;
    private String schoolname;
    private String viewdate;
    private String address;
    private String time;
    private String room;
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
    @Column(name = "FILEID")
    public long getFileid() {
        return fileid;
    }

    public void setFileid(long fileid) {
        this.fileid = fileid;
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
    @Column(name = "SCHOOLNAME")
    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    @Basic
    @Column(name = "VIEWDATE")
    public String getViewdate() {
        return viewdate;
    }

    public void setViewdate(String viewdate) {
        this.viewdate = viewdate;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "TIME")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "ROOM")
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
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
        SchoolRecruitInterview that = (SchoolRecruitInterview) o;
        return id == that.id &&
                fileid == that.fileid &&
                Objects.equals(name, that.name) &&
                Objects.equals(idcard, that.idcard) &&
                Objects.equals(schoolname, that.schoolname) &&
                Objects.equals(viewdate, that.viewdate) &&
                Objects.equals(address, that.address) &&
                Objects.equals(time, that.time) &&
                Objects.equals(room, that.room) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileid, name, idcard, schoolname, viewdate, address, time, room, comment, status);
    }
}
