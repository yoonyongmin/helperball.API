package com.oknym.helperball.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.oknym.helperball.model.Foot;
import com.oknym.helperball.model.Info;
import com.oknym.helperball.model.Position;
import com.oknym.helperball.model.Stat;
import com.oknym.helperball.model.User;

@Service
@Transactional
public class HelperballServiceImpl implements HelperballService {

	@Autowired
	private JavaMailSender javaMailSender;
	
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
	
	@Override
	public User userAuthentication(User user) {
		System.out.println(user.getUserId());
		System.out.println(user.getName());
		
		UserRepository userRepository = getUserRepository();
		User saveUser = new User();
		
		saveUser.setUserId(user.getUserId());
		saveUser.setName(user.getName());
		
		userRepository.save(saveUser);
		
		return saveUser;
	}
	
	@Override
	public void sendMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("dydals361@gamil.com");
		message.setSubject("세렝게티에서 사용할 임시 비밀번호 입니다.");
		message.setText("제발 보내죠");
		javaMailSender.send(message);
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
