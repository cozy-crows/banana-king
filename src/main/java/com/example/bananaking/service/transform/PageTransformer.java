package com.example.bananaking.service.transform;

import com.example.bananaking.entity.Page;
import com.example.bananaking.mananger.dto.fanspage.PageDTO;

/**
 * Created by jerry on 2018/7/20.
 * <p>
 * transform the dto to entity
 *
 * @author jerry
 */
public class PageTransformer {

    private PageTransformer() {
    }

    public static Page toEntity(PageDTO dto) {
        Page entity = new Page();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCover(null == dto.getCover() ? null : dto.getCover().getSource());
        entity.setDescription(dto.getDescription());
        entity.setFanCount(null == dto.getFanCount() ? 0 : dto.getFanCount());
        entity.setMessengerPlatformBot(null == dto.getMessengerPlatformBot() ? false : dto.getMessengerPlatformBot());
        entity.setWebhooksSubscribed(null == dto.getWebhooksSubscribed() ? false : dto.getWebhooksSubscribed());
        entity.setLink(dto.getLink());
        entity.setNewLikeCount(null == dto.getNewLikeCount() ? 0 : dto.getNewLikeCount());
        entity.setRatingCount(null == dto.getRatingCount() ? 0 : dto.getRatingCount());
        entity.setTalkingAboutCount(null == dto.getTalkingAboutCount() ? 0 : dto.getTalkingAboutCount());
        entity.setUnreadMessageCount(null == dto.getUnreadMessageCount() ? 0 : dto.getUnreadMessageCount());
        entity.setUnreadNotifCount(null == dto.getUnreadNotifCount() ? 0 : dto.getUnreadNotifCount());
        return entity;
    }
}
