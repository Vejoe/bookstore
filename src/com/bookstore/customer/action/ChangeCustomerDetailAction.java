package com.bookstore.customer.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeCustomerDetailAction extends ActionSupport{
	@Autowired
	Customer customer;
	CustomerDaoInterface cd;
	public ChangeCustomerDetailAction(){
		
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CustomerDaoInterface getCd() {
		return cd;
	}
	public void setCd(CustomerDaoInterface cd) {
		this.cd = cd;
	}
	public String execute(){
		Customer oldcustomer=cd.QueryCustomerBycaccount(customer.getCaccount());
		oldcustomer.setCname(customer.getCname());
		oldcustomer.setSex(customer.getSex());
		oldcustomer.setEmail(customer.getEmail());
		oldcustomer.setPhone_num(customer.getPhone_num());
		oldcustomer.setBirthday(customer.getBirthday());
		if(customer.getEmail().length()==0){
			oldcustomer.setEmail(null);
		}
		if(cd.ChangeCustomerinformation(oldcustomer)){
			return SUCCESS;
		}
		else{
			return INPUT;
		}
	}
}
