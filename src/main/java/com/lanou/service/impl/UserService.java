package com.lanou.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanou.bean.TbAddress;
import com.lanou.bean.TbDetails;
import com.lanou.bean.TbProduct;
import com.lanou.bean.TbProductmessage;
import com.lanou.bean.TbUser;
import com.lanou.bean.TbUsermessage;
import com.lanou.mapper.TbAddressMapper;
import com.lanou.mapper.TbDetailsMapper;
import com.lanou.mapper.TbProductMapper;
import com.lanou.mapper.TbProductmessageMapper;
import com.lanou.mapper.TbUserMapper;
import com.lanou.mapper.TbUsermessageMapper;
import com.lanou.service.IUserService;

@Service
public class UserService implements IUserService {

	@Resource
	private TbUserMapper usersMapper;
	@Resource
	private TbProductMapper productMapper;
	@Resource
	private TbAddressMapper addressMapper;
	@Resource
	private TbProductmessageMapper productmessageMapper;
	@Resource
	private TbDetailsMapper detailsMapper;
	@Resource
	private TbUsermessageMapper usermessageMapper;

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

	public Map<String, Object> userRegister(TbUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		TbUser user1 = usersMapper.selectOne(user);
		if (user1 != null) {
			result.put("result", 0);
		} else {
			int i = usersMapper.insert(user);
			if (i == 1) {
				result.put("result", 1);
			}
		}
		return result;
	}

	public Map<String, Object> tb_userMessage(TbUsermessage usermessage, TbUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		TbUser user2 = usersMapper.selectId(user);
		TbUsermessage usermessage2 = usermessageMapper.selectone(user2.getId());
		if (usermessage2 != null) {
			int i = usermessageMapper.updateByPrimaryKeySelective(usermessage);
			if (i == 1) {
				result.put("result", 1);
			} else {
				result.put("result", 0);
			}
		} else {
			int i = usermessageMapper.insertSelective(usermessage);
			if (i == 1) {
				result.put("result", 1);
			} else {
				result.put("result", 0);
			}
		}

		return result;
	}

	public Map<String, Object> add_data(TbProduct product, TbProductmessage productmessage) {
		Map<String, Object> result = new HashMap<String, Object>();
		TbProduct product2 = productMapper.selectOne(product);
		if (product2 != null) {
			result.put("result", -2);
		} else {
			int i = productMapper.insert(product);
			int k = productmessageMapper.insert(productmessage);
			if (i == 1 && k == 1) {
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

	public Map<String, Object> remove_data(Integer id) {
		Map<String, Object> result = new HashMap<String, Object>();
		TbProduct product = productMapper.selectByPrimaryKey(id);
		if (product != null) {
			int i = productMapper.deleteByPrimaryKey(id);
			if (i == 1) {
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

	public Map<String, Object> delete(Integer id) {
		Map<String, Object> result = new HashMap<String, Object>();
		int i = addressMapper.deleteByPrimaryKey(id);
		if (i == 1) {
			result.put("result", 1);
		} else {
			result.put("result", 0);
		}
		return result;
	}

	public boolean add_details(TbDetails details) {
		int i = detailsMapper.insert(details);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	public Map<String, Object> tb_userMessageselect(TbUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		TbUser user2 = usersMapper.selectId(user);
		if (user2 != null) {
			TbUsermessage usermessage2 = usermessageMapper.selectone(user.getId());
			result.put("result", 1);
			result.put("username", usermessage2.getUsername());
			result.put("signature", usermessage2.getSignature());
		} else {
			result.put("result", 0);
		}
		return null;
	}

}
