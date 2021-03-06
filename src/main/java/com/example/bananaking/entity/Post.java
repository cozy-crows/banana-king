package com.example.bananaking.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by jerry on 2018/7/20.
 *
 * @author jerry
 */
@Entity(name = "post")
@Table(name = "post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Id
    private String id;

    @Getter
    @Setter
    @Column(name = "message", columnDefinition="Text")
    private String message;

    @Getter
    @Setter
    @Column(name = "link")
    private String link;

    @Getter
    @Setter
    @Column(name = "object_id")
    private String objectId;

    @Getter
    @Setter
    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Getter
    @Setter
    @Column(name = "full_picture", columnDefinition="Text")
    private String fullPicture;

    @Getter
    @Setter
    @Column(name = "shares", columnDefinition = "int default 0")
    private int shares = 0;

    @Getter
    @Setter
    @Column(name = "had_reactions", columnDefinition = "boolean default 0")
    private boolean hadReactions = false;

    @Getter
    @Setter
    @Column(name = "had_comments", columnDefinition = "boolean default 0")
    private boolean hadComments = false;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private User from;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "page_id")
    private Page page;

    @Getter
    @Setter
    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private List<Comment> comments;

    @Getter
    @Setter
    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "post_id")
    private List<Reaction> reactions;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "-" + this.getId();
    }
}
