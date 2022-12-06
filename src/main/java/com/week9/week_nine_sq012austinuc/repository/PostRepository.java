package com.week9.week_nine_sq012austinuc.repository;

import com.week9.week_nine_sq012austinuc.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findByTitle(String string);

}
