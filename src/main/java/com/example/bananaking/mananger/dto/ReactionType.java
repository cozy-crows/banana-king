package com.example.bananaking.mananger.dto;

/**
 * Created by jerry on 2018/7/23.
 * @see <a href="https://developers.facebook.com/docs/graph-api/reference/v3.0/object/reactions"> docs </a>
 *
 * @author jerry
 */
public enum ReactionType {
    LIKE("LIKE"),
    LOVE("LOVE"),
    WOW("WOW"),
    HAHA("HAHA"),
    SAD("SAD"),
    ANGRY("ANGRY"),
    THANKFUL("THANKFUL"),
    NONE("NONE");

    private String value;

    ReactionType(String value) {
        this.value = value;
    }
}
