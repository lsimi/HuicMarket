package com.huic.store.service;

import java.util.List;

import com.huic.base.service.BaseService;
import com.huic.store.entity.Store;

public interface StoreService extends BaseService<Store>{
	
	List<Store> selectStore(List<Integer> list);
}
