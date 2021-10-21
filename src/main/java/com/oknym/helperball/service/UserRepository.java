package com.oknym.helperball.service;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oknym.helperball.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByToken(String token);
	
}
