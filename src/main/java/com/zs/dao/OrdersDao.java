package com.zs.dao;

import com.zs.entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Orders)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:38:09
 */
public interface OrdersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param oId 主键
     * @return 实例对象
     */
    Orders queryById(String oId);

    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 影响行数
     */
    int insert(Orders orders);

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 影响行数
     */
    int update(Orders orders);

    /**
     * 通过主键删除数据
     *
     * @param oId 主键
     * @return 影响行数
     */
    int deleteById(String oId);

}

