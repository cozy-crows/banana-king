package com.example.bananaking.entity;

import lombok.Data;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by jerry on 2018/7/22.
 *
 * @author jerry
 */
@Data
@Entity
@Table(name = "users")
public class User {

    /** psid */
    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private List<Comment> comments;
}
