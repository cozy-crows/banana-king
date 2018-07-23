package com.example.bananaking.service;

import static org.junit.Assert.assertTrue;

import com.example.bananaking.BaseicTest;
import com.example.bananaking.config.FacebookPageProperties;
import com.example.bananaking.entity.Page;
import com.example.bananaking.entity.Post;
import com.example.bananaking.repository.CommentRepository;
import com.example.bananaking.repository.PageRepository;
import com.example.bananaking.repository.PostRepository;
import com.example.bananaking.repository.ReactionUserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
    private ReactionUserRepository reactionUserRepo;

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
        assertTrue(1 < pageRepo.findAll().size());
    }

    @Test
    @Transactional
    public void assert_save_comments_success() throws ExecutionException, InterruptedException {
        Post post = postRepo.getOne("540088262692058_1000307046670175");
        pageService.fetchAndSaveComments(post);
        assertTrue(1 <= commentRepo.findAll().size());
    }

    @Test
    public void assert_save_reactions_success() throws ExecutionException, InterruptedException {
        Post post = postRepo.getOne("540088262692058_1000307046670175");
        pageService.fetchAndSaveReactions(post);
        assertTrue(1 <= reactionUserRepo.findAll().size());
    }

}
