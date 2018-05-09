package com.mybankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybankapp.dao.DeleteTemporaryAccountDatadao;
import com.mybankapp.misc.Mailsender;
import com.mybankapp.model.Customer;
import com.mybankapp.model.CustomerAuthentication;
import com.mybankapp.model.CustomerDetails;
import com.mybankapp.model.TemporaryTable;
import com.mybankapp.services.DeleteTemporaryAccountDataservice;
import com.mybankapp.services.GetTemporaryAccountDataservice;
import com.mybankapp.services.InsertDataservice;

/**
 * Servlet implementation class ValidateCustomer
 */
@WebServlet("/ValidateCustomer")
public class ValidateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DeleteTemporaryAccountDataservice deleteUser=new DeleteTemporaryAccountDataservice();
		InsertDataservice insertUser=new InsertDataservice();
		String username=request.getParameter("username");
		TemporaryTable temporaryCustomer=new TemporaryTable();
		temporaryCustomer.setUsername(username);
		GetTemporaryAccountDataservice getTemporaryAccountDataservice=new GetTemporaryAccountDataservice();
		temporaryCustomer=getTemporaryAccountDataservice.getUserByUsername(temporaryCustomer);
		Customer customer=new Customer();
		CustomerAuthentication custAuth=new CustomerAuthentication();
		CustomerDetails custDetails=new CustomerDetails();
		customer.setUsername(temporaryCustomer.getUsername());
		Random random=new Random();
		long accountNo=100000000 + random.nextInt(900000000);//generate 9 digits random account number
		customer.setAccountno(accountNo);
		customer.setAccount_type(temporaryCustomer.getAccount_type());
		customer.setAmount(temporaryCustomer.getAmount());
		customer.setTenure(temporaryCustomer.getTenure());
		custAuth.setPassword(temporaryCustomer.getPassword());
		custAuth.setCustomerId(accountNo);
		custDetails.setAddress(temporaryCustomer.getAddress());
		custDetails.setCustomerId(accountNo);
		custDetails.setDOB(temporaryCustomer.getDOB());
		custDetails.setName(temporaryCustomer.getName());
		custDetails.setPhoneNo(temporaryCustomer.getPhoneNo());
		customer.setCustomerAuth(custAuth);
		customer.setCustomerDetail(custDetails);
		if(insertUser.createuserService(customer)==true) {
			deleteUser.deleteUser(temporaryCustomer);
			String message="Account Approved! Account No="+accountNo;
			Mailsender.sendmail(message, customer.getUsername());
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("CustomerVerification.jsp");
		rd.forward(request, response);
}
}
