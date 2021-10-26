package com.zs.controller;

import com.zs.entity.Address;
import com.zs.entity.Token;
import com.zs.entity.Users;
import com.zs.service.AddressService;
import com.zs.service.TokenService;
import com.zs.service.UsersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * (Address)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:38:05
 */
@RestController
public class AddressController {
    /**
     * 服务对象
     */
    @Resource
    private AddressService addressService;
    @Resource
    private UsersService usersService;
    /**
     *
     */
    @GetMapping("/VegetableMarket/Address")
    public com.zs.util.ResponseEntity<Address> queryById(String username) {
     try {
         Users users = usersService.queryByUsername(username);

         Address address = addressService.queryById(users.getUId());

         if (address == null) {
             return new com.zs.util.ResponseEntity<>(1002, "Error：未查询到", address);
         } else {
             return new com.zs.util.ResponseEntity<>(1000, "Success：查询到", address);
         }
     }catch (Exception e) {
         e.printStackTrace();
         return new com.zs.util.ResponseEntity<>(1000, "Error：未知错误", null);

     }

    }



    /**
     * 编辑数据
     *
     * @param address 实体
     * @return 编辑结果
     */
    @GetMapping("/VegetableMarket/AddressUpdate")
    public com.zs.util.ResponseEntity<Address> edit(Address address,String username) {
        System.out.println(address.toString());
     //   System.out.println(username);
        Users users = usersService.queryByUsername(username);
        address.setUId(users.getUId());
        System.out.println(address.toString());

         Address address1=addressService.update(address);
         System.out.println(address1.toString());
         if (address1 != null) {
             return new com.zs.util.ResponseEntity<>(1000, "Success：修改成功", address1);
         }else {
             return new com.zs.util.ResponseEntity<>(1002, "Error：修改失败", address1);
         }
    }


}

