package com.zs.entity;

import java.io.Serializable;

/**
 * (Goodsparameters)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:08
 */
public class Goodsparameters implements Serializable {
    private static final long serialVersionUID = -83376956106464226L;

    private Integer pId;

    private String pType;

    private String pMaterialOrigin;

    private String pOrigin;

    private String pBatching;

    private String pProduct;

    private String pWeightTime;

    private String pProductionLicenseNo;

    private String pStorageMeans;

    private String pUsage;

    private Integer gId;

    private String es1;

    private String es2;

    private String es3;


    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getPType() {
        return pType;
    }

    public void setPType(String pType) {
        this.pType = pType;
    }

    public String getPMaterialOrigin() {
        return pMaterialOrigin;
    }

    public void setPMaterialOrigin(String pMaterialOrigin) {
        this.pMaterialOrigin = pMaterialOrigin;
    }

    public String getPOrigin() {
        return pOrigin;
    }

    public void setPOrigin(String pOrigin) {
        this.pOrigin = pOrigin;
    }

    public String getPBatching() {
        return pBatching;
    }

    public void setPBatching(String pBatching) {
        this.pBatching = pBatching;
    }

    public String getPProduct() {
        return pProduct;
    }

    public void setPProduct(String pProduct) {
        this.pProduct = pProduct;
    }

    public String getPWeightTime() {
        return pWeightTime;
    }

    public void setPWeightTime(String pWeightTime) {
        this.pWeightTime = pWeightTime;
    }

    public String getPProductionLicenseNo() {
        return pProductionLicenseNo;
    }

    public void setPProductionLicenseNo(String pProductionLicenseNo) {
        this.pProductionLicenseNo = pProductionLicenseNo;
    }

    public String getPStorageMeans() {
        return pStorageMeans;
    }

    public void setPStorageMeans(String pStorageMeans) {
        this.pStorageMeans = pStorageMeans;
    }

    public String getPUsage() {
        return pUsage;
    }

    public void setPUsage(String pUsage) {
        this.pUsage = pUsage;
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

