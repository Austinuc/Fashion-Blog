package com.week9.week_nine_sq012austinuc.repository;

import com.week9.week_nine_sq012austinuc.models.Post;
import com.week9.week_nine_sq012austinuc.models.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {

    List<PostComment> findAllByPost(Post post);
}
