package com.example.bananaking.service.transform;

import com.example.bananaking.entity.Post;
import com.example.bananaking.entity.ReactionUser;
import com.example.bananaking.mananger.dto.ReactionType;
import com.example.bananaking.mananger.dto.fanspage.ReactionDTO;

/**
 * Created by jerry on 2018/7/23.
 *
 * @author jerry
 */
public class ReactionTransformer {

    private ReactionTransformer() {}

    public static ReactionUser toEntity(Post post, ReactionDTO dto) {
        ReactionUser user = new ReactionUser();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setType(ReactionType.valueOf(dto.getType()));
        user.setLink(dto.getLink());
        user.setPicLarge(dto.getPicLarge());
        user.setPost(post);
        return user;
    }
}
