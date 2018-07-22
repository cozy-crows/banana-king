package com.example.bananaking.manager;

import static org.junit.Assert.assertNotNull;

import com.example.bananaking.BaseicTest;
import com.example.bananaking.config.FacebookPageProperties;
import com.example.bananaking.mananger.FacebookPageManager;
import com.example.bananaking.mananger.dto.FbResponse;
import com.example.bananaking.mananger.dto.fanspage.CommentDTO;
import com.example.bananaking.mananger.dto.fanspage.PageDTO;
import com.example.bananaking.mananger.dto.fanspage.PostDTO;
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
    public void assert_get_page_success() throws ExecutionException, InterruptedException {

        PageDTO dto = pageManager.getPage(pageProperties.getId()).get();
        assertNotNull(dto);
    }

    @Test
    public void assert_get_post_success() throws ExecutionException, InterruptedException {

        FbResponse<PostDTO> posts = pageManager.getPosts(pageProperties.getId(), null).get();
        assertNotNull(posts);
    }

    @Test
    public void assert_get_comments_success() throws ExecutionException, InterruptedException {
        final String postId = "540088262692058_549928451708039";

        FbResponse<CommentDTO> comments = pageManager.getPostComments(postId, null).get();
        assertNotNull(comments);
    }
}
