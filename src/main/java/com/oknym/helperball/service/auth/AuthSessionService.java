package com.oknym.helperball.service.auth;

import java.util.List;

import com.oknym.helperball.model.session.AuthSession;

public interface AuthSessionService {

	List<AuthSession> selectActiveSession(AuthSession userSession);
	AuthSession create(AuthSession userSession);
	
}
