package com.zs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Users)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:12
 */
public class Users implements Serializable {
    private static final long serialVersionUID = 306219090781440025L;

    private Integer uId;

    private String username;

    private String passwd;

    private String uEmail;

    private String uTel;

    private String uSex;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date uDatetime;

    private String uPhoto;

    private String uRole;

    private String uStatus;

    private String es1;

    private String es2;

    private String es3;


    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUEmail() {
        return uEmail;
    }

    public void setUEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getUTel() {
        return uTel;
    }

    public void setUTel(String uTel) {
        this.uTel = uTel;
    }

    public String getUSex() {
        return uSex;
    }

    public void setUSex(String uSex) {
        this.uSex = uSex;
    }

    public Date getUDatetime() {
        return uDatetime;
    }

    public void setUDatetime(Date uDatetime) {
        this.uDatetime = uDatetime;
    }

    public String getUPhoto() {
        return uPhoto;
    }

    public void setUPhoto(String uPhoto) {
        this.uPhoto = uPhoto;
    }

    public String getURole() {
        return uRole;
    }

    public void setURole(String uRole) {
        this.uRole = uRole;
    }

    public String getUStatus() {
        return uStatus;
    }

    public void setUStatus(String uStatus) {
        this.uStatus = uStatus;
    }

    public String getEs1() {
        return es1;
    }

    public void setEs1(String es1) {
        this.es1 = es1;
    }

    public String getEs2() {
        return es2;
    }

    public void setEs2(String es2) {
        this.es2 = es2;
    }

    public String getEs3() {
        return es3;
    }

    public void setEs3(String es3) {
        this.es3 = es3;
    }

}

