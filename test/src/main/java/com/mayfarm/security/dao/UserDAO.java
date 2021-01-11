package com.mayfarm.security.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mayfarm.security.vo.UserVO;

	

@Repository
public class UserDAO {
	
	@Inject
	SqlSession sql;
	
	// 회원가입
	public void register(UserVO vo) throws Exception {
		sql.insert("userMapper.register", vo);
	}
}
