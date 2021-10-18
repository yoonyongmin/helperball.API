package com.oknym.helperball.service;

import java.util.List;

import com.oknym.helperball.model.Foot;
import com.oknym.helperball.model.Info;
import com.oknym.helperball.model.Position;
import com.oknym.helperball.model.Stat;
import com.oknym.helperball.model.User;
import com.oknym.helperball.request.InfoRequest;

public interface HelperballService {

	List<User> selectUser();
	List<Stat> selectStat();
	List<Info> selectInfo();
	List<Position> selectPosition();
	List<Foot> selectFoot();
//	InfoRequest saveInfo(InfoRequest infoRequest);

}
