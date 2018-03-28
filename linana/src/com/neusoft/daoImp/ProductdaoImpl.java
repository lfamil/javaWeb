package com.neusoft.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.dao.Productdao;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.nuesoft.common.Utils;

public class ProductdaoImpl implements Productdao {
private ProductdaoImpl() {}
private static ProductdaoImpl productdao=null;
public static ProductdaoImpl getInstance() {
	synchronized( ProductdaoImpl.class) {
	if(productdao==null) {
		productdao=new ProductdaoImpl();
	}
	}
	return productdao;
} 
public List<Product> findAllProduct() {
	// TODO Auto-generated method stub
	List<Product> list=new ArrayList<Product>();
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	try {
		conn=Utils.getConnection();
		
		pst=conn.prepareStatement("select id,category_name,name,subtitle,main_image,sub_images,detail,price,stock,status, create_time,update_time from product ");
		rs=pst.executeQuery();
		while(rs.next()) {
			Product product=new Product(rs.getInt("id"),rs.getString("category_name"),rs.getString("name"),rs.getString("subtitle"),rs.getString("main_image"),rs.getString("sub_images"),rs.getString("detail"),rs.getBigDecimal("price"),rs.getInt("stock"),rs.getString("status"),rs.getDate("create_time"),rs.getDate("update_time"));
			list.add(product);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			Utils.close(conn, pst, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	return list;
}
	

	@SuppressWarnings("resource")
	@Override
	public PageModel<Product> findProductbyPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageModel<Product> pagemodel=new PageModel<Product>();
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList<Product>();
		try {
			conn=Utils.getConnection();
			String sqlcount="select count(id) from product";
			pst=conn.prepareStatement(sqlcount);
			rs=pst.executeQuery();
			if(rs.next()) {
				int totalCount=rs.getInt(1);
				int totalpage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1);
				pagemodel.setTotalpage(totalpage);
			}
			pst=conn.prepareStatement("select id,category_name,name,subtitle,main_image,sub_images,detail,price,stock,status, create_time,update_time from product   limit ?,?");
			pst.setInt(1, (pageNo-1)*pageSize);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			while(rs.next()) {
				Product product=new Product(rs.getInt("id"),rs.getString("category_name"),rs.getString("name"),rs.getString("subtitle"),rs.getString("main_image"),rs.getString("sub_images"),rs.getString("detail"),rs.getBigDecimal("price"),rs.getInt("stock"),rs.getString("status"),rs.getDate("create_time"),rs.getDate("update_time"));
			list.add(product);
			}
			pagemodel.setData(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				Utils.close(conn, pst, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return pagemodel;
	}
	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement st=null;
		try {
				connection=Utils.getConnection();//获取连接
			String sql="insert into product(id,category_name,name,subtitle,main_image,sub_images,detail,price,stock,status,create_time,update_time) values (?,?,?,?,?,?,?,?,?,?,now(),now())";	
				 st=connection.prepareStatement(sql);//获取statement
				st.setInt(1, product.getId());
				st.setString(2, product.getCategory_name());
				st.setString(3,product.getName());
				st.setString(4, product.getSubtitle());
				st.setString(5, product.getMain_image());
				st.setString(6,product.getSub_images());
				st.setString(7, product.getDetail());
				st.setBigDecimal(8, product.getPrice());
				st.setInt(9,product.getStock());
				st.setString(10, product.getStatus());
			
		
			return st.executeUpdate();
			}
			
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				
				Utils.close(connection,st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	@Override
	public int deleteProductByid(Integer id) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement pst=null;
		
		
		try {
			conn=Utils.getConnection();
			
			pst=conn.prepareStatement("delete from product where id=?");
			pst.setInt(1,id);
		return pst.executeUpdate();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				Utils.close(conn, pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	@Override
	public Product findProductbyId(Integer id) {
		// TODO Auto-generated method stub
		Product product=null;
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=Utils.getConnection();
			String sql="select id,category_name,name,subtitle,main_image,sub_images,detail,price,stock,status, create_time,update_time from product where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				 product=new Product(rs.getInt("id"),rs.getString("category_name"),rs.getString("name"),rs.getString("subtitle"),rs.getString("main_image"),rs.getString("sub_images"),rs.getString("detail"),rs.getBigDecimal("price"),rs.getInt("stock"),rs.getString("status"),rs.getDate("create_time"),rs.getDate("update_time"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				Utils.close(conn, pst, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return product;
	}
	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		
		
		try {
			conn=Utils.getConnection();
			
			pst=conn.prepareStatement("update product set category_name=?,name=?,subtitle=?,main_image=?,sub_images=?,detail=?,price=?,stock=?,status=? where id=?");
			
			pst.setString(1, product.getCategory_name());
			pst.setString(2, product.getName());
			pst.setString(3, product.getSubtitle());
			pst.setString(4,product.getMain_image());
			pst.setString(5, product.getSub_images());
			pst.setString(6, product.getDetail());
		pst.setBigDecimal(7, product.getPrice());
		pst.setInt(8, product.getStock());	
		pst.setString(9, product.getStatus());

		pst.setInt(10,product.getId());
		return pst.executeUpdate();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				Utils.close(conn, pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	@Override
	public List<Product> searchProduct(String categoryname) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Long getProductStock(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int reduceproductStock(Integer id, Integer quantity) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Product findProductByName(String productname) {
		// TODO Auto-generated method stub
		return null;
	}

}
