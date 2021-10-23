package com.zs.controller;

import com.zs.entity.Shoppingcart;
import com.zs.service.ShoppingcartService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Shoppingcart)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:38:10
 */
@RestController
@RequestMapping("shoppingcart")
public class ShoppingcartController {
    /**
     * 服务对象
     */
    @Resource
    private ShoppingcartService shoppingcartService;

    /**
     * 分页查询
     *
     * @param shoppingcart 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Shoppingcart>> queryByPage(Shoppingcart shoppingcart, PageRequest pageRequest) {
        return ResponseEntity.ok(this.shoppingcartService.queryByPage(shoppingcart, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Shoppingcart> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.shoppingcartService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param shoppingcart 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Shoppingcart> add(Shoppingcart shoppingcart) {
        return ResponseEntity.ok(this.shoppingcartService.insert(shoppingcart));
    }

    /**
     * 编辑数据
     *
     * @param shoppingcart 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Shoppingcart> edit(Shoppingcart shoppingcart) {
        return ResponseEntity.ok(this.shoppingcartService.update(shoppingcart));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.shoppingcartService.deleteById(id));
    }

}
