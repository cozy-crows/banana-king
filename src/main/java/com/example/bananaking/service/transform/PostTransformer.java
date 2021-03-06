package com.example.bananaking.service.transform;

import com.example.bananaking.entity.Page;
import com.example.bananaking.entity.Post;
import com.example.bananaking.mananger.dto.fanspage.PostDTO;

import java.util.Objects;

/**
 * Created by jerry on 2018/7/22.
 *
 * @author jerry
 */
public class PostTransformer {

    private PostTransformer() {
    }

    public static Post toEntity(Page page, PostDTO dto) {
        Post post = new Post();
        post.setId(dto.getId());
        post.setMessage(dto.getMessage());
        post.setLink(dto.getLink());
        post.setObjectId(dto.getObjectId());
        post.setCreatedTime(dto.getCreatedTime().toLocalDateTime());
        post.setFullPicture(dto.getFullPicture());
        post.setFrom(UserTransformer.toEntity(dto.getFrom()));
        if (Objects.nonNull(dto.getShares())) {
            post.setShares(dto.getShares().getCount());
        }
        post.setPage(page);
        return post;
    }

}
