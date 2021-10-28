package com.zs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.entity.Users;
import com.zs.dao.UsersDao;
import com.zs.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public int reg(Users users) {
        this.usersDao.insert(users);
        return 1;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    @Override
    public Users queryById(int uId) {
        return this.usersDao.queryById(uId);
    }

    @Override
    public Users queryByUsername(String username) {
        return usersDao.queryByUsername(username);
    }

    @Override
    public List<Users> querycustomer(String uRole) {
        return usersDao.queryconsumer(uRole);
    }

    @Override
    public List<Users> queryAnyByUsername(String username) {
        return usersDao.queryAnyByUsername(username);
    }

    @Override
    public PageInfo querycustomerPage(String uRole, int pageNum) {
        //pageNum和pageSize
        PageHelper.startPage(pageNum, 4);//pageSize应为15
        List<Users> userList =usersDao.queryconsumer(uRole);
        //创建pageInfo对象
        com.github.pagehelper.PageInfo pageInfo = new com.github.pagehelper.PageInfo(userList);
        //返回pageInfo
      //  System.out.println(pageInfo);
        return pageInfo;
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