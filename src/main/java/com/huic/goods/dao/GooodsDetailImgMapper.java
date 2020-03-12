package com.huic.goods.dao;

import com.huic.goods.entity.GooodsDetailImg;

public interface GooodsDetailImgMapper {
    int deleteByPrimaryKey(Integer imgid);

    int insert(GooodsDetailImg record);

    int insertSelective(GooodsDetailImg record);

    GooodsDetailImg selectByPrimaryKey(Integer imgid);

    int updateByPrimaryKeySelective(GooodsDetailImg record);

    int updateByPrimaryKey(GooodsDetailImg record);
}