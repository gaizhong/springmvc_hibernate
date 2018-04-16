package com.cai.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.cai.domain.User;

public interface UserService {
	public List<User> getPageList(DetachedCriteria dc, Integer start, Integer pageSize);
}
