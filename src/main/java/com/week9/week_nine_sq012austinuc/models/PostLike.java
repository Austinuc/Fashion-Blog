package com.week9.week_nine_sq012austinuc.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long likeId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Long postId;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PostLike postLike = (PostLike) o;
        return likeId != null && Objects.equals(likeId, postLike.likeId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
