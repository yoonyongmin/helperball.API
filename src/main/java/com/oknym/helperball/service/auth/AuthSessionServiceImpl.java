package com.oknym.helperball.service.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oknym.helperball.model.session.AuthSession;
import com.oknym.helperball.model.session.SessionStatusType;
import com.oknym.helperball.rest.AuthSessionHandler;

@Service
public class AuthSessionServiceImpl implements AuthSessionService {

	AuthSessionRepository authSessionRepository;
	@Autowired
	public void setRepository(AuthSessionRepository authSessionRepository) {
		this.authSessionRepository = authSessionRepository;
	}
	public AuthSessionRepository getRepository() {
		return this.authSessionRepository;
	}
	
	@Override
	public List<AuthSession> selectActiveSession(AuthSession authSession) {
		AuthSessionRepository authSessionRepository = getRepository();
		
		return authSessionRepository.findByActiveSession(authSession.getUserId());
	}
	
	@Override
	public AuthSession create(AuthSession userSession) {
		AuthSessionRepository authSessionRepository = getRepository();
		
		if (userSession != null) {
			if (userSession.getStatus() == SessionStatusType.Enabled) {
				try {
					Map<String, String> headers = new HashMap<String, String>();
					
					headers.put(AuthSessionHandler.HeaderLoginId, userSession.getUserId());
					headers.put(AuthSessionHandler.HeaderAccessKey, userSession.getUserAccess());
					headers.put(AuthSessionHandler.HeaderSecretKey, userSession.getUserSecret());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return authSessionRepository.save(userSession);
	}
	
}
