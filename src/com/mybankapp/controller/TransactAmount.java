package com.mybankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybankapp.model.Customer;
import com.mybankapp.services.GetAmountservice;
import com.mybankapp.services.UpdateAccountservice;

/**
 * Servlet implementation class Transaction
 */
@WebServlet("/TransactAmount")
public class TransactAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			  PrintWriter pw=response.getWriter();
			  long tamount=Long.parseLong(request.getParameter("tamount"));
			  long saccno=Long.parseLong(request.getParameter("saccountno"));
			  long taccno=Long.parseLong(request.getParameter("taccountno"));
			  GetAmountservice amountData=new GetAmountservice();
			  Customer customer=new Customer();
			  customer.setAccountno(saccno);
			  long amount=amountData.getdataservice(customer);
			  Customer cust=new Customer();
			  cust.setAccountno(taccno);
			  long balance=amountData.getdataservice(cust);
			  if(amount-tamount>0) {
				  amount=amount-tamount;
				  balance=balance+tamount;
			  UpdateAccountservice accountData=new UpdateAccountservice();
			  //customer.setAccountno(saccno);
			  customer.setAmount(amount);
			  pw.println(accountData.updatedataservice(customer));
			 // cust.setAccountno(taccno);
			  cust.setAmount(balance);
			  pw.println(accountData.updatedataservice(cust));
			  }else {
				  pw.println("insufficient balance");
			  }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
