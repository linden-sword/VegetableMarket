package com.zs.entity;

import java.io.Serializable;

/**
 * (Classification)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:06
 */
public class Classification implements Serializable {
    private static final long serialVersionUID = 649736889965723750L;

    private Integer cId;

    private String cName;

    private Integer cfId;

    private String es1;

    private String es2;

    private String es3;


    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public Integer getCfId() {
        return cfId;
    }

    public void setCfId(Integer cfId) {
        this.cfId = cfId;
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

