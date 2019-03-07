package com.liuqi.springboot.entity;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "school_recruit_stuinfo", schema = "oaapp", catalog = "")
public class SchoolRecruitStuinfo {
    private long id;
    private String name;
    private String idcard;
    private Date birthday;
    private String ticketno;
    private String sex;
    private String political;
    private String nationality;
    private String registration;
    private String photo;
    private String height;
    private String weight;
    private String health;
    private String schoolname;
    private String classname;
    private String address;
    private String recipient;
    private String phone;
    private String zipcode;
    private String recommend;
    private String schoolcode;
    private String honor;
    private String specialty;
    private String intent;
    private List<SchoolRecruitParent> parents;
    private List<SchoolRecruitTest> tests;

    @OneToMany(mappedBy = "stuinfo", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public List<SchoolRecruitTest> getTests() {
        return tests;
    }

    public void setTests(List<SchoolRecruitTest> tests) {
        this.tests = tests;
    }

    @OneToMany(mappedBy = "stuinfo", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public List<SchoolRecruitParent> getParents() {
        return parents;
    }

    public void setParents(List<SchoolRecruitParent> parents) {
        this.parents = parents;
    }

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "IDCARD")
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Basic
    @Column(name = "BIRTHDAY")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "TICKETNO")
    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno;
    }

    @Basic
    @Column(name = "SEX")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "POLITICAL")
    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    @Basic
    @Column(name = "NATIONALITY")
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Basic
    @Column(name = "REGISTRATION")
    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    @Basic
    @Column(name = "PHOTO")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "HEIGHT")
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Basic
    @Column(name = "WEIGHT")
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "HEALTH")
    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    @Basic
    @Column(name = "SCHOOLNAME")
    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    @Basic
    @Column(name = "CLASSNAME")
    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "RECIPIENT")
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Basic
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "ZIPCODE")
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "RECOMMEND")
    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    @Basic
    @Column(name = "SCHOOLCODE")
    public String getSchoolcode() {
        return schoolcode;
    }

    public void setSchoolcode(String schoolcode) {
        this.schoolcode = schoolcode;
    }

    @Basic
    @Column(name = "HONOR")
    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }

    @Basic
    @Column(name = "SPECIALTY")
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Basic
    @Column(name = "INTENT")
    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolRecruitStuinfo that = (SchoolRecruitStuinfo) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(idcard, that.idcard) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(ticketno, that.ticketno) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(political, that.political) &&
                Objects.equals(nationality, that.nationality) &&
                Objects.equals(registration, that.registration) &&
                Objects.equals(photo, that.photo) &&
                Objects.equals(height, that.height) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(health, that.health) &&
                Objects.equals(schoolname, that.schoolname) &&
                Objects.equals(classname, that.classname) &&
                Objects.equals(address, that.address) &&
                Objects.equals(recipient, that.recipient) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(zipcode, that.zipcode) &&
                Objects.equals(recommend, that.recommend) &&
                Objects.equals(schoolcode, that.schoolcode) &&
                Objects.equals(honor, that.honor) &&
                Objects.equals(specialty, that.specialty) &&
                Objects.equals(intent, that.intent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, idcard, birthday, ticketno, sex, political, nationality, registration, photo, height, weight, health, schoolname, classname, address, recipient, phone, zipcode, recommend, schoolcode, honor, specialty, intent);
    }
}
