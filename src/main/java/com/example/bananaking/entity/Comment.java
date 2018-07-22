package com.example.bananaking.entity;

import lombok.Data;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by jerry on 2018/7/22.
 *
 * @author jerry
 */
@Data
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    private String id;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "comment_count")
    private int commentCount;

    @Column(name = "like_count")
    private int likeCount;

    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    /** 留言的 user */
    @OneToOne
    @JoinColumn(name = "user_id")
    private User from;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
