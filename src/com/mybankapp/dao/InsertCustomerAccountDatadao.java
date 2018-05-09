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
			  
			  String sql="INSERT INTO temporarytable(username,name,account_type,amount,password,DOB,phoneNo,address)VALUES(?,?,?,?,?,?,?,?)";
			  PreparedStatement pstmt= con.prepareStatement(sql);
			  //System.out.println(temp.getUsername());
			  pstmt.setString(1,temp.getUsername());
			  pstmt.setString(2,temp.getName());
			  pstmt.setString(3,temp.getAccount_type());
			  pstmt.setLong(4,temp.getAmount());
			  pstmt.setString(5,temp.getPassword());
			  pstmt.setString(6,temp.getDOB());
			  pstmt.setLong(7,temp.getPhoneNo());
			  pstmt.setString(8, temp.getAddress());
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


