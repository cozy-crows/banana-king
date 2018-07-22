package com.example.bananaking.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
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
@Entity(name = "comment")
@Table(name = "comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Id
    private String id;

    @Getter
    @Setter
    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Getter
    @Setter
    @Column(name = "comment_count")
    private int commentCount;

    @Getter
    @Setter
    @Column(name = "like_count")
    private int likeCount;

    @Getter
    @Setter
    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    /** 留言的 user */
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private CommentUser from;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "-" + this.getId();
    }
}
