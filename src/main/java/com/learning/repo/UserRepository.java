package com.learning.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	//custom jpa method
	boolean existsByEmail(String email);
	Optional<User> findByUsername(String username);
	boolean existsByUsername(String username);

}
