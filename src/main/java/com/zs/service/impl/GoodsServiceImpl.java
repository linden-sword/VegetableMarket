package com.zs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.entity.Goods;
import com.zs.dao.GoodsDao;
import com.zs.service.GoodsService;
import org.springframework.stereotype.Service;

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
     * 查询所有__分页
     *
     * @param pageNum
     * @return List<Goods>
     */
    @Override
    public PageInfo queAllGoods(int pageNum) {
        //pageNum和pageSize
        PageHelper.startPage(pageNum, 4);//pageSize应为15
        List<Goods> goodsList = goodsDao.queAllGoods();
        //创建pageInfo对象
        com.github.pagehelper.PageInfo pageInfo = new com.github.pagehelper.PageInfo(goodsList);
        //返回pageInfo
        System.out.println(pageInfo);
        return pageInfo;
    }

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
        PageHelper.startPage(pageNum, 4);//pageSize应为15
        List<Goods> goodsList = goodsDao.queryByCId(cId);
        //创建pageInfo对象
        com.github.pagehelper.PageInfo pageInfo = new com.github.pagehelper.PageInfo(goodsList);
        //返回pageInfo
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Override
    public PageInfo queryByCIdPass(Integer cId, int pageNum) {
        //pageNum和pageSize
        PageHelper.startPage(pageNum, 4);//pageSize应为15
        List<Goods> goodsList = goodsDao.queryByCIdPass(cId);
        //创建pageInfo对象
        com.github.pagehelper.PageInfo pageInfo = new com.github.pagehelper.PageInfo(goodsList);
        //返回pageInfo
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Override
    public PageInfo queryByGNameLike(Goods goods,int pageNum) {
        //pageNum和pageSize
        PageHelper.startPage(pageNum, 4);//pageSize应为15
        List<Goods> goodsList = goodsDao.queryByGNameLike(goods);
        //创建pageInfo对象
        com.github.pagehelper.PageInfo pageInfo = new com.github.pagehelper.PageInfo(goodsList);
        //返回pageInfo
        System.out.println(pageInfo);
        return pageInfo;
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
