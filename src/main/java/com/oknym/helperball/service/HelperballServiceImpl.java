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
	public void save(User user) {
		User usersave = new User();
		usersave.setUserId(user.getUserId());
		usersave.setName(user.getName());
		
		userRepository.save(usersave);
	}
	
	@Override
	public User oauthUserAuthentication(User user) {
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
	public User authenticationUserId(String id) {
		if (userRepository.findByUserId(id) == null) {
			return null;
		} else {
			return userRepository.findByUserId(id);
		}
	}
	
	@Override
	public void sendMail(String email, String name, String certification) {
		System.out.println("여기까진왔음");
		System.out.println(email);
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo("dydals361@gmail.com", "dydalszhffk@naver.com", "yoonyongmin@aifrica.co.kr");
		message.setSubject("헬퍼볼 인증 확인 메일입니다.");
		message.setText("헬퍼볼 가입을 환영합니다! 인증번호를 확인하세요");
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
