package com.zs.service.impl;

import com.zs.entity.Orderdetails;
import com.zs.dao.OrderdetailsDao;
import com.zs.service.OrderdetailsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Orderdetails)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:38:09
 */
@Service("orderdetailsService")
public class OrderdetailsServiceImpl implements OrderdetailsService {
    @Resource
    private OrderdetailsDao orderdetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param odId 主键
     * @return 实例对象
     */
    @Override
    public Orderdetails queryById(Integer odId) {
        return this.orderdetailsDao.queryById(odId);
    }

    /**
     * 分页查询
     *
     * @param orderdetails 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    @Override
    public Page<Orderdetails> queryByPage(Orderdetails orderdetails, PageRequest pageRequest) {
        long total = this.orderdetailsDao.count(orderdetails);
        return new PageImpl<>(this.orderdetailsDao.queryAllByLimit(orderdetails, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param orderdetails 实例对象
     * @return 实例对象
     */
    @Override
    public Orderdetails insert(Orderdetails orderdetails) {
        this.orderdetailsDao.insert(orderdetails);
        return orderdetails;
    }

    /**
     * 修改数据
     *
     * @param orderdetails 实例对象
     * @return 实例对象
     */
    @Override
    public Orderdetails update(Orderdetails orderdetails) {
        this.orderdetailsDao.update(orderdetails);
        return this.queryById(orderdetails.getOdId());
    }

    /**
     * 通过主键删除数据
     *
     * @param odId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer odId) {
        return this.orderdetailsDao.deleteById(odId) > 0;
    }
}
