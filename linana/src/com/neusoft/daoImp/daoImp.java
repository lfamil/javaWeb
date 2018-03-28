package com.neusoft.daoImp;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.dao.daologin;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.User;
import com.neusoft.exception.MyException;
import com.nuesoft.common.Utils;

public class daoImp implements daologin {

private static daoImp userdao=null;
private daoImp() {
	
}
	
public static daoImp getInstance() {
	synchronized( daoImp.class) {
	if(userdao==null) {
		userdao=new daoImp();
	}
	}
	return userdao;
}
	public int checkUserName(String username) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
		 conn=Utils.getConnection();
		 String sql="select username from user where username=?";
		 pst=conn.prepareStatement(sql);
		 pst.setString(1,username);
		 rs=pst.executeQuery();
		 if(rs.next()) {
			 return 1;
		 }else {
			 return 0;
		 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyException("没有找到用户名");
		}finally {
			try {
				Utils.close(conn, pst, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new MyException("关闭连接异常");
			}
		}
	}

	@Override
	public User findUserByUsernameAndPassword(String username,String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		User user=null;
		try {
			 conn=Utils.getConnection();
		String sql="select id,username,password,email,phone,question,answer,role,create_time,update_time from user where username=?and password=?"; 
			 
			 pst=conn.prepareStatement(sql);
			 pst.setString(1,username);
			 pst.setString(2, password);
			 rs=pst.executeQuery();
			 if(rs.next()) {
		user=new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("email"),rs.getString("phone"),rs.getString("question"),rs.getString("answer"),rs.getInt("role"),rs.getDate("create_time"),rs.getDate("update_time"))	;	
			 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new MyException("根据用户名和密码查询用户信息出错");
			}finally {
				try {
					Utils.close(conn, pst, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new MyException("关闭连接失败");
				}
			}
		return user;
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		List<User> list=new ArrayList<User>();
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			conn=Utils.getConnection();
			
			pst=conn.prepareStatement("select id,username,password,email,phone,question,answer,role,create_time,update_time from user");
			rs=pst.executeQuery();
			while(rs.next()) {
				User user=new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("email"),rs.getString("phone"),rs.getString("question"),rs.getString("answer"),rs.getInt("role"),rs.getDate("create_time"),rs.getDate("update_time"));
			list.add(user);
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
	public int deleteUserByid(Integer id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		
		
		try {
			conn=Utils.getConnection();
			
			pst=conn.prepareStatement("delete from user where id=?");
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
	public int addUser(User user) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement st=null;
		try {
				connection=Utils.getConnection();//获取连接
			String sql="insert into user(id,username,password,email,phone,question,answer,role,create_time,update_time) values (?,?,?,?,?,?,?,?,now(),now())";	
				 st=connection.prepareStatement(sql);//获取statement
				st.setInt(1, user.getId());
				st.setString(2, user.getUsername());
				st.setString(3,user.getPassword());
				st.setString(4, user.getEmail());
			st.setString(5,user.getPhone());
			st.setString(6, user.getQuestion());
			st.setString(7, user.getAnswer());
			st.setInt(8, user.getRole());
			
		//	st.setDate(9, new Date(user.getCreate_time().getTime()));
			
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
	public User findUserbyid(Integer id) {
		// TODO Auto-generated method stub
	User user=null;
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			conn=Utils.getConnection();
			
			pst=conn.prepareStatement("select id,username,password,email,phone,question,answer,role,create_time,update_time from user where id=?");
			pst.setInt(1, id);
			rs=pst.executeQuery();
			
			if(rs.next()) {
				user=new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("email"),rs.getString("phone"),rs.getString("question"),rs.getString("answer"),rs.getInt("role"),rs.getDate("create_time"),rs.getDate("update_time"));
		
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
		
		return user;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		
		
		try {
			conn=Utils.getConnection();
			
			pst=conn.prepareStatement("update user set  username=?,password=?,email=?,phone=?,question=?,answer=?,role=?,update_time=now() where id=?");
			
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getPhone());
			pst.setString(5, user.getQuestion());
			pst.setString(6, user.getAnswer());
		pst.setInt(7, user.getRole());
		pst.setInt(8, user.getId());	
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
	public int updateTokenByUserId(Integer id, String token) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		
		
		try {
			conn=Utils.getConnection();
			
			pst=conn.prepareStatement("update user set token=? where id=?");
			pst.setString(1, token);
			pst.setInt(2, id);
			
	
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
	public User findUserByToken(String token) throws MyException {
		// TODO Auto-generated method stub
		User user=null;
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			conn=Utils.getConnection();
			
			pst=conn.prepareStatement("select id,username,password,email,phone,question,answer,role,create_time,update_time from user where token=?");
			pst.setString(1, token);
			rs=pst.executeQuery();
			
			if(rs.next()) {
				user=new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("email"),rs.getString("phone"),rs.getString("question"),rs.getString("answer"),rs.getInt("role"),rs.getDate("create_time"),rs.getDate("update_time"));
		
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
		
		return user;
	}

	@Override
	public PageModel<User> findUserByPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addBatchUser(List<User> users) throws MyException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> findUserByforeach(List<Integer> ids) throws MyException {
		// TODO Auto-generated method stub
		return null;
	}

	
}

