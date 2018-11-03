package com.hg;

import com.hg.config.StorageProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;


/**
 * Main class of application<br>
 *
 * @author Xiaochuan Wang (wangxiaochuan01@163.com)
 */

@SpringBootApplication
@EnableCaching
@EnableConfigurationProperties({StorageProperties.class})
@MapperScan({"com.hg.web.repository", "com.hg.promotion.repository", "com.hg.security.repository"})
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
