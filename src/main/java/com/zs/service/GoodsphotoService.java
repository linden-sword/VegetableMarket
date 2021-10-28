package com.zs.service;

import com.zs.entity.Goodsphoto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Goodsphoto)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:38:08
 */
public interface GoodsphotoService {

    /**
     * 通过ID查询单条数据
     *
     * @param gpId 主键
     * @return 实例对象
     */
    Goodsphoto queryById(Integer gpId);

    /**
     * 新增数据
     *
     * @param goodsphoto 实例对象
     * @return 实例对象
     */
    Goodsphoto insert(Goodsphoto goodsphoto);

    /**
     * 修改数据
     *
     * @param goodsphoto 实例对象
     * @return 实例对象
     */
    Goodsphoto update(Goodsphoto goodsphoto);

    /**
     * 通过主键删除数据
     *
     * @param gpId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer gpId);

}
