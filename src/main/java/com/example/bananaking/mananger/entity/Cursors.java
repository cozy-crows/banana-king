package com.example.bananaking.mananger.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by jerry on 2018/7/20.
 *
 * @author jerry
 */
@Data
class Cursors {

    @JsonProperty("before")
    private String before;
    @JsonProperty("after")
    private String after;
}
