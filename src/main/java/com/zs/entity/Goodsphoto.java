package com.zs.entity;

import java.io.Serializable;

/**
 * (Goodsphoto)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:08
 */
public class Goodsphoto implements Serializable {
    private static final long serialVersionUID = -26501536673785430L;

    private Integer gpId;

    private String gpName;

    private Integer gId;

    private Integer gLevel;

    private String es1;

    private String es2;

    private String es3;


    public Integer getGpId() {
        return gpId;
    }

    public void setGpId(Integer gpId) {
        this.gpId = gpId;
    }

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    public Integer getGId() {
        return gId;
    }

    public void setGId(Integer gId) {
        this.gId = gId;
    }

    public Integer getGLevel() {
        return gLevel;
    }

    public void setGLevel(Integer gLevel) {
        this.gLevel = gLevel;
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

