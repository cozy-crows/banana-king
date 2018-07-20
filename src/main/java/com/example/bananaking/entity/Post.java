package com.example.bananaking.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by jerry on 2018/7/20.
 *
 * @author jerry
 */
@Data
@Entity
@Table(name="posts")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
}
