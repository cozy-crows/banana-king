package com.example.bananaking.service;

import com.example.bananaking.entity.Comment;
import com.example.bananaking.entity.Page;
import com.example.bananaking.entity.Post;
import com.example.bananaking.entity.CommentUser;
import com.example.bananaking.mananger.FacebookPageManager;
import com.example.bananaking.mananger.dto.FbResponse;
import com.example.bananaking.mananger.dto.fanspage.CommentDTO;
import com.example.bananaking.mananger.dto.fanspage.PageDTO;
import com.example.bananaking.mananger.dto.fanspage.PostDTO;
import com.example.bananaking.repository.CommentRepository;
import com.example.bananaking.repository.PageRepository;
import com.example.bananaking.repository.PostRepository;
import com.example.bananaking.repository.CommentUserRepository;
import com.example.bananaking.service.transform.CommentTransformer;
import com.example.bananaking.service.transform.PageTransformer;
import com.example.bananaking.service.transform.PostTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * Created by jerry on 2018/7/20.
 *
 * @author jerry
 */
@Slf4j
@Service
@AllArgsConstructor
public class PageService {

    private FacebookPageManager pageManager;
    private PageRepository pageRepo;
    private PostRepository postRepo;
    private CommentRepository commentRepo;
    private CommentUserRepository userRepo;

    /**
     * Fetch page info and save
     */
    @Transactional(rollbackFor = Exception.class)
    public Page fetchAndSavePage(final String pageId) throws ExecutionException, InterruptedException {

        CompletableFuture<PageDTO> future = pageManager.getPage(pageId);
        PageDTO pageInfo = future.get();
        Page page = PageTransformer.toEntity(pageInfo);
        return pageRepo.save(page);
    }


    public List<Post> fetchAndSavePosts(final Page page) throws ExecutionException, InterruptedException {

        List<Post> allPosts = new ArrayList<>();
        FbResponse<PostDTO> response;
        String nextPage = null;

        do {
            CompletableFuture<FbResponse<PostDTO>> future = pageManager.getPosts(page.getId(), nextPage);
            response = future.get();
            List<Post> posts =
                response.getData()
                    .parallelStream()
                    .map(post -> PostTransformer.toEntity(page, post))
                    .collect(Collectors.toList());
            nextPage = response.getAfterPageHash();
            allPosts.addAll(posts);
        } while (response.hasNextPage());

        allPosts = postRepo.saveAll(allPosts);
        page.setPosts(allPosts);
        pageRepo.save(page);
        return allPosts;
    }


    public List<Comment> fetchAndSaveComments(Post post) throws ExecutionException, InterruptedException {

        List<Comment> allComments = new ArrayList<>();
        List<CommentUser> allUsers = new ArrayList<>();
        FbResponse<CommentDTO> response;
        String nextPage = null;

        do {
            CompletableFuture<FbResponse<CommentDTO>> future =
                pageManager.getPostComments(post.getId(), nextPage);
            response = future.get();
            List<Comment> comments =
                response.getData()
                    .parallelStream()
                    .map(comment -> CommentTransformer.toEntity(post, comment))
                    .collect(Collectors.toList());
            List<CommentUser> users =
                comments.parallelStream()
                .map(Comment::getFrom)
                .collect(Collectors.toList());

            nextPage = response.getAfterPageHash();
            allComments.addAll(comments);
            allUsers.addAll(users);
        } while (response.hasNextPage());

        userRepo.saveAll(allUsers);
        allComments = commentRepo.saveAll(allComments);
        post.setComments(allComments);
        postRepo.save(post);
        return allComments;
    }
}
