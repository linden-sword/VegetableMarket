package com.zs.controller;

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
     * @param classification 实体
     * @return 新增结果
     */
    @GetMapping("/VegetableMarket/AddClassification")
    public ResponseEntity<Classification> add(Classification classification) {
        return ResponseEntity.ok(this.classificationService.insert(classification));
    }





}

