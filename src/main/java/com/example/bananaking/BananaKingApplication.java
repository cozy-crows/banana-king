package com.example.bananaking;

import com.example.bananaking.config.FacebookPageProperties;
import com.example.bananaking.config.FacebookProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {
    FacebookProperties.class,
    FacebookPageProperties.class
})
public class BananaKingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BananaKingApplication.class, args);
    }
}
