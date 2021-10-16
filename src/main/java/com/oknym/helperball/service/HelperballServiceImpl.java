package com.oknym.helperball.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oknym.helperball.model.Stat;
import com.oknym.helperball.model.User;

@Service
@Transactional
public class HelperballServiceImpl implements HelperballService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	StatRepository statRepository;
	
	
	@Override
	public List<User> selectUser() {
		return (List<User>) userRepository.findAll();
	}
	
	@Override
	public List<Stat> selectStat() {
		return (List<Stat>) statRepository.findAll();
	}
	
}
