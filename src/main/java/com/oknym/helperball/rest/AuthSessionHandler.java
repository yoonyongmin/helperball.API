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
			
			AuthSessionService authSessionService = getAuthSessionService();
			List<AuthSession> 
			
			System.out.println(user);
			HttpHeaders headers = new HttpHeaders();
			
			if (user != null) {
				
				String userAccessKey = UUID.randomUUID().toString();
				String userSecretKey = UUID.randomUUID().toString();
				
				headers.add(HeaderAccessKey, userAccessKey);
				headers.add(HeaderSecretKey, userSecretKey);
				return ResponseEntity.created(null).headers(headers).body(user);
			} else {
				AuthSession session = userAccessList.get(0);
				
				headers.add(HeaderAccessKey, session.getUserAccess());
				headers.add(HeaderSecretKey, session.getUserSecret());
				
				return ResponseEntity.status(HttpStatus.OK).headers(headers).body(user);
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
