package com.week9.week_nine_sq012austinuc.repository;

import com.week9.week_nine_sq012austinuc.models.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

    boolean existsByEmailAndPostId(String email, Long postId);
    void deletePostLikeByEmailAndPostId(String email, Long postId);

    List<PostLike> findAllByPostId(Long postId);
}
