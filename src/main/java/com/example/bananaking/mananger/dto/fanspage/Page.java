package com.example.bananaking.mananger.dto.fanspage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by jerry on 2018/7/19.
 * <p>
 * facebook page post dto
 *
 * @author jerry
 * @see <a href="https://developers.facebook.com/docs/graph-api/reference/page/"> docs </a>
 */
@Data
public class Page implements Serializable {

    @JsonProperty("id")
    private String id;

    @JsonProperty("about")
    private String about;

    @JsonProperty("category")
    private String category;

    /** fans page 首頁圖片 */
    @JsonProperty("cover")
    private Cover cover;

    @JsonProperty("description")
    private String description;

    @JsonProperty("description_html")
    private String descriptionHtml;

    /** 粉絲數 */
    @JsonProperty("fan_count")
    private int fanCount;

    /** 有無 bot */
    @JsonProperty("is_messenger_platform_bot")
    private boolean isMessengerPlatformBot;

    @JsonProperty("is_webhooks_subscribed")
    private boolean isWebhooksSubscribed;

    @JsonProperty("link")
    private String link;

    @JsonProperty("location")
    private Location location;

    @JsonProperty("name")
    private String name;

    /** 最近使用者對 page 按讚的數量 */
    @JsonProperty("new_like_count")
    private int newLikeCount;

    @JsonProperty("rating_count")
    private int ratingCount;

    @JsonProperty("talking_about_count")
    private int talkingAboutCount;

    @JsonProperty("unread_message_count")
    private int unreadMessageCount;

    @JsonProperty("unread_notif_count")
    private int unreadNotifCount;

    @JsonProperty("website")
    private String website;

    /** 到實體店面打卡人數 */
    @JsonProperty("were_here_count")
    private String wereHereCount;

    /** 有用 whatapp 連絡的人數 */
    @JsonProperty("whatsapp_number")
    private String whatsappNumber;

    static class Cover implements Serializable {

        @JsonProperty("source")
        private String source;
    }

    static class Location implements Serializable {

        @JsonProperty("city")
        private String city;
        @JsonProperty("country")
        private String country;
        @JsonProperty("zip")
        private String zip;
    }
}
