package com.mybankapp.services;

import com.mybankapp.dao.GetCustomerAccountDatadao;
import com.mybankapp.model.Customer;

public class GetCustomerDataService {

	public Customer getData(Customer customer) {
		GetCustomerAccountDatadao customerData=new GetCustomerAccountDatadao();
		return customerData.getdata(customer);
	}
	public boolean authVerify(Customer customer) {
		GetCustomerAccountDatadao customerData=new GetCustomerAccountDatadao();
		return customerData.authVerifydao(customer);
	}
}
