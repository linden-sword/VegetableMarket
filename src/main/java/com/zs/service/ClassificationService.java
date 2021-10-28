package com.zs.service;

import com.zs.entity.Classification;

import java.util.List;

/**
 * (Classification)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:38:07
 */
public interface ClassificationService {

    List<Classification> FindAll();

    /**
     * 通过ID查询单条数据
     *
     * @param cId 主键
     * @return 实例对象
     */
    Classification queryById(Integer cId);

    /**
     * 新增数据
     *
     * @param classification 实例对象
     * @return 实例对象
     */
    int insert(Classification classification);
    Classification queryByName(String cName);

    /**
     * 通过主键删除数据
     *
     * @param cId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer cId);

    /**
     * 修改数据
     *
     * @param classification 实例对象
     * @return 实例对象
     */
    int update(Classification classification);

    /**
     * 通过cID查询多条数据__分页
     *
     * @param pageNum 主键
     * @return 实例对象
     */
    com.github.pagehelper.PageInfo queryByCId(int pageNum);
}
