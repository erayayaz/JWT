package com.eray.jwt.security.repository;

import com.eray.jwt.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
