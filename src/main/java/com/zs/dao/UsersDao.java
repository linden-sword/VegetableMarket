package com.zs.dao;

import com.zs.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Users)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:38:12
 */
public interface UsersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    Users queryById(int uId);

    /**
     * 通过username查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    Users queryByUsername(String username);


    List<Users> queryconsumer(String uRole);

    List<Users> queryAnyByUsername(String username);

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int insert(Users users);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Users> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Users> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Users> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Users> entities);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int update(Users users);

    /**
     * 通过用户名修改数据
     */
    int updateByUserName(Users users);

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 影响行数
     */
    int deleteById(Integer uId);

}