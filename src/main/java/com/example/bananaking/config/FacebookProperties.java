package com.example.bananaking.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by jerry on 2018/7/18.
 *
 * @author jerry
 */
@Data
@ConfigurationProperties(prefix = "facebook")
public class FacebookProperties {

    /** api version */
    private String version;

    /** base graph api url */
    private String baseUrl;

    /** develop app id */
    private String app;

    /** develop app secret */
    private String secret;

    /** access token */
    private String accessToken;
}
