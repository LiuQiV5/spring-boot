package com.liuqi.springboot.recruit.vo;

import com.liuqi.springboot.recruit.basevo.PlanVo;

import java.util.List;

public class PagePlanVo {

    private List<PlanVo> planList;

    private Integer totalCount;

    private Integer pageNo;

    private Integer pageSize;

    public PagePlanVo(List<PlanVo> planList, Integer totalCount, Integer pageNo, Integer pageSize) {
        this.planList = planList;
        this.totalCount = totalCount;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public PagePlanVo() {
    }

    public List<PlanVo> getPlanList() {
        return planList;
    }

    public void setPlanList(List<PlanVo> planList) {
        this.planList = planList;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PagePlanVo{" +
                "planList=" + planList +
                ", totalCount=" + totalCount +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
