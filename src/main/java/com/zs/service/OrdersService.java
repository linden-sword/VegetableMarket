package com.zs.service;

import com.github.pagehelper.PageInfo;
import com.zs.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Orders)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:38:10
 */
public interface OrdersService {

    /**
     * 通过ID查询单条数据
     *
     * @param oId 主键
     * @return 实例对象
     */
    Orders queryById(String oId);

    /**
     * 分页查询
     *
     * @param orders      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Orders> queryByPage(Orders orders, PageRequest pageRequest);


    PageInfo queryordersPage(int pageNum);
    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    Orders insert(Orders orders);

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    Orders update(Orders orders);

    /**
     * 通过主键删除数据
     *
     * @param oId 主键
     * @return 是否成功
     */
    boolean deleteById(String oId);

}
