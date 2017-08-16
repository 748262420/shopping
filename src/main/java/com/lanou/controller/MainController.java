package com.lanou.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lanou.bean.TbAddress;
import com.lanou.bean.TbProduct;
import com.lanou.bean.TbUser;
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
	public Map<String, Object> selectOne(TbUser user) {
		return userservice.userLogin(user);
	}

	@RequestMapping(value = "/adddata", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add_data(MultipartFile file, HttpServletRequest request, TbProduct product)
			throws IOException {
		String path = request.getSession().getServletContext().getRealPath("/upload");
		String fileName = file.getOriginalFilename();
		File dir = new File(path, fileName);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		file.transferTo(dir);
		product.setProductphoto(request.getSession().getServletContext().getRealPath("upload") + path);

		return userservice.add(product);
	}

	@RequestMapping("/modify_data")
	@ResponseBody
	public Map<String, Object> modify_data(TbProduct product) {
		return userservice.modify_data(product);
	}

	@RequestMapping("/person")
	@ResponseBody
	public Map<String, Object> person(TbAddress address, @RequestParam("addORselect") String addORselect,
			@RequestParam("phoneNumber") String phoneNumber) {
		if (addORselect.equals("add")) {
			return userservice.add(address);
		} else if (addORselect.equals("select")) {
			return userservice.select(phoneNumber);
		}
		return null;
	}

}
