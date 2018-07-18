package com.example.bananaking.http;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * Created by jerry on 2018/7/19.
 *
 * @author jerry
 */
@ToString
@AllArgsConstructor(staticName = "of")
public class AccessTokenSupplier implements TokenSupplier {

    private final String token;

    @Override
    public String get() {
        return this.token;
    }
}
