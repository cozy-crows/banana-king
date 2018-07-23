package com.example.bananaking.entity;

import com.example.bananaking.mananger.dto.ReactionType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Created by jerry on 2018/7/23.
 *
 * @author jerry
 */

@Entity(name = "reaction_user")
@Table(
    name = "reaction_user",
    uniqueConstraints = @UniqueConstraint(columnNames = {"id", "post_id"}))
public class ReactionUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Id
    private String id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "link")
    private String link;

    @Getter
    @Setter
    @Column(name = "pic")
    private String picLarge;

    @Getter
    @Setter
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ReactionType type;


    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    private Post post;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "-" + this.getId();
    }

}
