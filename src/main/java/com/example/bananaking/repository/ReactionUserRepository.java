package com.example.bananaking.repository;

import com.example.bananaking.entity.ReactionUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jerry on 2018/7/23.
 *
 * @author jerry
 */
@Repository
public interface ReactionUserRepository extends JpaRepository<ReactionUser, String> {
}
