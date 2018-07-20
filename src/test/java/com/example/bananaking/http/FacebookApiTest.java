package com.example.bananaking.http;

import static org.junit.Assert.assertEquals;

import com.example.bananaking.BaseicTest;
import com.example.bananaking.config.FacebookPageProperties;
import com.example.bananaking.http.api.FacebookPageService;
import com.example.bananaking.http.api.FacebookService;
import com.example.bananaking.mananger.dto.fanspage.PageDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * Created by jerry on 2018/7/18.
 *
 * @author jerry
 */
public class FacebookApiTest extends BaseicTest {

    @Autowired
    private FacebookService facebookService;

    @Autowired
    private FacebookPageService facebookPageService;

    @Autowired
    private FacebookPageProperties pageProperties;

    @Test
    public void assert_get_me_200() throws IOException {
        Call<JsonNode> call = facebookService.me();
        Response<JsonNode> response = call.execute();
        assertEquals(200, response.code());
    }

    @Test
    public void assert_get_page_200() throws IOException {
        final String pageId = pageProperties.getId();
        final String fields = "id, name";

        Call<PageDTO> call = facebookPageService.page(pageId, fields, null, null);
        Response<PageDTO> response = call.execute();
        assertEquals(200, response.code());
    }
}
