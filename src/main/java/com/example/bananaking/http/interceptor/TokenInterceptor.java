package com.example.bananaking.http.interceptor;

import com.example.bananaking.http.TokenSupplier;
import lombok.AllArgsConstructor;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by jerry on 2018/7/18.
 *
 * 添加 access token
 *
 * @author jerry
 */
@AllArgsConstructor(staticName = "forTokenSupplier")
public class TokenInterceptor implements Interceptor {

    private final TokenSupplier tokenSupplier;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer " + tokenSupplier.get())
            .build();

        return chain.proceed(request);
    }
}
