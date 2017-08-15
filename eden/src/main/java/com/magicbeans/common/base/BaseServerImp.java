package com.magicbeans.common.base;

import com.baomidou.mybatisplus.enums.SqlMethod;
import com.baomidou.mybatisplus.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.toolkit.ReflectionKit;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServerImp<M extends BaseMapper<T>, T> {
    private static final Log logger = LogFactory.getLog(ServiceImpl.class);
    @Autowired
    protected M baseMapper;

    public BaseServerImp() {
    }

    protected static boolean retBool(Integer result) {
        return SqlHelper.retBool(result);
    }

    protected Class<T> currentModelClass() {
        return ReflectionKit.getSuperClassGenricType(this.getClass(), 1);
    }

    protected SqlSession sqlSessionBatch() {
        return SqlHelper.sqlSessionBatch(this.currentModelClass());
    }

    protected String sqlStatement(SqlMethod sqlMethod) {
        return SqlHelper.table(this.currentModelClass()).getSqlStatement(sqlMethod.getMethod());
    }

    protected Page<T> selectPage(Page<T> page, Wrapper<T> wrapper) {
        SqlHelper.fillWrapper(page, wrapper);
        page.setRecords(this.baseMapper.selectPage(page, wrapper));
        return page;
    }

    protected boolean insertBatch(List<T> entityList, int batchSize) {
        if (CollectionUtils.isEmpty(entityList)) {
            throw new IllegalArgumentException("Error: entityList must not be empty");
        } else {
            SqlSession batchSqlSession = this.sqlSessionBatch();

            try {
                int size = entityList.size();
                String sqlStatement = this.sqlStatement(SqlMethod.INSERT_ONE);

                for(int i = 0; i < size; ++i) {
                    batchSqlSession.insert(sqlStatement, entityList.get(i));
                    if (i >= 1 && i % batchSize == 0) {
                        batchSqlSession.flushStatements();
                    }
                }

                batchSqlSession.flushStatements();
                return true;
            } catch (Throwable var7) {
                throw new MybatisPlusException("Error: Cannot execute insertBatch Method. Cause", var7);
            }
        }
    }
}
