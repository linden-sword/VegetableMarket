package com.zs.controller;

import com.zs.entity.Goodsparameters;
import com.zs.service.GoodsparametersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Goodsparameters)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:38:07
 */
@RestController
@RequestMapping("goodsparameters")
public class GoodsparametersController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsparametersService goodsparametersService;

    /**
     * 分页查询
     *
     * @param goodsparameters 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Goodsparameters>> queryByPage(Goodsparameters goodsparameters, PageRequest pageRequest) {
        return ResponseEntity.ok(this.goodsparametersService.queryByPage(goodsparameters, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Goodsparameters> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.goodsparametersService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param goodsparameters 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Goodsparameters> add(Goodsparameters goodsparameters) {
        return ResponseEntity.ok(this.goodsparametersService.insert(goodsparameters));
    }

    /**
     * 编辑数据
     *
     * @param goodsparameters 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Goodsparameters> edit(Goodsparameters goodsparameters) {
        return ResponseEntity.ok(this.goodsparametersService.update(goodsparameters));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.goodsparametersService.deleteById(id));
    }

}

