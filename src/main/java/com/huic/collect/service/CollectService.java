package com.huic.collect.service;

import com.huic.base.service.BaseService;
import com.huic.collect.entity.Collect;

public interface CollectService extends BaseService<Collect>{
	 Collect selectByCollect(Collect collect);
}
