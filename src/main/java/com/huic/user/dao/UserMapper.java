package com.huic.user.dao;

import com.huic.annotation.Myannotation;
import com.huic.base.dao.BaseMapper;
import com.huic.user.entity.User;

@Myannotation
public interface UserMapper extends BaseMapper<User>{
   
	User selectByEmail(String email);
}