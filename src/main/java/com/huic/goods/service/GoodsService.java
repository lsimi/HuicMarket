package com.huic.goods.service;

import com.huic.base.service.BaseService;
import com.huic.goods.entity.Goods;
import com.huic.goods.entity.Goodsdetail;

public interface GoodsService extends BaseService<Goods>{
	Goods selectGoodsByGoodsId(int gId);
}
