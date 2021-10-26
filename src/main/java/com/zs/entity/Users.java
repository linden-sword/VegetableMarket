package com.zs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (Users)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:38:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users implements Serializable {
    private static final long serialVersionUID = 306219090781440025L;

    private Integer uId;
    private String username;
    private String passwd;
    private String uEmail;
    private String uTel;
    private String uSex;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date uDatetime;
    private String uPhoto;
    private String uRole;
    private String uStatus;
    private String es1;
    private String es2;
    private String es3;


}

