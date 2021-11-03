package com.oknym.helperball.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oknym.helperball.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	@Query("SELECT u FROM User u WHERE u.userId=:id")
	User findByUserId(String id);
	
}
