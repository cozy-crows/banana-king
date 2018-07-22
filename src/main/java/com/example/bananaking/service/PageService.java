package com.example.bananaking.service;

import com.example.bananaking.entity.Post;
import com.example.bananaking.mananger.FacebookPageManager;
import com.example.bananaking.mananger.dto.FbResponse;
import com.example.bananaking.mananger.dto.fanspage.PageDTO;
import com.example.bananaking.mananger.dto.fanspage.PostDTO;
import com.example.bananaking.repository.PageRepository;
import com.example.bananaking.repository.PostRepository;
import com.example.bananaking.service.transform.PageTransformer;
import com.example.bananaking.service.transform.PostTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

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
    private PostRepository postRepo;

    /**
     * Fetch page info and save
     */
    public void fetchAndSavePage(final String pageId) throws ExecutionException, InterruptedException {

        CompletableFuture<PageDTO> future = pageManager.getPage(pageId);
        PageDTO pageInfo = future.get();
        pageRepo.save(
            PageTransformer.toEntity(pageInfo));
    }

    public void fetchAndSavePosts(final String pageId) throws ExecutionException, InterruptedException {

        FbResponse<PostDTO> response;
        String nextPage = null;

        do {
            CompletableFuture<FbResponse<PostDTO>> future = pageManager.getPosts(pageId, nextPage);
            response = future.get();
            List<Post> posts =
                response.getData()
                .parallelStream()
                .map(PostTransformer::toEntity)
                .collect(Collectors.toList());
            nextPage = response.getAfterPageHash();
            postRepo.saveAll(posts);
        } while (response.hasNextPage());
    }
}
