package com.example.bananaking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by jerry on 2018/7/26.
 *
 * @author jerry
 */
@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PostReactionId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    private String reactionId;

    @Column(name = "post_id")
    private String postId;
}
