package com.neusoft.serviceImp;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.daoImp.CartDaoImpl;
import com.neusoft.entity.Cart;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.vo.CartCheckedVO;
import com.neusoft.entity.vo.CartVO;
import com.neusoft.exception.CartDaoException;
import com.neusoft.service.CartService;

public class CartServiceImpl implements CartService {

	CartDaoImpl cartdao=CartDaoImpl.getInstance();
	@Override
	public int addIntoCart(Integer userid, HttpServletRequest request) throws CartDaoException {
		// TODO Auto-generated method stub
		//steps:productid�ǿ��ж�
		String productid=request.getParameter("product_id");
		if(productid==null||productid.equals("")) {
			throw new CartDaoException("���빺�ﳵ�����봫����Ʒid");
		}
		Integer _productid=0;
		try {
		_productid=Integer.parseInt(productid);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new CartDaoException("���빺�ﳵ����Ʒid����Ϊ��������");
		}
		
		//steps: ��Ʒ�Ƿ��Ѿ����ڹ��ﳵ��   ���ڣ�������Ʒ����    �����ڣ���ӵ����ﳵ
			String quantity=request.getParameter("quantity");
			Integer _quantity=0;
			try {
				_quantity=Integer.parseInt(quantity);
			}catch(NumberFormatException e) {
				e.printStackTrace();
				throw new CartDaoException("��Ʒ���빺�ﳵ�����봫�����������ַ�������");
			}
		
				Cart cart=cartdao.findCartByUserIdAndProductId(userid, _productid);
				if(cart!=null) {
					 //���ڣ�������Ʒ����
					Integer totalQuantity=cart.getQuantity()+_quantity;
				return cartdao.updateCartByUserIdAndProductId(userid, _productid, totalQuantity);
				}else {
				//�����ڣ���ӵ����ﳵ
				
				
					return cartdao.addProductIntoCartByUserIdAndProductId(userid, _productid, _quantity) ;
				
				}
	
	}

	@Override
	public PageModel<CartVO> deleteCartByProductId(Integer userid, HttpServletRequest request) throws CartDaoException {
		// TODO Auto-generated method stub
		String productid=request.getParameter("product_id");
		if(productid==null||productid.equals("")) {
			throw new CartDaoException("���봫����Ʒid");
			
		}
		Integer _productid=null;
		try {
		_productid=Integer.parseInt(productid);
		cartdao.deleteCartByProductId(userid, _productid);
		return findCartByPage(userid,request);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new CartDaoException("��Ʒid����Ϊ��������");
		}
		 
	}
	@Override
	public PageModel<CartVO> findCartByPage(Integer userid, HttpServletRequest request) throws CartDaoException {
		// TODO Auto-generated method stub
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		int _pageNo=1;
		int _pageSize=3;
		if(pageNo!=null&&pageSize!=null) {
		try {
			_pageNo=Integer.parseInt(pageNo);
			_pageSize=Integer.parseInt(pageSize);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new CartDaoException("����ת���쳣");
		}
		}
		
		PageModel<Cart> pagemodel=cartdao.findCartByPage(userid, _pageNo, _pageSize);
		System.out.println(convertToCartVO(pagemodel));
		return convertToCartVO(pagemodel);
	}
	
	public PageModel<CartVO> convertToCartVO(PageModel<Cart> pagemodel){
		PageModel<CartVO> pageModel=new PageModel<CartVO>();
		if(pagemodel!=null) {
			List<CartVO> list=new ArrayList<CartVO>();
			List<Cart> orders=pagemodel.getData();
			for(Cart order:orders) {
				CartVO cartvo=new CartVO();
				cartvo.convertCartToCartVO(order);
				list.add(cartvo);
			}
			pageModel.setTotalpage(pagemodel.getTotalpage());
			pageModel.setData(list);
		}
		return pageModel;
	}

	@Override
	/**
	 * ���¹��ﳵ����Ʒ����
	 * */
	public PageModel<CartVO> updateCartByUserIdAndProductId(Integer userid, HttpServletRequest request) throws CartDaoException {
		// TODO Auto-generated method stub
		String productid=request.getParameter("productid");
		if(productid==null||productid.equals("")) {
			throw new CartDaoException("���봫����Ʒid");
		}
		Integer _productid=0;
		try {
		_productid=Integer.parseInt(productid);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new CartDaoException("��Ʒid����Ϊ��������");
		}
		
		//steps: ��Ʒ�Ƿ��Ѿ����ڹ��ﳵ��   ���ڣ�������Ʒ���� 
			String quantity=request.getParameter("quantity");
			Integer _quantity=0;
			try {
				_quantity=Integer.parseInt(quantity);
			}catch(NumberFormatException e) {
				e.printStackTrace();
				throw new CartDaoException("���봫�����������ַ�������");
			}
		
				Cart cart=cartdao.findCartByUserIdAndProductId(userid, _productid);
				if(cart!=null) {
					 //���ڣ�������Ʒ����
				
				 cartdao.updateCartByUserIdAndProductId(userid, _productid, _quantity);
				 return findCartByPage(userid,request); }
				else {
					throw new CartDaoException("����Ʒ������");
				}
	}

	@Override
	/**
	 * ѡ��ĳ����Ʒ��ȡ��ѡ��    ȫѡ��ȡ��ȫѡ
	 * */
	public CartCheckedVO checkedOrNotchecked(Integer userid, HttpServletRequest request) throws CartDaoException {
		// TODO Auto-generated method stub
		
		String productid=request.getParameter("product_id");
		
		Integer _productid=null;
		CartCheckedVO vo=new CartCheckedVO();
		if(productid!=null&&productid.equals("")) {
			try {
				_productid=Integer.parseInt(productid);
				
				
			}catch(NumberFormatException e) {
				e.printStackTrace();
				vo.setErrno(CartCheckedVO.ERRNO_FAIL);
			throw new CartDaoException("ȫѡ/��ѡ��Ʒid���ݴ���");
				
			}
		}
		
		String _checked=request.getParameter("checked");
		
		if(_checked==null||_checked.equals("")) {
			vo.setErrno(CartCheckedVO.ERRNO_FAIL);
			throw new CartDaoException("ȫѡ/��ѡchecked�ش�");
		}
		Integer checked=null;
		try {
			checked=Integer.parseInt(_checked);
			
			
		}catch(NumberFormatException e) {
			e.printStackTrace();
			vo.setErrno(CartCheckedVO.ERRNO_FAIL);
			throw new CartDaoException("ȫѡ/��ѡchecked���ݴ���");
		}
		
	
	int row=cartdao.checkedOrNotchecked(checked, userid, _productid);
	
		if(row>0) {
			vo.setErrno(CartCheckedVO.ERRNO_SUCESS);
			vo.setChecked(checked);
			vo.setProduct_id(_productid);
		}
		return vo;
	}

	@Override
	/**
	 * ��ѯ���ﳵ����Ʒ������
	 * */
	public int checkedQuantity(Integer userid) throws CartDaoException {
		// TODO Auto-generated method stub
		
		return cartdao.checkedQuantity(userid);
	}
	
	
	

}
