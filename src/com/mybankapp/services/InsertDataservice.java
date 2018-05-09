package com.mybankapp.services;

import com.mybankapp.dao.InsertCustomerAccountDatadao;
import com.mybankapp.model.Customer;
import com.mybankapp.model.TemporaryTable;

public class InsertDataservice {
	public boolean insertdataservice(TemporaryTable temp) {
		InsertCustomerAccountDatadao customerData=new InsertCustomerAccountDatadao();
		return customerData.insertdata(temp);	
	}
	public boolean createuserService(Customer customer) {
		InsertCustomerAccountDatadao insertData=new InsertCustomerAccountDatadao();
		return insertData.createCustomer(customer);
	}
}
