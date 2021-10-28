package com.zs.dao;

import com.zs.entity.Classification;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Classification)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:38:06
 */
public interface ClassificationDao {


    List<Classification> queryAll();
    Classification   queryByName(String cName);
    /**
     * 统计总行数
     *
     * @param classification 查询条件
     * @return 总行数
     */
    long count(Classification classification);

    /**
     * 新增数据
     *
     * @param classification 实例对象
     * @return 影响行数
     */
    int insert(Classification classification);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Classification> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Classification> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Classification> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Classification> entities);

    /**
     * 修改数据
     *
     * @param classification 实例对象
     * @return 影响行数
     */
    int update(Classification classification);

    /**
     * 通过主键删除数据
     *
     * @param cId 主键
     * @return 影响行数
     */
    int deleteById(Integer cId);

}

