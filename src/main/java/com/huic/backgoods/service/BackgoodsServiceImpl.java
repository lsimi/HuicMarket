package com.huic.backgoods.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huic.backgoods.dao.BackgoodsMapper;
import com.huic.backgoods.entity.Backgoods;
import com.huic.backgoods.entity.BackgoodsPage;
import com.huic.backstore.entity.Backstore;
import com.huic.base.service.AbstractServiceImpl;
import com.huic.goods.entity.Goods;

@Service
public class BackgoodsServiceImpl extends AbstractServiceImpl<Backgoods> implements BackgoodsService{

	@Resource
	private BackgoodsMapper mapper;
	
	@Override
	public PageInfo<Backgoods> selectAll(BackgoodsPage backgoodspage,Integer pageNum,Integer pageSize) 
	{
		PageHelper.startPage(pageNum, pageSize);
		List<Backgoods> Backgoods = mapper.selectAll(backgoodspage);
		PageInfo<Backgoods> backgoods=new PageInfo<Backgoods>(Backgoods);
		return backgoods;
	}

	@Override
	public Integer updateGreat(Backgoods backgoods) {
		return mapper.updateGreat(backgoods);
	}

	@Override
	public Integer updateStatus(Backgoods backgoods) {
		return mapper.updateStatus(backgoods);
	}

	@Override
	public Integer deletegoods(Backgoods backgoods) {
		return mapper.deletegoods(backgoods);
	}

	
	
}
