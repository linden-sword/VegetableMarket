package com.zs.service;

import com.zs.entity.Token;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Token)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:38:11
 */
public interface TokenService {

    /**
     * 通过ID查询单条数据
     *
     * @param toId 主键
     * @return 实例对象
     */
    Token queryById(Integer toId);

    /**
     * 通过UUID查询单条数据
     *
     * @param toUuid 查询条件
     * @return 实例对象
     */
    Token queryByUUId(String toUuid);

    /**
     * 分页查询
     *
     * @param token       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Token> queryByPage(Token token, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param token 实例对象
     * @return 实例对象
     */
    Token insert(Token token);

    /**
     * 修改数据
     *
     * @param token 实例对象
     * @return 实例对象
     */
    Token update(Token token);

    /**
     * 通过主键删除数据
     *
     * @param toId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer toId);

}
