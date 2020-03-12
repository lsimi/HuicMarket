package com.huic.addrinfo.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huic.addrinfo.dao.AddrInfoMapper;
import com.huic.addrinfo.entity.AddrInfo;
import com.huic.base.service.AbstractServiceImpl;

@Service
public class AddrInfoServiceImpl extends AbstractServiceImpl<AddrInfo>
implements AddrInfoService{
	
	@Resource
	AddrInfoMapper addrInfoMapper;
	
	@Override
	public List<AddrInfo> selectAddrByUserId(int userId) {
		return addrInfoMapper.selectAddrByUserId(userId);
	}
	
	/**
	 * 设置默认地址
	 */
	@Override
	public int updateAddrStatus(int userId) {
		
		//该默认地址之前先重置之前默认地址的状态，再设当前地址为默认地址
		int i = addrInfoMapper.updateStatusByOne();
		
		int j = addrInfoMapper.updateStatusByZero(userId);
		if(i>0 && j>0){
			return 1;
		}else{
			return 0;
		}
		
	}

	@Override
	public int deleteAddrInfo(int addrId, int userId) {
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("addrId", addrId);
		map.put("userId", userId);
		return addrInfoMapper.deleteAddrInfo(map);
	}

	@Override
	public int selectAddrByDefaltstatus(int addrStatus, int userId) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("addrStatus", addrStatus);
		map.put("userId", userId);
		return addrInfoMapper.selectAddrByDefaltstatus(map);
	}

}
