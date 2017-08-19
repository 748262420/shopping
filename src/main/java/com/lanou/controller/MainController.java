package com.lanou.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.bean.TbAddress;
import com.lanou.bean.TbDetails;
import com.lanou.bean.TbProduct;
import com.lanou.bean.TbProductmessage;
import com.lanou.bean.TbUser;
import com.lanou.bean.TbUsermessage;
import com.lanou.service.IUserService;
import com.lanou.util.Base64;

@Controller
public class MainController {

	@Resource
	private IUserService userservice;

	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> selectOne(TbUser user) {
		return userservice.userLogin(user);
	}

	@RequestMapping("/register")
	@ResponseBody
	public Map<String, Object> insertOne(TbUser user) {
		return userservice.userRegister(user);
	}

	@RequestMapping("/tb_userMessage")
	@ResponseBody
	public Map<String, Object> tb_userMessage(TbUsermessage usermessage, TbUser user) {
		return userservice.tb_userMessage(usermessage, user);
	}

	@RequestMapping("/add_data")
	@ResponseBody
	public Map<String, Object> add_data(@RequestParam("shopJson") List<Map<String, Object>> img, TbProduct product,
			TbProductmessage productmessage, List<TbDetails> details) {
		for (int i = 0; i < img.size(); i++) {
			String type = (String) img.get(i).get("type");
			String bg = img.get(i).get("base64").toString().substring(23);
			String path = new Base64().generateImage(bg, type);
			details.get(i).setProductid(product.getId());
			details.get(i).setPhotos(path);
			userservice.add_details(details.get(i));
		}
		return userservice.add_data(product, productmessage);
	}

	@RequestMapping(value = "/modify_data")
	@ResponseBody
	public Map<String, Object> modify_data(TbProduct product) {
		return userservice.modify_data(product);
	}

	@RequestMapping("/remove_data")
	@ResponseBody
	public Map<String, Object> remove_data(@RequestParam("removeID") Integer id) {
		return userservice.remove_data(id);
	}

	@RequestMapping("/person")
	@ResponseBody
	public Map<String, Object> person(TbAddress address, @RequestParam("addORselect") String addORselect,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("id") Integer id) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (addORselect.equals("add")) {
			result = userservice.add(address);
		} else if (addORselect.equals("select")) {
			result = userservice.select(phoneNumber);
		} else if (addORselect.equals("delete")) {
			result = userservice.delete(id);
		}
		return result;
	}
}
