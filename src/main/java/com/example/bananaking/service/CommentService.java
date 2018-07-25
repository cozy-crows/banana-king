package com.example.bananaking.service;

import com.example.bananaking.entity.Page;
import com.example.bananaking.repository.CommentRepository;
import com.example.bananaking.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by jerry on 2018/7/26.
 *
 * 按讚王
 *
 * @author jerry
 */
@Service
@AllArgsConstructor
public class CommentService {

    private CommentRepository commentRepo;
    private UserRepository commentUserRepo;

    public List top10CommentUsers(Page page) {
        return Collections.EMPTY_LIST;
    }
}
