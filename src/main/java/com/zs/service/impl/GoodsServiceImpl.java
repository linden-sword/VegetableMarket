package com.zs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.entity.Goods;
import com.zs.dao.GoodsDao;
import com.zs.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Goods)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:38:07
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param gId 主键
     * @return 实例对象
     */
    @Override
    public Goods queryById(Integer gId) {
        return this.goodsDao.queryById(gId);
    }


    /**
     * 通过cId查询多个商品__分页
     *
     * @param cId 主键
     * @return List<Goods>
     */
    @Override
    public PageInfo queryByCId(Integer cId, int pageNum) {
        //pageNum和pageSize
        PageHelper.startPage(pageNum, 15);
        List<Goods> goodsList = goodsDao.queryByCId(cId);
        //创建pageInfo对象
        com.github.pagehelper.PageInfo pageInfo = new com.github.pagehelper.PageInfo(goodsList);
        //返回pageInfo
        System.out.println(pageInfo);
        return pageInfo;
    }

    /**
     * 分页查询
     *
     * @param goods       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Goods> queryByPage(Goods goods, PageRequest pageRequest) {
        long total = this.goodsDao.count(goods);
        return new PageImpl<>(this.goodsDao.queryAllByLimit(goods, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods insert(Goods goods) {
        this.goodsDao.insert(goods);
        return goods;
    }

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods update(Goods goods) {
        this.goodsDao.update(goods);
        return this.queryById(goods.getGId());
    }

    /**
     * 通过主键删除数据
     *
     * @param gId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer gId) {
        return this.goodsDao.deleteById(gId) > 0;
    }
}
