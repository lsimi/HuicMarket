package com.huic.goods.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huic.base.service.AbstractServiceImpl;
import com.huic.goods.dao.GoodsMapper;
import com.huic.goods.entity.Goods;

@Service
public class GoodsServiceImpl extends AbstractServiceImpl<Goods> implements GoodsService{

	@Resource
	GoodsMapper goodsmapper;

	@Override
	public Goods selectGoodsByGoodsId(int gId) {
		
		return goodsmapper.selectGoodsByGoodsId(gId);
	}
	
}
