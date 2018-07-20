package com.example.bananaking.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by jerry on 2018/7/20.
 *
 * @author jerry
 */
@Data
@Entity
@Table(name = "pages")
public class Page {

    /** page_id */
    @Id
    private String id;

    /** page name */
    @Column(name = "name")
    private String name;

    /** page cover picture */
    @Column(name = "cover")
    private String cover;

    /** description */
    @Column(name = "description")
    private String description;

    /** fans count */
    @Column(name = "fan_count", columnDefinition = "int default 0")
    private int fanCount = 0;

    @Column(name = "is_messenger_platform_bot", columnDefinition = "boolean default 0")
    private boolean isMessengerPlatformBot = false;

    @Column(name = "is_webhooks_subscribed", columnDefinition = "boolean default 0")
    private boolean isWebhooksSubscribed = false;

    @Column(name = "link")
    private String link;

    @Column(name = "new_like_count", columnDefinition = "int default 0")
    private int newLikeCount;

    @Column(name = "rating_count", columnDefinition = "int default 0")
    private int ratingCount;

    @Column(name = "talking_about_count", columnDefinition = "int default 0")
    private int talkingAboutCount;

    @Column(name = "unread_message_count", columnDefinition = "int default 0")
    private int unreadMessageCount;

    @Column(name = "unread_notif_count", columnDefinition = "int default 0")
    private int unreadNotifCount;

    @Column(name = "website")
    private String website;

}
