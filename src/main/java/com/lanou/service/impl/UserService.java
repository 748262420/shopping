package com.lanou.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.bean.TbClassify;
import com.lanou.bean.TbUser;
import com.lanou.bean.Users;
import com.lanou.mapper.TbClassifyMapper;
import com.lanou.mapper.UsersMapper;
import com.lanou.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private TbClassifyMapper tbClassifyMapper;

	public List<TbClassify> findClassPictur() {

		List<TbClassify> tbclass = tbClassifyMapper.findClassInformation();
		System.out.println("=========" + tbclass);

		return tbclass;
	}

	public Map<String, Object> insertClassPicture(TbClassify tbclassify) {
		Map<String, Object> mapAdd = new HashMap<String, Object>();

		tbClassifyMapper.insert(tbclassify);
		System.out.println("============" + tbClassifyMapper.insert(tbclassify));

		if (tbClassifyMapper.insert(tbclassify) > 0) {
			mapAdd.put("reulst", 1);

		} else {
			mapAdd.put("reulst", 0);
		}
		return mapAdd;
	}

	public Map<String, Object> deleteClassPicture(int id) {
		Map<String, Object> map = new HashMap<String, Object>();

		tbClassifyMapper.deleteByPrimaryKey(id);

		System.out.println("======delete======" + tbClassifyMapper.deleteByPrimaryKey(id));
		if (tbClassifyMapper.deleteByPrimaryKey(id) == 0) {

			map.put("result", 1);

		} else {
			map.put("result", 0);
		}
		return map;
	}

	public Map<String, Object> modefyClassPicture(TbClassify tbclassfy) {

		Map<String, Object> map = new HashMap<String, Object>();

		tbClassifyMapper.updateByPrimaryKeySelective(tbclassfy);
		System.out.println("=======MM=======" + tbClassifyMapper.updateByPrimaryKeySelective(tbclassfy));

		return null;
	}

	public Map<String, Object> insertClassPicture(String name, String path) {

		TbClassify tb = new TbClassify();
		tb.setClassify(name);
		tb.setClassifyphoto(path);
		int num = tbClassifyMapper.insert(tb);
		System.out.println("==========num===" + num);
		Map<String, Object> map = new HashMap<String, Object>();
		if (num > 0) {

			map.put("result", 1);
			
			//http://192.168.20.173:8080/Shopping/uploads1/610315735.jpg
			map.put("result1", path);

		} else {
			map.put("result", -1);

		}

		return map;
	}

}
