package com.example.bananaking.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by jerry on 2018/7/20.
 *
 * @author jerry
 */

@Entity(name = "page")
@Table(name = "page")
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Id
    private String id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "cover")
    private String cover;

    @Getter
    @Setter
    @Column(name = "description")
    private String description;

    @Getter
    @Setter
    @Column(name = "fan_count", columnDefinition = "int default 0")
    private int fanCount = 0;

    @Getter
    @Setter
    @Column(name = "is_messenger_platform_bot", columnDefinition = "boolean default 0")
    private boolean messengerPlatformBot = false;

    @Getter
    @Setter
    @Column(name = "is_webhooks_subscribed", columnDefinition = "boolean default 0")
    private boolean webhooksSubscribed = false;

    @Getter
    @Setter
    @Column(name = "link")
    private String link;

    @Getter
    @Setter
    @Column(name = "new_like_count", columnDefinition = "int default 0")
    private int newLikeCount;

    @Getter
    @Setter
    @Column(name = "rating_count", columnDefinition = "int default 0")
    private int ratingCount;

    @Getter
    @Setter
    @Column(name = "talking_about_count", columnDefinition = "int default 0")
    private int talkingAboutCount;

    @Getter
    @Setter
    @Column(name = "unread_message_count", columnDefinition = "int default 0")
    private int unreadMessageCount;

    @Getter
    @Setter
    @Column(name = "unread_notif_count", columnDefinition = "int default 0")
    private int unreadNotifCount;

    @Getter
    @Setter
    @Column(name = "website")
    private String website;

    @Getter
    @Setter
    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY)
    @JoinColumn(name = "page_id")
    private List<Post> posts;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "-" + this.getId();
    }
}
