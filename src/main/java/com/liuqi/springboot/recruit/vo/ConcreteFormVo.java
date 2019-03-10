package com.liuqi.springboot.recruit.vo;

import com.liuqi.springboot.recruit.basevo.FormVo;
import com.liuqi.springboot.recruit.basevo.IntentVo;
import com.liuqi.springboot.recruit.entity.SchoolRecruitPlanForm;

import java.util.ArrayList;
import java.util.List;

public class ConcreteFormVo extends FormVo {

    private Long planformid;

    private String alias;

    private List<IntentVo> intent = new ArrayList<>(10);

    public ConcreteFormVo(Long planformid,Long id, String modelpath, String indexpath, String imgpath, String name, String model,String alias) {
        super(id, modelpath, indexpath, imgpath, name, model);
        this.alias = alias;
        this.planformid = planformid;
    }

    public ConcreteFormVo() {
    }

    public void add(IntentVo vo){
        intent.add(vo);
    }

    public List<IntentVo> getIntent() {
        return intent;
    }

    public void setIntent(List<IntentVo> intent) {
        this.intent = intent;
    }

    public SchoolRecruitPlanForm voToDo(ConcreteFormVo vo){
        SchoolRecruitPlanForm form = new SchoolRecruitPlanForm();
        form.setAlias(vo.getAlias());
        form.setFormid(vo.getId());
        return form;
    }

    public Long getPlanformid() {
        return planformid;
    }

    public void setPlanformid(Long planformid) {
        this.planformid = planformid;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "ConcreteFormVo{" +
                "alias='" + alias + '\'' +
                ", intent=" + intent +
                '}';
    }
}
