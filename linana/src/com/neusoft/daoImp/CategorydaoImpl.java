package com.neusoft.daoImp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.dao.categoryDao;
import com.neusoft.entity.Category;
import com.neusoft.entity.PageModel;
import com.nuesoft.common.Utils;


public class CategorydaoImpl implements categoryDao {
public static CategorydaoImpl categorydao=null;
private CategorydaoImpl() {}
public static CategorydaoImpl getInstance() {
	synchronized(CategorydaoImpl.class){
	if(categorydao==null) {
		categorydao=new CategorydaoImpl();
	}
	}
	return categorydao;
}
	@Override
	public List<Category> findAllCate() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Category> list=new ArrayList<Category>();
		
		try {
			conn=Utils.getConnection();
			String sql="select id,parent_id,name,status,sort_order,create_time,update_time from category";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				Category category=new Category(rs.getInt("id"),rs.getInt("parent_id"),rs.getString("name"),rs.getInt("status"),rs.getInt("sort_order"),rs.getDate("create_time"),rs.getDate("update_time"));
				list.add(category);
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
	@Override
	public int deleteCateById(Integer id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		
		
		try {
			conn=Utils.getConnection();
			
			pst=conn.prepareStatement("delete from category where id=?");
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
	
	
	
	@SuppressWarnings("resource")
	@Override
	public PageModel<Category> findCatebyPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageModel<Category> pagemodel=new PageModel<Category>();
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Category> list=new ArrayList<Category>();
		try {
			conn=Utils.getConnection();
			String sqlcount="select count(id) from category";
			pst=conn.prepareStatement(sqlcount);
			rs=pst.executeQuery();
			if(rs.next()) {
				int totalCount=rs.getInt(1);
				int totalpage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1);
				pagemodel.setTotalpage(totalpage);
			}
			pst=conn.prepareStatement("select id,parent_id,name,status,sort_order, create_time,update_time from category limit ?,?");
			pst.setInt(1, (pageNo-1)*pageSize);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			while(rs.next()) {
				Category category=new Category(rs.getInt("id"),rs.getInt("parent_id"),rs.getString("name"),rs.getInt("status"),rs.getInt("sort_order"),rs.getDate("create_time"),rs.getDate("update_time"));
			list.add(category);
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
	public Category findCateByid(Integer id) {
		// TODO Auto-generated method stub
		Category category=null;
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=Utils.getConnection();
			String sql="select id,parent_id,name,status,sort_order, create_time,update_time from category where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				 category=new Category(rs.getInt("id"),rs.getInt("parent_id"),rs.getString("name"),rs.getInt("status"),rs.getInt("sort_order"),rs.getDate("create_time"),rs.getDate("update_time"));
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
		return category;
	}
	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=Utils.getConnection();
			
			pst=conn.prepareStatement("update category set parent_id=?,name=?,status=?,sort_order=?,create_time=?,update_time=now() where id=?");
			
			pst.setInt(1, category.getParent_id());
			pst.setString(2, category.getName());
			pst.setInt(3, category.getStatus());
			pst.setInt(4,category.getSort_order());
			
		pst.setDate(5, new Date(category.getCreate_time().getTime()));
		pst.setInt(6,category.getId());
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
	public int addCategory(Category category) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement st=null;
		try {
				connection=Utils.getConnection();//获取连接
			String sql="insert into category(id,parent_id,name,status,sort_order,create_time,update_time) values (?,?,?,?,?,?,now())";	
				 st=connection.prepareStatement(sql);//获取statement
				st.setInt(1, category.getId());
				st.setInt(2, category.getParent_id());
				st.setString(3, category.getName());
				st.setInt(4, category.getStatus());
				st.setInt(5, category.getSort_order());
				st.setDate(6, new Date(category.getCreate_time().getTime()));
				
			
		
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
	

	

}
