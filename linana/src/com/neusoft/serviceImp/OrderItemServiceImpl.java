package com.neusoft.serviceImp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.dao.OrderItemDao;
import com.neusoft.daoImp.OrderItemDaoImpl;
import com.neusoft.entity.OrderItem;
import com.neusoft.entity.vo.OrderItemVO;
import com.neusoft.exception.OrderItemException;
import com.neusoft.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {

	@Override
	public List<OrderItemVO> findOrderItemByOrderNo(HttpServletRequest request) throws OrderItemException {
		// TODO Auto-generated method stub
		String orderno=request.getParameter("orderno");
		if(orderno==null||orderno.equals("")) {
			throw new OrderItemException("订单编号必传");
			
		}
		long _orderno=0;
		try {
			_orderno=Long.parseLong(orderno);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new OrderItemException("orderno转换为long类型时出错");
		}
		OrderItemDao itemdao=new OrderItemDaoImpl();
		List<OrderItem> list=itemdao.findOrderItemByOrderNo(_orderno);
		return convertToItemVo(list);
	}

	public List<OrderItemVO> convertToItemVo(List<OrderItem> items){
		
		if(items!=null) {
			List<OrderItemVO> list=new ArrayList<OrderItemVO>();
			
			for(OrderItem item:items) {
				OrderItemVO itemvo=new OrderItemVO();
				itemvo.convertItemToItemVO(item);
				list.add(itemvo);
			}
			return list;
		}
	return null;
	}
}
