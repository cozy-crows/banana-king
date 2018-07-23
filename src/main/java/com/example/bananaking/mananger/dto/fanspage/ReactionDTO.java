package com.example.bananaking.mananger.dto.fanspage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import lombok.Value;

import java.io.Serializable;

/**
 * Created by jerry on 2018/7/23.
 * id,name,pic_large,type,link,profile_type
 * @author jerry
 */
@Value
@ToString
public class ReactionDTO implements Serializable {

    @JsonProperty("id")
    private String id;

    private String name;

    private String picLarge;

    private String type;

    private String link;

}
