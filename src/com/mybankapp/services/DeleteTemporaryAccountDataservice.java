package com.mybankapp.services;

import com.mybankapp.dao.DeleteTemporaryAccountDatadao;
import com.mybankapp.model.TemporaryTable;

public class DeleteTemporaryAccountDataservice {
public boolean deleteUser(TemporaryTable customer) {
	DeleteTemporaryAccountDatadao deleteTemporaryTable=new DeleteTemporaryAccountDatadao();
	return deleteTemporaryTable.deleteTemp(customer);
}
}
