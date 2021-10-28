package com.zs.controller;

import com.zs.entity.Goodsphoto;
import com.zs.service.GoodsphotoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Goodsphoto)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:38:08
 */
@RestController
@RequestMapping("goodsphoto")
public class GoodsphotoController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsphotoService goodsphotoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Goodsphoto> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.goodsphotoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param goodsphoto 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Goodsphoto> add(Goodsphoto goodsphoto) {
        return ResponseEntity.ok(this.goodsphotoService.insert(goodsphoto));
    }

    /**
     * 编辑数据
     *
     * @param goodsphoto 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Goodsphoto> edit(Goodsphoto goodsphoto) {
        return ResponseEntity.ok(this.goodsphotoService.update(goodsphoto));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.goodsphotoService.deleteById(id));
    }

}

