package com.liuqi.springboot.recruit.vo;

import com.liuqi.springboot.entity.SchoolRecruitNotice;
import com.liuqi.springboot.recruit.basevo.NoticeVo;
import com.liuqi.springboot.recruit.basevo.PlanVo;
import com.liuqi.springboot.recruit.basevo.UrlVo;
import com.liuqi.springboot.recruit.entity.SchoolRecruitPlan;
import com.liuqi.springboot.recruit.entity.SchoolRecruitPlanNotice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecruitPlanVo extends PlanVo {

    private Long siteid;

    private String schoolguid;

    private String guide;

    private String description;

    private String note;

    private String examination;

    private String schoolcode;

    private List<ConcreteFormVo> form;

    private List<NoticeVo> notice;

    private List<UrlVo> url;

    public RecruitPlanVo(Long planId, String title, Date startDate, Date endDate,Date createDate){
        super(planId, title, startDate, endDate,createDate);
    }

    public RecruitPlanVo() {
    }

    public Long getSiteid() {
        return siteid;
    }

    public void setSiteid(Long siteid) {
        this.siteid = siteid;
    }

    public String getSchoolguid() {
        return schoolguid;
    }

    public void setSchoolguid(String schoolguid) {
        this.schoolguid = schoolguid;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getSchoolcode() {
        return schoolcode;
    }

    public void setSchoolcode(String schoolcode) {
        this.schoolcode = schoolcode;
    }

    public List<ConcreteFormVo> getForm() {
        return form;
    }

    public void setForm(List<ConcreteFormVo> form) {
        this.form = form;
    }

    public List<NoticeVo> getNotice() {
        return notice;
    }

    public void setNotice(List<NoticeVo> notice) {
        this.notice = notice;
    }

    public List<UrlVo> getUrl() {
        return url;
    }

    public void setUrl(List<UrlVo> url) {
        this.url = url;
    }

    public SchoolRecruitPlan planVOToPlanDO(RecruitPlanVo vo){
        SchoolRecruitPlan plan = new SchoolRecruitPlan();
        plan.setId(vo.getPlanId());
        plan.setDescription(vo.getDescription());
        plan.setEnddate(new java.sql.Date(vo.getEndDate().getTime()));
        plan.setStartdate(new java.sql.Date(vo.getStartDate().getTime()));
        plan.setExamination(vo.getExamination());
        plan.setGuide(vo.getGuide());
        plan.setNote(vo.getNote());
        plan.setSchoolcode(vo.getSchoolcode());
        plan.setSchoolguid(vo.getSchoolguid());
        plan.setSiteid(vo.getSiteid());
        plan.setTitle(vo.getTitle());
        return plan;
    }

    public List<SchoolRecruitPlanNotice> noticeVOsToNoticeDOs(RecruitPlanVo vo){
        List<SchoolRecruitPlanNotice> notices = new ArrayList<>(8);
        List<NoticeVo> noticeVos = vo.getNotice();
        if(noticeVos!=null && noticeVos.size()>0) {
            for (NoticeVo noticeVo : noticeVos) {
                SchoolRecruitPlanNotice notice = new SchoolRecruitPlanNotice();
                notice.setContent(noticeVo.getContent());
                notice.setModelpath(noticeVo.getModelpath());
                notice.setName(noticeVo.getName());
                notice.setType(noticeVo.getType());
                notice.setVisibility(noticeVo.getVisibility());
                notice.setOperatedate(new Date());
                notices.add(notice);
            }
        }
        return notices;
    }
}
