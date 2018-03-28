package linana;

import org.junit.Test;

import com.neusoft.dao.UserOrderDao;
import com.neusoft.daoImp.UserOrderDaoImpl;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.UserOrder;

public class OrderTest {

	public void testfindUserOrderByPage() {
	 UserOrderDao orderdao=new UserOrderDaoImpl();
	PageModel<UserOrder> pagemodel= orderdao.findUserOrderByPage(2, 1, 2);
	 System.out.println(pagemodel);
 }
	@Test
public void testfindUserOrderDetailByOrderNo() {
	 UserOrderDao orderdao=new UserOrderDaoImpl();
	UserOrder userorder= orderdao.findUserOrderDetailByOrderNo(1520779141472L);
	 System.out.println(userorder.getOrderitems().size());
	 System.out.println(userorder);
}
	 
 }

