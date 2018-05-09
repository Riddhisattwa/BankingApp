package com.mybankapp.services;

import java.util.ArrayList;

import com.mybankapp.dao.GetTemporaryAccountDatadao;
import com.mybankapp.model.TemporaryTable;

public class GetTemporaryAccountDataservice {
	public ArrayList<TemporaryTable> getdata(){
		GetTemporaryAccountDatadao temporaryData=new GetTemporaryAccountDatadao();
		return temporaryData.getdata();
	}

}
