package com.lanou.service;

import java.util.List;
import java.util.Map;

import com.lanou.bean.TbClassify;
import com.lanou.bean.Users;

public interface IUserService {

	public List<TbClassify> findClassPictur();
	
	public Map<String, Object> insertClassPicture(TbClassify tbclassify);
	
	public Map<String, Object> deleteClassPicture(int id);
	
	public Map<String, Object> modefyClassPicture(TbClassify tbclassfy );
	
	public Map<String, Object> insertClassPicture(String name,String path);
	

}
