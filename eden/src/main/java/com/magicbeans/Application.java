package com.magicbeans;

import com.magicbeans.common.cache.CacheClientBind;
import com.magicbeans.common.cache.redis.RedisMybatisCacheClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.magicbeans")
public class Application implements ApplicationListener<ApplicationReadyEvent> {


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisMybatisCacheClient  redisMybatisCacheClient;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        CacheClientBind.setCacheClient(redisMybatisCacheClient);
    }

    @Bean
    public RedisMybatisCacheClient redisMybatisCacheClient(){
        return  new RedisMybatisCacheClient(redisTemplate);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }


}
