package com.bookstore.customer.action;

import java.util.List;
import java.util.Map;

import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
public class GetCustomerDetailBycaccountAction extends ActionSupport{
	@Autowired
	Customer customer;
	CustomerDaoInterface cd;
	String num;
	public GetCustomerDetailBycaccountAction(){
		
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CustomerDaoInterface getCd(){
		return cd;
	}
	public void setCd(CustomerDaoInterface cd){
		this.cd = cd;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());		
		if(customer!=null){
			return "success"+num;
		}
		else{
			return INPUT;
		}
	}
}
