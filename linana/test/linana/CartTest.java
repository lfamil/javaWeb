package linana;

import java.util.List;

import org.junit.Test;

import com.neusoft.dao.CartDao;
import com.neusoft.daoImp.CartDaoImpl;
import com.neusoft.entity.Cart;
import com.neusoft.entity.PageModel;

public class CartTest {
	
public void testaddProductIntoCartByUserIdAndProductId() {
	CartDao cartdao=CartDaoImpl.getInstance();
  int result=	cartdao.addProductIntoCartByUserIdAndProductId(2, 34, 4);
  System.out.println(result);
}

	public void testupdateCartByUserIdAndProductId() {
		CartDao cartdao=CartDaoImpl.getInstance();
		
cartdao.updateCartByUserIdAndProductId(2, 34, 16);
	}
	
public void testdeleteCartByProductId() {
	CartDao cartdao=CartDaoImpl.getInstance();
	cartdao.deleteCartByProductId(3,0);
}

	public void testfindCartByUserIdAndProductId() {
		CartDao cartdao=CartDaoImpl.getInstance();
		Cart cart=cartdao.findCartByUserIdAndProductId(2, 34);
		System.out.println(cart);
	}
	
public void testfindCartByPage() {
	CartDao cartdao=CartDaoImpl.getInstance();
	PageModel<Cart> pagemodel=cartdao.findCartByPage(2, 1, 1);
	System.out.println(pagemodel);
}
@Test
	public void testcheckedOrNotchecked() {
		CartDao cartdao=CartDaoImpl.getInstance();
		System.out.println(cartdao.checkedOrNotchecked(1, 2,null));
	}
	
public void testcheckedQuantity() {
		CartDao cartdao=CartDaoImpl.getInstance();
		System.out.println(cartdao.checkedQuantity(2));
}

public void testfindCartListByUserID() {
	CartDao cartdao=CartDaoImpl.getInstance();
	List<Cart> carts=cartdao.findCartListByUserID(2);
	System.out.println(carts);
}
}
