package com.zs.dao;

import com.zs.entity.Token;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Token)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:38:11
 */
public interface TokenDao {

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
     * 查询指定行数据
     *
     * @param token    查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Token> queryAllByLimit(Token token, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param token 查询条件
     * @return 总行数
     */
    long count(Token token);

    /**
     * 新增数据
     *
     * @param token 实例对象
     * @return 影响行数
     */
    int insert(Token token);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Token> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Token> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Token> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Token> entities);

    /**
     * 修改数据
     *
     * @param token 实例对象
     * @return 影响行数
     */
    int update(Token token);

    /**
     * 通过主键删除数据
     *
     * @param toId 主键
     * @return 影响行数
     */
    int deleteById(Integer toId);

}

