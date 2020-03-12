package com.huic.saleCar.dao;

import java.util.HashMap;
import java.util.List;

import com.huic.annotation.Myannotation;
import com.huic.base.dao.BaseMapper;
import com.huic.saleCar.entity.SaleCar;
@Myannotation
public interface SaleCarMapper extends BaseMapper<SaleCar>{
	
	//查询购物车所有信息
	List<SaleCar> selectSaleCarInfo(int userId);
	
	//批量添加数据
	int insertBacth(List<SaleCar> list);
	
	//根据用户id批量删除，用于清空购物车
	int deleteBacth(HashMap<String,Object> map);
	
	//修改购物车商品数量或者属性值
	int updateSalNum(HashMap<String,Object> map);
	
	//根据购物车id查出里面的购物车项   ==》下单时候用  carIds==>int[] carIds  userId==> userId
	List<SaleCar> selectSaleCarInfoByCarId(HashMap<String,Object> map);
	
	//根据Id
}