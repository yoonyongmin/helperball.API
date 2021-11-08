package com.oknym.helperball.service;

import java.util.List;

import com.oknym.helperball.model.Foot;
import com.oknym.helperball.model.Info;
import com.oknym.helperball.model.Position;
import com.oknym.helperball.model.Stat;
import com.oknym.helperball.model.User;

public interface HelperballService {

	List<User> selectUser();
	List<Stat> selectStat();
	List<Info> selectInfo();
	List<Position> selectPosition();
	List<Foot> selectFoot();
	
	void save(String userId, String name, String password);
	
	User oauthUserAuthentication(User user);
	User authenticationUserId(String id);
	
	void sendMail(String email, String name, String certification);

}
