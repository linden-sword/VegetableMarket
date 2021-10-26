package com.zs.service;

import com.zs.entity.Classification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Classification)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:38:07
 */
public interface ClassificationService {

    List<Classification> FindAll();

    /**
     * 新增数据
     *
     * @param classification 实例对象
     * @return 实例对象
     */
    Classification insert(Classification classification);
    Classification queryByName(String cName);

    /**
     * 通过主键删除数据
     *
     * @param cId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer cId);

}
