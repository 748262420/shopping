package com.lanou.service;

import java.util.Map;

import com.lanou.bean.Users;

public interface IUserService {

	public Map<String, Object> userLogin(Users user);

}
