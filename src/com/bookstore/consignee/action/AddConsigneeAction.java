package com.bookstore.consignee.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.consignee.interfaces.ConsigneeDaoInterface;
import com.bookstore.consignee.model.Consignee;
import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddConsigneeAction extends ActionSupport{
	@Autowired
	Customer customer;
	Consignee consignee;
	CustomerDaoInterface cd;
	ConsigneeDaoInterface csgd;
	public AddConsigneeAction(){
		
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Consignee getConsignee() {
		return consignee;
	}
	public void setConsignee(Consignee consignee) {
		this.consignee = consignee;
	}
	public CustomerDaoInterface getCd() {
		return cd;
	}
	public void setCd(CustomerDaoInterface cd) {
		this.cd = cd;
	}
	public ConsigneeDaoInterface getCsgd() {
		return csgd;
	}
	public void setCsgd(ConsigneeDaoInterface csgd) {
		this.csgd = csgd;
	}
	public void validate(){
		if(consignee.getArea().equals("-1"))
			addFieldError("consignee.area","请完善收货人地址");
	}
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());
		consignee.setCustomer(customer);
		if(csgd.AddConsignee(consignee))
			return SUCCESS;
		else
			return INPUT;
	}
}
