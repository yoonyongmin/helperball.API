package com.oknym.helperball.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oknym.helperball.model.Foot;
import com.oknym.helperball.model.Info;
import com.oknym.helperball.model.Position;
import com.oknym.helperball.model.Stat;
import com.oknym.helperball.model.User;
import com.oknym.helperball.request.InfoRequest;

@Service
@Transactional
public class HelperballServiceImpl implements HelperballService {

	UserRepository userRepository;
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public UserRepository getUserRepository() {
		return this.userRepository;
	}
	
	StatRepository statRepository;
	@Autowired
	public void setStatRepository(StatRepository statRepository) {
		this.statRepository = statRepository;
	}
	public StatRepository getStatRepository() {
		return this.statRepository;
	}
	
	InfoRepository infoRepository;
	@Autowired
	public void setInfoRepository(InfoRepository infoRepository) {
		this.infoRepository = infoRepository;
	}
	public InfoRepository getInfoRepository() {
		return this.infoRepository;
	}
	
	PositionRepository positionRepository;
	@Autowired
	public void setPositonRepository(PositionRepository positionRepository) {
		this.positionRepository = positionRepository;
	}
	public PositionRepository getPositionRepository() {
		return this.positionRepository;
	}
	
	FootRepository footRepository;
	@Autowired
	public void setFootRepository(FootRepository footRepository) {
		this.footRepository = footRepository;
	}
	public FootRepository getFootRepository() {
		return this.footRepository;
	}
	
	@Override
	public List<User> selectUser() {
		return (List<User>) userRepository.findAll();
	}
	
	@Override
	public List<Stat> selectStat() {
		return (List<Stat>) statRepository.findAll();
	}

	@Override
	public List<Info> selectInfo() {
		return (List<Info>) infoRepository.findAll();
	}
	
	@Override
	public List<Position> selectPosition() {
		return (List<Position>) positionRepository.findAll();
	}
	
	@Override
	public List<Foot> selectFoot() {
		return (List<Foot>) footRepository.findAll();
	}
	
//	@Override
//	public InfoRequest saveInfo(InfoRequest infoRequest) {
//		InfoRepository infoRepository = getInfoRepository();	
//		UserRepository userRepository = getUserRepository();
//		
//		Optional<User> user = userRepository.findById((long) 1);
//		System.out.println(user);
//		Info info = new Info();
//		System.out.println(info);
//		info.setWeight(infoRequest.getWeight());
//		info.setHeight(infoRequest.getHeight());
//		info.setFoot(infoRequest.getFoot());
//
//		return null;
//	}
}
