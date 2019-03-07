package com.liuqi.springboot.recruit.basevo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PlanVo {

    private Long planId;

    private String title;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    public PlanVo(Long planId, String title, Date startDate, Date endDate) {
        this.planId = planId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public PlanVo() {
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "PlanVo{" +
                "planId=" + planId +
                ", title='" + title + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
