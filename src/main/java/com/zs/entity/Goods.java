package com.zs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date gStorageTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date gRemovalTime;

    private Integer gStatus;

    private String es1;

    private String es2;

    private String es3;



}

