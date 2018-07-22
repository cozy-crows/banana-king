package com.example.bananaking.service.transform;

import com.example.bananaking.entity.Comment;
import com.example.bananaking.entity.Post;
import com.example.bananaking.mananger.dto.fanspage.CommentDTO;

/**
 * Created by jerry on 2018/7/22.
 *
 * @author jerry
 */
public class CommentTransformer {

    private CommentTransformer() {}

    public static Comment toEntity(Post post, CommentDTO dto) {
        Comment comment = new Comment();
        comment.setId(dto.getId());
        comment.setMessage(dto.getMessage());
        comment.setCreatedTime(dto.getCreatedTime().toLocalDateTime());
        comment.setFrom(UserTransformer.toEntity(dto.getFrom()));
        comment.setLikeCount(dto.getLikeCount());
        comment.setCommentCount(dto.getCommentCount());
        comment.setPost(post);
        return comment;
    }
}
