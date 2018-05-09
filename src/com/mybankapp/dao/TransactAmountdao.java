package com.mybankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mybankapp.model.Customer;

public class TransactAmountdao {
	public  boolean doTransaction(Customer sourceCustomer,Customer receivingCustomer) {
		Connection  con=null;
		try {
			  con=Connectdb.dbconnect();
			  con.setAutoCommit(false);
			  String sql="UPDATE customer SET amount=? WHERE accountno=? AND account_type=?";
			  PreparedStatement pstmt= con.prepareStatement(sql);
			  pstmt.setLong(1,sourceCustomer.getAmount());
			  pstmt.setLong(2,sourceCustomer.getAccountno());
			  pstmt.setString(3,sourceCustomer.getAccount_type());
			  pstmt.executeUpdate();
			  sql="UPDATE customer SET amount=? WHERE accountno=? AND account_type=?";
			  pstmt= con.prepareStatement(sql);
			  pstmt.setLong(1,receivingCustomer.getAmount());
			  pstmt.setLong(2,receivingCustomer.getAccountno());
			  pstmt.setString(3,receivingCustomer.getAccount_type());
			  pstmt.executeUpdate();
			  con.commit();
			  return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
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


