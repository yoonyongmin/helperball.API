package com.oknym.helperball.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oknym.helperball.service.HelperballService;

import io.swagger.annotations.ApiOperation;

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

}
