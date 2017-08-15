package com.magicbeans.common.cache;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by ShowSoft on 2017/7/11.
 */
public class MybatisCache implements Cache {

    private final static Logger logger = LoggerFactory.getLogger(MybatisCache.class);

    /**
     * The ReadWriteLock.
     */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private MyBatisCacheClient client;
    private String id;

    public MybatisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id=" + id);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void putObject(Object o, Object o1) {
        getClient().putObject(o,o1);
    }

    public Object getObject(Object o) {
        return getClient().getObject(o);
    }

    public Object removeObject(Object o) {
        return getClient().removeObject(o);
    }

    public void clear() {
        getClient().clear();
    }

    public int getSize() {
        return getClient().getSize();
    }

    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }


    private MyBatisCacheClient getClient(){
        if(null == client){
            return client = CacheClientBind.getCacheClient();
        }
        return client;
    }
}
