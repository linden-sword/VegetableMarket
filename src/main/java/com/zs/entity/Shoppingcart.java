package com.zs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (Shoppingcart)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:11
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
}

