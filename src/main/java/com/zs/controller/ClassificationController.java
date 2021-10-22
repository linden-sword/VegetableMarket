package com.zs.controller;

import com.zs.entity.Classification;
import com.zs.service.ClassificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Classification)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:38:06
 */
@RestController
@RequestMapping("classification")
public class ClassificationController {
    /**
     * 服务对象
     */
    @Resource
    private ClassificationService classificationService;

    /**
     * 分页查询
     *
     * @param classification 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Classification>> queryByPage(Classification classification, PageRequest pageRequest) {
        return ResponseEntity.ok(this.classificationService.queryByPage(classification, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Classification> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.classificationService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param classification 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Classification> add(Classification classification) {
        return ResponseEntity.ok(this.classificationService.insert(classification));
    }

    /**
     * 编辑数据
     *
     * @param classification 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Classification> edit(Classification classification) {
        return ResponseEntity.ok(this.classificationService.update(classification));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.classificationService.deleteById(id));
    }

}

