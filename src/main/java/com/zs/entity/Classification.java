package com.zs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (Classification)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:06
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Classification implements Serializable {
    private static final long serialVersionUID = 649736889965723750L;

    private Integer cId;

    private String cName;

    private Integer cfId;

    private String es1;

    private String es2;

    private String es3;



}

