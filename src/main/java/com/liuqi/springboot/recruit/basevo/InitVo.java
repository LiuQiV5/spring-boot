package com.liuqi.springboot.recruit.basevo;

import java.util.List;

public class InitVo {

    private String guide;

    private String description;

    private String note;

    private String examination;

    private List<NoticeVo> notices;

    private List<FormVo> forms;

    public InitVo(String guide, String description, String note, String examination, List<NoticeVo> notices, List<FormVo> forms) {
        this.guide = guide;
        this.description = description;
        this.note = note;
        this.examination = examination;
        this.notices = notices;
        this.forms = forms;
    }

    public InitVo() {
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

    public List<NoticeVo> getNotices() {
        return notices;
    }

    public void setNotices(List<NoticeVo> notices) {
        this.notices = notices;
    }

    public List<FormVo> getForms() {
        return forms;
    }

    public void setForms(List<FormVo> forms) {
        this.forms = forms;
    }

    @Override
    public String toString() {
        return "InitVo{" +
                "guide='" + guide + '\'' +
                ", description='" + description + '\'' +
                ", note='" + note + '\'' +
                ", examination='" + examination + '\'' +
                ", notices=" + notices +
                ", forms=" + forms +
                '}';
    }
}
