package com.example.bananaking.repository;


import com.example.bananaking.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jerry on 2018/7/20.
 *
 * @author jerry
 */
@Repository
public interface PageRepository extends JpaRepository<Page, String> {
    
}
