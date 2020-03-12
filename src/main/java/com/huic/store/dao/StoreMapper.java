package com.huic.store.dao;

import java.util.List;

import com.huic.annotation.Myannotation;
import com.huic.base.dao.BaseMapper;
import com.huic.store.entity.Store;

@Myannotation
public interface StoreMapper extends BaseMapper<Store>{
	
	List<Store> selectStore(List<Integer> list);
}