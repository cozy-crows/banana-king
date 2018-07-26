package com.example.bananaking.service;

import com.example.bananaking.entity.Comment;
import com.example.bananaking.entity.User;
import com.example.bananaking.repository.CommentRepository;
import com.example.bananaking.service.dto.KingOfComment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    /**
     *
     * @return
     */
    public List<KingOfComment> top10CommentUsers() {

        List<Comment> comments = commentRepo.findAll();
        Map<User, Long> userComments = new LinkedHashMap<>();
        comments.stream()
            .collect(Collectors.groupingBy(
                Comment::getFrom,
                Collectors.counting()
            ))
            .entrySet()
            .stream()
            .sorted(Map.Entry.<User, Long>comparingByValue().reversed())
            .limit(10)
            .forEach(entry -> userComments.put(entry.getKey(), entry.getValue()));

        return userComments.entrySet()
            .parallelStream()
            .map(entry -> {
                String userId = entry.getKey().getAsid();
                String userName = entry.getKey().getName();
                Long commentCount = entry.getValue();
                return  new KingOfComment(userId, userName, commentCount);
            }).collect(Collectors.toList());
    }
}
