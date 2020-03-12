package com.huic.goods.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huic.base.service.AbstractServiceImpl;
import com.huic.goods.dao.GoodsdetailMapper;
import com.huic.goods.entity.Goodsdetail;

@Service
public class GoodsdetailServiceImpl extends AbstractServiceImpl<Goodsdetail> implements GoodsdetailService{
	
	@Resource
	GoodsdetailMapper goodsdetailMapper;
	
	@Override
	public Goodsdetail selectByGdId(int gdId) {
		return goodsdetailMapper.selectBysaleCar(gdId);
	}

	@Override
	public int updateStock(int stock, int gdId) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("stock", stock);
		map.put("gdId", gdId);
		return goodsdetailMapper.updateStock(map);
	}
	
}
