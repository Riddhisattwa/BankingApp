package com.mybankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mybankapp.model.TemporaryTable;

public class DeleteTemporaryAccountDatadao {
public boolean deleteTemp(TemporaryTable temp) {
	Connection con=null;
	try {
		con=Connectdb.dbconnect();
		String sql="DELETE FROM TemporaryTable WHERE username=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,temp.getUsername());
		ps.execute();
		return true;
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return false;
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
