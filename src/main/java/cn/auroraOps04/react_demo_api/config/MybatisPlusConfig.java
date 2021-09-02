package cn.auroraOps04.react_demo_api.config;

import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author AuroraOps04
 * @date 2021-09-02 11:28:25
 * @description
 */

@Configuration
@MapperScan(basePackages = "cn.auroraOps04.react_demo_api.mapper")
public class MybatisPlusConfig {

    @Bean
    public PageInterceptor pageInterceptor() {
        return new PageInterceptor();
    }
}
