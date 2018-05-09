package com.mybankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mybankapp.model.Customer;

public class DeleteCustomerDatadao {
	public boolean deleteUser(Customer customer) {
		Connection con=null;
		try {
			con=Connectdb.dbconnect();
			con.setAutoCommit(false);
			String sql="DELETE FROM customerdetails WHERE CustomerId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1,customer.getAccountno());
			ps.execute();
			
			sql="DELETE FROM customerauthentication WHERE CustomerId=?";
			ps=con.prepareStatement(sql);
			ps.setLong(1,customer.getAccountno());
			ps.execute();
		    sql="DELETE FROM customer WHERE accountno=?";
		    ps=con.prepareStatement(sql);
			ps.setLong(1,customer.getAccountno());
			ps.execute();
			con.commit();
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


