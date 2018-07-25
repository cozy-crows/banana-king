package com.example.bananaking.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by jerry on 2018/7/23.
 *
 * @author jerry
 */
@Data
@Table(name = "user")
@Entity(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    // todo only support one page
    @Id
    private String psid;

    @Column(name = "name")
    private String name;

    @Column(name = "asid")
    private String asid;


}
