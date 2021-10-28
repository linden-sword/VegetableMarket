package com.zs.service.impl;

import com.zs.entity.Goodsparameters;
import com.zs.dao.GoodsparametersDao;
import com.zs.service.GoodsparametersService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Goodsparameters)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:38:08
 */
@Service("goodsparametersService")
public class GoodsparametersServiceImpl implements GoodsparametersService {
    @Resource
    private GoodsparametersDao goodsparametersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    @Override
    public Goodsparameters queryById(Integer pId) {
        return this.goodsparametersDao.queryById(pId);
    }

    @Override
    public Goodsparameters queryByGId(Integer Gid) {
        return this.goodsparametersDao.queryByGId(Gid);
    }

    /**
     * 新增数据
     *
     * @param goodsparameters 实例对象
     * @return 实例对象
     */
    @Override
    public Goodsparameters insert(Goodsparameters goodsparameters) {
        this.goodsparametersDao.insert(goodsparameters);
        return goodsparameters;
    }

    /**
     * 修改数据
     *
     * @param goodsparameters 实例对象
     * @return 实例对象
     */
    @Override
    public Goodsparameters update(Goodsparameters goodsparameters) {
        this.goodsparametersDao.update(goodsparameters);
        return this.queryById(goodsparameters.getPId());
    }

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer pId) {
        return this.goodsparametersDao.deleteById(pId) > 0;
    }
}
