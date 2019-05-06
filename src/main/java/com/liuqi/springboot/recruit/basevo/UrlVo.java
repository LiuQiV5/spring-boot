package com.liuqi.springboot.recruit.basevo;

public class UrlVo {

    private Long planid;

    private String url;

    public UrlVo() {
    }

    public UrlVo(Long planid, String url) {
        this.planid = planid;
        this.url = url;
    }

    public Long getPlanid() {
        return planid;
    }

    public void setPlanid(Long planid) {
        this.planid = planid;
    }
}
