package com.mybankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mybankapp.model.TemporaryTable;

public class InsertCustomerAccountDatadao {
	public  boolean insertdata(TemporaryTable temp ) {
		Connection  con=null;
		try {
			  con=Connectdb.dbconnect();
			  
			  String sql="INSERT INTO temporarytable(username,account_type,amount,password,DOB,phoneNo,address)VALUES(?,?,?,?,?,?,?)";
			  PreparedStatement pstmt= con.prepareStatement(sql);
			  //System.out.println(temp.getUsername());
			  pstmt.setString(1,temp.getUsername());
			 // pstmt.setLong(2,temp.getAccountno());
			  pstmt.setString(2,temp.getAccount_type());
			  pstmt.setLong(3,temp.getAmount());
			  pstmt.setString(4,temp.getPassword());
			  pstmt.setString(5,temp.getDOB());
			  pstmt.setLong(6,temp.getPhoneNo());
			  pstmt.setString(7, temp.getAddress());
			  pstmt.execute();
			  return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				//con.commit();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	}


