package com.huic.goods.dao;

import java.util.List;

import com.huic.annotation.Myannotation;
import com.huic.base.dao.BaseMapper;
import com.huic.goods.entity.Goods;

@Myannotation
public interface GoodsMapper extends BaseMapper<Goods>{
	
	Goods selectGoodsByGoodsId(int gId);
}