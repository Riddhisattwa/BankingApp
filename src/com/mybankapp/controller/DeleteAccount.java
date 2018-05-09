package com.mybankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybankapp.model.Customer;
import com.mybankapp.services.DeleteDataservice;
import com.mybankapp.services.GetAmountservice;

/**
 * Servlet implementation class DeleteAccount
 */
@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			  PrintWriter pw=response.getWriter();
			  long accno=Long.parseLong(request.getParameter("accountno"));
			  DeleteDataservice deleteData=new DeleteDataservice();
			  Customer customer=new Customer();
			  customer.setAccountno(accno);
			  if(deleteData.deleteAccount(customer)==true) {
				  pw.println("Successfully Deleted");
			  }else {
				  pw.println("error");
			  }
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
