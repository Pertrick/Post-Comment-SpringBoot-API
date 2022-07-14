package com.myblog.BlogRestApi.repository;

import com.myblog.BlogRestApi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
