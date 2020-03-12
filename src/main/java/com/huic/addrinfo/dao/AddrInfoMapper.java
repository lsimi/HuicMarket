package com.huic.addrinfo.dao;

import java.util.HashMap;
import java.util.List;

import com.huic.addrinfo.entity.AddrInfo;
import com.huic.annotation.Myannotation;
import com.huic.base.dao.BaseMapper;

@Myannotation
public interface AddrInfoMapper extends BaseMapper<AddrInfo>{
   
	//根据用户id查出其所有收货地址
	List<AddrInfo> selectAddrByUserId(int userId);
	
	//因为只有一个默认地址，当要改变默认地址时，先全部设为非默认状为 1
	int updateStatusByOne();
	
	//再根据传进的addrId将地址设为默认地址  状态修改为0
	int updateStatusByZero(int addrId);
	
	int deleteAddrInfo(HashMap<String,Object> map);
	
	int selectAddrByDefaltstatus(HashMap<String,Object> map);
}