package com.zs.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Sales)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:10
 */
public class Sales implements Serializable {
    private static final long serialVersionUID = 775481426816948822L;

    private Integer sId;

    private Date sDateTime;

    private Integer cId;

    private Integer sOrderTotal;

    private double sTotal;

    private double sTotalWeight;

    private Object sFreightPrice;

    private String es1;

    private String es2;

    private String es3;


    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public Date getSDateTime() {
        return sDateTime;
    }

    public void setSDateTime(Date sDateTime) {
        this.sDateTime = sDateTime;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public Integer getSOrderTotal() {
        return sOrderTotal;
    }

    public void setSOrderTotal(Integer sOrderTotal) {
        this.sOrderTotal = sOrderTotal;
    }

    public double getSTotal() {
        return sTotal;
    }

    public void setSTotal(double sTotal) {
        this.sTotal = sTotal;
    }

    public double getSTotalWeight() {
        return sTotalWeight;
    }

    public void setSTotalWeight(double sTotalWeight) {
        this.sTotalWeight = sTotalWeight;
    }

    public Object getSFreightPrice() {
        return sFreightPrice;
    }

    public void setSFreightPrice(Object sFreightPrice) {
        this.sFreightPrice = sFreightPrice;
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

