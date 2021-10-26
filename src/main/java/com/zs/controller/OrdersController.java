package com.zs.controller;

import com.github.pagehelper.PageInfo;
import com.zs.entity.Orders;
import com.zs.service.OrdersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Orders)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:38:09
 */
@RestController
public class OrdersController {
    /**
     * 服务对象
     */
    @Resource
    private OrdersService ordersService;



    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Orders> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.ordersService.queryById(id));
    }



    @GetMapping("/VegetableMarket/OrdersPage")
    public com.zs.util.ResponseEntity<PageInfo> queryOrdersPage(int pageNum){
        com.github.pagehelper.PageInfo pageInfo = ordersService.queryordersPage(pageNum);
        System.out.println("===="+pageInfo);
        if (pageInfo.getList().isEmpty()){
            return new com.zs.util.ResponseEntity<>(1002,"Error",null);
        }
        return new com.zs.util.ResponseEntity<>(1000,"Success",pageInfo);
    }


    /**
     * 新增数据
     *
     * @param orders 实体
     * @return 新增结果
     */
    @PostMapping("/VegetableMarket/OrdersPage")
    public ResponseEntity<Orders> add(Orders orders) {
        return ResponseEntity.ok(this.ordersService.insert(orders));
    }

    /**
     * 编辑数据
     *
     * @param orders 实体
     * @return 编辑结果
     */
    @PutMapping("/VegetableMarket/OrdersPage")
    public ResponseEntity<Orders> edit(Orders orders) {
        return ResponseEntity.ok(this.ordersService.update(orders));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/VegetableMarket/OrdersPage")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.ordersService.deleteById(id));
    }

}

