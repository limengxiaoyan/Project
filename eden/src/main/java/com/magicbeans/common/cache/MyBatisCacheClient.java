package com.magicbeans.common.cache;

/**
 * Created by ShowSoft on 2017/7/11.
 */
public interface MyBatisCacheClient {

    /**
     * PUT
     * @param key
     * @param value
     */
    void putObject(Object key, Object value) ;

    /**
     * get
     * @param key
     * @return
     */
    Object getObject(Object key);


    /**
     * REMOVE
     * @param key
     * @return
     */
    Object removeObject(Object key);


    /**
     * clear
     */
    void clear();

    /**
     * GET SIZE
     * @return
     */
    int getSize();
}
