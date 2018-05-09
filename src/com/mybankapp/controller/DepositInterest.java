package com.mybankapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybankapp.model.Customer;
import com.mybankapp.services.GetCustomerDataService;

/**
 * Servlet implementation class DepositInterest
 */
@WebServlet("/DepositInterest")
public class DepositInterest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Customer customer=new Customer();
			
			GetCustomerDataService customerData=new GetCustomerDataService();
			customerData.getData(customer);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
