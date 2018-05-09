package com.mybankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ant.SessionsTask;

import com.mybankapp.model.Customer;
import com.mybankapp.model.CustomerAuthentication;
import com.mybankapp.model.CustomerDetails;
import com.mybankapp.services.GetCustomerDataService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			GetCustomerDataService getData=new GetCustomerDataService();
			Customer customer=new Customer();
			CustomerAuthentication custAuth=new CustomerAuthentication();
			customer.setUsername(request.getParameter("username"));
			custAuth.setPassword(request.getParameter("password"));
			customer.setCustomerAuth(custAuth);
			if(getData.authVerify(customer)==true) {
				HttpSession session=request.getSession();
				session.setAttribute("username",request.getParameter("username") );
				RequestDispatcher rd=request.getRequestDispatcher("CustomerHomePage.jsp");
				rd.forward(request,response);
			}else {
				PrintWriter pw=response.getWriter();
				pw.println("Error");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
