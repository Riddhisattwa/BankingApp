package com.mybankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mybankapp.model.Customer;

public class UpdateCustomerAccountDatadao {
	public  Customer updatedata(Customer customer) {
		Connection  con=null;
		try {
			  con=Connectdb.dbconnect();
			  
			  String sql="UPDATE customer SET amount=? WHERE accountno=? AND account_type=?";
			  PreparedStatement pstmt= con.prepareStatement(sql);
			  pstmt.setLong(1,customer.getAmount());
			  pstmt.setLong(2,customer.getAccountno());
			  pstmt.setString(3,customer.getAccount_type());
			  pstmt.executeUpdate();
			  return customer;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
		finally {
			try {
			//	con.commit();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	}
