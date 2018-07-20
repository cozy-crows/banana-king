package com.example.bananaking.mananger;

import com.example.bananaking.http.api.FacebookPageService;
import com.example.bananaking.mananger.entity.FbResponse;
import com.example.bananaking.mananger.entity.fanspage.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by jerry on 2018/7/19.
 *
 * 包裝 FacebookPageService.java
 *
 * @author jerry
 */
@Service
@AllArgsConstructor
public class FacebookPageManager {

    private final FacebookPageService pageService;


    public CompletableFuture<FbResponse<Post>> getPosts(final String pageId) {
        final List<String> fields = Arrays.asList("id", "about", "cover", "description", "description_html",
            "fan_count", "is_messenger_platform_bot", "is_webhooks_subscribed", "link", "name", "rating_count",
            "talking_about_count", "unread_message_count", "unread_notif_count", "website", "were_here_count");

        return toFuture(
            pageService.posts(pageId, fieldsToString(fields), null, null));
    }

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

    private String fieldsToString(List<String> fields) {
        return String.join(",", fields);
    }
}
