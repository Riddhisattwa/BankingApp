package com.mybankapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybankapp.dao.Connectdb;
import com.mybankapp.model.Customer;
import com.mybankapp.services.GetAmountservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.PrintWriter;

/**
 * Servlet implementation class ViewBalance
 */
@WebServlet("/ViewBalance")
public class ViewBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  try {
		  //Customer c=null;
		  PrintWriter pw=response.getWriter();
		  long accno=Long.parseLong(request.getParameter("accountno"));
		  GetAmountservice amountData=new GetAmountservice();
		  Customer customer=new Customer();
		  customer.setAccountno(accno);
		  pw.println(amountData.getdataservice(customer));
	  }catch(Exception e) {
			e.printStackTrace();
		}

	}
}
