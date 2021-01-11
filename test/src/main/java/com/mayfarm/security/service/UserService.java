package com.mayfarm.security.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.mayfarm.security.dao.UserDAO;
import com.mayfarm.security.vo.UserVO;

@Service
public class UserService {
	
	@Inject
	private UserDAO dao;
	
	public void register(UserVO vo) throws Exception {
		
		dao.register(vo);
	}
}
