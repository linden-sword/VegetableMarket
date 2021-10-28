package com.zs.controller;

import com.github.pagehelper.PageInfo;
import com.zs.entity.Goods;
import com.zs.service.GoodsService;
import com.zs.util.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public com.zs.util.ResponseEntity<PageInfo> queryAllGoods(Integer pageNum){
        System.out.println("=== pageNum:"+pageNum);
        com.github.pagehelper.PageInfo pageInfo = goodsService.queAllGoods(pageNum);
        if (pageInfo.getList().isEmpty()){
            return new com.zs.util.ResponseEntity<>(1002,"Error",null);
        }
        return new com.zs.util.ResponseEntity<>(1000,"Success",pageInfo);
    }

    /**
     * 查询分类下的商品__分页
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
     * 查询分类下的商品__分页__已下架
     *
     * @param cId
     * @return
     */
    @GetMapping("/VegetableMarket/goodsPassed/cId/{cId}")
    public com.zs.util.ResponseEntity<PageInfo> queryGoodsBycIdPassed(@PathVariable("cId") Integer cId, Integer pageNum){
        System.out.println("=== pageNum:"+pageNum);
        com.github.pagehelper.PageInfo pageInfo = goodsService.queryByCIdPass(cId,pageNum);
        if (pageInfo.getList().isEmpty()){
            return new com.zs.util.ResponseEntity<>(1002,"Error",null);
        }
        return new com.zs.util.ResponseEntity<>(1000,"Success",pageInfo);
    }

    /**
     * 搜索商品__名称、描述，模糊查询
     *
     * @param searchString
     * @return
     */
    @GetMapping("/VegetableMarket/goods")
    public com.zs.util.ResponseEntity<PageInfo> queryByGNameLike(String searchString,Integer pageNum){
        System.out.println("=== searchString:"+searchString);
        Goods goods = new Goods();
        goods.setGName(searchString);
        com.github.pagehelper.PageInfo pageInfo = goodsService.queryByGNameLike(goods,pageNum);
        if (pageInfo.getList().isEmpty()){
            return new com.zs.util.ResponseEntity<>(1002,"Error",null);
        }
        return new com.zs.util.ResponseEntity<>(1000,"Success",pageInfo);
    }

//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("/VegetableMarket/goods/id/{id}")
//    public ResponseEntity<Goods> queryById(@PathVariable("id") Integer id) {
//        return new com.zs.util.ResponseEntity<>(1000,"Success",goodsService.queryById(id));
//    }
    /**
     * 通过主键查询单条数据
     *
     * @param gId 主键
     * @return 单条数据
     */
    @GetMapping("/VegetableMarket/goods/gId/{gId}")
    public com.zs.util.ResponseEntity<Goods> queryById(@PathVariable("gId") Integer gId) {
        Goods goods = goodsService.queryById(gId);
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

