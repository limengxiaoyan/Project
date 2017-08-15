package com.magicbeans.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * @作者 jesus
 * @创建时间 2016/5/24 9:43
 * @描述
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 4800)
public class HttpSessionConfig {

    @Bean
    public HttpSessionStrategy httpSessionStrategy(){
        return new CookieHttpSessionStrategy();
    }

}
