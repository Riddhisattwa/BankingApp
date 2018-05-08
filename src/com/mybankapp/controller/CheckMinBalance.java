package com.mybankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybankapp.dao.Connectdb;
import com.mybankapp.model.Customer;
import com.mybankapp.services.GetAmountservice;

/**
 * Servlet implementation class MinBalance
 */
@WebServlet("/CheckMinBalance")
public class CheckMinBalance extends HttpServlet {
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
			 long balance= amountData.getdataservice(customer);
			 if(balance<500) {
				 pw.println("Your account balance is lower than minimum balance");
			 }
			 else {
			  pw.println(amountData.getdataservice(customer));
			 }
		  }catch(Exception e) {
				e.printStackTrace();
			}

		}
	}
