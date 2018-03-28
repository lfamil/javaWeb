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
		//steps:productid非空判断
		String productid=request.getParameter("product_id");
		if(productid==null||productid.equals("")) {
			throw new CartDaoException("加入购物车，必须传入商品id");
		}
		Integer _productid=0;
		try {
		_productid=Integer.parseInt(productid);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new CartDaoException("加入购物车，商品id必须为数字类型");
		}
		
		//steps: 商品是否已经存在购物车中   存在，更新商品数量    不存在，添加到购物车
			String quantity=request.getParameter("quantity");
			Integer _quantity=0;
			try {
				_quantity=Integer.parseInt(quantity);
			}catch(NumberFormatException e) {
				e.printStackTrace();
				throw new CartDaoException("商品加入购物车，必须传入数字类型字符串参数");
			}
		
				Cart cart=cartdao.findCartByUserIdAndProductId(userid, _productid);
				if(cart!=null) {
					 //存在，更新商品数量
					Integer totalQuantity=cart.getQuantity()+_quantity;
				return cartdao.updateCartByUserIdAndProductId(userid, _productid, totalQuantity);
				}else {
				//不存在，添加到购物车
				
				
					return cartdao.addProductIntoCartByUserIdAndProductId(userid, _productid, _quantity) ;
				
				}
	
	}

	@Override
	public PageModel<CartVO> deleteCartByProductId(Integer userid, HttpServletRequest request) throws CartDaoException {
		// TODO Auto-generated method stub
		String productid=request.getParameter("product_id");
		if(productid==null||productid.equals("")) {
			throw new CartDaoException("必须传入商品id");
			
		}
		Integer _productid=null;
		try {
		_productid=Integer.parseInt(productid);
		cartdao.deleteCartByProductId(userid, _productid);
		return findCartByPage(userid,request);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new CartDaoException("商品id必须为数字类型");
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
			throw new CartDaoException("数字转换异常");
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
	 * 更新购物车中商品数量
	 * */
	public PageModel<CartVO> updateCartByUserIdAndProductId(Integer userid, HttpServletRequest request) throws CartDaoException {
		// TODO Auto-generated method stub
		String productid=request.getParameter("productid");
		if(productid==null||productid.equals("")) {
			throw new CartDaoException("必须传入商品id");
		}
		Integer _productid=0;
		try {
		_productid=Integer.parseInt(productid);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new CartDaoException("商品id必须为数字类型");
		}
		
		//steps: 商品是否已经存在购物车中   存在，更新商品数量 
			String quantity=request.getParameter("quantity");
			Integer _quantity=0;
			try {
				_quantity=Integer.parseInt(quantity);
			}catch(NumberFormatException e) {
				e.printStackTrace();
				throw new CartDaoException("必须传入数字类型字符串参数");
			}
		
				Cart cart=cartdao.findCartByUserIdAndProductId(userid, _productid);
				if(cart!=null) {
					 //存在，更新商品数量
				
				 cartdao.updateCartByUserIdAndProductId(userid, _productid, _quantity);
				 return findCartByPage(userid,request); }
				else {
					throw new CartDaoException("该商品不存在");
				}
	}

	@Override
	/**
	 * 选中某个商品，取消选中    全选，取消全选
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
			throw new CartDaoException("全选/单选商品id传递错误");
				
			}
		}
		
		String _checked=request.getParameter("checked");
		
		if(_checked==null||_checked.equals("")) {
			vo.setErrno(CartCheckedVO.ERRNO_FAIL);
			throw new CartDaoException("全选/单选checked必传");
		}
		Integer checked=null;
		try {
			checked=Integer.parseInt(_checked);
			
			
		}catch(NumberFormatException e) {
			e.printStackTrace();
			vo.setErrno(CartCheckedVO.ERRNO_FAIL);
			throw new CartDaoException("全选/单选checked传递错误");
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
	 * 查询购物车中商品总数量
	 * */
	public int checkedQuantity(Integer userid) throws CartDaoException {
		// TODO Auto-generated method stub
		
		return cartdao.checkedQuantity(userid);
	}
	
	
	

}
