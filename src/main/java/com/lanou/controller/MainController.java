package com.lanou.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.bean.TbClassify;
import com.lanou.bean.TbUser;
import com.lanou.bean.Users;
import com.lanou.service.IUserService;
import com.lanou.until.Until;
import com.mysql.jdbc.Util;

import sun.misc.BASE64Decoder;
import javax.servlet.http.HttpServletRequest;

/*import javax.servlet.http.HttpServletRequest;*/
@Controller
public class MainController {

	@Autowired
	private IUserService service;

	@RequestMapping(value = "/")
	public String test() {
		return "index";
	}

	@RequestMapping(value = "/classificationInterface")
	@ResponseBody
	public List<Map<String, Object>> displayClassInformation() {

		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("==========controoler==============");
		List<TbClassify> list1 = service.findClassPictur();
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < list1.size(); i++) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("id", list1.get(i).getId());
			result.put("classify", list1.get(i).getId());
			result.put("classifyphoto", list1.get(i).getClassifyphoto());

			list2.add(result);
		}
		return list2;
	}

	/*
	 * imgBase: x, imgFormat: y, className
	 */
	@RequestMapping(value = "/classificationOperation")
	@ResponseBody
	public Map<String, Object> modifyOrDeleteShoppingClass(@RequestParam("operationType") String typeParam,
			@RequestParam("classID") int id, TbClassify tbclassfy) {
		Map<String, Object> map = new HashMap<String, Object>();

		System.out.println("========controller=========" + typeParam);
		if (typeParam.equals("add")) {

			return service.insertClassPicture(tbclassfy);

		} else if (typeParam.equals("remove")) {

			return service.deleteClassPicture(id);
		}

		else if (typeParam.equals("modify")) {
			tbclassfy.setId(id);

			service.modefyClassPicture(tbclassfy);
			return service.modefyClassPicture(tbclassfy);
		} else {

			map.put("result", "²ÎÊýÓÐÎó");
			return map;
		}

	}

	@RequestMapping(value = "/upload")
	/*
	 * imgBase: x, imgFormat: y, className: $("#bm").val()
	 */
	@ResponseBody
	public Map<String, Object> UploadPhoto(HttpServletRequest request, @RequestParam("imgBase") String str,
			@RequestParam("imgFormat") String format, @RequestParam("className") String className) {
		String path2 = "C:\\Users\\lanou\\Desktop\\apache-tomcat-6.0.53\\wtpwebapps\\Shopping\\uploads1";
		if(!new File(path2).exists())   {
		    new File(path2).mkdirs();
		  }
		
		
		
		
		System.out.println("==========come  in====");

		Map<String, Object> map = new HashMap<String, Object>();
		String date64 = str;
		String formate = format;
		String name = className;
		Random random = new Random();
		int number = random.nextInt(999999999 - 100000000 + 1) + 100000000;

		String pathh = request.getSession().getServletContext().getRealPath("/uploads1");
		    
		
		System.out.println(pathh);
		String path = pathh +"\\"+number+ ".jpg";
		System.out.println("=========PATH===========" + path);
		Until until = new Until();
		String path1 = "http://192.168.20.173:8080/Shopping/uploads1/"+number+".jpg";
		if (until.GenerateImage(date64, path)) {

			return service.insertClassPicture(name, path1);

		} else {
			map.put("result", -1);

			return map;

		}

	}

}
