package com.zs.service.impl;

import com.zs.entity.Shoppingcart;
import com.zs.dao.ShoppingcartDao;
import com.zs.service.ShoppingcartService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Shoppingcart)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:38:11
 */
@Service("shoppingcartService")
public class ShoppingcartServiceImpl implements ShoppingcartService {
    @Resource
    private ShoppingcartDao shoppingcartDao;

    /**
     * 通过ID查询单条数据
     *
     * @param scId 主键
     * @return 实例对象
     */
    @Override
    public Shoppingcart queryById(Integer scId) {
        return this.shoppingcartDao.queryById(scId);
    }

    @Override
    public List<Shoppingcart> queryByUid(Integer uId) {
        return this.shoppingcartDao.queryByUid(uId);
    }

    /**
     * 分页查询
     *
     * @param shoppingcart 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    @Override
    public Page<Shoppingcart> queryByPage(Shoppingcart shoppingcart, PageRequest pageRequest) {
        long total = this.shoppingcartDao.count(shoppingcart);
        return new PageImpl<>(this.shoppingcartDao.queryAllByLimit(shoppingcart, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param shoppingcart 实例对象
     * @return 实例对象
     */
    @Override
    public Shoppingcart insert(Shoppingcart shoppingcart) {
        this.shoppingcartDao.insert(shoppingcart);
        return shoppingcart;
    }

    /**
     * 修改数据
     *
     * @param shoppingcart 实例对象
     * @return 实例对象
     */
    @Override
    public Shoppingcart update(Shoppingcart shoppingcart) {
        this.shoppingcartDao.update(shoppingcart);
        return this.queryById(shoppingcart.getScId());
    }

    @Override
    public Shoppingcart updateAdd(Shoppingcart shoppingcart) {
       this.shoppingcartDao.updateAddWeight(shoppingcart);
   return this.queryById(shoppingcart.getScId());
    }

    @Override
    public Shoppingcart updatemul(Shoppingcart shoppingcart) {
        this.shoppingcartDao.updatemulWeight(shoppingcart);
        return this.queryById(shoppingcart.getScId());
    }

    /**
     * 通过主键删除数据
     *
     * @param scId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer scId) {
        return this.shoppingcartDao.deleteById(scId) > 0;
    }
}
