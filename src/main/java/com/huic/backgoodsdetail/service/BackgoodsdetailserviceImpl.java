package com.huic.backgoodsdetail.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huic.backgoods.entity.BackgoodsPage;
import com.huic.backgoodsdetail.dao.BackgoodsdetailMapper;
import com.huic.backgoodsdetail.entity.Backgoodsdetail;
import com.huic.base.service.AbstractServiceImpl;

@Service
public class BackgoodsdetailserviceImpl extends AbstractServiceImpl<Backgoodsdetail> implements Backgoodsdetailservice{

	@Resource
	private BackgoodsdetailMapper mapper;
	
	@Override
	public List<Backgoodsdetail> selectByGid(BackgoodsPage backgoodsPage) {
		return mapper.selectByGid(backgoodsPage);
	}

}
