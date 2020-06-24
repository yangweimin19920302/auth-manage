package com.auth.manage.util;


import com.auth.starter.ConfigurationManagement;
import com.auth.starter.annotation.LoginType;
import com.auth.starter.annotation.StorageMedium;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 认证配置
 */
@Configuration
public class ConfigurationUtil {

    /**
     * 认证相关配置
     */
    @Bean
    public void getCacheManagement() {
        //LoginType.MANY表示一个账号可以多点登录；LoginType.ONE为一个账号只能在一个点登录，（即，后面登录的人会把前面登录的人踢出登录）
        ConfigurationManagement.setLoginType(LoginType.ONE);
        //StorageMedium.EHCACHE为ehcache缓存,StorageMedium.REDIS为redis缓存
        ConfigurationManagement.setStorageMedium(StorageMedium.EHCACHE);

        //如果使用redis，必须配置redis的IP地址和端口
        /*RedisConfig redisConfig = ConfigurationManagement.getRedisConfig();
        redisConfig.setIp("118.118.118.20");
        redisConfig.setPort(6379);*/

        //如果使用Ehcache，可以不配置，则使用默认的配置
        /*EhcacheConfig ehcacheConfig = ConfigurationManagement.getEhcacheConfig();
        ehcacheConfig.setPath("/ehcache.xml");*/
    }
}
