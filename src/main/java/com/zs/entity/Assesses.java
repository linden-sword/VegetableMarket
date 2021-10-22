package com.zs.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Assesses)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:06
 */
public class Assesses implements Serializable {
    private static final long serialVersionUID = -15379500189922254L;

    private Integer asId;

    private Integer uId;

    private String asContent;

    private Date asTime;

    private Integer gId;

    private String es1;

    private String es2;

    private String es3;


    public Integer getAsId() {
        return asId;
    }

    public void setAsId(Integer asId) {
        this.asId = asId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getAsContent() {
        return asContent;
    }

    public void setAsContent(String asContent) {
        this.asContent = asContent;
    }

    public Date getAsTime() {
        return asTime;
    }

    public void setAsTime(Date asTime) {
        this.asTime = asTime;
    }

    public Integer getGId() {
        return gId;
    }

    public void setGId(Integer gId) {
        this.gId = gId;
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

