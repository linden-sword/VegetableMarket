package com.zs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (Orders)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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



}

