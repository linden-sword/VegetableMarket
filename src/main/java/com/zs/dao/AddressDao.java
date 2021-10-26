package com.zs.dao;

import com.zs.entity.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Address)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:38:05
 */
public interface AddressDao {

    /**
     * 通过ID查询单条数据

     */
    Address queryById(Integer uId);



    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 影响行数
     */
    int insert(Address address);

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 影响行数
     */
    int update(Address address);


    /**
     * 通过主键删除数据
     *
     * @param adId 主键
     * @return 影响行数
     */
    int deleteById(Integer adId);

}

