package com.example.bananaking.repository;

import static org.junit.Assert.assertTrue;

import com.example.bananaking.BaseicTest;
import com.example.bananaking.config.FacebookPageProperties;
import com.example.bananaking.entity.Page;
import com.example.bananaking.entity.Post;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jerry on 2018/7/23.
 *
 * @author jerry
 */
public class PostRepositoryTest extends BaseicTest {

    @Autowired
    private FacebookPageProperties pageProperties;

    @Autowired
    private PageRepository pageRepo;
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private ReactionRepository reactionUserRepo;

    @Test
    @Transactional
    public void assert_find_by_page_success() {
        Page page = pageRepo.getOne(pageProperties.getId());
        LocalDateTime since = LocalDateTime.of(2018, 6, 1, 1,1);
        LocalDateTime until = LocalDateTime.now();
        List<Post> posts = postRepo.findByPageAndCreatedTimeBetween(page, since, until);
        assertTrue(1 <= posts.size());
    }
}
