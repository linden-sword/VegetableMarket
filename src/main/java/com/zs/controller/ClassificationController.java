package com.zs.controller;

import com.github.pagehelper.PageInfo;
import com.zs.entity.Classification;
import com.zs.service.ClassificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Classification)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:38:06
 */
@RestController
public class ClassificationController {

    @Resource
    private ClassificationService classificationService;

    /**
     * 分页查询
     */
    @GetMapping("/VegetableMarket/FindClassification/cf/{pageNum}")
    public com.zs.util.ResponseEntity<PageInfo> queryClassificationBycId(@PathVariable("pageNum") Integer pageNum) {
        System.out.println("=== pageNum:" + pageNum);
        com.github.pagehelper.PageInfo pageInfo = classificationService.queryByCId(pageNum);
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
    @GetMapping("/VegetableMarket/FindClassification/{id}")
    public ResponseEntity<Classification> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.classificationService.queryById(id));
    }


    @GetMapping("/VegetableMarket/FindClassification")
    public com.zs.util.ResponseEntity<List<Classification>> queryAll() {
        List<Classification> classificationList = classificationService.FindAll();
        if (classificationList.isEmpty()) {
            return new com.zs.util.ResponseEntity<>(1002, "Error：查询用户失敗", null);
        } else {
            return new com.zs.util.ResponseEntity<>(1000, "Success:查询用户成功", classificationList);
        }
    }

    @GetMapping("/VegetableMarket/FindClassificationByName")
    public com.zs.util.ResponseEntity<Classification> queryByName(String cName) {
        Classification classification = classificationService.queryByName(cName);
        if (classification==null) {
            return new com.zs.util.ResponseEntity<>(1002, "Error：查询用户失敗", null);
        } else {
            return new com.zs.util.ResponseEntity<>(1000, "Success:查询用户成功", classification);
        }
    }

    /**
     * 新增数据
     *
     * @param
     * @return 新增结果
     */
    @PostMapping("/VegetableMarket/FindClassification")
    public com.zs.util.ResponseEntity<String> insertClass(Classification classification) {
        int flag= classificationService.insert(classification);
        if (flag==1){
            return new com.zs.util.ResponseEntity<>(1000,"success","添加成功");
        }
        return new com.zs.util.ResponseEntity<>(1002,"error","添加失败");

    }

    /**
     * 编辑数据
     *
     * @param classification 实体
     * @return 编辑结果
     */
    @PutMapping("/VegetableMarket/FindClassification")
    public com.zs.util.ResponseEntity<String> edit(Classification classification) {
        System.out.println("========"+classification.getCId());
        int flag=classificationService.update(classification);
        if (flag==1){
            return new com.zs.util.ResponseEntity<>(1000,"success","编辑成功");
        }
        return new com.zs.util.ResponseEntity<>(1002,"error","编辑失败");

    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/VegetableMarket/FindClassification")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.classificationService.deleteById(id));
    }





}

