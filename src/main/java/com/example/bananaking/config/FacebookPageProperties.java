package com.example.bananaking.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by jerry on 2018/7/19.
 *
 * @author jerry
 */
@Data
@ConfigurationProperties(prefix = "facebook.page")
public class FacebookPageProperties {

    /** page id */
    private String id;

    /** page name */
    private String name;

    /** page token */
    private String token;
}
