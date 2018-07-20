package com.example.bananaking.manager;

import static org.junit.Assert.assertNotNull;

import com.example.bananaking.BaseicTest;
import com.example.bananaking.config.FacebookPageProperties;
import com.example.bananaking.mananger.FacebookPageManager;
import com.example.bananaking.mananger.entity.FbResponse;
import com.example.bananaking.mananger.entity.fanspage.Post;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutionException;

/**
 * Created by jerry on 2018/7/20.
 *
 * @author jerry
 */
public class FacebookPageManagerTest extends BaseicTest {

    @Autowired
    private FacebookPageManager pageManager;
    @Autowired
    private FacebookPageProperties pageProperties;

    @Test
    public void assert_get_post_success() throws ExecutionException, InterruptedException {

        FbResponse<Post> response = pageManager.getPosts(pageProperties.getId()).get();

        assertNotNull(response.getData());
    }
}
