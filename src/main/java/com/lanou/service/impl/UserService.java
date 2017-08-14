package com.lanou.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanou.bean.TbUser;
import com.lanou.mapper.TbUserMapper;
import com.lanou.service.IUserService;

@Service
public class UserService implements IUserService {

	@Resource
	private TbUserMapper usersMapper;

	public Map<String, Object> userLogin(TbUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		TbUser user1 = usersMapper.selectOne(user);
		if (user1 != null) {
			result.put("result", 1);
			result.put("phoneNumber", user.getPhonenumber());
		} else {
			result.put("result", 0);
		}
		return result;
	}

}
