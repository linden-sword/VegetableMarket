package com.zs.service;

import com.zs.entity.Shoppingcart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Shoppingcart)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:38:11
 */
public interface ShoppingcartService {

    /**
     * 通过ID查询单条数据
     *
     * @param scId 主键
     * @return 实例对象
     */
    Shoppingcart queryById(Integer scId);

    /**
     * 分页查询
     *
     * @param shoppingcart 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    Page<Shoppingcart> queryByPage(Shoppingcart shoppingcart, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param shoppingcart 实例对象
     * @return 实例对象
     */
    Shoppingcart insert(Shoppingcart shoppingcart);

    /**
     * 修改数据
     *
     * @param shoppingcart 实例对象
     * @return 实例对象
     */
    Shoppingcart update(Shoppingcart shoppingcart);

    /**
     * 通过主键删除数据
     *
     * @param scId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer scId);

}
