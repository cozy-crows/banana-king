package com.example.bananaking.repository;

import com.example.bananaking.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jerry on 2018/7/23.
 *
 * @author jerry
 */
@Repository
public interface ReactionRepository extends JpaRepository<Reaction, String> {
}
