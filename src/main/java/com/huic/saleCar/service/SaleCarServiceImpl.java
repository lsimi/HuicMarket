package com.huic.saleCar.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huic.base.service.AbstractServiceImpl;
import com.huic.saleCar.dao.SaleCarMapper;
import com.huic.saleCar.entity.SaleCar;
@Service
public class SaleCarServiceImpl extends AbstractServiceImpl<SaleCar> implements SaleCarService{
	
	@Autowired
	SaleCarMapper saleCarMapper;
	
	@Override
	public PageInfo<SaleCar> selectSaleCarInfo(int pageNum, int pageSize,int userId) {
		PageHelper.startPage(pageNum, pageSize);
		List<SaleCar> list = saleCarMapper.selectSaleCarInfo(userId);
		return new PageInfo<SaleCar>(list);
	}

	@Override
	public int insertBacth(List<SaleCar> list) {
		return saleCarMapper.insertBacth(list);
	}

	

	@Override
	public int updateSalNum(int carId, int salNum) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("carId", carId);
		map.put("salNum", salNum);
		return saleCarMapper.updateSalNum(map);
	}

	@Override
	public int deleteBacth(int userId, int[] carIds) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("carIds", carIds);
		map.put("userId", userId);
		return saleCarMapper.deleteBacth(map);
	}

	@Override
	public List<SaleCar> selectSaleCarInfoByCarId(int[] carIds, int userId) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("carIds", carIds);
		map.put("userId",userId);
		return  saleCarMapper.selectSaleCarInfoByCarId(map);
	}

	
	
	
}
