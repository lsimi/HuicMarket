package com.huic.collect.dao;

import com.huic.annotation.Myannotation;
import com.huic.base.dao.BaseMapper;
import com.huic.collect.entity.Collect;
@Myannotation
public interface CollectMapper extends BaseMapper<Collect>{
   Collect selectByCollect(Collect collect);
    
}