package com.zs.controller;

import com.zs.entity.Address;
import com.zs.entity.Goods;
import com.zs.entity.Shoppingcart;
import com.zs.entity.Users;
import com.zs.service.GoodsService;
import com.zs.service.ShoppingcartService;
import com.zs.service.UsersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Shoppingcart)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:38:10
 */
@RestController
public class ShoppingcartController {
    /**
     * 服务对象
     */
    @Resource
    private ShoppingcartService shoppingcartService;
    @Resource
    private UsersService usersService;
    @Resource
    private GoodsService goodsService;

//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("{id}")
//    public ResponseEntity<Shoppingcart> queryById(@PathVariable("id") Integer id) {
//        return ResponseEntity.ok(this.shoppingcartService.queryById(id));
//    }

    /**
     *
     */
    @GetMapping("/VegetableMarket/ShoppingcartFind")
    public com.zs.util.ResponseEntity<List<Shoppingcart>> queryByUid(String username) {
        //  System.out.println("==========username" + username);
        Users users = usersService.queryByUsername(username);
        List<Shoppingcart> shoppingcartList = shoppingcartService.queryByUid(users.getUId());
        List<Shoppingcart> shoppingcartList2 = new ArrayList();

        for (Shoppingcart shoppingcart : shoppingcartList) {
            Goods goods = goodsService.queryById(shoppingcart.getGId());
            shoppingcart.setG_price((double) goods.getGPrice());
            shoppingcart.setG_name(goods.getGName());
            System.out.println(shoppingcart.toString());
            shoppingcartList2.add(shoppingcart);
        }
        if (shoppingcartList.size() == 0 || shoppingcartList == null) {
            return new com.zs.util.ResponseEntity<>(1002, "Error：未查询到", shoppingcartList2);
        } else {
            return new com.zs.util.ResponseEntity<>(1000, "Success：查询到", shoppingcartList2);
        }

    }

    /**
     * 新增数据
     *
     * @param shoppingcart 实体
     * @return 新增结果
     */
    @PostMapping("/VegetableMarket/Shoppingcart")
    public ResponseEntity<Shoppingcart> add(Shoppingcart shoppingcart) {
        return ResponseEntity.ok(this.shoppingcartService.insert(shoppingcart));
    }

    /**
     * 编辑数据
     *
     * @param shoppingcart 实体
     * @return 编辑结果
     */
    @PutMapping("/VegetableMarket/Shoppingcart")
    public ResponseEntity<Shoppingcart> edit(Shoppingcart shoppingcart) {
        return ResponseEntity.ok(this.shoppingcartService.update(shoppingcart));
    }

    /**
     * 删除数据
     *
     * @return 删除是否成功
     */
    @GetMapping("/VegetableMarket/ShoppingcartDe")
    public com.zs.util.ResponseEntity<Boolean> deleteById(Integer scId) {
        boolean b = shoppingcartService.deleteById(scId);
        if (b) {
            return new com.zs.util.ResponseEntity<>(1000, "Success：删除成功", b);
        } else {
            return new com.zs.util.ResponseEntity<>(1002, "Error：删除失败", b);
        }
    }

    @GetMapping("/VegetableMarket/ShoppingcartUp")
    public com.zs.util.ResponseEntity<Shoppingcart> UpdateUp(Integer scId) {
        Shoppingcart shoppingcart = shoppingcartService.updateAdd(shoppingcartService.queryById(scId));
        if (shoppingcart != null) {
            return new com.zs.util.ResponseEntity<>(1000, "Success：增加成功", shoppingcart);
        } else {
            return new com.zs.util.ResponseEntity<>(1002, "Success：增加失败", shoppingcart);
        }
    }
    @GetMapping("/VegetableMarket/ShoppingcartDown")
    public com.zs.util.ResponseEntity<Shoppingcart> UpdateDown(Integer scId) {
        Shoppingcart shoppingcart1 = shoppingcartService.queryById(scId);
        Shoppingcart shoppingcart=new Shoppingcart();
        if (shoppingcart1.getScWeight()>1) {
         shoppingcart  = shoppingcartService.updatemul(shoppingcart1);
        }else if (shoppingcart1.getScWeight()<= 1&&shoppingcart1.getScWeight()>0){
            shoppingcart.setScWeight(0.0);
        }
        if (shoppingcart != null) {
            return new com.zs.util.ResponseEntity<>(1000, "Success：减少成功", shoppingcart);
        } else {
            return new com.zs.util.ResponseEntity<>(1002, "Success：减少失败", shoppingcart);
        }
    }

}

