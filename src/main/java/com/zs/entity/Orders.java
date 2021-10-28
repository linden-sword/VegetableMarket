package com.zs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (Orders)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:09
 */
public class Orders implements Serializable {
    private static final long serialVersionUID = 345652436258650442L;

    private String oId;

    private Integer uId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date oTime;

    private String oStatus;

    private Object oTotalPrice;

    private String oRemark;

    private Integer adId;

    private String oPayType;

    private Object oFreightPrice;

    private Integer oIdend;

    private Integer oPayStatus;

    private String es1;

    private String es2;

    private String es3;


    public String getOId() {
        return oId;
    }

    public void setOId(String oId) {
        this.oId = oId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public Date getOTime() {
        return oTime;
    }

    public void setOTime(Date oTime) {
        this.oTime = oTime;
    }

    public String getOStatus() {
        return oStatus;
    }

    public void setOStatus(String oStatus) {
        this.oStatus = oStatus;
    }

    public Object getOTotalPrice() {
        return oTotalPrice;
    }

    public void setOTotalPrice(Object oTotalPrice) {
        this.oTotalPrice = oTotalPrice;
    }

    public String getORemark() {
        return oRemark;
    }

    public void setORemark(String oRemark) {
        this.oRemark = oRemark;
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public String getOPayType() {
        return oPayType;
    }

    public void setOPayType(String oPayType) {
        this.oPayType = oPayType;
    }

    public Object getOFreightPrice() {
        return oFreightPrice;
    }

    public void setOFreightPrice(Object oFreightPrice) {
        this.oFreightPrice = oFreightPrice;
    }

    public Integer getOIdend() {
        return oIdend;
    }

    public void setOIdend(Integer oIdend) {
        this.oIdend = oIdend;
    }

    public Integer getOPayStatus() {
        return oPayStatus;
    }

    public void setOPayStatus(Integer oPayStatus) {
        this.oPayStatus = oPayStatus;
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

