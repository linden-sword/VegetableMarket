package com.zs.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:07
 */
public class Goods implements Serializable {
    private static final long serialVersionUID = 872715097453402087L;

    private Integer gId;

    private Integer cId;

    private String gName;

    private Object gPrice;

    private Integer gIsdiscount;

    private String gDescribe;

    private Object gSalesVolume;

    private Integer gBuyPersonTime;

    private Object gStock;

    private Date gStorageTime;

    private Date gRemovalTime;

    private Integer gStatus;

    private String es1;

    private String es2;

    private String es3;


    public Integer getGId() {
        return gId;
    }

    public void setGId(Integer gId) {
        this.gId = gId;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getGName() {
        return gName;
    }

    public void setGName(String gName) {
        this.gName = gName;
    }

    public Object getGPrice() {
        return gPrice;
    }

    public void setGPrice(Object gPrice) {
        this.gPrice = gPrice;
    }

    public Integer getGIsdiscount() {
        return gIsdiscount;
    }

    public void setGIsdiscount(Integer gIsdiscount) {
        this.gIsdiscount = gIsdiscount;
    }

    public String getGDescribe() {
        return gDescribe;
    }

    public void setGDescribe(String gDescribe) {
        this.gDescribe = gDescribe;
    }

    public Object getGSalesVolume() {
        return gSalesVolume;
    }

    public void setGSalesVolume(Object gSalesVolume) {
        this.gSalesVolume = gSalesVolume;
    }

    public Integer getGBuyPersonTime() {
        return gBuyPersonTime;
    }

    public void setGBuyPersonTime(Integer gBuyPersonTime) {
        this.gBuyPersonTime = gBuyPersonTime;
    }

    public Object getGStock() {
        return gStock;
    }

    public void setGStock(Object gStock) {
        this.gStock = gStock;
    }

    public Date getGStorageTime() {
        return gStorageTime;
    }

    public void setGStorageTime(Date gStorageTime) {
        this.gStorageTime = gStorageTime;
    }

    public Date getGRemovalTime() {
        return gRemovalTime;
    }

    public void setGRemovalTime(Date gRemovalTime) {
        this.gRemovalTime = gRemovalTime;
    }

    public Integer getGStatus() {
        return gStatus;
    }

    public void setGStatus(Integer gStatus) {
        this.gStatus = gStatus;
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

