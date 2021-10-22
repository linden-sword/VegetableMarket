package com.zs.service;

import com.zs.entity.Sales;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Sales)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:38:10
 */
public interface SalesService {

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    Sales queryById(Integer sId);

    /**
     * 分页查询
     *
     * @param sales       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Sales> queryByPage(Sales sales, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sales 实例对象
     * @return 实例对象
     */
    Sales insert(Sales sales);

    /**
     * 修改数据
     *
     * @param sales 实例对象
     * @return 实例对象
     */
    Sales update(Sales sales);

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer sId);

}
