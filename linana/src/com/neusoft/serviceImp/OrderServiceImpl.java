package com.neusoft.serviceImp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.consts.OrderStatusEnum;
import com.neusoft.dao.CartDao;
import com.neusoft.dao.OrderItemDao;
import com.neusoft.dao.Productdao;
import com.neusoft.dao.UserOrderDao;
import com.neusoft.daoImp.CartDaoImpl;
import com.neusoft.daoImp.OrderItemDaoImpl;
import com.neusoft.daoImp.ProductDaoBatisImpl;
import com.neusoft.daoImp.UserOrderDaoImpl;
import com.neusoft.entity.Cart;
import com.neusoft.entity.OrderItem;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.entity.UserOrder;
import com.neusoft.entity.vo.UserOrderVo;
import com.neusoft.exception.OrderException;
import com.neusoft.exception.OrderItemException;
import com.neusoft.service.IOrderService;

public class OrderServiceImpl implements IOrderService {
/**
 * ����ҵ���߼�������
 * */
private	CartDao cartdao=CartDaoImpl.getInstance();
private Productdao productdao=new ProductDaoBatisImpl();
private UserOrderDao orderdao=new UserOrderDaoImpl();
private OrderItemDao orderitemdao=new OrderItemDaoImpl();
@Override
public UserOrder createOrder(Integer user_id, HttpServletRequest request) throws OrderException {
	// TODO Auto-generated method stub
	//steps:��ȡ������ַ
	String shipping_id=request.getParameter("shipping_id");
	if(shipping_id==null||shipping_id.equals("")) {
		throw new OrderException("������ַ����");
	}
	Integer	_shipping_id=null;
	try {
		 _shipping_id=Integer.parseInt(shipping_id);	
	}catch(NumberFormatException e) {
		e.printStackTrace();
		throw new OrderException("��ַid���ݲ���ȷ");
	}
	//steps2:�ӹ��ﳵ��ȡ�û��µ�����Ʒ 
	List<Cart> carts=cartdao.findCartListByUserID(user_id);
	//steps3:��ȡ������ϸ
	List<OrderItem> orderitems=convertCartToOrderItems(user_id,carts);
	//steps4:���㶩���ܼ۸�
	BigDecimal totalPriceDecimal=getTotalPrice(orderitems);
	//steps5:��������
	UserOrder order=createOrdeer(user_id,_shipping_id,totalPriceDecimal,orderitems);
	if(order!=null) {//�����ɹ����뵽���ݿ�
		addOrderItemsIntoDB(order,orderitems);
	}
	//steps6:������Ʒ���
	for(OrderItem orderitem:orderitems) {
		productdao.reduceproductStock(orderitem.getProduct_id(), orderitem.getQuantity());
	}
	//steps7:��չ��ﳵ
	cartdao.deleteCheckedProductByUserid(user_id);
	
	return null;
}
  public List<OrderItem> convertCartToOrderItems(Integer user_id,List<Cart> carts){
	  List<OrderItem> list=new ArrayList<OrderItem>();
	  if(carts==null) {
			throw new OrderException("���ﳵ��û����Ʒ��ѡ��");
			
		}else {
			  
				for(Cart cart:carts) {
					
					
						OrderItem orderitem=new OrderItem();
						//����product_id��ȡ��Ʒ��Ϣ
						Product product=productdao.findProductbyId(cart.getProduct_id());
					
					if(product!=null) {
						orderitem.setProduct_id(cart.getProduct_id());
					
						orderitem.setCurrent_unit_price(product.getPrice());
						orderitem.setProduct_image(product.getMain_image());
						orderitem.setProduct_name(product.getName());	
						orderitem.setQuantity(cart.getQuantity());
						//������Ʒ�ܼ۸�
						//double _totalprice=(product.getPrice().doubleValue())*cart.getQuantity();
						BigDecimal _totalprice=new BigDecimal("0");
						_totalprice=orderitem.getCurrent_unit_price().multiply(new BigDecimal(cart.getQuantity()));
						orderitem.setTotal_price(_totalprice);
						orderitem.setUser_id(user_id);
						list.add(orderitem);
						
					}
				}	
		}
	  return list;

}
  /**
   * ��������
   * */
  private UserOrder createOrdeer(Integer user_id,Integer shipping_id,BigDecimal payment,List<OrderItem> orderitems) {
	if(orderitems==null) {
		throw new OrderException("���ﳵ������Ʒ��ѡ�У��޷����ɶ�����ϸ");
	}else {

		  UserOrder order=new UserOrder();
		 //user_id
		 order.setUser_id(user_id);
		  //������
		 order.setOrder_no(generateOrderNo());
		  //�ջ���ַ
		  order.setShipping_id(shipping_id);
		  //�����ܽ��
		  order.setPayment(payment);
		  order.setPayment_type(1);
		  order.setPostage(0);
		  //���ö���״̬
		  order.setStatus(OrderStatusEnum.UNPAY.getStatus());
		  //�������������ݿ�
		  
		  int row=orderdao.addOrder(order);
		  if(row>0) {
			  return order;   
		  }else {
			  throw new OrderException("��������ʧ�ܣ�����");
		  }
	}
	
  }
  
  /**
   * ���ɶ������
   * */
  private long generateOrderNo() {
	  return System.currentTimeMillis()+(int)(Math.random()*101);
  }
  /**
   * ���㶩���ܼ۸�
   * */
  
private BigDecimal getTotalPrice(List<OrderItem> orderitems) {
	if(orderitems==null) {
		throw new OrderException("���ﳵû����Ʒ��ѡ�У��޷����ɶ�����ϸ");
	} 
	BigDecimal bigdecimal=new BigDecimal("0");
	  for(OrderItem orderitem:orderitems) {
		  bigdecimal=bigdecimal.add(orderitem.getTotal_price());
	  }
	  return bigdecimal;
  }
private int addOrderItemsIntoDB(UserOrder order,List<OrderItem> orderitems) {
	//Ϊÿһ��������ϸ��Ӷ�����
	for(OrderItem orderitem:orderitems) {
		orderitem.setOrder_no(order.getOrder_no());
		System.out.println(orderitem);
		//�ж���Ʒ����Ƿ����
		long stock=productdao.getProductStock(orderitem.getProduct_id());
	if(stock<orderitem.getQuantity()) {
		throw new OrderItemException("��治�㣡����");
	}
	}
	//��������ϸ���뵽���ݿⷽ��
	return orderitemdao.addBatch(orderitems);
	
}
@Override
public PageModel<UserOrderVo> findUserOrderByPage(Integer user_id, HttpServletRequest request) throws OrderException {
	// TODO Auto-generated method stub
	String pageNo=request.getParameter("pageNo");
	String PageSize=request.getParameter("pageSize");
	int _pageNo=0;
	int _PageSize=0;
	if(pageNo==null||PageSize==null) {
		throw new OrderException("��ҳ��ѯ���������봫��pageNo��PageSize");
	}
	try {
		_pageNo=Integer.parseInt(pageNo);
		_PageSize=Integer.parseInt(PageSize);
	}catch(NumberFormatException e) {
		e.printStackTrace();
		throw new OrderException("����ת���쳣");
	}

	
	PageModel<UserOrder> pagemodel= orderdao.findUserOrderByPage(user_id, _pageNo, _PageSize);
	
	return convertToOrderVo(pagemodel);
	
}

/**
 * ��UserOrder-->UserOrderVo
 * */
private PageModel<UserOrderVo> convertToOrderVo(PageModel<UserOrder> pagemodel){
	PageModel<UserOrderVo> pageModel=new PageModel<UserOrderVo>();
	if(pagemodel!=null) {
		List<UserOrderVo> list=new ArrayList<UserOrderVo>();
		List<UserOrder> orders=pagemodel.getData();
		for(UserOrder order:orders) {
			UserOrderVo ordervo=new UserOrderVo();
			list.add(ordervo.convertUserOrderToOrderVo(order));
			//list.add(ordervo);
		}
		pageModel.setTotalpage(pagemodel.getTotalpage());
		pageModel.setData(list);
	}
	return pageModel;
}
@Override
public UserOrder findUserOrderDetailByOrderNo(HttpServletRequest request) throws OrderException {
	// TODO Auto-generated method stub
	String orderno=request.getParameter("orderno");
	if(orderno==null||orderno.equals("")) {
		throw new OrderException("��ѯ���������봫�붩�����");
	}
	long _orderno=0;
	try {
_orderno=Long.parseLong(orderno);
}catch(NumberFormatException e) {
	e.printStackTrace();
throw new OrderException("����ת���쳣");
}
return orderdao.findUserOrderDetailByOrderNo(_orderno);

	
}
@Override
public int updateOrderStatusByOrderNo(HttpServletRequest request) throws OrderException {
	// TODO Auto-generated method stub
	String orderno=request.getParameter("orderno");
	String _status=request.getParameter("status");
	if(orderno==null||orderno.equals("")) {
		throw new OrderException("���Ķ���״̬�����봫�붩�����");
	}
	long _orderno=0;
	Integer status=0;
	try {
_orderno=Long.parseLong(orderno);
status=Integer.parseInt(_status);
}catch(NumberFormatException e) {
	e.printStackTrace();
throw new OrderException("����ת���쳣");
}
return orderdao.updateOrderStatusByOrderNo(_orderno,status);
}
}
