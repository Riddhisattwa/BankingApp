package com.mybankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mybankapp.model.TemporaryTable;

public class GetTemporaryAccountDatadao {
public ArrayList<TemporaryTable> getdata() {
	Connection con=Connectdb.dbconnect();
	try {
		ArrayList<TemporaryTable> customers=new ArrayList<>();
		String sql="SELECT * FROM TemporaryTable";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			TemporaryTable temp=new TemporaryTable();
			temp.setUsername(rs.getString("username"));
			temp.setName(rs.getString("name"));
			temp.setPhoneNo(rs.getLong("phoneNo"));
			temp.setAccount_type(rs.getString("account_type"));
			temp.setAddress(rs.getString("address"));
			temp.setAmount(rs.getLong("amount"));
			temp.setDOB(rs.getString("DOB"));
			temp.setPassword(rs.getString("password"));
			customers.add(temp);
		}
		return customers;
	}catch(Exception e) {
		e.printStackTrace();
		return null;
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
