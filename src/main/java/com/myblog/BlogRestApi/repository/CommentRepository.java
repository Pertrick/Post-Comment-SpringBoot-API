package com.myblog.BlogRestApi.repository;

import com.myblog.BlogRestApi.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
