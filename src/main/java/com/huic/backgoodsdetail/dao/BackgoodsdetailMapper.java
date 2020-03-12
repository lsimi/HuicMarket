package com.huic.backgoodsdetail.dao;

import java.util.List;

import com.huic.annotation.Myannotation;
import com.huic.backgoods.entity.BackgoodsPage;
import com.huic.backgoodsdetail.entity.Backgoodsdetail;
import com.huic.base.dao.BaseMapper;

@Myannotation
public interface BackgoodsdetailMapper extends BaseMapper<Backgoodsdetail>{

	List<Backgoodsdetail> selectByGid(BackgoodsPage backgoodsPage);
	
}