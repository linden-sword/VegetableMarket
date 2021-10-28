package com.zs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.entity.Classification;
import com.zs.dao.ClassificationDao;
import com.zs.service.ClassificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Classification)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:38:07
 */
@Service("classificationService")
public class ClassificationServiceImpl implements ClassificationService {
    @Resource
    private ClassificationDao classificationDao;


    @Override
    public List<Classification> FindAll() {
        return classificationDao.queryAll();
    }

    @Override
    public Classification queryByName(String cName) {
    return classificationDao.queryByName(cName);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param cId 主键
     * @return 实例对象
     */
    @Override
    public Classification queryById(Integer cId) {
        return this.classificationDao.queryById(cId);
    }

    /**
     * 新增数据
     *
     * @param classification 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Classification classification) {
        return this.classificationDao.insert(classification);
    }

    /**
     * 修改数据
     *
     * @param classification 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Classification classification) {

        return this.classificationDao.update(classification);
    }

    /**
     * 通过主键删除数据
     *
     * @param cId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer cId) {
        return this.classificationDao.deleteById(cId) > 0;
    }

    /**
     * 通过cId查询分页
     *
     * @param pageNum
     */
    @Override
    public PageInfo queryByCId(int pageNum) {
        //pageNum和pageSize
        PageHelper.startPage(pageNum, 7);
        List<Classification> List = classificationDao.queryAll();
        //创建pageInfo对象
        com.github.pagehelper.PageInfo pageInfo = new com.github.pagehelper.PageInfo(List);
        //返回pageInfo
        System.out.println(pageInfo);
        return pageInfo;
    }
}
