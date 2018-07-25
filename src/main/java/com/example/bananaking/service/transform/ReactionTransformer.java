package com.example.bananaking.service.transform;

import com.example.bananaking.entity.Post;
import com.example.bananaking.entity.PostReactionId;
import com.example.bananaking.entity.Reaction;
import com.example.bananaking.mananger.dto.ReactionType;
import com.example.bananaking.mananger.dto.fanspage.ReactionDTO;

/**
 * Created by jerry on 2018/7/23.
 *
 * @author jerry
 */
public class ReactionTransformer {

    private ReactionTransformer() {}

    public static Reaction toEntity(Post post, ReactionDTO dto) {
        Reaction reaction = new Reaction();
        reaction.setId(new PostReactionId(dto.getId(), post.getId()));
        reaction.setName(dto.getName());
        reaction.setUserName(dto.getUserName());
        reaction.setLink(dto.getLink());
        reaction.setType(ReactionType.valueOf(dto.getType()));
        reaction.setPicLarge(dto.getPicLarge());
        reaction.setProfileType(dto.getProfileType());
        reaction.setCanPost(dto.getCanPost());
        reaction.setPost(post);

        return reaction;
    }
}
