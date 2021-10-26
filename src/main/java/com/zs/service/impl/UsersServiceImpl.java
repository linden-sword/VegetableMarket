package com.zs.service.impl;

import com.zs.dao.UsersDao;
import com.zs.entity.Users;
import com.zs.service.UsersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:38:12
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    @Override
    public int login(String username, String passwd) {
        Users users = usersDao.queryByUsername(username);
        if (users != null) {
            if (users.getPasswd().equals(passwd)) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    @Override
    public Users queryById(Integer uId) {
        return this.usersDao.queryById(uId);
    }

    @Override
    public Users queryByUsername(String username) {
        return usersDao.queryByUsername(username);
    }

    /**
     * 分页查询
     *
     * @param users       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Users> queryByPage(Users users, PageRequest pageRequest) {
        long total = this.usersDao.count(users);
        return new PageImpl<>(this.usersDao.queryAllByLimit(users, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Users insert(Users users) {
        this.usersDao.insert(users);
        return users;
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Users update(Users users) {
        this.usersDao.update(users);
        return this.queryById(users.getUId());
    }

    @Override
    public Users updateByUserName(Users users) {
        this.usersDao.updateByUserName(users);
        return this.queryByUsername(users.getUsername());
    }

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer uId) {
        return this.usersDao.deleteById(uId) > 0;
    }
}



//package com.zs.service.impl;
//
//import com.zs.entity.Users;
//import com.zs.dao.UsersDao;
//import com.zs.service.UsersService;
//import org.springframework.stereotype.Service;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//
//import javax.annotation.Resource;
//
///**
// * (Users)表服务实现类
// *
// * @author makejava
// * @since 2021-10-22 21:38:12
// */
//@Service("usersService")
//public class UsersServiceImpl implements UsersService {
//    @Resource
//    private UsersDao usersDao;
//
//    @Override
//    public int login(String username, String passwd) {
//        Users users = usersDao.queryByUsername(username);
//        if (users != null){
//            if (users.getPasswd().equals(passwd)){
//                return 1;
//            }
//            return 2;
//        }
//        return 0;
//    }
//
//    /**
//     * 通过ID查询单条数据
//     *
//     * @param uId 主键
//     * @return 实例对象
//     */
//    @Override
//    public Users queryById(Integer uId) {
//        return this.usersDao.queryById(uId);
//    }
//
//    @Override
//    public Users queryByUsername(String username) {
//        return usersDao.queryByUsername(username);
//    }
//
//    /**
//     * 分页查询
//     *
//     * @param users       筛选条件
//     * @param pageRequest 分页对象
//     * @return 查询结果
//     */
//    @Override
//    public Page<Users> queryByPage(Users users, PageRequest pageRequest) {
//        long total = this.usersDao.count(users);
//        return new PageImpl<>(this.usersDao.queryAllByLimit(users, pageRequest), pageRequest, total);
//    }
//
//    /**
//     * 新增数据
//     *
//     * @param users 实例对象
//     * @return 实例对象
//     */
//    @Override
//    public Users insert(Users users) {
//        this.usersDao.insert(users);
//        return users;
//    }
//
//    /**
//     * 修改数据
//     *
//     * @param users 实例对象
//     * @return 实例对象
//     */
//    @Override
//    public Users update(Users users) {
//        this.usersDao.update(users);
//        return this.queryById(users.getUId());
//    }
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param uId 主键
//     * @return 是否成功
//     */
//    @Override
//    public boolean deleteById(Integer uId) {
//        return this.usersDao.deleteById(uId) > 0;
//    }
//}
