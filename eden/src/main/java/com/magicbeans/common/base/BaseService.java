package com.magicbeans.common.base;

import com.baomidou.mybatisplus.plugins.Page;

import java.io.Serializable;

public interface BaseService<T> {

    boolean insert(T var1);

    boolean deleteById(Serializable var1);

    boolean updateById(T var1);

    T selectById(Serializable var1);

    Page<T> selectPage(Page<T> var1);

}
