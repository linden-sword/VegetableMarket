package com.zs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.entity.Orders;
import com.zs.dao.OrdersDao;
import com.zs.entity.Users;
import com.zs.dao.GoodsDao;
import com.zs.dao.OrderdetailsDao;
import com.zs.dao.ShoppingcartDao;
import com.zs.entity.Goods;
import com.zs.entity.Orderdetails;
import com.zs.entity.Orders;
import com.zs.dao.OrdersDao;
import com.zs.entity.Shoppingcart;
import com.zs.service.OrdersService;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * (Orders)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:38:10
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersDao ordersDao;
    @Resource
    private OrderdetailsDao orderdetailsDao;
    @Resource
    private GoodsDao goodsDao;
    @Resource
    private ShoppingcartDao shoppingcartDao;

    /**
     * 通过ID查询单条数据
     *
     * @param oId 主键
     * @return 实例对象
     */
    @Override
    public Orders queryById(String oId) {
        return this.ordersDao.queryById(oId);
    }





    /**
     * 添加订单(事务)__直接购买
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(Orders orders, String gId, String odWeight) {
        //先插入订单表
        //生成订单编号
        String oId = UUID.randomUUID().toString();
        orders.setOId(oId);
        this.ordersDao.insert(orders);
        //插入订单详情表
        Orderdetails orderdetails = new Orderdetails();
        orderdetails.setOId(oId);
        orderdetails.setGId(Integer.parseInt(gId));
        orderdetails.setOdPrice(goodsDao.queryById(Integer.parseInt(gId)).getGPrice()*Integer.parseInt(odWeight));
        orderdetails.setOdWeight(Integer.parseInt(odWeight));
        orderdetailsDao.insert(orderdetails);
        //减少库存(通过gId查库存，减少后修改库存)
        Goods goods = goodsDao.queryById(Integer.parseInt(gId));
        goods.setGStock(goods.getGStock()-Integer.parseInt(odWeight));
        goodsDao.update(goods);
        return 1;
    }

    @Override
    public PageInfo queryordersPage(int pageNum) {
        PageHelper.startPage(pageNum, 4);
        List<Orders> ordersList =ordersDao.queryAllordersPage();
        com.github.pagehelper.PageInfo pageInfo = new com.github.pagehelper.PageInfo(ordersList);
        return pageInfo;
    }
    @Override
    public PageInfo queryAllordersPageByUid(int uId,int pageNum) {
        PageHelper.startPage(pageNum, 4);
        List<Orders> ordersList =ordersDao.queryAllordersPageByUid(uId);
        com.github.pagehelper.PageInfo pageInfo = new com.github.pagehelper.PageInfo(ordersList);
        return pageInfo;
    }

    /**
     * 添加订单(事务)__购物车结算
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insertByCart(Orders orders,Integer[] scIdArr) {
        //生成订单编号
        String oId = UUID.randomUUID().toString();
        orders.setOId(oId);
        //通过scIdArr查询购物车商品
        List<Shoppingcart> shoppingcartList = shoppingcartDao.queryByScIdArr(scIdArr);
        //循环插入订单详情表；同时减少库存，并计算totalPrice
        double totalPrice = 0;
        for (Shoppingcart shoppingcart:shoppingcartList){
            Orderdetails orderdetails = new Orderdetails();
            orderdetails.setOId(oId);
            orderdetails.setGId(shoppingcart.getGId());
            orderdetails.setOdPrice(goodsDao.queryById(shoppingcart.getGId()).getGPrice()*shoppingcart.getScWeight());
            orderdetails.setOdWeight(shoppingcart.getScWeight());
            orderdetailsDao.insert(orderdetails);
            //删除购物车
            shoppingcartDao.deleteById(shoppingcart.getScId());
            //减少库存(通过gId查库存，减少后修改库存)
            Goods goods = goodsDao.queryById(shoppingcart.getGId());
            goods.setGStock(goods.getGStock()-shoppingcart.getScWeight());
            goodsDao.update(goods);
            //计算totalPrice
            totalPrice = totalPrice + goodsDao.queryById(shoppingcart.getGId()).getGPrice()*shoppingcart.getScWeight();
        }
        orders.setOTotalPrice(totalPrice+10);
        //插入订单表
        this.ordersDao.insert(orders);
        return 1;
    }

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public Orders update(Orders orders) {
        this.ordersDao.update(orders);
        return this.queryById(orders.getOId());
    }

    /**
     * 通过主键删除数据
     *
     * @param oId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String oId) {
        return this.ordersDao.deleteById(oId) > 0;
    }
}
