package com.oknym.helperball.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.oknym.helperball.model.Stat;
import com.oknym.helperball.model.User;
import com.oknym.helperball.request.UserRequest;

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
	
	@Override
	public List<User> selectUser() {
		return (List<User>) userRepository.findAll();
	}
	
	@Override
	public List<Stat> selectStat() {
		return (List<Stat>) statRepository.findAll();
	}
	
	@Override
	public void save(String userId, String name, String password) {		
		Stat stat = new Stat();
		User user = new User();

		user.setUserId(userId);
		user.setName(name);
		user.setPassword(password);
		
		stat.setUser(user);
		
		userRepository.save(user);
		statRepository.save(stat);
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
	public User authenticationUserId(String userId) {
		if (userRepository.findByUserId(userId) == null) {
			return null;
		} else {
			return userRepository.findByUserId(userId);
		}
	}
	
	@Override
	public User verifyUser(String userId, String password) {
		
		User user = userRepository.findByUserId(userId);
		
		if (user != null) {
			if (user.getPassword() != null) {
				if (user.getPassword().equals(password)) {
					
				}
			}
		}
		
		return user;
	}
	
	@Override
	public void sendMail(String email, String name, String certification) {
		System.out.println("??????????????????");
		System.out.println(email);
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo("dydals361@gmail.com", "dydalszhffk@naver.com", "yoonyongmin@aifrica.co.kr");
		message.setSubject("????????? ?????? ?????? ???????????????.");
		message.setText("????????? ????????? ???????????????! ??????????????? ???????????????");
		javaMailSender.send(message);
	}
	
	@Override
	public User saveInfo(UserRequest userRequest, String userId) {
		
		User user = userRepository.findByUserId(userId);
		user.setHeight(userRequest.getHeight());
		user.setWeight(userRequest.getWeight());
		user.setAge(userRequest.getAge());
		user.setFoot(userRequest.getFoot());
		user.setPosition(userRequest.getPosition());
		
		return user;
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
