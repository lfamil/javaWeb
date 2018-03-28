package linana;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.neusoft.dao.daologin;
import com.neusoft.daoImp.UserdaoBatisImpl;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.User;

public class UserTest {
	
	public void testcheckUserName() {
	 daologin userdao=new UserdaoBatisImpl();
	 int result=userdao.checkUserName("lisi");
	 System.out.println(result);
	 
	}
	@Test	
public void testfindUserByUsernameAndPassword() {
		 daologin userdao=new UserdaoBatisImpl();
		User user= userdao.findUserByUsernameAndPassword("linana", "123456");
	System.out.println(user);
	}
	

	public void testupdateTokenByUserId() {
		 daologin userdao=new UserdaoBatisImpl();
		int result=userdao.updateTokenByUserId(2,"123456");
		System.out.println(result);
	}

	public void testfindUserByToken() {
		daologin userdao=new UserdaoBatisImpl();
		User user=userdao.findUserByToken("123456");
		System.out.println(user);
	}
	


	public void testfindAllUser() {
		daologin userdao=new UserdaoBatisImpl();
		List<User> users=userdao.findAllUser();
		System.out.println(users);
	}

	public void testfindUserByPage() {
		daologin userdao=new UserdaoBatisImpl();
		PageModel<User> pagemodel=userdao.findUserByPage(1, 3);
		System.out.println(pagemodel);
	}
	
	public void testaddUser() {
		daologin userdao=new UserdaoBatisImpl();
		User user=new User();
		user.setUsername("admin");
		user.setPassword("3193");
		user.setAnswer("answer");
		int result=userdao.addUser(user);
		System.out.println(result);
	}
	
	public void testdeleteUserByid() {
		daologin userdao=new UserdaoBatisImpl();
    int result= userdao.deleteUserByid(13);
    System.out.println(result);
	}
	
	public void testfindUserbyid() {
		daologin userdao=new UserdaoBatisImpl();
		User user=userdao.findUserbyid(2);
		  System.out.println(user);
	}
	
	public void testupdateUser() {
		daologin userdao=new UserdaoBatisImpl();
		User user=new User();
		user.setId(11);
		user.setUsername("ani");
		user.setAnswer("aaaa");
		user.setPassword("83918");
		int result=userdao.updateUser(user);
		 System.out.println(result);
	}

	public void testaddBatchUser() {
		daologin userdao=new UserdaoBatisImpl();
		List<User> users=new ArrayList<User>();
		for(int i=0;i<10;i++) {
			users.add(new User("za"+i,"129923189"));
		}
		userdao.addBatchUser(users);
	}

	public void testfindUserByforeach() {
		daologin userdao=new UserdaoBatisImpl();
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		List<User> users=userdao.findUserByforeach(ids);
		System.out.println(users);
	}
}
