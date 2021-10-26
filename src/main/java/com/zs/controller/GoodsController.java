package com.zs.controller;

import com.zs.entity.Goods;
import com.zs.entity.Goodsparameters;
import com.zs.entity.Goodsphoto;
import com.zs.service.GoodsService;
import com.zs.service.GoodsparametersService;
import com.zs.service.GoodsphotoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * (Goods)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:38:07
 */
@RestController
public class GoodsController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;


    /**
     * 新增数据
     *
     * @param goods 实体
     * @return 新增结果
     */
    @GetMapping("/VegetableMarket/AddGoods")
    public com.zs.util.ResponseEntity<Goods> add(Goods goods) {
        Date date = new Date();
        goods.setGStorageTime(date);
        Goods goods1 = goodsService.insert(goods);
        if (goods1 == null) {
            return new com.zs.util.ResponseEntity<>(1002, "Error:添加失败", null);
        } else {
            return new com.zs.util.ResponseEntity<>(1001, "Error:添加了商品", goods1);
        }


    }

}

