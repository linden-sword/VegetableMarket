package com.zs.service;

import com.zs.entity.Goods;

/**
 * (Goods)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:38:07
 */
public interface GoodsService {
    /**
     * 查询所有__分页
     *
     * @return
     */
    com.github.pagehelper.PageInfo queAllGoods(int pageNum);

    /**
     * 通过ID查询单条数据
     *
     * @param gId 主键
     * @return 实例对象
     */
    Goods queryById(Integer gId);

    /**
     * 通过cID查询多条数据__分页
     *
     * @param cId 主键
     * @return 实例对象
     */
    com.github.pagehelper.PageInfo queryByCId(Integer cId, int pageNum);

    /**
     * 通过商品分类查询多条数据__已下架
     *
     * @param cId 主键
     * @return 实例对象
     */
    com.github.pagehelper.PageInfo queryByCIdPass(Integer cId, int pageNum);

    /**
     * 通过商品名称、描述 模糊查询
     *
     * @param goods
     * @return 实例对象
     */
    com.github.pagehelper.PageInfo queryByGNameLike(Goods goods, int pageNum);


    /**
     * 查询所有上架商品
     */
    com.github.pagehelper.PageInfo queryAllPut(int pageNum);

    com.github.pagehelper.PageInfo queryAllPut2(int pageNum);

    /**
     * 查询所有上架商品（时间升序）
     */
    com.github.pagehelper.PageInfo queryAllPutASC(int pageNum);


    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods insert(Goods goods);

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    int update(Goods goods);

    /**
     * 通过主键删除数据
     *
     * @param gId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer gId);

}
