package com.zs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (Address)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Address implements Serializable {
    private static final long serialVersionUID = -89435207012061925L;

    private Integer adId;

    private String adName;

    private String adTel;

    private String adAddress;

    private String adZipcode;

    private Integer uId;

    private Integer adDefaultAddress;

    private String es1;

    private String es2;

    private String es3;

}

