package com.zs.dao;

import com.zs.entity.Shoppingcart;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Shoppingcart)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:38:11
 */
public interface ShoppingcartDao {

    /**
     * 通过ID查询单条数据
     *
     * @param scId 主键
     * @return 实例对象
     */
    Shoppingcart queryById(Integer scId);
    /**
<<<<<<< HEAD
     * 通过uID查询单条数据
=======
     * 通过uID查询数据
>>>>>>> 66face6ab7d2b3a3f760b2d7f44c03d438dd0d54
     *
     * @param uId 主键
     * @return 实例对象
     */
    List<Shoppingcart> queryByUid(Integer uId);


    /**
     * 通过scIdArr查询数据
     *
     * @param scIdArr 购物车商品数组
     * @return 实例对象
     */
    List<Shoppingcart> queryByScIdArr(Integer[] scIdArr);

    /**
     * 查询指定行数据
     *
     * @param shoppingcart 查询条件
     * @param pageable     分页对象
     * @return 对象列表
     */
    List<Shoppingcart> queryAllByLimit(Shoppingcart shoppingcart, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param shoppingcart 查询条件
     * @return 总行数
     */
    long count(Shoppingcart shoppingcart);

    /**
     * 新增数据
     *
     * @param shoppingcart 实例对象
     * @return 影响行数
     */
    int insert(Shoppingcart shoppingcart);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Shoppingcart> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Shoppingcart> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Shoppingcart> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Shoppingcart> entities);

    /**
     * 修改数据
     *
     * @param shoppingcart 实例对象
     * @return 影响行数
     */
    int update(Shoppingcart shoppingcart);

    int updateAddWeight(Shoppingcart shoppingcart);
    int updatemulWeight(Shoppingcart shoppingcart);
    /**
     * 通过主键删除数据
     *
     * @param scId 主键
     * @return 影响行数
     */
    int deleteById(Integer scId);

}



//package com.zs.dao;
//
//import com.zs.entity.Shoppingcart;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.data.domain.Pageable;
//
//import java.util.List;
//
///**
// * (Shoppingcart)表数据库访问层
// *
// * @author makejava
// * @since 2021-10-22 21:38:11
// */
//public interface ShoppingcartDao {
//
//    /**
//     * 通过ID查询单条数据
//     *
//     * @param scId 主键
//     * @return 实例对象
//     */
//    Shoppingcart queryById(Integer scId);
//
//    /**
//     * 查询指定行数据
//     *
//     * @param shoppingcart 查询条件
//     * @param pageable     分页对象
//     * @return 对象列表
//     */
//    List<Shoppingcart> queryAllByLimit(Shoppingcart shoppingcart, @Param("pageable") Pageable pageable);
//
//    /**
//     * 统计总行数
//     *
//     * @param shoppingcart 查询条件
//     * @return 总行数
//     */
//    long count(Shoppingcart shoppingcart);
//
//    /**
//     * 新增数据
//     *
//     * @param shoppingcart 实例对象
//     * @return 影响行数
//     */
//    int insert(Shoppingcart shoppingcart);
//
//    /**
//     * 批量新增数据（MyBatis原生foreach方法）
//     *
//     * @param entities List<Shoppingcart> 实例对象列表
//     * @return 影响行数
//     */
//    int insertBatch(@Param("entities") List<Shoppingcart> entities);
//
//    /**
//     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
//     *
//     * @param entities List<Shoppingcart> 实例对象列表
//     * @return 影响行数
//     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
//     */
//    int insertOrUpdateBatch(@Param("entities") List<Shoppingcart> entities);
//
//    /**
//     * 修改数据
//     *
//     * @param shoppingcart 实例对象
//     * @return 影响行数
//     */
//    int update(Shoppingcart shoppingcart);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param scId 主键
//     * @return 影响行数
//     */
//    int deleteById(Integer scId);
//
//}
//
