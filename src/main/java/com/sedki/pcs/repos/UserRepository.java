package com.sedki.pcs.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sedki.pcs.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}