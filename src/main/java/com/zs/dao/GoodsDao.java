package com.zs.dao;

import com.zs.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Goods)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:38:07
 */
public interface GoodsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param gId 主键
     * @return 实例对象
     */
    Goods queryById(Integer gId);

    /**
     * 通过商品分类查询多条数据
     *
     * @param cId 主键
     * @return 实例对象
     */
    List<Goods> queryByCId(Integer cId);

    /**
     * 通过商品名称、描述 模糊查询
     *
     * @param goods
     * @return 实例对象
     */
    List<Goods> queryByGNameLike(Goods goods);




    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 影响行数
     */
    int insert(Goods goods);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Goods> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Goods> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Goods> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Goods> entities);

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 影响行数
     */
    int update(Goods goods);

    /**
     * 通过主键删除数据
     *
     * @param gId 主键
     * @return 影响行数
     */
    int deleteById(Integer gId);

}

