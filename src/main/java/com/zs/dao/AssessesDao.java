package com.zs.dao;

import com.zs.entity.Assesses;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Assesses)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:38:06
 */
public interface AssessesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param asId 主键
     * @return 实例对象
     */
    Assesses queryById(Integer asId);

    /**
     * 查询指定行数据
     *
     * @param assesses 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Assesses> queryAllByLimit(Assesses assesses, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param assesses 查询条件
     * @return 总行数
     */
    long count(Assesses assesses);

    /**
     * 新增数据
     *
     * @param assesses 实例对象
     * @return 影响行数
     */
    int insert(Assesses assesses);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Assesses> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Assesses> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Assesses> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Assesses> entities);

    /**
     * 修改数据
     *
     * @param assesses 实例对象
     * @return 影响行数
     */
    int update(Assesses assesses);

    /**
     * 通过主键删除数据
     *
     * @param asId 主键
     * @return 影响行数
     */
    int deleteById(Integer asId);

}

