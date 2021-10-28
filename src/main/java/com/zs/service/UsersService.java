package com.zs.service;

import com.github.pagehelper.PageInfo;
import com.zs.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Users)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:38:12
 */
public interface UsersService {
    /**
     * 登录
     *
     * @param username
     * @param passwd
     * @return
     */
    int login(String username, String passwd);

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

    List<Users> querycustomer(String uRole);
    List<Users> queryAnyByUsername(String username);
    PageInfo querycustomerPage(String uRole, int pageNum);
    /**
     * 分页查询
     *
     * @param users       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Users> queryByPage(Users users, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    Users insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    Users update(Users users);

    /**
     * 通过用户名修改数据
     */
    Users updateByUserName(Users users);

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer uId);

}


//package com.zs.service;
//
//import com.zs.entity.Users;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//
///**
// * (Users)表服务接口
// *
// * @author makejava
// * @since 2021-10-22 21:38:12
// */
//public interface UsersService {
//    /**
//     * 登录
//     *
//     * @param username
//     * @param passwd
//     * @return
//     */
//    int login(String username,String passwd);
//
//    /**
//     * 通过ID查询单条数据
//     *
//     * @param uId 主键
//     * @return 实例对象
//     */
//    Users queryById(Integer uId);
//
//    /**
//     * 通过username查询单条数据
//     *
//     * @param username 主键
//     * @return 实例对象
//     */
//    Users queryByUsername(String username);
//
//    /**
//     * 分页查询
//     *
//     * @param users       筛选条件
//     * @param pageRequest 分页对象
//     * @return 查询结果
//     */
//    Page<Users> queryByPage(Users users, PageRequest pageRequest);
//
//    /**
//     * 新增数据
//     *
//     * @param users 实例对象
//     * @return 实例对象
//     */
//    Users insert(Users users);
//
//    /**
//     * 修改数据
//     *
//     * @param users 实例对象
//     * @return 实例对象
//     */
//    Users update(Users users);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param uId 主键
//     * @return 是否成功
//     */
//    boolean deleteById(Integer uId);
//
//}
