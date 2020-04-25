package com.hthyaq.learnadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("com.hthyaq.learnadmin.mapper")
public class LearnAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnAdminApplication.class, args);
    }

    //解决页面和redis的sessionId不一致情况
/*    @Bean
    public DefaultCookieSerializer getDefaultCookieSerializer() {
        DefaultCookieSerializer defaultCookieSerializer = new DefaultCookieSerializer();
        defaultCookieSerializer.setUseBase64Encoding(false);
        return defaultCookieSerializer;
    }*/
}
