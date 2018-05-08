package com.mybankapp.services;

import com.mybankapp.dao.UpdateCustomerAccountDatadao;
import com.mybankapp.model.Customer;

public class UpdateAccountservice {
	public Long updatedataservice(Customer customer) {
		UpdateCustomerAccountDatadao customerData=new UpdateCustomerAccountDatadao();
		return customerData.updatedata(customer).getAmount();
	}
	}


