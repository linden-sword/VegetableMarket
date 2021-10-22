package com.zs.service;

import com.zs.entity.Assesses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Assesses)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:38:06
 */
public interface AssessesService {

    /**
     * 通过ID查询单条数据
     *
     * @param asId 主键
     * @return 实例对象
     */
    Assesses queryById(Integer asId);

    /**
     * 分页查询
     *
     * @param assesses    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Assesses> queryByPage(Assesses assesses, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param assesses 实例对象
     * @return 实例对象
     */
    Assesses insert(Assesses assesses);

    /**
     * 修改数据
     *
     * @param assesses 实例对象
     * @return 实例对象
     */
    Assesses update(Assesses assesses);

    /**
     * 通过主键删除数据
     *
     * @param asId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer asId);

}
