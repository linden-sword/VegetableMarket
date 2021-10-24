package com.zs.controller;

import com.github.pagehelper.PageInfo;
import com.zs.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
     * 查询分类下的商品
     *
     * @param cId
     * @return
     */
    @GetMapping("/VegetableMarket/goods/cId/{cId}")
    public com.zs.util.ResponseEntity<PageInfo> queryGoodsBycId(@PathVariable("cId") Integer cId, Integer pageNum){
        System.out.println("=== pageNum:"+pageNum);
        com.github.pagehelper.PageInfo pageInfo = goodsService.queryByCId(cId,pageNum);
        if (pageInfo.getList().isEmpty()){
            return new com.zs.util.ResponseEntity<>(1002,"Error",null);
        }
        return new com.zs.util.ResponseEntity<>(1000,"Success",pageInfo);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
//    @GetMapping("/VegetableMarket/goods/id/{id}")
//    public ResponseEntity<Goods> queryById(@PathVariable("id") Integer id) {
//        return ResponseEntity.ok(this.goodsService.queryById(id));
//    }

    /**
     * 新增数据
     *
     * @param goods 实体
     * @return 新增结果
     */
//    @PostMapping
//    public ResponseEntity<Goods> add(Goods goods) {
//        return ResponseEntity.ok(this.goodsService.insert(goods));
//    }

    /**
     * 编辑数据
     *
     * @param goods 实体
     * @return 编辑结果
     */
//    @PutMapping
//    public ResponseEntity<Goods> edit(Goods goods) {
//        return ResponseEntity.ok(this.goodsService.update(goods));
//    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
//    @DeleteMapping
//    public ResponseEntity<Boolean> deleteById(Integer id) {
//        return ResponseEntity.ok(this.goodsService.deleteById(id));
//    }

}

