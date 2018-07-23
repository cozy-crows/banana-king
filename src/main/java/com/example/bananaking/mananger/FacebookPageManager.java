package com.example.bananaking.mananger;

import com.example.bananaking.http.api.FacebookPageService;
import com.example.bananaking.mananger.dto.FbResponse;
import com.example.bananaking.mananger.dto.fanspage.CommentDTO;
import com.example.bananaking.mananger.dto.fanspage.PageDTO;
import com.example.bananaking.mananger.dto.fanspage.PostDTO;
import com.example.bananaking.mananger.dto.fanspage.ReactionDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by jerry on 2018/7/19.
 * <p>
 * 包裝 FacebookPageService.java
 *
 * @author jerry
 */
@Service
@AllArgsConstructor
public class FacebookPageManager {

    private final FacebookPageService pageService;

    /**
     * Async request
     *
     * @param callToWrap
     * @param <T>
     * @return
     */
    private static <T> CompletableFuture<T> toFuture(Call<T> callToWrap) {
        final CallbackAdaptor<T> responseFuture = new CallbackAdaptor<>();
        callToWrap.enqueue(responseFuture);
        return responseFuture;
    }

    public CompletableFuture<PageDTO> getPage(final String pageId) {
        final List<String> fields = Arrays.asList("id", "about", "cover", "description", "description_html",
            "fan_count", "is_messenger_platform_bot", "is_webhooks_subscribed", "link", "name", "new_like_count",
            "rating_count", "talking_about_count", "unread_message_count", "unread_notif_count",
            "website", "were_here_count");
        return toFuture(
            pageService.page(pageId, fieldsToString(fields), null, null)
        );
    }

    public CompletableFuture<FbResponse<PostDTO>> getPosts(final String pageId, final String nextPage) {
        final List<String> fields = Arrays.asList("id", "message", "link", "object_id", "created_time",
            "full_picture", "shares");
        final boolean isPublished = true;
        final int limit = 100;
        return toFuture(
            pageService.posts(pageId, fieldsToString(fields), isPublished, limit, nextPage, null)
        );
    }

    public CompletableFuture<FbResponse<CommentDTO>> getPostComments(final String postId, final String nextPage) {
        final List<String> fields = Arrays.asList("id", "message", "from", "created_time",
            "comment_count", "like_count");
        final int limit = 100;
        return toFuture(
            pageService.postComments(postId, fieldsToString(fields), limit, nextPage, null)
        );
    }

    public CompletableFuture<FbResponse<ReactionDTO>> getPostReactions(final String postId, final String nextPage) {
        final List<String> fields = Arrays.asList("id","name","pic_large","type","link");
        final int limit = 100;
        return toFuture(
            pageService.postReactions(postId, fieldsToString(fields), limit, nextPage, null)
        );
    }

    private String fieldsToString(List<String> fields) {
        return String.join(",", fields);
    }
}
