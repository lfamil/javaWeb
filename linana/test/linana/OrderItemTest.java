package linana;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.neusoft.dao.OrderItemDao;
import com.neusoft.daoImp.OrderItemDaoImpl;
import com.neusoft.entity.OrderItem;

public class OrderItemTest {
@Test
public void testaddBatch() {
	OrderItemDao dao=new OrderItemDaoImpl();
	List<OrderItem> list=new ArrayList<OrderItem>();
	for(int i=0;i<3;i++) {
		list.add(new OrderItem(i));
	}
	dao.addBatch(list);
}
}
