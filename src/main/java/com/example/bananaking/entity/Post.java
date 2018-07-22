package com.example.bananaking.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by jerry on 2018/7/20.
 *
 * @author jerry
 */
@Data
@Entity
@Table(name = "posts")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Column(name = "message", columnDefinition="Text")
    private String message;

    @Column(name = "link")
    private String link;

    @Column(name = "object_id")
    private String objectId;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "full_picture", columnDefinition="Text")
    private String fullPicture;

    @Column(name = "shares", columnDefinition = "int default 0")
    private int shares = 0;

    @Column(name = "had_reactions", columnDefinition = "boolean default 0")
    private boolean hadReactions = false;

    @Column(name = "had_comments", columnDefinition = "boolean default 0")
    private boolean hadComments = false;

    @ManyToOne
    @JoinColumn(name = "page_id")
    private Page page;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();
}
