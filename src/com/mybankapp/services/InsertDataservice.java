package com.mybankapp.services;

import com.mybankapp.dao.InsertCustomerAccountDatadao;
import com.mybankapp.model.TemporaryTable;

public class InsertDataservice {
	public boolean insertdataservice(TemporaryTable temp) {
		InsertCustomerAccountDatadao customerData=new InsertCustomerAccountDatadao();
		return customerData.insertdata(temp);	
	}
	
}
