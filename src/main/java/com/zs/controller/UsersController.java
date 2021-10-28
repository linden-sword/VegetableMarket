package com.zs.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.glassfish.external.probe.provider.annotations.ProbeParam;
import com.zs.entity.Token;
import com.zs.entity.Users;
import com.zs.service.TokenService;
import com.zs.service.UsersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:38:12
 */
@RestController
public class UsersController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;
    @Resource
    private TokenService tokenService;

    /**
     * 登录
     *
     * @param username
     * @param passwd
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/VegetableMarket/User")
//    @CrossOrigin(origins="http://127.0.0.1:5502",allowCredentials="true")
    public com.zs.util.ResponseEntity<Token> login(String username, String passwd, HttpServletRequest request, HttpServletResponse response) {

        System.out.println("====== 登录信息 ：" + username + " ," + passwd + " ======");


        int flag = usersService.login(username, passwd);
        Users users = usersService.queryByUsername(username);
        if (flag == 1) {
            //登陆成功
            String tokenString = (String) request.getAttribute("token");
            //从数据库查token
            Token token = tokenService.queryByUUId(tokenString);
            token.setToLogin("true");
            token.setUsername(username);
            token.setUId(usersService.queryByUsername(username).getUId());
            //修改数据库中token
            tokenService.update(token);


            return new com.zs.util.ResponseEntity<>(1000, "Success:登陆成功", token);
        }
        if (flag == 2) {
            return new com.zs.util.ResponseEntity<>(1002, "Error:密码错误", null);
        }
        if (flag == 0) {
            return new com.zs.util.ResponseEntity<>(1002, "Error:用户不存在", null);
        }
        return new com.zs.util.ResponseEntity<>(1004, "Error:Service:未知错误", null);

    }

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("/VegetableMarket/UserFindID")
    public com.zs.util.ResponseEntity<Users> queryById(int uId) {
        Users users = usersService.queryById(uId);
        if (users != null) {
            return new com.zs.util.ResponseEntity<>(1000, "Success：查询用户成功", users);
        } else {
            return new com.zs.util.ResponseEntity<>(1002, "Error：查询用户失敗", users);
        }
    }

    @GetMapping("/VegetableMarket/UserFindusername")
    public com.zs.util.ResponseEntity<Users> queryByusername(String username) {
        System.out.println("==========" + username);
        Users users = usersService.queryByUsername(username);
        if (users.getUsername() != null) {
            return new com.zs.util.ResponseEntity<>(1000, "Success：查询用户成功", users);
        } else {
            return new com.zs.util.ResponseEntity<>(1002, "Error：查询用户失敗", users);
        }
    }

    @GetMapping("/VegetableMarket/UserFindAnyusername")
    public com.zs.util.ResponseEntity<List<Users>> queryAnyByusername(String username) {
        List<Users> usersList = usersService.queryAnyByUsername(username);
        System.out.println("============" + usersList);
        if (usersList.isEmpty()) {
            return new com.zs.util.ResponseEntity<>(1002, "Error：查询用户失敗", null);
        } else {
            return new com.zs.util.ResponseEntity<>(1000, "Success：查询用户成功", usersList);
        }
    }

    /**
     * 查询分类下的商品__分页
     *
     * @return
     */
    @GetMapping("/VegetableMarket/UsersPage")
    public com.zs.util.ResponseEntity<PageInfo> queryGoodsByuRolePage(String uRole, Integer pageNum) {
        com.github.pagehelper.PageInfo pageInfo = usersService.querycustomerPage(uRole, pageNum);
        if (pageInfo.getList().isEmpty()) {
            return new com.zs.util.ResponseEntity<>(1002, "Error", null);
        }
        return new com.zs.util.ResponseEntity<>(1000, "Success", pageInfo);
    }

    @GetMapping("/VegetableMarket/customer")
    public com.zs.util.ResponseEntity<List<Users>> querycustomer(String uRole) {
        List<Users> usersList = usersService.querycustomer(uRole);
        if (usersList == null || usersList.size() == 0) {
            return new com.zs.util.ResponseEntity<>(1002, "Error：查询用户失败", usersList);

        } else {
            return new com.zs.util.ResponseEntity<>(1000, "Success：查询用户成功", usersList);

        }
    }


    /**
     * 新增数据
     *
     * @param users 实体
     * @return 新增结果
     */
    @GetMapping("/VegetableMarket/UserAdd")
    public com.zs.util.ResponseEntity<Users> add(Users users) {
        Date date = new Date();
        users.setUDatetime(date);
        Users insert = usersService.insert(users);
        if (insert == null) {
            return new com.zs.util.ResponseEntity<>(1002, "Error：添加失败", null);
        }
            return new com.zs.util.ResponseEntity<>(1000, "Success：添加成功", insert);
    }

    /**
     * 编辑数据
     */
    @PutMapping("/VegetableMarket/change")
    public com.zs.util.ResponseEntity<String> editByUserName(Users users) {
        this.usersService.updateByUserName(users);
        return new com.zs.util.ResponseEntity<>(1000, "Success", "修改成功");
    }


    /**
     * 编辑数据
     *
     * @return 编辑结果
     */
    @GetMapping("/VegetableMarket/UserUp")
    public com.zs.util.ResponseEntity<Users> edit(int uid, String uStatus) {
        Users uu = usersService.queryById(uid);
        if (Integer.parseInt(uStatus) == 1) {
            uu.setUStatus("0");
        } else if (Integer.parseInt(uStatus) == 0) {
            uu.setUStatus("1");
        }
        Users update = usersService.update(uu);
        if (update != null) {
            return new com.zs.util.ResponseEntity<>(1000, "Success：修改用户status成功", update);
        } else {
            return new com.zs.util.ResponseEntity<>(1002, "Error：修改用户status失败", update);
        }
    }

    @GetMapping("/VegetableMarket/UserUpPsw")
    public com.zs.util.ResponseEntity<Users> editpsw(int uId, Users users) {
        Users uu = usersService.queryById(uId);
        uu.setUsername(users.getUsername());
        uu.setPasswd(users.getPasswd());
        Users update = usersService.update(uu);
        if (update != null) {
            return new com.zs.util.ResponseEntity<>(1000, "Success：修改用户成功", update);
        } else {
            return new com.zs.util.ResponseEntity<>(1002, "Error：修改用户失败", update);
        }
    }

    /**
     * 删除数据
     *
     * @return 删除是否成功
     */
    @GetMapping("/VegetableMarket/UserDelete")
    public com.zs.util.ResponseEntity<Boolean> deleteById(int uId) {
        System.out.println(uId);
        boolean b = usersService.deleteById(uId);
        if (b) {
            return new com.zs.util.ResponseEntity<>(1000, "Success：删除成功", b);
        } else {
            return new com.zs.util.ResponseEntity<>(1002, "Error：删除失败", b);
        }
    }

}

