package com.zs.controller;

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
     * 分页查询
     *
     * @param users       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/VegetableMarket/Users")
    public ResponseEntity<Page<Users>> queryByPage(Users users, PageRequest pageRequest) {
        return ResponseEntity.ok(this.usersService.queryByPage(users, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/VegetableMarket/User/id/{id}")
    public ResponseEntity<Users> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.usersService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param users 实体
     * @return 新增结果
     */
    @PostMapping("/VegetableMarket/User")
    public ResponseEntity<Users> add(Users users) {
        return ResponseEntity.ok(this.usersService.insert(users));
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
     * @param users 实体
     * @return 编辑结果
     */
    @PutMapping("/VegetableMarket/User")
    public ResponseEntity<Users> edit(Users users) {
        return ResponseEntity.ok(this.usersService.update(users));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/VegetableMarket/User")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.usersService.deleteById(id));
    }

}

