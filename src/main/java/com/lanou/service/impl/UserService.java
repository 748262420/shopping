package com.lanou.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanou.bean.TbAddress;
import com.lanou.bean.TbProduct;
import com.lanou.bean.TbUser;
import com.lanou.mapper.TbAddressMapper;
import com.lanou.mapper.TbProductMapper;
import com.lanou.mapper.TbUserMapper;
import com.lanou.service.IUserService;

@Service
public class UserService implements IUserService {

	@Resource
	private TbUserMapper usersMapper;
	@Resource
	private TbProductMapper productMapper;
	@Resource
	private TbAddressMapper addressMapper;

	public Map<String, Object> userLogin(TbUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		TbUser user1 = usersMapper.selectOne(user);
		if (user1 != null) {
			result.put("result", 1);
			result.put("phoneNumber", user.getPhoneNumber());
		} else {
			result.put("result", 0);
		}
		return result;
	}

	public Map<String, Object> add(TbProduct product) {
		Map<String, Object> result = new HashMap<String, Object>();
		TbProduct product2 = productMapper.selectOne(product);
		if (product2 != null) {
			result.put("result", -2);
		} else {
			int i = productMapper.insert(product);
			if (i == 1) {
				result.put("result", 1);
			} else {
				result.put("result", -1);
			}
		}
		return result;
	}

	public Map<String, Object> modify_data(TbProduct product) {
		Map<String, Object> result = new HashMap<String, Object>();
		TbProduct product2 = productMapper.selectByPrimaryKey(product.getId());
		if (product2 != null) {
			int ii = productMapper.updateByPrimaryKeySelective(product);
			if (ii == 1) {
				result.put("result", 1);
			} else {
				result.put("result", -1);
			}
		} else {
			result.put("result", -2);
		}
		return result;
	}

	public Map<String, Object> add(TbAddress address) {
		Map<String, Object> result = new HashMap<String, Object>();
		int i = addressMapper.insert(address);
		if (i == 1) {
			result.put("result", 1);
		} else {
			result.put("result", 0);
		}
		return result;
	}

	public Map<String, Object> select(String phoneNumber) {
		Map<String, Object> result = new HashMap<String, Object>();
		TbAddress address = addressMapper.selectdz(phoneNumber);
		if (address != null) {
			result.put("result", address.getPersonaddress());
		} else {
			result.put("result", 0);
		}
		return result;
	}

}
