package group.lsimi.test;

import java.awt.image.RasterOp;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.huic.addrinfo.dao.AddrInfoMapper;
import com.huic.addrinfo.service.AddrInfoService;
import com.huic.collect.entity.Collect;
import com.huic.collect.service.CollectService;
import com.huic.goods.dao.GoodsMapper;
import com.huic.goods.dao.GoodsdetailMapper;
import com.huic.goods.service.GoodsdetailService;
import com.huic.order.dao.OrderDetailMapper;
import com.huic.order.dao.OrderMapper;
import com.huic.order.entity.Order;
import com.huic.order.entity.OrderDetail;
import com.huic.saleCar.dao.SaleCarMapper;
import com.huic.saleCar.entity.SaleCar;
import com.huic.saleCar.service.SaleCarService;
import com.huic.store.dao.StoreMapper;
import com.huic.store.entity.Store;

import Base.ParentTest;

public class TestSaleCar extends ParentTest{
	
	@Autowired
	SaleCarMapper saleCarMapper;
	
	@Autowired
	GoodsdetailMapper goodsdetailMapper;
	
	@Resource
	GoodsdetailService goodsdetailService;
	
	@Resource
	CollectService collectService;
	
	@Resource
	AddrInfoMapper addrInfoMapper;
	
	@Resource
	AddrInfoService addrInfoService;
	
	@Resource
	SaleCarService saleCarService;
	
	@Resource
	StoreMapper storeMapper;
			
	@Resource
	OrderMapper orderMapper;
	
	@Resource
	OrderDetailMapper orderDetailMapper;
	
	@Resource
	GoodsMapper goodsMapper;
	
	@Test
	public void testSelectSaleCar(){
		//saleCarMapper.selectByPrimaryKey(1);
		saleCarMapper.selectAll();
	}
	@Test
	public void testGoodsDetail(){
		goodsdetailMapper.selectGoodsDetail();
	}
	
	@Test
	public void testSelectSaleCarInfo(){
		saleCarMapper.selectSaleCarInfo(1);
		//saleCarService.selectByPrimaryKey(1);
	}
	
	@Test
	public void testInsertBacth(){
		SaleCar saleCar = new SaleCar();
		saleCar.setGdId(1);
		saleCar.setSalNum(6);
		saleCar.setUserId(1);
		ArrayList<SaleCar> list = new ArrayList<SaleCar>();
		list.add(saleCar);
		saleCarMapper.insertBacth(list);
	}
	@Test
	public void testDeleteBacth(){
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
		int[] list={1,2};
		saleCarService.deleteBacth(1,list);
	}
	@Test
	public void testSelectByGdId(){
		//goodsdetailMapper.selectBysaleCar(1);
		goodsdetailService.selectByGdId(1);
	}
	
	@Test 
	public void testCollectService(){
		Collect collect = new Collect();
		collect.setUserId(23);
		collect.setgId(1);
		collectService.selectByCollect(collect);
	}
	
	@Test
	public void testselectAddrByUserId(){
		addrInfoMapper.selectAddrByUserId(1);
	}
	@Test
	public void testUpdateStatus(){
		addrInfoService.updateAddrStatus(1);
	}
	
	@Test
	public void testdeleteAddrInfo(){
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("addrStatus", 0);
		map.put("userId", 1);
		//addrInfoMapper.deleteAddrInfo(map);
		int i = addrInfoMapper.selectAddrByDefaltstatus(map);
		System.out.println(i);
	}
	
	@Test
	public void testStore(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		List<Store> list2 = storeMapper.selectStore(list);
		
	}
	
	@Test
	public void testsalecarBycarId(){
		int[] carIds={2,11};
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("carIds", carIds);
		map.put("userId", 1);
		saleCarMapper.selectSaleCarInfoByCarId(map);
	}
	
	@Test
	public void testInsertOrder(){
		Order order = new Order();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(new Date());
		Random ra = new Random();
		int raNum=ra.nextInt(10)+1;
		System.out.println(dateString+raNum);
		order.setAddrId(7);
		order.setUserId(1);
		order.setCreatetime(new Timestamp(System.currentTimeMillis()));
		order.setExpressId(1);
		order.setOrStatus(0);
		order.setOrSumprice(200.999);
		orderMapper.insertSelective(order);
		OrderDetail od = new OrderDetail();
		od.setGdId(1);
		od.setgNum(2);
		od.setOrId(order.getOrId());
		od.setTotalprice(16.25);
		orderDetailMapper.insertSelective(od);
		
	}
	
	@Test
	public void testInsertOrderDetail(){
		OrderDetail od = new OrderDetail();
		od.setGdId(1);
		od.setgNum(2);
		od.setOrId(8);
		od.setTotalprice(200.0);
		orderDetailMapper.insertSelective(od);
	}
	
	@Test
	public void testupdateStock(){
		goodsdetailService.updateStock(49, 1);
	}
	
	
	@Test
	public void testselectgoodbygoodid(){
		goodsMapper.selectGoodsByGoodsId(1);
	}
	
	
}
