package com.zs.service.impl;

import com.zs.entity.Classification;
import com.zs.dao.ClassificationDao;
import com.zs.service.ClassificationService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

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
     * 分页查询
     *
     * @param classification 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @Override
    public Page<Classification> queryByPage(Classification classification, PageRequest pageRequest) {
        long total = this.classificationDao.count(classification);
        return new PageImpl<>(this.classificationDao.queryAllByLimit(classification, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param classification 实例对象
     * @return 实例对象
     */
    @Override
    public Classification insert(Classification classification) {
        this.classificationDao.insert(classification);
        return classification;
    }

    /**
     * 修改数据
     *
     * @param classification 实例对象
     * @return 实例对象
     */
    @Override
    public Classification update(Classification classification) {
        this.classificationDao.update(classification);
        return this.queryById(classification.getCId());
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
}
