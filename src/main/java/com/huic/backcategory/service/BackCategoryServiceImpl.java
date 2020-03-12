package com.huic.backcategory.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huic.backcategory.dao.BackcategoryMapper;
import com.huic.backcategory.entity.Backcategory;
import com.huic.backstore.entity.Backstore;
import com.huic.base.service.AbstractServiceImpl;

@Service
public class BackCategoryServiceImpl extends AbstractServiceImpl<Backcategory> implements BackCategoryService{

	@Resource
	private BackcategoryMapper mapper;
	
	@Override
	public List<Backcategory> selectAllCateinStore(Backstore backstore) {
		
		return mapper.selectAllCateinStore(backstore);
	}

}
