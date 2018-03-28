package com.neusoft.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.dao.Catedao;
import com.neusoft.entity.Cate;
import com.nuesoft.common.Utils;

public class CatedaoImpl implements Catedao {

	public List<Cate> findAllcate() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Cate> list=new ArrayList<Cate>();
		
		try {
			conn=Utils.getConnection();
			String sql="select id,name from Cate";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				Cate cate=new Cate(rs.getInt("id"),rs.getString("name"));
				list.add(cate);
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

}
