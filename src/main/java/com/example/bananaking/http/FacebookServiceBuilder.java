package com.example.bananaking.http;

import com.example.bananaking.http.interceptor.TokenInterceptor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by jerry on 2018/7/18.
 *
 * @author jerry
 */
@Slf4j
public class FacebookServiceBuilder {

    private static final long DEFAULT_CONNECT_TIMEOUT = 60_000;
    private static final long DEFAULT_READ_TIMEOUT = 60_000;
    private static final long DEFAULT_WRITE_TIMEOUT = 60_000;

    private String apiEndPoint;

    private List<Interceptor> interceptors;
    private OkHttpClient.Builder okHttpClientBuilder;
    private Retrofit.Builder retrofitBuilder;

    /**
     * constructor
     *
     * @param interceptors okhttp interceptors
     */
    private FacebookServiceBuilder(List<Interceptor> interceptors) {
        this.interceptors = interceptors;
    }

    /**
     * first step
     *
     * @param token
     * @return {@link FacebookServiceBuilder}
     */
    public static FacebookServiceBuilder create(TokenSupplier token) {
        return new FacebookServiceBuilder(defaultInterceptors(token));
    }

    /**
     * default http interceptors
     *
     * @param token
     * @return
     */
    private static List<Interceptor> defaultInterceptors(TokenSupplier token) {
        final HttpLoggingInterceptor loggingInterceptor =
            new HttpLoggingInterceptor(message -> log.info("{}", message));
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return Arrays.asList(
            TokenInterceptor.forTokenSupplier(token),
            loggingInterceptor);
    }

    /**
     * set base graph api url
     * e.g. https://graph.facebook.com/v3.0/
     *
     * @param baseUrl
     * @return string
     */
    public FacebookServiceBuilder apiEndpoint(String baseUrl) {
        this.apiEndPoint = baseUrl;
        return this;
    }

    /**
     * build facebook api interface for retrofit
     *
     * @param apiService
     * @param <T>
     * @return
     */
    public <T> T build(Class<T> apiService) {
        // okhttp
        this.okHttpClientBuilder = new OkHttpClient.Builder();
        this.okHttpClientBuilder
            .connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.MILLISECONDS);

        // interceptors
        this.interceptors.forEach(okHttpClientBuilder::addInterceptor);

        // okhttp finish
        final OkHttpClient httpClient = this.okHttpClientBuilder.build();

        // init retrofit
        this.retrofitBuilder = retrofitBuilder();

        // build facebook http client
        return this.retrofitBuilder
            .baseUrl(this.apiEndPoint)
            .client(httpClient)
            .build()
            .create(apiService);
    }

    /**
     * @see <a href="https://github.com/square/retrofit"> Retrofit docs</a>
     * @return {@link retrofit2.Retrofit.Builder}
     */
    private Retrofit.Builder retrofitBuilder() {
        // jackson converter
        final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(new ParameterNamesModule())
            .registerModule(new JavaTimeModule())
            .configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);

        return new Retrofit.Builder()
            .addConverterFactory(JacksonConverterFactory.create(objectMapper));
    }

    // todo
    private static String markToken(String logMsg) {
        return logMsg;
    }
}
