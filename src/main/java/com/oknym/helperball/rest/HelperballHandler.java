package com.oknym.helperball.rest;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oknym.helperball.model.User;
import com.oknym.helperball.request.UserRequest;
import com.oknym.helperball.service.HelperballService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/hb/v1")
public class HelperballHandler {
	
	private HelperballService helperballService;
	
	@Autowired
	public void setHelperService(HelperballService helperballService) {
		this.helperballService = helperballService;
	}
	
	public HelperballService getHelperballService() {
		return this.helperballService;
	}
	

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ApiOperation(value = "Read User List", notes = "Read User List")
	public ResponseEntity<?> selectUser() {
		HelperballService helperballService = getHelperballService();
		
		return ResponseEntity.ok(helperballService.selectUser());
	}

	@RequestMapping(value = "/stat", method = RequestMethod.GET)
	@ApiOperation(value = "Read Stat List", notes = "Read Stat List")
	public ResponseEntity<?> selectStat() {
		HelperballService helperballService = getHelperballService();
		
		return ResponseEntity.ok(helperballService.selectStat());
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ApiOperation(value = "Save User", notes = "Save User")
	public void saveUser(
			@ApiParam("userId") String userId,
			@ApiParam("name") @RequestParam(required = true) String name,
			@ApiParam("password") @RequestParam(required = true) String password) {
		HelperballService helperballService = getHelperballService();
		helperballService.save(userId, name, password);
	}
	
	@RequestMapping(value = "/user/authentication", method = RequestMethod.POST)
	@ApiOperation(value = "Save User", notes = "Save User")
	public ResponseEntity<?> doubleCheckUserId(@RequestParam(name = "id") String id) {
		HelperballService helperballService = getHelperballService();
		
		return ResponseEntity.ok(helperballService.authenticationUserId(id));
	}

	@RequestMapping(value = "/user/oauth", method = RequestMethod.POST)
	@ApiOperation(value = "Oauth User Authentication", notes = "Oauth User Authentication")
	public ResponseEntity<?> oauthUserAuthentication(@RequestBody User user) {
		HelperballService helperballService = getHelperballService();
		user = helperballService.oauthUserAuthentication(user);
		
		return ResponseEntity.ok(user);
	}
	
	@RequestMapping(value = "/mail", method = RequestMethod.POST)
	public void sendMail(
			@RequestParam(name = "email") String email,
			@RequestParam(name = "name") String name,
			@RequestParam(name = "certification") String certification) {
		helperballService.sendMail(email, name, certification);
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	@ApiOperation(value = "Create User", notes = "Create User")
	public ResponseEntity<?> saveInfo(
			@RequestBody UserRequest userRequest,
			@RequestParam(name = "userId") String userId) {
		HelperballService helperballService = getHelperballService();
		User user = helperballService.saveInfo(userRequest, userId);
		
		return ResponseEntity.ok(user);
	}
	
//	@RequestMapping(value = "/info", method = RequestMethod.PUT)
//	@ApiOperation(value = "Save User Info", notes = "Save User Info")
//	public ResponseEntity<?> updateInfo() {
//		HelperballService helperballService = getHelperballService();
//		
//		return ResponseEntity.ok(helperballService.updateInfo());
//	}
	
}
