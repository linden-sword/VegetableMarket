package com.zs.controller;

import com.github.pagehelper.PageInfo;
import com.zs.entity.Orderdetails;
import com.zs.service.OrderdetailsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Orderdetails)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:38:09
 */
@RestController
public class OrderdetailsController {
    /**
     * 服务对象
     */
    @Resource
    private OrderdetailsService orderdetailsService;


    /**
     * 查询分类下的商品
     *
     * @param oid
     * @return
     */
    @GetMapping("/VegetableMarket/OrdersDetails/oid/{oid}")
    public com.zs.util.ResponseEntity<PageInfo> queryGoodsBycId(@PathVariable("oid") String oid, Integer pageNum) {
        System.out.println("=== pageNum:" + pageNum);
        com.github.pagehelper.PageInfo pageInfo = orderdetailsService.queryByoid(oid, pageNum);
        if (pageInfo.getList().isEmpty()) {
            return new com.zs.util.ResponseEntity<>(1002, "Error", null);
        }
        return new com.zs.util.ResponseEntity<>(1000, "Success", pageInfo);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/VegetableMarket/OrdersDetails/{id}")
    public ResponseEntity<Orderdetails> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.orderdetailsService.queryById(id));
    }


    @GetMapping("/VegetableMarket/OrdersDetails")
    public com.zs.util.ResponseEntity<List<Orderdetails>> queryByOId(String oId) {
        List<Orderdetails> orderdetailsList = orderdetailsService.queryByOId(oId);
        if (orderdetailsList.size() > 0) {
            return new com.zs.util.ResponseEntity<>(1000,"Success",orderdetailsList);
        }else {
            return new com.zs.util.ResponseEntity<>(1000,"Success",null);
        }

    }

    /**
     * 新增数据
     *
     * @param orderdetails 实体
     * @return 新增结果
     */
    @PostMapping("/VegetableMarket/OrdersDetails")
    public ResponseEntity<Orderdetails> add(Orderdetails orderdetails) {
        return ResponseEntity.ok(this.orderdetailsService.insert(orderdetails));
    }

    /**
     * 编辑数据
     *
     * @param orderdetails 实体
     * @return 编辑结果
     */
    @PutMapping("/VegetableMarket/OrdersDetails")
    public ResponseEntity<Orderdetails> edit(Orderdetails orderdetails) {
        return ResponseEntity.ok(this.orderdetailsService.update(orderdetails));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/VegetableMarket/OrdersDetails")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.orderdetailsService.deleteById(id));
    }

}

