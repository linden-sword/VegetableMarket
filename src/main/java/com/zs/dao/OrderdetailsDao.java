package com.zs.dao;

import com.zs.entity.Orderdetails;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Orderdetails)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:38:09
 */
public interface OrderdetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param odId 主键
     * @return 实例对象
     */
    Orderdetails queryById(Integer odId);
    List<Orderdetails>  queryByOId(String oId);
    /**
     * 查询指定行数据
     *
     * @param orderdetails 查询条件
     * @param pageable     分页对象
     * @return 对象列表
     */
    List<Orderdetails> queryAllByLimit(Orderdetails orderdetails, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param orderdetails 查询条件
     * @return 总行数
     */
    long count(Orderdetails orderdetails);

    /**
     * 新增数据
     *
     * @param orderdetails 实例对象
     * @return 影响行数
     */
    int insert(Orderdetails orderdetails);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Orderdetails> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Orderdetails> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Orderdetails> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Orderdetails> entities);

    /**
     * 修改数据
     *
     * @param orderdetails 实例对象
     * @return 影响行数
     */
    int update(Orderdetails orderdetails);

    /**
     * 通过主键删除数据
     *
     * @param odId 主键
     * @return 影响行数
     */
    int deleteById(Integer odId);

}

