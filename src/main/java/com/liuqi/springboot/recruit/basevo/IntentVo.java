package com.liuqi.springboot.recruit.basevo;

public class IntentVo {

    private Long id;

    private Long planformid;

    private String comment;

    public IntentVo(Long id, Long planformid, String comment) {
        this.id = id;
        this.planformid = planformid;
        this.comment = comment;
    }

    public IntentVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlanformid() {
        return planformid;
    }

    public void setPlanformid(Long planformid) {
        this.planformid = planformid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "IntentVo{" +
                "id=" + id +
                ", planformid=" + planformid +
                ", comment='" + comment + '\'' +
                '}';
    }
}
