package com.example.bananaking.config.thymeleaf;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jerry on 2018/7/24.
 *
 * @author jerry
 */
@Configuration
public class LayoutDialectConfig {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
