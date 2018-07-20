package com.example.bananaking.service;

import com.example.bananaking.BaseicTest;
import com.example.bananaking.config.FacebookPageProperties;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Test
    @Ignore
    public void assert_save_page_success() throws ExecutionException, InterruptedException {

        pageService.fetchAndSavePage(pageProperties.getId());
    }
}
