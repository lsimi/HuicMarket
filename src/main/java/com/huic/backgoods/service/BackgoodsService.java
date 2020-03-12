package com.huic.backgoods.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.huic.backgoods.entity.Backgoods;
import com.huic.backgoods.entity.BackgoodsPage;
import com.huic.backstore.entity.Backstore;
import com.huic.base.service.BaseService;
import com.huic.goods.entity.Goods;

public interface BackgoodsService extends BaseService<Backgoods>{
	
    PageInfo<Backgoods> selectAll(BackgoodsPage backgoodspage,Integer pageNum,Integer pageSize);
    
    Integer updateGreat(Backgoods backgoods);
    
    Integer updateStatus(Backgoods backgoods);
    
    Integer deletegoods(Backgoods backgoods);
}
