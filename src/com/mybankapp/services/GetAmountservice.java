package com.mybankapp.services;

import com.mybankapp.dao.GetCustomerAccountDatadao;
import com.mybankapp.model.Customer;

public class GetAmountservice {
public Long getdataservice(Customer customer) {
	GetCustomerAccountDatadao customerData=new GetCustomerAccountDatadao();
	return customerData.getdata(customer).getAmount();
	
}

}