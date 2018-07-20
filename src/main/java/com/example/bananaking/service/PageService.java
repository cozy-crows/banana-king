package com.example.bananaking.service;

import com.example.bananaking.mananger.FacebookPageManager;
import com.example.bananaking.mananger.dto.fanspage.PageDTO;
import com.example.bananaking.repository.PageRepository;
import com.example.bananaking.service.transform.PageTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by jerry on 2018/7/20.
 *
 * @author jerry
 */
@Service
@AllArgsConstructor
public class PageService {

    private FacebookPageManager pageManager;
    private PageRepository pageRepo;

    /**
     * Fetch page info and save
     */
    public void fetchAndSavePage(final String pageId) throws ExecutionException, InterruptedException {

        CompletableFuture<PageDTO> future = pageManager.getPage(pageId);
        PageDTO pageInfo = future.get();
        pageRepo.save(
            PageTransformer.toEntity(pageInfo));
    }
}
