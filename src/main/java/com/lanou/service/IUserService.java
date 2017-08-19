package com.lanou.service;

import java.util.Map;

import com.lanou.bean.TbAddress;
import com.lanou.bean.TbDetails;
import com.lanou.bean.TbProduct;
import com.lanou.bean.TbProductmessage;
import com.lanou.bean.TbUser;
import com.lanou.bean.TbUsermessage;

public interface IUserService {

	public Map<String, Object> userLogin(TbUser user);

	public Map<String, Object> userRegister(TbUser user);

	public Map<String, Object> tb_userMessage(TbUsermessage usermessage, TbUser user);

	public Map<String, Object> tb_userMessageselect(TbUser user);

	public Map<String, Object> add_data(TbProduct product, TbProductmessage productmessage);

	public boolean add_details(TbDetails details);

	public Map<String, Object> modify_data(TbProduct product);

	public Map<String, Object> remove_data(Integer id);

	public Map<String, Object> add(TbAddress address);

	public Map<String, Object> select(String phoneNumber);

	public Map<String, Object> delete(Integer id);
}
