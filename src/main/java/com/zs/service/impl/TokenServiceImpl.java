package com.zs.service.impl;

import com.zs.entity.Token;
import com.zs.dao.TokenDao;
import com.zs.service.TokenService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Token)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:38:11
 */
@Service("tokenService")
public class TokenServiceImpl implements TokenService {
    @Resource
    private TokenDao tokenDao;

    /**
     * 通过ID查询单条数据
     *
     * @param toId 主键
     * @return 实例对象
     */
    @Override
    public Token queryById(Integer toId) {
        return this.tokenDao.queryById(toId);
    }

    /**
     * 通过UUID查询单条数据
     *
     * @param toUuid 查询条件
     * @return
     */
    @Override
    public Token queryByUUId(String toUuid) {
        return tokenDao.queryByUUId(toUuid);
    }

    /**
     * 新增数据
     *
     * @param token 实例对象
     * @return 实例对象
     */
    @Override
    public Token insert(Token token) {
        this.tokenDao.insert(token);
        return token;
    }

    /**
     * 修改数据
     *
     * @param token 实例对象
     * @return 实例对象
     */
    @Override
    public Token update(Token token) {
        this.tokenDao.update(token);
        return this.queryById(token.getToId());
    }

    /**
     * 通过主键删除数据
     *
     * @param toId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer toId) {
        return this.tokenDao.deleteById(toId) > 0;
    }
}
