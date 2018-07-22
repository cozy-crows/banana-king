package com.example.bananaking.service.transform;

import com.example.bananaking.entity.CommentUser;
import com.example.bananaking.mananger.dto.fanspage.UserDTO;

/**
 * Created by jerry on 2018/7/22.
 *
 * @author jerry
 */
public class UserTransformer {

    private UserTransformer() {}

    public static CommentUser toEntity(UserDTO dto) {
        CommentUser user = new CommentUser();
        user.setId(dto.getId());
        user.setName(dto.getName());
        return user;
    }
}
