package com.example.bananaking.mananger.dto.fanspage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import lombok.Value;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * Created by jerry on 2018/7/22.
 *
 * @author jerry
 */
@Value
@ToString
public class CommentDTO implements Serializable {

    @JsonProperty("id")
    private String id;

    @JsonProperty("created_time")
    private OffsetDateTime createdTime;

    @JsonProperty("message")
    private String message;

    @JsonProperty("comment_count")
    private Integer commentCount;

    @JsonProperty("like_count")
    private Integer likeCount;

    @JsonProperty("from")
    private UserDTO from;

}
