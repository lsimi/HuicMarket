package com.huic.base.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T> {

    int deleteByPrimaryKey(Serializable s);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Serializable s);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    List<T> selectAll();
}
