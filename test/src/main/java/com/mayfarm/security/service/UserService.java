package com.mayfarm.security.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mayfarm.security.dao.UserDAO;
import com.mayfarm.security.vo.UserVO;

@Service
public class UserService {
	
	@Inject
	private UserDAO dao;
	
	@Inject
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public void register(UserVO vo) throws Exception {
		
		String encodePassword = bcryptPasswordEncoder.encode(vo.getPasswd());
		vo.setPasswd(encodePassword);
		dao.register(vo);
	}
}
