package com.example.bananaking.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by jerry on 2018/7/22.
 *
 * @author jerry
 */
@Data
@Entity(name = "comment_user")
@Table(name = "comment_user")
public class CommentUser {

    /** psid */
    @Id
    private String id;

    @Column(name = "name")
    private String name;


//    private List<Comment> comments;
}
