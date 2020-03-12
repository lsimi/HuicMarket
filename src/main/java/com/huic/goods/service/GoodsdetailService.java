package com.huic.goods.service;

import com.huic.base.service.BaseService;
import com.huic.goods.entity.Goodsdetail;

public interface GoodsdetailService extends BaseService<Goodsdetail>{
	
	Goodsdetail selectByGdId(int gdId);
	
	int updateStock(int stock,int gdId);
}
