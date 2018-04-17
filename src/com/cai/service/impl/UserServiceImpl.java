package com.cai.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cai.dao.UserDao;
import com.cai.domain.User;
import com.cai.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Resource(name="userDao")
	UserDao userDao;
	@Override
	public List<User> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		return userDao.getPageList(dc, start, pageSize);
	}
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}
	

}
