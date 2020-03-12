package com.huic.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huic.base.service.AbstractServiceImpl;
import com.huic.user.dao.UserMapper;
import com.huic.user.entity.User;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService
{
	@Resource 
	private UserMapper mapper;

	@Override
	public User selectByEmail(String email) {
		return mapper.selectByEmail(email);
	}
	
}
