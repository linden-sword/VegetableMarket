package com.zs.service.impl;

import com.zs.entity.Address;
import com.zs.dao.AddressDao;
import com.zs.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Address)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:38:05
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressDao addressDao;

    /**
     * 通过uID查询单条数据
     */
    @Override
    public Address queryById(Integer uId) {
        return this.addressDao.queryById(uId);
    }



    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override
    public Address insert(Address address) {
        this.addressDao.insert(address);
        return address;
    }

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override

    public int update(Address address) {
        return addressDao.update(address);
    }

    /**
     * 通过主键删除数据
     *
     * @param adId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer adId) {
        return this.addressDao.deleteById(adId) > 0;
    }
}