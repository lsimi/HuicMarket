package group.jiege.test;

import java.io.IOException;
import java.io.Reader;

import javax.annotation.Resource;
import javax.xml.ws.soap.Addressing;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huic.goods.dao.GoodsMapper;
import com.huic.goods.entity.Goods;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-main.xml")
public class TestProject {

	@Resource
	private GoodsMapper mapper;
	
	@Test
	public void test1()
	{
		Goods goods = mapper.selectByPrimaryKey(1);
		System.out.println(goods);
	}
	
}
