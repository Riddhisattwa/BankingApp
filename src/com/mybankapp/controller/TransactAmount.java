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
import com.mybankapp.services.GetTypeservice;
import com.mybankapp.services.Transactionservice;
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
			  //String stype=request.getParameter("saccount_type");
			  //String ttype=request.getParameter("taccount_type");
			  GetAmountservice amountData=new GetAmountservice();
			  GetTypeservice typeData=new GetTypeservice();
			  Customer sender=new Customer();
			  sender.setAccountno(saccno);
			  //customer.setAccount_type(stype);
			  long amount=amountData.getdataservice(sender);
			  Customer receiver=new Customer();
			  receiver.setAccountno(taccno);
			  long balance=amountData.getdataservice(receiver);
			  if(typeData.gettypeservice(sender).equalsIgnoreCase("fixed")==false && typeData.gettypeservice(receiver).equalsIgnoreCase("fixed")==false) {
			  if(amount-tamount>0) {
				  amount=amount-tamount;
				  balance=balance+tamount;
			  Transactionservice accountData=new Transactionservice();
			  //customer.setAccountno(saccno);
			  sender.setAmount(amount);
			  //pw.println(accountData.updatedataservice(customer));
			 // cust.setAccountno(taccno);
			  receiver.setAmount(balance);
			  pw.println(accountData.transactData(sender,receiver));
			  }else {
				  pw.println("insufficient balance");
			  }
			  }else {
				  pw.println("Incorrect Account Type");
			  }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
