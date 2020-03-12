package com.huic.collect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huic.base.service.AbstractServiceImpl;
import com.huic.collect.dao.CollectMapper;
import com.huic.collect.entity.Collect;

@Service
public class CollectServiceImpl extends AbstractServiceImpl<Collect>
implements CollectService{
	
	@Autowired
	CollectMapper collectMapper;
	
	@Override
	public Collect selectByCollect(Collect collect) {
		return collectMapper.selectByCollect(collect);
	}

}
