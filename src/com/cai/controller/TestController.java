package com.cai.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cai.domain.User;
import com.cai.service.UserService;

@Controller
public class TestController {
	
	
	@Resource(name="userService")
	UserService userService;
	@RequestMapping(value="test")
	public String test(){
		DetachedCriteria dc=DetachedCriteria.forClass(User.class);
		int start=0;
		int pageSize=20;
		List<User> list = userService.getPageList(dc, start, pageSize);
		System.out.println(list);
		
		return "test";
	}
}
