package com.huic.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huic.base.service.AbstractServiceImpl;
import com.huic.store.dao.StoreMapper;
import com.huic.store.entity.Store;

@Service
public class StoreServiceImpl extends AbstractServiceImpl<Store> implements StoreService{

	@Autowired
	StoreMapper storeMapper;
	
	@Override
	public List<Store> selectStore(List<Integer> list) {
		return storeMapper.selectStore(list);
	}

}
