package com.zs.dao;

import com.zs.entity.Classification;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Classification)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:38:06
 */
public interface ClassificationDao {



    Classification   queryByName(String cName);
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
     * @return 影响行数
     */
    int insert(Classification classification);

    /**
     * 修改数据
     *
     * @param classification 实例对象
     * @return 影响行数
     */
    int update(Classification classification);

    /**
     * 通过主键删除数据
     *
     * @param cId 主键
     * @return 影响行数
     */
    int deleteById(Integer cId);

    /**
     * 通过商品分类查询多条数据
     * @return 实例对象
     */
    List<Classification> queryAll();

}

