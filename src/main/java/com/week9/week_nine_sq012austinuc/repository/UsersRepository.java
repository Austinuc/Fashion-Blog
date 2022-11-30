package com.week9.week_nine_sq012austinuc.repository;

import com.week9.week_nine_sq012austinuc.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmailAndPassword(String email, String password);
    Optional<Users> findByUserIdAndRole(Long userId, String role);
}
