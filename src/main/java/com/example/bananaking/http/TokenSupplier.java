package com.example.bananaking.http;

import java.util.function.Supplier;

/**
 * Created by jerry on 2018/7/18.
 *
 * Token 介面, 單純方便區分, app token, page token, access token
 *
 * @author jerry
 */
@FunctionalInterface
public interface TokenSupplier extends Supplier<String> {
}
