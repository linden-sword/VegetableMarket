package com.zs.controller;

import com.zs.entity.Address;
import com.zs.entity.Users;
import com.zs.service.AddressService;
import com.zs.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/VegetableMarket/address/{id}")
    public ResponseEntity<Address> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.addressService.queryById(id));
    }

    @GetMapping("/VegetableMarket/Address")
    public com.zs.util.ResponseEntity<Address> queryById(String username) {

        Users users = usersService.queryByUsername(username);
        Address address = addressService.queryById(users.getUId());

        if (address == null) {
            return new com.zs.util.ResponseEntity<>(1002, "Error：未查询到", address);
        }
        return new com.zs.util.ResponseEntity<>(1000, "Success：查询到", address);
    }

    /**
     * 新增数据
     *
     * @param address 实体
     * @return 新增结果
     */
    @PostMapping("/VegetableMarket/Address")
    public ResponseEntity<Address> add(Address address) {
        return ResponseEntity.ok(this.addressService.insert(address));
    }



    /**
     * 编辑数据
     *
     * @param address 实体
     * @return 编辑结果
     */
    @PutMapping("/VegetableMarket/AddressUpdate")
    public com.zs.util.ResponseEntity<Address> edit(Address address, String username) {
        System.out.println(address.toString());
        Users users = usersService.queryByUsername(username);
        address.setUId(users.getUId());
        int flag = addressService.update(address);
        Address address1 = addressService.queryById(address.getUId());
        if (flag == 1) {
            return new com.zs.util.ResponseEntity<>(1000, "Success：修改成功", address1);
        }
        return new com.zs.util.ResponseEntity<>(1002, "Error：未查询到", address1);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/VegetableMarket/Address")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.addressService.deleteById(id));
    }
}

