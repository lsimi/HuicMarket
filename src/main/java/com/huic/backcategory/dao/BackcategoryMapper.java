package com.huic.backcategory.dao;

import java.util.List;

import com.huic.annotation.Myannotation;
import com.huic.backcategory.entity.Backcategory;
import com.huic.backstore.entity.Backstore;
import com.huic.base.dao.BaseMapper;

@Myannotation
public interface BackcategoryMapper extends BaseMapper<Backcategory>{

	List<Backcategory> selectAllCateinStore(Backstore backstore);
	
}