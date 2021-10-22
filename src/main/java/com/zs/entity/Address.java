package com.zs.entity;

import java.io.Serializable;

/**
 * (Address)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:05
 */
public class Address implements Serializable {
    private static final long serialVersionUID = -89435207012061925L;

    private Integer adId;

    private String adName;

    private String adTel;

    private String adAddress;

    private String adZipcode;

    private Integer uId;

    private Integer adDefaultAddress;

    private String es1;

    private String es2;

    private String es3;


    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdTel() {
        return adTel;
    }

    public void setAdTel(String adTel) {
        this.adTel = adTel;
    }

    public String getAdAddress() {
        return adAddress;
    }

    public void setAdAddress(String adAddress) {
        this.adAddress = adAddress;
    }

    public String getAdZipcode() {
        return adZipcode;
    }

    public void setAdZipcode(String adZipcode) {
        this.adZipcode = adZipcode;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public Integer getAdDefaultAddress() {
        return adDefaultAddress;
    }

    public void setAdDefaultAddress(Integer adDefaultAddress) {
        this.adDefaultAddress = adDefaultAddress;
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

