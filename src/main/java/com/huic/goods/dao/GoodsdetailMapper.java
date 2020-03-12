package com.huic.goods.dao;

import java.util.HashMap;
import java.util.List;

import com.huic.annotation.Myannotation;
import com.huic.base.dao.BaseMapper;
import com.huic.goods.entity.Goodsdetail;
@Myannotation
public interface GoodsdetailMapper extends BaseMapper<Goodsdetail>{
	
	//联合商品表、包装表，口味表，商品详细信息表==》四表嵌套查询，可以得出商品完整信息
	List<Goodsdetail> selectGoodsDetail();
	
	//根据gd_id关联查询taste表，pack表以及goods表
	 Goodsdetail selectBysaleCar(int gdId);
	 
	//根据gdId修改商品库存
	int updateStock(HashMap<String, Object> map);
	
}