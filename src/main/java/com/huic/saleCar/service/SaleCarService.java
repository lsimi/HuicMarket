package com.huic.saleCar.service;

import java.util.HashMap;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.huic.base.service.BaseService;
import com.huic.saleCar.entity.SaleCar;

public interface SaleCarService extends BaseService<SaleCar>{
		
	//查询购物车所有信息
	PageInfo<SaleCar> selectSaleCarInfo(int pageNum,int pageSize,int userId);
	
	//批量添加数据
	int insertBacth(List<SaleCar> list);
		
	//根据用户id批量删除，用于清空购物车
	int deleteBacth(int userId,int[] carIds);
		
	//修改购物车商品数量或者属性值
	int updateSalNum(int carId,int salNum);
	
	//根据购物车id查出里面的购物车项   ==》下单时候用  carIds==>int[] carIds  userId==> userId
	List<SaleCar> selectSaleCarInfoByCarId(int[] carIds,int userId);
}
