package com.lanou.service;

import java.util.Map;

import com.lanou.bean.TbAddress;
import com.lanou.bean.TbProduct;
import com.lanou.bean.TbUser;

public interface IUserService {

	public Map<String, Object> userLogin(TbUser user);

	public Map<String, Object> add(TbProduct product);

	public Map<String, Object> modify_data(TbProduct product);

	public Map<String, Object> add(TbAddress address);

	public Map<String, Object> select(String phoneNumber);
}
