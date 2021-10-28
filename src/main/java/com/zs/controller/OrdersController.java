package com.zs.controller;

import com.github.pagehelper.PageInfo;
import com.zs.entity.Goods;
import com.zs.entity.Orders;
import com.zs.entity.Token;
import com.zs.entity.Users;
import com.zs.service.GoodsService;
import com.zs.service.OrdersService;
import com.zs.service.TokenService;
import com.zs.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

/**
 * (Orders)表控制层
 *
 * @author makejava
 * @since 2021-10-22 21:38:09
 */
@RestController
public class OrdersController {
    /**
     * 服务对象
     */
    @Resource
    private OrdersService ordersService;
    @Resource
    private UsersService usersService;

    @Resource
    private TokenService tokenService;
    @Resource
    private GoodsService goodsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/VegetableMarket/orders/id/{id}")
    public ResponseEntity<Orders> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.ordersService.queryById(id));
    }



    @GetMapping("/VegetableMarket/OrdersPage")
    public com.zs.util.ResponseEntity<PageInfo> queryOrdersPage(int pageNum){
        com.github.pagehelper.PageInfo pageInfo = ordersService.queryordersPage(pageNum);
 //       System.out.println("===="+pageInfo);
        if (pageInfo.getList().isEmpty()){
            return new com.zs.util.ResponseEntity<>(1002,"Error",null);
        }
        return new com.zs.util.ResponseEntity<>(1000,"Success",pageInfo);
    }

    @GetMapping("/VegetableMarket/OrdersPageByUid")
    public com.zs.util.ResponseEntity<PageInfo> queryOrdersPageUid(String username,int pageNum){
        System.out.println("-=-========="+username);
        Users users = usersService.queryByUsername(username);
        System.out.println("-=-========="+users.toString());

        com.github.pagehelper.PageInfo pageInfo = ordersService.queryAllordersPageByUid(users.getUId(),pageNum);
        System.out.println("-=-========="+pageInfo);

        if (pageInfo.getList().isEmpty()){
            return new com.zs.util.ResponseEntity<>(1002,"Error",null);
        }
        return new com.zs.util.ResponseEntity<>(1000,"Success",pageInfo);
    }



    /**
     * 直接购买__新增数据
     *
     * @param orders 实体
     * @return 新增结果
     */

    @PostMapping("/VegetableMarket/orders")
    public com.zs.util.ResponseEntity<String> add(Orders orders, String gId, String odWeight, HttpServletRequest request) {
        System.out.println("====订单信息："+orders.getAdId()+","+orders.getOPayType()+","+gId+","+odWeight);
        //从token查uId
        String tokenString = (String) request.getAttribute("token");
        Token token = tokenService.queryByUUId(tokenString);

        orders.setUId(token.getUId());
        orders.setOTime(new Date());
        orders.setOStatus("待支付");
        //通过gId查商品
        Goods goods = goodsService.queryById(Integer.parseInt(gId));
        orders.setOTotalPrice(goods.getGPrice()*Integer.parseInt(odWeight));
        orders.setOFreightPrice(10);
        orders.setOIdend(1);
        orders.setOPayStatus(0);

        int flag = ordersService.insert(orders,gId,odWeight);
        if (flag == 1){
            return new com.zs.util.ResponseEntity<>(1000,"Success","订单提交成功");
        }
        return new com.zs.util.ResponseEntity<>(1002,"Error","订单提交失败");
    }

    /**
     * 购物车结算__新增数据
     *
     * @param orders 实体
     * @return 新增结果
     */
    @PostMapping("/VegetableMarket/ordersByCart/scIdArr/{scIdArr}")
    public com.zs.util.ResponseEntity<String> addByCart(Orders orders,@PathVariable("scIdArr") Integer[] scIdArr,HttpServletRequest request) {
        System.out.println("====订单信息："+orders.getAdId()+","+orders.getOPayType()+",scIdArr:"+ Arrays.toString(scIdArr));
        //从token查uId
        String tokenString = (String) request.getAttribute("token");
        Token token = tokenService.queryByUUId(tokenString);
        orders.setUId(token.getUId());
        orders.setOTime(new Date());
        orders.setOStatus("待支付");
        orders.setOFreightPrice(10);
        orders.setOIdend(1);
        orders.setOPayStatus(0);
        //通过购物车表查商品(当前用户的购物车)

        int flag = ordersService.insertByCart(orders,scIdArr);
        if (flag == 1){
            return new com.zs.util.ResponseEntity<>(1000,"Success","订单提交成功");
        }
        return new com.zs.util.ResponseEntity<>(1002,"Error","订单提交失败");

    }

    /**
     * 编辑数据
     *
     * @param orders 实体
     * @return 编辑结果
     */
//<<<<<<< HEAD
//    @PutMapping("/VegetableMarket/OrdersPage")
//=======
//    @PutMapping("/VegetableMarket/orders")
//>>>>>>> 66face6ab7d2b3a3f760b2d7f44c03d438dd0d54
//    public ResponseEntity<Orders> edit(Orders orders) {
//        return ResponseEntity.ok(this.ordersService.update(orders));
//    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
//<<<<<<< HEAD
//    @DeleteMapping("/VegetableMarket/OrdersPage")
//=======
//    @DeleteMapping("/VegetableMarket/orders")
//>>>>>>> 66face6ab7d2b3a3f760b2d7f44c03d438dd0d54
//    public ResponseEntity<Boolean> deleteById(String id) {
//        return ResponseEntity.ok(this.ordersService.deleteById(id));
//    }

}

