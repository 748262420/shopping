package com.lanou.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.bean.Users;
import com.lanou.service.IUserService;

@Controller
public class MainController {

	@Resource
	private IUserService userservice;

	@RequestMapping("/userlogin")
	public String login() {
		return "index";
	}

	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> selectOne(Users user) {
		return userservice.userLogin(user);
	}

}
