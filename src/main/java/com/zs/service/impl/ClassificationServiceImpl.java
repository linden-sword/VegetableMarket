package com.zs.service.impl;

import com.zs.entity.Classification;
import com.zs.dao.ClassificationDao;
import com.zs.service.ClassificationService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

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
