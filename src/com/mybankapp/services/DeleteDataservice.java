package com.mybankapp.services;

import com.mybankapp.dao.DeleteCustomerDatadao;
import com.mybankapp.model.Customer;

public class DeleteDataservice {
	public boolean deleteAccount(Customer customer) {
		DeleteCustomerDatadao deleteCustomer=new DeleteCustomerDatadao();
		return deleteCustomer.deleteUser(customer);
	}
}
