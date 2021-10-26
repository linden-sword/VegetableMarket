package com.zs.dao;

import com.zs.entity.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Address)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:38:05
 */
public interface AddressDao {

    /**
     * 通过ID查询单条数据
     */
    Address queryById(Integer uId);



    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 影响行数
     */
    int insert(Address address);

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 影响行数
     */
    int update(Address address);


    /**
     * 通过主键删除数据
     *
     * @param adId 主键
     * @return 影响行数
     */
    int deleteById(Integer adId);

}




//package com.zs.dao;
//
//import com.zs.entity.Address;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.data.domain.Pageable;
//
//import java.util.List;
//
///**
// * (Address)表数据库访问层
// *
// * @author makejava
// * @since 2021-10-22 21:38:05
// */
//public interface AddressDao {
//
//    /**
//     * 通过ID查询单条数据
//     *
//     * @param adId 主键
//     * @return 实例对象
//     */
//    Address queryById(Integer adId);
//
//    /**
//     * 查询指定行数据
//     *
//     * @param address  查询条件
//     * @param pageable 分页对象
//     * @return 对象列表
//     */
//    List<Address> queryAllByLimit(Address address, @Param("pageable") Pageable pageable);
//
//    /**
//     * 统计总行数
//     *
//     * @param address 查询条件
//     * @return 总行数
//     */
//    long count(Address address);
//
//    /**
//     * 新增数据
//     *
//     * @param address 实例对象
//     * @return 影响行数
//     */
//    int insert(Address address);
//
//    /**
//     * 批量新增数据（MyBatis原生foreach方法）
//     *
//     * @param entities List<Address> 实例对象列表
//     * @return 影响行数
//     */
//    int insertBatch(@Param("entities") List<Address> entities);
//
//    /**
//     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
//     *
//     * @param entities List<Address> 实例对象列表
//     * @return 影响行数
//     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
//     */
//    int insertOrUpdateBatch(@Param("entities") List<Address> entities);
//
//    /**
//     * 修改数据
//     *
//     * @param address 实例对象
//     * @return 影响行数
//     */
//    int update(Address address);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param adId 主键
//     * @return 影响行数
//     */
//    int deleteById(Integer adId);
//
//}
//
