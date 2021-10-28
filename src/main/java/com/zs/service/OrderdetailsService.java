package com.zs.service;

import com.zs.entity.Orderdetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Orderdetails)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:38:09
 */
public interface OrderdetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @param odId 主键
     * @return 实例对象
     */
    Orderdetails queryById(Integer odId);

    List<Orderdetails> queryByOId(String oId);

    com.github.pagehelper.PageInfo queryByoid(String oid, Integer pageNum);

    /**
     * 新增数据
     *
     * @param orderdetails 实例对象
     * @return 实例对象
     */
    Orderdetails insert(Orderdetails orderdetails);

    /**
     * 修改数据
     *
     * @param orderdetails 实例对象
     * @return 实例对象
     */
    Orderdetails update(Orderdetails orderdetails);

    /**
     * 通过主键删除数据
     *
     * @param odId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer odId);
}
