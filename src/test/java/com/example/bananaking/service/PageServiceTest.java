package com.example.bananaking.service;

import static org.junit.Assert.assertTrue;

import com.example.bananaking.BaseicTest;
import com.example.bananaking.config.FacebookPageProperties;
import com.example.bananaking.entity.Page;
import com.example.bananaking.repository.CommentRepository;
import com.example.bananaking.repository.PageRepository;
import com.example.bananaking.repository.PostRepository;
import com.example.bananaking.repository.ReactionRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

/**
 * Created by jerry on 2018/7/21.
 *
 * @author jerry
 */
public class PageServiceTest extends BaseicTest {

    @Autowired
    private PageService pageService;
    @Autowired
    private FacebookPageProperties pageProperties;
    @Autowired
    private PageRepository pageRepo;
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private CommentRepository commentRepo;
    @Autowired
    private ReactionRepository reactionRepo;

    @Test
    @Transactional
    public void assert_save_page_success() throws ExecutionException, InterruptedException {
        pageService.fetchAndSavePage(pageProperties.getId());
        assertTrue(1 <= pageRepo.findAll().size());
    }

    @Test
    @Transactional
    public void assert_save_posts_success() throws ExecutionException, InterruptedException {
        Page page = pageRepo.getOne(pageProperties.getId());
        pageService.fetchAndSavePosts(page);
        assertTrue(1 <= postRepo.findAll().size());
    }

    @Test
    @Transactional
    public void assert_fetch_all_post_comments_success() {
        Page page = pageRepo.getOne(pageProperties.getId());
        LocalDateTime since = LocalDateTime.of(2018, 6, 1, 1,1);
        LocalDateTime until = LocalDateTime.now();

        pageService.fetchAllPostComments(page, since, until);
        assertTrue(1 <= commentRepo.findAll().size());
    }


    @Test
    @Transactional
    public void assert_fetch_all_post_reactions_success() {
        Page page = pageRepo.getOne(pageProperties.getId());
        LocalDateTime since = LocalDateTime.of(2018, 6, 1, 1,1);
        LocalDateTime until = LocalDateTime.now();

        pageService.fetchAllPostReactions(page, since, until);
        assertTrue(1 <= reactionRepo.findAll().size());
    }

}
