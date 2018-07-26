package com.example.bananaking.service;

import com.example.bananaking.BaseicTest;
import com.example.bananaking.config.FacebookPageProperties;
import com.example.bananaking.entity.Page;
import com.example.bananaking.repository.PageRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jerry on 2018/7/26.
 *
 * @author jerry
 */
public class CommentServiceTest extends BaseicTest {

    @Autowired
    private FacebookPageProperties pageProperties;
    @Autowired
    private PageRepository pageRepo;
    @Autowired
    private CommentService commentService;

    @Test
    public void test() {
        Page page = pageRepo.getOne("540088262692058");
        commentService.top10CommentUsers();
    }
}
