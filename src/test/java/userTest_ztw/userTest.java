package userTest_ztw;

import javax.annotation.Resource;

import org.junit.Test;

import com.huic.user.dao.UserMapper;
import com.huic.user.entity.User;
import com.huic.user.utils.MailUitls;

import Base.ParentTest;

public class userTest extends ParentTest {

	@Resource
	UserMapper userMapper;
	
	@Test
	public void selectByEmail() {
		User user = userMapper.selectByEmail("123@qq.com");
		System.out.println(user);
	}
	
	@Test
	public void email() throws Exception {
		MailUitls uitls = new MailUitls();
		uitls.sendMail("619742786@qq.com","11111111111111");
	}
}
