package com.example.bananaking.mananger.dto.fanspage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import lombok.Value;

/**
 * Created by jerry on 2018/7/22.
 *
 * @author jerry
 */
@Value
@ToString
public class UserDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;
}
