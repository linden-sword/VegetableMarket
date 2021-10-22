package com.zs.dao;

import com.zs.entity.Sales;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Sales)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:38:10
 */
public interface SalesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    Sales queryById(Integer sId);

    /**
     * 查询指定行数据
     *
     * @param sales    查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Sales> queryAllByLimit(Sales sales, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param sales 查询条件
     * @return 总行数
     */
    long count(Sales sales);

    /**
     * 新增数据
     *
     * @param sales 实例对象
     * @return 影响行数
     */
    int insert(Sales sales);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Sales> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Sales> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Sales> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Sales> entities);

    /**
     * 修改数据
     *
     * @param sales 实例对象
     * @return 影响行数
     */
    int update(Sales sales);

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 影响行数
     */
    int deleteById(Integer sId);

}

