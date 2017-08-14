package com.lanou.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanou.bean.Users;
import com.lanou.mapper.UsersMapper;
import com.lanou.service.IUserService;

@Service
public class UserService implements IUserService {

	@Resource
	private UsersMapper usersMapper;

	public Map<String, Object> userLogin(Users user) {
		Map<String, Object> result = new HashMap<String, Object>();
		Users user1 = usersMapper.selectOne(user);
		if (user1 != null) {
			result.put("result", 1);
			result.put("phoneNumber", user.getPhoneNumber());
		} else {
			result.put("result", 0);
		}
		return result;
	}

}
