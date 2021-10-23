package com.zs.service;

import com.zs.entity.Goodsparameters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Goodsparameters)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:38:08
 */
public interface GoodsparametersService {

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    Goodsparameters queryById(Integer pId);

    /**
     * 分页查询
     *
     * @param goodsparameters 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    Page<Goodsparameters> queryByPage(Goodsparameters goodsparameters, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param goodsparameters 实例对象
     * @return 实例对象
     */
    Goodsparameters insert(Goodsparameters goodsparameters);

    /**
     * 修改数据
     *
     * @param goodsparameters 实例对象
     * @return 实例对象
     */
    Goodsparameters update(Goodsparameters goodsparameters);

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer pId);

}