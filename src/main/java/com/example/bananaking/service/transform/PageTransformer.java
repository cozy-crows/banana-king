package com.example.bananaking.service.transform;

import com.example.bananaking.entity.Page;
import com.example.bananaking.mananger.dto.fanspage.PageDTO;

import java.util.Objects;

/**
 * Created by jerry on 2018/7/20.
 *
 * transform the dto to entity
 *
 * @author jerry
 */
public class PageTransformer {

    private PageTransformer(){}

    public static Page toEntity(PageDTO dto) {
        Page entity = new Page();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        if (Objects.nonNull(dto.getCover())) {
            entity.setCover(dto.getCover().getSource());
        }
        entity.setDescription(dto.getDescription());
        entity.setFanCount(dto.getFanCount());
        entity.setMessengerPlatformBot(dto.getMessengerPlatformBot());
        entity.setWebhooksSubscribed(dto.getWebhooksSubscribed());
        entity.setLink(dto.getLink());
        entity.setNewLikeCount(dto.getNewLikeCount());
        entity.setRatingCount(dto.getRatingCount());
        entity.setTalkingAboutCount(dto.getTalkingAboutCount());
        entity.setUnreadMessageCount(dto.getUnreadMessageCount());
        entity.setUnreadNotifCount(dto.getUnreadNotifCount());
        return entity;
    }
}
