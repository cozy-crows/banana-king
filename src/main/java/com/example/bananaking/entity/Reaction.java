package com.example.bananaking.entity;

import com.example.bananaking.mananger.dto.ReactionType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Created by jerry on 2018/7/23.
 *
 * @author jerry
 */

@Entity(name = "reaction")
@Table(name = "reaction", uniqueConstraints = @UniqueConstraint(columnNames = {"post_id", "id"}))
public class Reaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @EmbeddedId
    private PostReactionId id;

    @Setter
    @Getter
    @Column(name = "can_post", columnDefinition = "boolean default 0")
    private boolean canPost = false;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "user_name")
    private String userName;

    @Getter
    @Setter
    @Column(name = "profile_type")
    private String profileType;

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
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ReactionType type;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    private Post post;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "-" + this.getId();
    }

}
