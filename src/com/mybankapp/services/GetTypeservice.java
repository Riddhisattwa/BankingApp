package com.mybankapp.services;

import com.mybankapp.dao.GetCustomerAccountDatadao;
import com.mybankapp.model.Customer;

public class GetTypeservice {
	public String gettypeservice(Customer customer) {
		GetCustomerAccountDatadao customerData=new GetCustomerAccountDatadao();
		return customerData.getdata(customer).getAccount_type();
		
	}
}
