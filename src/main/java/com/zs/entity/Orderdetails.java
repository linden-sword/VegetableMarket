package com.zs.entity;

import java.io.Serializable;

/**
 * (Orderdetails)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:09
 */
public class Orderdetails implements Serializable {
    private static final long serialVersionUID = 466520518185794854L;

    private Integer odId;

    private String oId;

    private Integer gId;

    private Object odPrice;

    private Object odWeight;

    private String es1;

    private String es2;

    private String es3;


    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public String getOId() {
        return oId;
    }

    public void setOId(String oId) {
        this.oId = oId;
    }

    public Integer getGId() {
        return gId;
    }

    public void setGId(Integer gId) {
        this.gId = gId;
    }

    public Object getOdPrice() {
        return odPrice;
    }

    public void setOdPrice(Object odPrice) {
        this.odPrice = odPrice;
    }

    public Object getOdWeight() {
        return odWeight;
    }

    public void setOdWeight(Object odWeight) {
        this.odWeight = odWeight;
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

