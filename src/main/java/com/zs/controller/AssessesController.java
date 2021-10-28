package com.zs.controller;

import com.zs.entity.Assesses;
import com.zs.service.AssessesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Assesses)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:38:05
 */
@RestController
@RequestMapping("assesses")
public class AssessesController {
    /**
     * 服务对象
     */
    @Resource
    private AssessesService assessesService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Assesses> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.assessesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param assesses 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Assesses> add(Assesses assesses) {
        return ResponseEntity.ok(this.assessesService.insert(assesses));
    }

    /**
     * 编辑数据
     *
     * @param assesses 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Assesses> edit(Assesses assesses) {
        return ResponseEntity.ok(this.assessesService.update(assesses));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.assessesService.deleteById(id));
    }

}

