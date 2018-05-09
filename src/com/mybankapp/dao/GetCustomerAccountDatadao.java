package com.mybankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mybankapp.model.Customer;

public class GetCustomerAccountDatadao {
public  Customer getdata(Customer customer) {
	Connection  con=null;
	try {
		  con=Connectdb.dbconnect();
		  String sql="SELECT * from customer WHERE accountno=?";
		  PreparedStatement pstmt= con.prepareStatement(sql);
		  pstmt.setLong(1,customer.getAccountno());
		  ResultSet rs=pstmt.executeQuery();
		  if(rs.next())
		  {
			  customer.setId(rs.getInt("Id"));
			  customer.setUsername(rs.getString("username"));
			  customer.setAccount_type(rs.getString("account_type"));
			  customer.setAmount(rs.getLong("amount"));	
			  customer.setAccountcreationtime(rs.getTimestamp("accountcreationtime").toString());
			  
	}
		  return customer;
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return null;
	}
	finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
