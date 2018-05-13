package com.mybankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
			customer.setAccountno(Long.parseLong(request.getParameter("accountno")));
			GetCustomerDataService customerData=new GetCustomerDataService();
			customer=customerData.getData(customer);
			PrintWriter pw=response.getWriter();
			String date[]=customer.getAccountcreationtime().split(" ");
			pw.println(date[0]);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date mydate = new Date();
			String currDate[]=dateFormat.format(mydate).split(" ");
			pw.println(currDate[0]);
			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = myFormat.parse(date[0]);
		    Date date2 = myFormat.parse(currDate[0]);
			long diff = date2.getTime() - date1.getTime();
		    pw.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		    long days= TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		    float duration=days/365;
		    pw.println(customer.getTenure());
		    if(customer.getAccount_type().equalsIgnoreCase("savings")==true) {
		    	if((int)duration>=1) {
		    		double interest=(customer.getAmount()*5*1)/100;
		    		pw.println("Interest= "+interest);
		    	}
		    	else {
		    		pw.println("Interest Calculated annually");
		    	}
		    }else if(customer.getAccount_type().equalsIgnoreCase("fixed")==true) {
		    	double x=Math.pow((1+(0.10/1)),(1*customer.getTenure()));
		    	pw.println(x);
		    	double interest=customer.getAmount()*Math.pow((1+(0.10/1)), (1)*customer.getTenure())-customer.getAmount();
		    	pw.println("Interest= "+interest);
		    }else {
		    	pw.println("Error");
		    }
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
