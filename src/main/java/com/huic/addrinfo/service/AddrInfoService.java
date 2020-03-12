package com.huic.addrinfo.service;

import java.util.List;

import com.huic.addrinfo.entity.AddrInfo;
import com.huic.base.service.BaseService;

public interface AddrInfoService extends  BaseService<AddrInfo>{
	
	List<AddrInfo> selectAddrByUserId(int userId);
	
	//改变地址状态
	int updateAddrStatus(int addrId);
	
	int deleteAddrInfo(int addrId,int userId);
	
	int selectAddrByDefaltstatus(int addrStatus,int userId);
}
