package com.zs.service.impl;

import com.zs.entity.Assesses;
import com.zs.dao.AssessesDao;
import com.zs.service.AssessesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Assesses)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:38:06
 */
@Service("assessesService")
public class AssessesServiceImpl implements AssessesService {
    @Resource
    private AssessesDao assessesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param asId 主键
     * @return 实例对象
     */
    @Override
    public Assesses queryById(Integer asId) {
        return this.assessesDao.queryById(asId);
    }

    /**
     * 分页查询
     *
     * @param assesses    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Assesses> queryByPage(Assesses assesses, PageRequest pageRequest) {
        long total = this.assessesDao.count(assesses);
        return new PageImpl<>(this.assessesDao.queryAllByLimit(assesses, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param assesses 实例对象
     * @return 实例对象
     */
    @Override
    public Assesses insert(Assesses assesses) {
        this.assessesDao.insert(assesses);
        return assesses;
    }

    /**
     * 修改数据
     *
     * @param assesses 实例对象
     * @return 实例对象
     */
    @Override
    public Assesses update(Assesses assesses) {
        this.assessesDao.update(assesses);
        return this.queryById(assesses.getAsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param asId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer asId) {
        return this.assessesDao.deleteById(asId) > 0;
    }
}
