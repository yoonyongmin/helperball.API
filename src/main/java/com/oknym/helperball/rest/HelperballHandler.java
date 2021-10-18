package com.oknym.helperball.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oknym.helperball.model.Position;
import com.oknym.helperball.model.User;
import com.oknym.helperball.request.InfoRequest;
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

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@ApiOperation(value = "Read Info List", notes = "Read Info List")
	public ResponseEntity<?> selectInfo() {
		HelperballService helperballService = getHelperballService();
		
		return ResponseEntity.ok(helperballService.selectInfo());
	}
	
	@RequestMapping(value = "/position", method = RequestMethod.GET)
	@ApiOperation(value = "Read Position List", notes = "Read Position List")
	public ResponseEntity<?> selectPosition() {
		HelperballService helperballService = getHelperballService();
		
		return ResponseEntity.ok(helperballService.selectPosition());
	}
	
	@RequestMapping(value = "/foot", method = RequestMethod.GET)
	@ApiOperation(value = "Read Foot List", notes = "Read Foot List")
	public ResponseEntity<?> selectFoot() {
		HelperballService helperballService = getHelperballService();
		
		return ResponseEntity.ok(helperballService.selectFoot());
	}
	
//	@RequestMapping(value = "/info", method = RequestMethod.POST)
//	@ApiOperation(value = "Create User", notes = "Create User")
//	public ResponseEntity<?> saveInfo(@ApiParam(name = "weight") int weight,
//										@ApiParam(name = "height") int height,
//										@ApiParam(name = "foot") String foot,
//										@ApiParam(name = "position") String position) {
//		System.out.println(weight);
//		System.out.println(height);
//		System.out.println(foot);
//		System.out.println(position);
//
//		
//		HelperballService helperballService = getHelperballService();
//		InfoRequest infoRequest = new InfoRequest();
//		infoRequest.setWeight(weight);
//		infoRequest.setHeight(height);
//		infoRequest.setFoot(foot);
//		infoRequest.setPosition(position);
//		
//		return ResponseEntity.ok(helperballService.saveInfo(infoRequest));
//	}
	
//	@RequestMapping(value = "/info", method = RequestMethod.PUT)
//	@ApiOperation(value = "Save User Info", notes = "Save User Info")
//	public ResponseEntity<?> updateInfo() {
//		HelperballService helperballService = getHelperballService();
//		
//		return ResponseEntity.ok(helperballService.updateInfo());
//	}
	
}
