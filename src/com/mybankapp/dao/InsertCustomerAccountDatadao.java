package com.mybankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mybankapp.model.Customer;
import com.mybankapp.model.TemporaryTable;

public class InsertCustomerAccountDatadao {
	public  boolean insertdata(TemporaryTable temp ) {
		Connection  con=null;
		try {
			  con=Connectdb.dbconnect();
			  
			  String sql="INSERT INTO temporarytable(username,name,account_type,amount,password,DOB,phoneNo,address,tenure)VALUES(?,?,?,?,?,?,?,?,?)";
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
			  pstmt.setFloat(9, temp.getTenure());
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
	public boolean createCustomer(Customer customer) {
		Connection con=null;
		try {
			con=Connectdb.dbconnect();
			con.setAutoCommit(false);
			String sql="INSERT INTO customer(username,accountno,account_type,amount,tenure) VALUES(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			//ps.setInt(1,customer.getId());
			ps.setString(1, customer.getUsername());
			ps.setLong(2, customer.getAccountno());
			ps.setString(3,customer.getAccount_type());
			ps.setLong(4, customer.getAmount());
			ps.setFloat(5, customer.getTenure());
			ps.execute();
			sql="INSERT INTO customerdetails(name,DOB,phoneNo,CustomerId,address) VALUES(?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			//ps.setInt(1,customer.getId());
			ps.setString(1, customer.getCustomerDetail().getName());
			ps.setString(2, customer.getCustomerDetail().getDOB());
			ps.setLong(3, customer.getCustomerDetail().getPhoneNo());
			ps.setLong(4, customer.getCustomerDetail().getCustomerId());
			ps.setString(5,customer.getCustomerDetail().getAddress());
			ps.execute();
			sql="INSERT INTO customerauthentication(Id,CustomerId,password) VALUES(?,?,?)";
			 ps=con.prepareStatement(sql);
			ps.setInt(1,customer.getId());
			ps.setLong(2, customer.getCustomerDetail().getCustomerId());
			ps.setString(3, customer.getCustomerAuth().getPassword());
			ps.execute();
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


