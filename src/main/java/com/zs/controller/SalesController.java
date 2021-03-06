package com.zs.controller;

import com.zs.entity.Sales;
import com.zs.service.SalesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Sales)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:38:10
 */
@RestController
@RequestMapping("/VegetableMarket/sales")
public class SalesController {
    /**
     * 服务对象
     */
    @Resource
    private SalesService salesService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Sales> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.salesService.queryById(id));
    }

    @GetMapping("all")
    public com.zs.util.ResponseEntity<List<Sales>> queryAll(){
        List<Sales> salesList = salesService.queryAllSales();
        return new com.zs.util.ResponseEntity<>(1000,"salesList",salesList);
    }

    /**
     * 新增数据
     *
     * @param sales 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Sales> add(Sales sales) {
        return ResponseEntity.ok(this.salesService.insert(sales));
    }

    /**
     * 编辑数据
     *
     * @param sales 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Sales> edit(Sales sales) {
        return ResponseEntity.ok(this.salesService.update(sales));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.salesService.deleteById(id));
    }

}

