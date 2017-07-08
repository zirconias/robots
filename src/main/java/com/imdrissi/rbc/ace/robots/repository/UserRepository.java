package com.imdrissi.rbc.ace.robots.repository;

import com.imdrissi.rbc.ace.robots.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
}
