package com.zs.service;

import com.zs.entity.Address;

/**
 * (Address)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:38:05
 */
public interface AddressService {

    /**
     * 通过uID查询单条数据

     */
    Address queryById(Integer uId);


    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    Address insert(Address address);

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    int update(Address address);

    /**
     * 通过主键删除数据
     *
     * @param adId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer adId);

}