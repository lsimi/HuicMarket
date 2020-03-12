package com.huic.base.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.ws.soap.Addressing;
import org.springframework.beans.factory.annotation.Autowired;

import com.huic.base.dao.BaseMapper;

public class AbstractServiceImpl<T> implements BaseService<T>{

	@Autowired
	BaseMapper<T> mapper;
	
	@Override
	public int deleteByPrimaryKey(Serializable s) {
		
		return mapper.deleteByPrimaryKey(s);
	}

	@Override
	public int insert(T t) {
		return mapper.insert(t);
	}

	@Override
	public int insertSelective(T t) {
		return mapper.insertSelective(t);
	}

	@Override
	public T selectByPrimaryKey(Serializable s) {
		return mapper.selectByPrimaryKey(s);
	}

	@Override
	public int updateByPrimaryKeySelective(T t) {
		return mapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKey(T t) {
		return mapper.updateByPrimaryKey(t);
	}

	@Override
	public List<T> selectAll() {
		return mapper.selectAll();
	}

}
