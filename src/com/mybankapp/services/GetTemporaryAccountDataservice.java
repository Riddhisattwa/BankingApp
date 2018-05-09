package com.mybankapp.services;

import java.util.ArrayList;

import com.mybankapp.dao.GetTemporaryAccountDatadao;
import com.mybankapp.model.TemporaryTable;

public class GetTemporaryAccountDataservice {
	public ArrayList<TemporaryTable> getdata(){
		GetTemporaryAccountDatadao temporaryData=new GetTemporaryAccountDatadao();
		return temporaryData.getdata();
	}
	public TemporaryTable getUserByUsername(TemporaryTable customer) {
		GetTemporaryAccountDatadao temp=new GetTemporaryAccountDatadao();
		return temp.getSingleUserbyUsername(customer);
	}

}
 