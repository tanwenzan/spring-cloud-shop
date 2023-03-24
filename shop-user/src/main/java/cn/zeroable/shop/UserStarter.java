package cn.zeroable.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 简要说明.
 * <br/> 详细说明.
 *
 * @author zeroable
 * @version 2023/3/24 16:31
 * @see
 * @since 0.0.1
 */
@SpringBootApplication
@EnableAsync
@EnableDiscoveryClient
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(value = {"cn.zeroable.shop.user.mapper"})
public class UserStarter {
    public static void main(String[] args) {
        SpringApplication.run(UserStarter.class, args);
    }
}
