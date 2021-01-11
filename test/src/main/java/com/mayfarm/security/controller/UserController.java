package com.mayfarm.security.controller;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mayfarm.security.service.UserService;
import com.mayfarm.security.vo.UserVO;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	UserService service;
	
	@GetMapping("/users/login")
	public void loginPage(String error, String logout, Model model) {
		
		logger.info("로그인 페이지로 이동~");
		logger.info("err :" + error);
		logger.info("logout : " + logout);
		if(error != null) {
			model.addAttribute("error","로그인 실패");
		}
		if(logout != null) {
			model.addAttribute("logout", "로그아웃");
		}
	}
	
	@PostMapping("/users/login-processing")
	public void loginProcessing(String error) {
		logger.info("login-processing!");
		logger.info("err :" + error );
	}
	
	@GetMapping("/users/member") 
	public void doMember() { 
		logger.info("멤버로그인~"); 
	} 
	
	@GetMapping("/users/admin") 
	public void doAdmin() { 
    		logger.info("관리자로그인~"); 
	}
	// 회원가입 폼
	@RequestMapping(value= "/users/registerView", method = RequestMethod.GET)
	public void RegisterPage() throws Exception {
		logger.info("registerView");
	}
	
	// 회원가입 폼 작성
	@RequestMapping(value = "/users/register", method = RequestMethod.POST)
	public String Register(UserVO userVO) throws Exception {
		logger.info("register");
		
		service.register(userVO);
		return "/users/login";
		
	}

}
