package com.example.bananaking.config.facebook;

import com.example.bananaking.config.FacebookPageProperties;
import com.example.bananaking.config.FacebookProperties;
import com.example.bananaking.http.AccessTokenSupplier;
import com.example.bananaking.http.api.FacebookPageService;
import com.example.bananaking.http.api.FacebookService;
import com.example.bananaking.http.FacebookServiceBuilder;
import com.example.bananaking.http.PageTokenSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jerry on 2018/7/18.
 *
 * @author jerry
 */
@Configuration
public class FacebookConfiguration {

    @Autowired
    private FacebookProperties properties;

    @Autowired
    private FacebookPageProperties pageProperties;

    /**
     * call general graph api with personal access token
     *
     * @return {@link FacebookService}
     */
    @Bean
    public FacebookService facebookService() {
        return FacebookServiceBuilder
            .create(AccessTokenSupplier.of(properties.getAccessToken()))
            .apiEndpoint(properties.getBaseUrl())
            .build(FacebookService.class);
    }

    /**
     * call page api with page access token
     *
     * @return {@link FacebookPageService}
     */
    @Bean
    public FacebookPageService facebookPageService() {
        return FacebookServiceBuilder
            .create(PageTokenSupplier.of(pageProperties.getToken()))
            .apiEndpoint(properties.getBaseUrl())
            .build(FacebookPageService.class);
    }
}
