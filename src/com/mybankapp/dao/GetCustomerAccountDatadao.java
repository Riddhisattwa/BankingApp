package com.mybankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mybankapp.model.Customer;
import com.mybankapp.model.CustomerAuthentication;
import com.mybankapp.model.CustomerDetails;

public class GetCustomerAccountDatadao {
public  Customer getdata(Customer customer) {
	Connection  con=null;
	try {
		  con=Connectdb.dbconnect();
		 // String sql="SELECT * from customer WHERE accountno=?";
		  String sql="SELECT * FROM customer INNER JOIN customerdetails\r\n" + 
		  		"ON customer.accountno=customerdetails.CustomerId\r\n" + 
		  		"INNER JOIN customerauthentication\r\n" + 
		  		"ON customerdetails.CustomerId=customerauthentication.CustomerId WHERE customer.accountno=?";
		  PreparedStatement pstmt= con.prepareStatement(sql);
		  pstmt.setLong(1,customer.getAccountno());
		  ResultSet rs=pstmt.executeQuery();
		  if(rs.next())
		  {
			  CustomerDetails CustomerDetails=new CustomerDetails();
			  CustomerAuthentication customerAuth=new CustomerAuthentication();
			  customer.setId(rs.getInt("Id"));
			  customer.setUsername(rs.getString("username"));
			  customer.setAccount_type(rs.getString("account_type"));
			  customer.setAmount(rs.getLong("amount"));	
			  customer.setAccountcreationtime(rs.getTimestamp("accountcreationtime").toString());
			  customer.setTenure(rs.getFloat("tenure"));
			  CustomerDetails.setDOB(rs.getString("DOB"));
			  CustomerDetails.setName(rs.getString("name"));
			  CustomerDetails.setAddress(rs.getString("address"));
			  CustomerDetails.setPhoneNo(rs.getLong("phoneNo"));
			  customerAuth.setPassword(rs.getString("password"));
			  
			  
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
public  boolean authVerifydao(Customer customer) {
	Connection  con=null;
	try {
		  con=Connectdb.dbconnect();
		 // String sql="SELECT * from customer WHERE accountno=?";
		  String sql="SELECT * FROM customer INNER JOIN customerdetails\r\n" + 
		  		"ON customer.accountno=customerdetails.CustomerId\r\n" + 
		  		"INNER JOIN customerauthentication\r\n" + 
		  		"ON customerdetails.CustomerId=customerauthentication.CustomerId WHERE customer.username=? AND customerauthentication.password=?";
		  PreparedStatement pstmt= con.prepareStatement(sql);
		  pstmt.setLong(1,customer.getAccountno());
		  pstmt.setString(2, customer.getCustomerAuth().getPassword());
		  ResultSet rs=pstmt.executeQuery();
		  if(rs.next())
		  {
			 return true;
			  
			  
	}else {
		return false;
	}
		  
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return false;
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
