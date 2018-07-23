package com.example.bananaking.entity;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by jerry on 2018/7/23.
 *
 * @author jerry
 */
@Embeddable
@AllArgsConstructor
public class ReactionUserId implements Serializable {

    private static final long serialVersionUID = 1L;


    private String id;


    @Column(name = "post_id")
    private String postId;
}
