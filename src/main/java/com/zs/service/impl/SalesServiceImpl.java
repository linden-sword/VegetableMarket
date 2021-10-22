package com.zs.service.impl;

import com.zs.entity.Sales;
import com.zs.dao.SalesDao;
import com.zs.service.SalesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Sales)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:38:10
 */
@Service("salesService")
public class SalesServiceImpl implements SalesService {
    @Resource
    private SalesDao salesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    @Override
    public Sales queryById(Integer sId) {
        return this.salesDao.queryById(sId);
    }

    /**
     * 分页查询
     *
     * @param sales       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Sales> queryByPage(Sales sales, PageRequest pageRequest) {
        long total = this.salesDao.count(sales);
        return new PageImpl<>(this.salesDao.queryAllByLimit(sales, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param sales 实例对象
     * @return 实例对象
     */
    @Override
    public Sales insert(Sales sales) {
        this.salesDao.insert(sales);
        return sales;
    }

    /**
     * 修改数据
     *
     * @param sales 实例对象
     * @return 实例对象
     */
    @Override
    public Sales update(Sales sales) {
        this.salesDao.update(sales);
        return this.queryById(sales.getSId());
    }

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer sId) {
        return this.salesDao.deleteById(sId) > 0;
    }
}
