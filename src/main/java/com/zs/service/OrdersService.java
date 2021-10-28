package com.zs.service;

import com.github.pagehelper.PageInfo;
import com.zs.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

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
     * 添加订单(事务)__直接购买
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    int insert(Orders orders, String gId, String odWeight);


    PageInfo queryordersPage(int pageNum);
    PageInfo queryAllordersPageByUid(int uId,int pageNum);


    /**
     * 添加订单(事务)__购物车结算
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    int insertByCart(Orders orders,Integer[] scIdArr);

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
