package com.zs.dao;

import com.zs.entity.Goodsparameters;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Goodsparameters)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:38:07
 */
public interface GoodsparametersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    Goodsparameters queryById(Integer pId);

    Goodsparameters queryByGId(Integer GId);

    /**
     * 查询指定行数据
     *
     * @param goodsparameters 查询条件
     * @param pageable        分页对象
     * @return 对象列表
     */
    List<Goodsparameters> queryAllByLimit(Goodsparameters goodsparameters, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param goodsparameters 查询条件
     * @return 总行数
     */
    long count(Goodsparameters goodsparameters);

    /**
     * 新增数据
     *
     * @param goodsparameters 实例对象
     * @return 影响行数
     */
    int insert(Goodsparameters goodsparameters);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Goodsparameters> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Goodsparameters> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Goodsparameters> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Goodsparameters> entities);

    /**
     * 修改数据
     *
     * @param goodsparameters 实例对象
     * @return 影响行数
     */
    int update(Goodsparameters goodsparameters);

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 影响行数
     */
    int deleteById(Integer pId);

}

