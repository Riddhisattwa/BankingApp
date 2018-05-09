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
import com.mybankapp.services.GetTypeservice;
import com.mybankapp.services.UpdateAccountservice;

/**
 * Servlet implementation class DepositAmount
 */
@WebServlet("/DepositAmount")
public class DepositAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
			 try {
				  PrintWriter pw=response.getWriter();
				  long credit=Long.parseLong(request.getParameter("credit"));
				  long accno=Long.parseLong(request.getParameter("accountno"));
				  //String type=request.getParameter("account_type");
				  GetAmountservice amountData=new GetAmountservice();
				  GetTypeservice typeData=new GetTypeservice();
				  Customer customer=new Customer();
				  customer.setAccountno(accno);
				  //customer.setAccount_type(type);
				  //String type=amountData.gettypeservice(customer);
				  long amount=amountData.getdataservice(customer);
				  if(typeData.gettypeservice(customer).equalsIgnoreCase("fixed")==false){
				  long balance=amount+credit;
				  UpdateAccountservice accountData=new UpdateAccountservice();
				  customer.setAmount(balance);
				 // customer.setAccountno(accno);
				 long tamount=accountData.updatedataservice(customer);
				 pw.println("your account is credited by "+credit);
				 pw.println("Your current balance is  "+tamount);
				  }else {
					  pw.println("Incorrect Account Type");
				  }
			  }catch(Exception e) {
					e.printStackTrace();
				}

		}
}
