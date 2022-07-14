package com.myblog.BlogRestApi.repository;

import com.myblog.BlogRestApi.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
