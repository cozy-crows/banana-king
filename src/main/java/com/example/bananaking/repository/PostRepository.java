package com.example.bananaking.repository;

import com.example.bananaking.entity.Page;
import com.example.bananaking.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jerry on 2018/7/22.
 *
 * @author jerry
 */
@Repository
public interface PostRepository extends JpaRepository<Post, String> {

    List<Post> findByPageAndCreatedTimeBetween(Page page, LocalDateTime since, LocalDateTime until);
}
