package com.zs.service;

import com.zs.entity.Classification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Classification)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:38:07
 */
public interface ClassificationService {

    /**
     * 通过ID查询单条数据
     *
     * @param cId 主键
     * @return 实例对象
     */
    Classification queryById(Integer cId);

    /**
     * 分页查询
     *
     * @param classification 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    Page<Classification> queryByPage(Classification classification, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param classification 实例对象
     * @return 实例对象
     */
    Classification insert(Classification classification);

    /**
     * 修改数据
     *
     * @param classification 实例对象
     * @return 实例对象
     */
    Classification update(Classification classification);

    /**
     * 通过主键删除数据
     *
     * @param cId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer cId);

}
