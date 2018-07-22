package com.example.bananaking.repository;

import com.example.bananaking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jerry on 2018/7/22.
 *
 * @author jerry
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
