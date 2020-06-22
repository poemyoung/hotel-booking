package com.wxwl.hotelbooking.common.domain;

import java.util.Date;

public class Users {
    private Integer id;

    private String phone;

    private String idcard;

    private String pwd;

    private String email;

    private String avatar;

    private Boolean smoke;

    private String levelpref;

    private String paypref;

    private String accessneed;

    private Date createat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Boolean getSmoke() {
        return smoke;
    }

    public void setSmoke(Boolean smoke) {
        this.smoke = smoke;
    }

    public String getLevelpref() {
        return levelpref;
    }

    public void setLevelpref(String levelpref) {
        this.levelpref = levelpref == null ? null : levelpref.trim();
    }

    public String getPaypref() {
        return paypref;
    }

    public void setPaypref(String paypref) {
        this.paypref = paypref == null ? null : paypref.trim();
    }

    public String getAccessneed() {
        return accessneed;
    }

    public void setAccessneed(String accessneed) {
        this.accessneed = accessneed == null ? null : accessneed.trim();
    }

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }
}