package com.magicbeans.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.plugins.Page;
import com.magicbeans.entity.User;
import com.magicbeans.mapper.UserMapper;
import com.magicbeans.common.base.BaseServerImp;
import com.magicbeans.service.IUserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author magic-beans
 * @since 2017-07-27
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl extends BaseServerImp<UserMapper, User> implements IUserService {


    @Override
    @CacheEvict(allEntries = true)
    public boolean insert(User var1) {
        return SqlHelper.retBool(baseMapper.insert(var1));
    }

    @Override
    @CacheEvict(allEntries = true)
    public boolean deleteById(Serializable var1) {
        return SqlHelper.retBool(baseMapper.deleteById(var1));
    }


    @Override
    @CacheEvict(allEntries = true)
    public boolean updateById(User var1) {
        return SqlHelper.retBool(baseMapper.updateById(var1));
    }


    @Override
    @Cacheable
    public User selectById(Serializable id) {
        return baseMapper.selectById(id);
    }


    @Override
    @Cacheable
    public Page<User> selectPage(Page<User> objectPage) {
        return this.selectPage(objectPage, Condition.EMPTY);
    }
}
