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
 * Servlet implementation class WithdrawAmount
 */
@WebServlet("/WithdrawAmount")
public class WithdrawAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
			  PrintWriter pw=response.getWriter();
			  long debit=Long.parseLong(request.getParameter("debit"));
			  long accno=Long.parseLong(request.getParameter("accountno"));
			  //String type=request.getParameter("account_type");
			  GetAmountservice amountData=new GetAmountservice();
			  GetTypeservice data=new GetTypeservice();
			  Customer customer=new Customer();
			  customer.setAccountno(accno);
			  //customer.setAccount_type(type);
			  long amount=amountData.getdataservice(customer);
			  String type=data.gettypeservice(customer);
			  System.out.println(type);
			  if(type.equalsIgnoreCase("fixed")){
				  pw.println("You can not withdraw ");
			  }else {
			  if(amount<500) {
				  pw.println("insufficient balance");
			  }else {
			  long balance=amount-debit;
			  UpdateAccountservice accountData=new UpdateAccountservice();
			  //customer.setAccountno(accno);
			  customer.setAmount(balance);
			  long tamount=accountData.updatedataservice(customer);
			  pw.println("Your Account is debited by  "+debit);
			  pw.println("Your Current Balance is "+tamount);
			  }
			  }
		  }catch(Exception e) {
				e.printStackTrace();
			}

	}
}
