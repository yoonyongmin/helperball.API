package com.oknym.helperball.service.auth;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oknym.helperball.model.session.AuthSession;

@Repository
public interface AuthSessionRepository extends JpaRepository<AuthSession, Long> {

	@Query("SELECT a from AuthSession a WHERE a.userId = :userId and a.status = 'Enabled'")
	List<AuthSession> findByActiveSession(String userId);

}
