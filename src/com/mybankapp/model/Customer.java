package com.mybankapp.model;

public class Customer {
	private int Id;
	private String username;
	private long accountno;
	private String account_type;
	private long amount;
	private CustomerDetails customerDetail;
	private CustomerAuthentication customerAuth;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public CustomerDetails getCustomerDetail() {
		return customerDetail;
	}
	public void setCustomerDetail(CustomerDetails customerDetail) {
		this.customerDetail = customerDetail;
	}
	public CustomerAuthentication getCustomerAuth() {
		return customerAuth;
	}
	public void setCustomerAuth(CustomerAuthentication customerAuth) {
		this.customerAuth = customerAuth;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	public long getAccountno() {
		return accountno;
	}
	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	

}
