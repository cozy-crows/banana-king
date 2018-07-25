package com.example.bananaking.mananger.dto.fanspage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import lombok.Value;

import java.io.Serializable;

/**
 * Created by jerry on 2018/7/23.
 * "id","link","name","pic_large","profile_type","type","username"
 * @author jerry
 */
@Value
@ToString
public class ReactionDTO implements Serializable {

    @JsonProperty("id")
    private String id;

    @JsonProperty("link")
    private String link;

    @JsonProperty("name")
    private String name;

    @JsonProperty("pic_large")
    private String picLarge;

    @JsonProperty("profile_type")
    private String profileType;

    @JsonProperty("type")
    private String type;

    @JsonProperty("username")
    private String userName;

    @JsonProperty("can_post")
    private Boolean canPost;
}
