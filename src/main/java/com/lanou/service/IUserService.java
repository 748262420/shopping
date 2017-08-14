package com.lanou.service;

import java.util.Map;

import com.lanou.bean.TbUser;

public interface IUserService {

	public Map<String, Object> userLogin(TbUser user);

}
