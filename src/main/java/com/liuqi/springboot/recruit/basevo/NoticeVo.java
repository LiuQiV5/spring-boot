package com.liuqi.springboot.recruit.basevo;

public class NoticeVo {

    private String name;

    private String type;

    private String content;

    private String modelpath;

    private String visibility;

    public NoticeVo() {
    }

    public NoticeVo(String name, String type, String content, String modelpath, String visibility) {
        this.name = name;
        this.type = type;
        this.content = content;
        this.modelpath = modelpath;
        this.visibility = visibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getModelpath() {
        return modelpath;
    }

    public void setModelpath(String modelpath) {
        this.modelpath = modelpath;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "NoticeVo{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", modelpath='" + modelpath + '\'' +
                ", visibility='" + visibility + '\'' +
                '}';
    }
}
