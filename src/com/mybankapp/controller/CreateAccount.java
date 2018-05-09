package com.mybankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybankapp.model.Customer;
import com.mybankapp.model.TemporaryTable;
import com.mybankapp.services.GetAmountservice;
import com.mybankapp.services.InsertDataservice;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			  PrintWriter pw=response.getWriter();
			  Random random=new Random();
			  TemporaryTable temp=new TemporaryTable();
			  temp.setUsername(request.getParameter("username"));
			  //System.out.println(username);
			  //long accno=Long.parseLong(request.getParameter("accountno"));
			 // temp.setAccountno(100000000 + random.nextInt(900000000));
			  temp.setName(request.getParameter("name"));
			  String account_type=request.getParameter("account_type");
			  temp.setAccount_type(account_type);
			  long amount=Long.parseLong(request.getParameter("amount"));
			  temp.setAmount(amount);
			  temp.setPassword(request.getParameter("password"));
			  temp.setDOB(request.getParameter("DOB"));
			 /* SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-dd-MM");
				java.util.Date date= dateFormat.parse(dob);
				java.sql.Date dateobj=new java.sql.Date(date.getTime()); */
			  long phone=Long.parseLong(request.getParameter("phoneNo"));
			  temp.setPhoneNo(phone);
			  temp.setAddress(request.getParameter("address"));
			  if(account_type.equalsIgnoreCase("fixed")==true && amount>=10000) {
			  float tenure=Float.parseFloat(request.getParameter("tenure"));
			  InsertDataservice insertData=new InsertDataservice();
			  if(insertData.insertdataservice(temp)==true)
				  pw.println("Data inserted!");
			  else
				  pw.println("error");
			  temp.setTenure(tenure);
			  }else if(account_type.equalsIgnoreCase("current")==true && amount>=10000){
				  temp.setTenure(0);
				  InsertDataservice insertData=new InsertDataservice();
				  if(insertData.insertdataservice(temp)==true)
					  pw.println("Data inserted!");
				  else
					  pw.println("error");
			  }else if(account_type.equalsIgnoreCase("savings")==true) {
				  InsertDataservice insertData=new InsertDataservice();
				  if(insertData.insertdataservice(temp)==true)
					  pw.println("Data inserted!");
				  else
					  pw.println("error");
			  }else {
				pw.print("error");  
			  }
			  
		  }catch(Exception e) {
				e.printStackTrace();
			}

		}
	}
