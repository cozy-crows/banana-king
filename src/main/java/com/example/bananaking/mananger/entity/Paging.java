package com.example.bananaking.mananger.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by jerry on 2018/7/20.
 *
 * @author jerry
 */
@Data
class Paging {

    @JsonProperty("cursors")
    private Cursors cursors;
    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private String previous;

}
