package com.mybankapp.services;

import com.mybankapp.dao.TransactAmountdao;
import com.mybankapp.model.Customer;

public class Transactionservice {
	public boolean transactData(Customer sourceCustomer,Customer receivingCustomer) {
		TransactAmountdao transact=new TransactAmountdao();
		return transact.doTransaction(sourceCustomer, receivingCustomer);
		
	}

}
