package com.huic.backgoodsdetail.service;

import java.util.List;

import com.huic.backgoods.entity.BackgoodsPage;
import com.huic.backgoodsdetail.entity.Backgoodsdetail;
import com.huic.base.service.BaseService;

public interface Backgoodsdetailservice extends BaseService<Backgoodsdetail>{

	List<Backgoodsdetail> selectByGid(BackgoodsPage backgoodsPage);
	
}
