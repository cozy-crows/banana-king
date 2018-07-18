package com.example.bananaking.http.api;

import com.fasterxml.jackson.databind.JsonNode;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jerry on 2018/7/18.
 *
 * @author jerry
 */
public interface FacebookService {

    /**
     * me info
     *
     * @return {@link JsonNode}
     */
    @GET("me")
    Call<JsonNode> me();
}
