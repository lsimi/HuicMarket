package com.huic.backcategory.service;

import java.util.List;

import com.huic.backcategory.entity.Backcategory;
import com.huic.backstore.entity.Backstore;
import com.huic.base.service.BaseService;

public interface BackCategoryService extends BaseService<Backcategory>{

	List<Backcategory> selectAllCateinStore(Backstore backstore);
	
	
}
