package com.example.bananaking.mananger.dto.fanspage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import lombok.Value;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * Created by jerry on 2018/7/20.
 *
 * @author jerry
 */
@Value
@ToString
public class PostDTO implements Serializable {

    /** post id */
    @JsonProperty("id")
    private String id;

    @JsonProperty("message")
    private String message;

    @JsonProperty("link")
    private String link;

    @JsonProperty("object_id")
    private String objectId;

    @JsonProperty("created_time")
    private OffsetDateTime createdTime;

    @JsonProperty("full_picture")
    private String fullPicture;

    @JsonProperty("shares")
    private Shares shares;


    @Value
    @ToString
    public static class Shares {

        @JsonProperty("count")
        private int count;
    }

}
