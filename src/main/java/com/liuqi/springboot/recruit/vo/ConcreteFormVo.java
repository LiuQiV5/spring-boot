package com.liuqi.springboot.recruit.vo;

import com.liuqi.springboot.recruit.basevo.FormVo;
import com.liuqi.springboot.recruit.basevo.IntentVo;

import java.util.List;

public class ConcreteFormVo extends FormVo {

    private List<IntentVo> intent;

    public ConcreteFormVo(long id, String modelpath, String indexpath, String imgpath, String name, String model) {
        super(id, modelpath, indexpath, imgpath, name, model);
    }

    public ConcreteFormVo() {
    }

    public List<IntentVo> getIntent() {
        return intent;
    }

    public void setIntent(List<IntentVo> intent) {
        this.intent = intent;
    }

    @Override
    public String toString() {
        return "ConcreteFormVo{" +
                "intent=" + intent +
                '}';
    }
}
