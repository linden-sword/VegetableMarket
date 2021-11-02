package com.zs.controller;

import com.github.pagehelper.PageInfo;
import com.zs.entity.Goods;
import com.zs.service.GoodsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import java.io.File;
import java.io.IOException;
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
     * 查询所有商品
     *
     * @return
     */
    @GetMapping("/VegetableMarket/goods/allGoods")
    public com.zs.util.ResponseEntity<PageInfo> queryAllGoods(Integer pageNum) {
        System.out.println("=== pageNum:" + pageNum);
        com.github.pagehelper.PageInfo pageInfo = goodsService.queAllGoods(pageNum);
        if (pageInfo.getList().isEmpty()) {
            return new com.zs.util.ResponseEntity<>(1002, "Error", null);
        }
        return new com.zs.util.ResponseEntity<>(1000, "Success", pageInfo);
    }

    /**
     * 查询分类下的商品__分页
     *
     * @param cId
     * @return
     */
    @GetMapping("/VegetableMarket/goods/cId/{cId}")
    public com.zs.util.ResponseEntity<PageInfo> queryGoodsBycId(@PathVariable("cId") Integer cId, Integer pageNum) {
        System.out.println("=== pageNum:" + pageNum);
        com.github.pagehelper.PageInfo pageInfo = goodsService.queryByCId(cId, pageNum);
        if (pageInfo.getList().isEmpty()) {
            return new com.zs.util.ResponseEntity<>(1002, "Error", null);
        }
        return new com.zs.util.ResponseEntity<>(1000, "Success", pageInfo);
    }

    /**
     * 查询分类下的商品__分页__已下架
     *
     * @param cId
     * @return
     */
    @GetMapping("/VegetableMarket/goodsPassed/cId/{cId}")
    public com.zs.util.ResponseEntity<PageInfo> queryGoodsBycIdPassed(@PathVariable("cId") Integer cId, Integer pageNum) {
        System.out.println("=== pageNum:" + pageNum);
        com.github.pagehelper.PageInfo pageInfo = goodsService.queryByCIdPass(cId, pageNum);
        if (pageInfo.getList().isEmpty()) {
            return new com.zs.util.ResponseEntity<>(1002, "Error", null);
        }
        return new com.zs.util.ResponseEntity<>(1000, "Success", pageInfo);
    }

    /**
     * 搜索商品__名称、描述，模糊查询
     *
     * @param searchString
     * @return
     */
    @GetMapping("/VegetableMarket/goods")
    public com.zs.util.ResponseEntity<PageInfo> queryByGNameLike(String searchString, Integer pageNum) {
        System.out.println("=== searchString:" + searchString);
        Goods goods = new Goods();
        goods.setGName(searchString);
        com.github.pagehelper.PageInfo pageInfo = goodsService.queryByGNameLike(goods, pageNum);
        if (pageInfo.getList().isEmpty()) {
            return new com.zs.util.ResponseEntity<>(1002, "Error", null);
        }
        return new com.zs.util.ResponseEntity<>(1000, "Success", pageInfo);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param gId 主键
     * @return 单条数据
     */
    @GetMapping("/VegetableMarket/goods/gId/{gId}")
    public com.zs.util.ResponseEntity<Goods> queryById(@PathVariable("gId") Integer gId) {
        Goods goods = goodsService.queryById(gId);
        System.out.println("goods:" + goods.toString());
        if (goods == null) {
            return new com.zs.util.ResponseEntity<>(1002, "Error", null);
        }
        return new com.zs.util.ResponseEntity<>(1000, "Success", goods);
    }

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

    /**
     * 编辑商品__主图上传
     *
     * @param goods 实体
     * @return 编辑结果
     */
    @PostMapping("/VegetableMarket/goods")
    public com.zs.util.ResponseEntity<String> edit(MultipartFile picture, Goods goods) throws IOException {
        //原文件名
        String originalFilename = picture.getOriginalFilename();
        //生成UUID文件名
        String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        //把文件名等属性保存到Photos对象里面
        goods.setEs1(newFileName);
        //把照片存到照片库中
        File file = new File("E:/images/" + newFileName);
        picture.transferTo(file);
        //把对象存入数据库表
        int flag = goodsService.update(goods);
        if (flag == 1) {
            return new com.zs.util.ResponseEntity<>(1000, "Success", "修改商品信息成功");
        } else {
            return new com.zs.util.ResponseEntity<>(1002, "Error", "修改商品信息失败");
        }
    }


    /**
     * 查询新品
     */
    @GetMapping("/VegetableMarket/goods/FreshTaste")
    public com.zs.util.ResponseEntity<PageInfo> queryFreshTaste(Integer pageNum) {
        com.github.pagehelper.PageInfo pageInfo = goodsService.queryAllPut(1);
        if (pageInfo.getList().isEmpty()) {
            return new com.zs.util.ResponseEntity<>(1002, "Error", null);
        }
        return new com.zs.util.ResponseEntity<>(1000, "Success", pageInfo);
    }

    @GetMapping("/VegetableMarket/goods/FreshTaste2")
    public com.zs.util.ResponseEntity<PageInfo> queryFreshTaste2(Integer pageNum) {
        com.github.pagehelper.PageInfo pageInfo = goodsService.queryAllPut2(1);
        if (pageInfo.getList().isEmpty()) {
            return new com.zs.util.ResponseEntity<>(1002, "Error", null);
        }
        return new com.zs.util.ResponseEntity<>(1000, "Success", pageInfo);
    }

    /**
     * 查询旧品（特价促销）
     */
    @GetMapping("/VegetableMarket/goods/PromotionSale")
    public com.zs.util.ResponseEntity<PageInfo> queryPromotionSale(Integer pageNum) {
        com.github.pagehelper.PageInfo pageInfo = goodsService.queryAllPutASC(1);
        if (pageInfo.getList().isEmpty()) {
            return new com.zs.util.ResponseEntity<>(1002, "Error", null);
        }
        return new com.zs.util.ResponseEntity<>(1000, "Success", pageInfo);
    }


    /**
     * 编辑商品__只含信息
     *
     * @param goods 实体
     * @return 编辑结果
     */
    @PutMapping("/VegetableMarket/goods")
    public com.zs.util.ResponseEntity<String> edit1(Goods goods) {
        //把对象存入数据库表
        int flag = goodsService.update(goods);
        if (flag == 1) {
            return new com.zs.util.ResponseEntity<>(1000, "Success", "修改商品信息成功");
        } else {
            return new com.zs.util.ResponseEntity<>(1002, "Error", "修改商品信息失败");
        }
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/VegetableMarket/goods/delete/{gId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("gId") Integer id) {
        return ResponseEntity.ok(this.goodsService.deleteById(id));
    }
}