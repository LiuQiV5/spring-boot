package com.liuqi.springboot.recruit.basevo;

public class FormVo {

    private Long id;

    private String modelpath;

    private String indexpath;

    private String imgpath;

    private String name;

    private String model;

    public FormVo(Long id, String modelpath, String indexpath, String imgpath, String name, String model) {
        this.id = id;
        this.modelpath = modelpath;
        this.indexpath = indexpath;
        this.imgpath = imgpath;
        this.name = name;
        this.model = model;
    }

    public FormVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelpath() {
        return modelpath;
    }

    public void setModelpath(String modelpath) {
        this.modelpath = modelpath;
    }

    public String getIndexpath() {
        return indexpath;
    }

    public void setIndexpath(String indexpath) {
        this.indexpath = indexpath;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "FormVo{" +
                "id=" + id +
                ", modelpath='" + modelpath + '\'' +
                ", indexpath='" + indexpath + '\'' +
                ", imgpath='" + imgpath + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
