package com.example.bananaking.mananger;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.concurrent.CompletableFuture;

/**
 * Created by jerry on 2018/7/19.
 *
 * 轉接 response 結果,
 *
 * @author jerry
 */
@Slf4j
class CallbackAdaptor<T> extends CompletableFuture<T> implements Callback<T> {

    /**
     * success get response
     *
     * @param call
     * @param response
     */
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            complete(response.body());

        } else {
            log.warn("Http error: {}", response.body());
            // todo warp to some exception...
            completeExceptionally(new Exception("Response not 200"));
        }
    }

    /**
     * http client connection timeout or hand-shack error
     *
     * @param call {@link Call}
     * @param throwable
     */
    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
        // todo log something and warp to some exception...
        Request request = call.request();
        String method = request.method();
        Headers headers = request.headers();
        HttpUrl url = request.url();

        log.warn("Http error: {}", throwable.getMessage());

        completeExceptionally(throwable);
    }
}
