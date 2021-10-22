package com.zs.service.impl;

import com.zs.entity.Goodsphoto;
import com.zs.dao.GoodsphotoDao;
import com.zs.service.GoodsphotoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Goodsphoto)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:38:09
 */
@Service("goodsphotoService")
public class GoodsphotoServiceImpl implements GoodsphotoService {
    @Resource
    private GoodsphotoDao goodsphotoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param gpId 主键
     * @return 实例对象
     */
    @Override
    public Goodsphoto queryById(Integer gpId) {
        return this.goodsphotoDao.queryById(gpId);
    }

    /**
     * 分页查询
     *
     * @param goodsphoto  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Goodsphoto> queryByPage(Goodsphoto goodsphoto, PageRequest pageRequest) {
        long total = this.goodsphotoDao.count(goodsphoto);
        return new PageImpl<>(this.goodsphotoDao.queryAllByLimit(goodsphoto, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param goodsphoto 实例对象
     * @return 实例对象
     */
    @Override
    public Goodsphoto insert(Goodsphoto goodsphoto) {
        this.goodsphotoDao.insert(goodsphoto);
        return goodsphoto;
    }

    /**
     * 修改数据
     *
     * @param goodsphoto 实例对象
     * @return 实例对象
     */
    @Override
    public Goodsphoto update(Goodsphoto goodsphoto) {
        this.goodsphotoDao.update(goodsphoto);
        return this.queryById(goodsphoto.getGpId());
    }

    /**
     * 通过主键删除数据
     *
     * @param gpId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer gpId) {
        return this.goodsphotoDao.deleteById(gpId) > 0;
    }
}
