package com.oknym.helperball.rest;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oknym.helperball.model.User;
import com.oknym.helperball.model.session.AuthSession;
import com.oknym.helperball.model.session.SessionStatusType;
import com.oknym.helperball.service.HelperballService;
import com.oknym.helperball.service.auth.AuthSessionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

@RestController
@RequestMapping(value = "/hb/v1/auth")
public class AuthSessionHandler {
	
	public static final String HeaderLoginId = "LoginId";
	public static final String HeaderAccessKey = "AccessKey";
	public static final String HeaderSecretKey = "SecretKey";
	
	public static String getLoginIdInHeader(HttpServletRequest request) {
		String loginId = request.getHeader(HeaderLoginId);
		
		if(loginId != null) {
			return StringEscapeUtils.unescapeHtml4(loginId);
		}
		else {
			return null;
		}
	}
	
	public static String getAccessKeyInHeader(HttpServletRequest request) {
		String accessKey = request.getHeader(HeaderAccessKey);
		
		if(accessKey != null) {
			return StringEscapeUtils.unescapeHtml4(accessKey);
		}
		else {
			return null;
		}
	}
	
	public static String getSecretKeyInHeader(HttpServletRequest request) {
		String secretKey = request.getHeader(HeaderSecretKey);
		
		if(secretKey != null) {
			return StringEscapeUtils.unescapeHtml4(secretKey);
		}
		else {
			return null;
		}
	}
	
	private HelperballService helperballService;
	
	@Autowired
	public void setHelperService(HelperballService helperballService) {
		this.helperballService = helperballService;
	}
	
	public HelperballService getHelperballService() {
		return this.helperballService;
	}
	
	private AuthSessionService authSessionService;
	
	@Autowired
	public void setAuthSessionService(AuthSessionService authSessionService) {
		this.authSessionService = authSessionService;
	}
	
	public AuthSessionService getAuthSessionService() {
		return this.authSessionService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ApiOperation(value = "Login", notes = "Login")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "User already logged in", 
					response = User.class, 
					responseHeaders = {
							@ResponseHeader(name = HeaderAccessKey,
									description="User Access Key",
									responseContainer = "",
									response=String.class),
							@ResponseHeader(name = HeaderSecretKey, 
									description="User Secret Credential", 
									responseContainer = "",
									response=String.class)
			}),
			@ApiResponse(code = 201, message = "Login credential created", 
					response = User.class, 
					responseHeaders={
							@ResponseHeader(name = HeaderAccessKey, description="User Access Key", response=String.class),
							@ResponseHeader(name = HeaderSecretKey, description="User Secret Credential", response=String.class)
			}),
			@ApiResponse(code = 401, message = "Unauthorized", response = Boolean.class),
			@ApiResponse(code = 403, message = "User is forbidden", response = Boolean.class), 
			@ApiResponse(code = 404, message = "Can't find user", response = Boolean.class), 
	})
	public ResponseEntity<?> login(
			@ApiParam("userId") String userId,
			@ApiParam("password") String password,
			@RequestBody HashMap<String, String> userCredential,
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		System.out.println(userId);
		System.out.println(password);
		System.out.println(userCredential);
		
		if(userId == null) {
			userId = userCredential.get("userId");
		}
		if(password == null) {
			password = userCredential.get("password");
		}
		
		try {
			HelperballService helperballService = getHelperballService();
			User user = helperballService.verifyUser(userId, password);
			
			if (user != null) {
				if (user.getStatus().equals("Disabled")) {
					return ResponseEntity.status(HttpStatus.LOCKED).build();
				} else if (user.getStatus().equals("Deleted")) {
					return ResponseEntity.status(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS).build();
				} else {
					AuthSessionService authSessionService = getAuthSessionService();
					List<AuthSession> userAccessList = authSessionService.selectActiveSession(new AuthSession(user.getUserId()));
					
					HttpHeaders headers = new HttpHeaders();
					
					if (userAccessList == null || userAccessList.size() == 0) {
						String userAccessKey = UUID.randomUUID().toString();
						String userSecretKey = UUID.randomUUID().toString();
						
						headers.add(HeaderAccessKey, userAccessKey);
						headers.add(HeaderSecretKey, userSecretKey);
						headers.add("test", "test");
						
						AuthSession userAccess = new AuthSession(user.getUserId(), userAccessKey, userSecretKey, SessionStatusType.Enabled);
						authSessionService.create(userAccess);
						
						System.out.println(headers);
						System.out.println(headers.get("AccessKey"));
						System.out.println(headers.get(HeaderSecretKey));
						
						return ResponseEntity.created(null).headers(headers).body(user);
					} else {
						AuthSession session = userAccessList.get(0);
						
						headers.add(HeaderAccessKey, session.getUserAccess());
						headers.add(HeaderSecretKey, session.getUserSecret());
						
						return ResponseEntity.status(HttpStatus.OK).headers(headers).body(user);
					}
				}
			}
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
