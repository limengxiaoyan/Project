package com.magicbeans.common.cache;

public class CacheClientBind {
    private static MyBatisCacheClient cacheClient;

    public static MyBatisCacheClient getCacheClient() {
        return cacheClient;
    }

    public static void setCacheClient(MyBatisCacheClient cacheClient) {
        CacheClientBind.cacheClient = cacheClient;
    }
}
