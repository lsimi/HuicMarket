package com.huic.backgoods.dao;

import java.util.List;

import com.huic.annotation.Myannotation;
import com.huic.backgoods.entity.Backgoods;
import com.huic.backgoods.entity.BackgoodsPage;
import com.huic.backstore.entity.Backstore;
import com.huic.base.dao.BaseMapper;

@Myannotation
public interface BackgoodsMapper extends BaseMapper<Backgoods>{

	List<Backgoods> selectAll(BackgoodsPage backgoodspage); 
	
	Integer updateGreat(Backgoods backgoods);
	
	Integer updateStatus(Backgoods backgoods);
	
	Integer deletegoods(Backgoods backgoods);
}