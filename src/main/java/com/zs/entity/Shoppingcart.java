package com.zs.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Shoppingcart)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:11
 */
public class Shoppingcart implements Serializable {
    private static final long serialVersionUID = -59988131921368054L;

    private Integer scId;

    private Integer uId;

    private Integer gId;

    private Double scWeight;

    private Date scAddtime;

    private String es1;

    private String es2;

    private String es3;

    private double g_price;
    private String g_name;



    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public Integer getGId() {
        return gId;
    }

    public void setGId(Integer gId) {
        this.gId = gId;
    }

    public Double getScWeight() {
        return scWeight;
    }

    public void setScWeight(Double scWeight) {
        this.scWeight = scWeight;
    }

    public Date getScAddtime() {
        return scAddtime;
    }

    public void setScAddtime(Date scAddtime) {
        this.scAddtime = scAddtime;
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

    public double getG_price() {
        return g_price;
    }

    public void setG_price(double g_price) {
        this.g_price = g_price;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }
}

