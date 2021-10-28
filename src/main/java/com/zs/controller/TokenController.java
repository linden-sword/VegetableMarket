package com.zs.controller;

import com.zs.entity.Token;
import com.zs.service.TokenService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Token)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:38:11
 */
@RestController
@RequestMapping("token")
public class TokenController {
    /**
     * 服务对象
     */
    @Resource
    private TokenService tokenService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Token> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tokenService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param token 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Token> add(Token token) {
        return ResponseEntity.ok(this.tokenService.insert(token));
    }

    /**
     * 编辑数据
     *
     * @param token 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Token> edit(Token token) {
        return ResponseEntity.ok(this.tokenService.update(token));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tokenService.deleteById(id));
    }

}

