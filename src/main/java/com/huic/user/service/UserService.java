package com.huic.user.service;

import com.huic.base.service.BaseService;
import com.huic.user.entity.User;

public interface UserService extends BaseService<User>{
	User selectByEmail(String email);//根据邮箱查询用户
}
