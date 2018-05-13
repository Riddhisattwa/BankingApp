package com.mybankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			if(request.getParameter("username").equals("root") && request.getParameter("password").equals("root123")) {
				RequestDispatcher rd=request.getRequestDispatcher("Admindashboard.html");
				rd.forward(request, response);
			}else {
				PrintWriter pw=response.getWriter();
				pw.println("<p class=\"card bg-danger text-white\">Wrong username or password</p>");
				RequestDispatcher rd=request.getRequestDispatcher("Adminlogin.html");
				rd.include(request, response);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
