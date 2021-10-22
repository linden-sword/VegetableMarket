package com.zs.controller;

import com.zs.entity.Orderdetails;
import com.zs.service.OrderdetailsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Orderdetails)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:38:09
 */
@RestController
@RequestMapping("orderdetails")
public class OrderdetailsController {
    /**
     * 服务对象
     */
    @Resource
    private OrderdetailsService orderdetailsService;

    /**
     * 分页查询
     *
     * @param orderdetails 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Orderdetails>> queryByPage(Orderdetails orderdetails, PageRequest pageRequest) {
        return ResponseEntity.ok(this.orderdetailsService.queryByPage(orderdetails, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Orderdetails> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.orderdetailsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param orderdetails 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Orderdetails> add(Orderdetails orderdetails) {
        return ResponseEntity.ok(this.orderdetailsService.insert(orderdetails));
    }

    /**
     * 编辑数据
     *
     * @param orderdetails 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Orderdetails> edit(Orderdetails orderdetails) {
        return ResponseEntity.ok(this.orderdetailsService.update(orderdetails));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.orderdetailsService.deleteById(id));
    }

}

