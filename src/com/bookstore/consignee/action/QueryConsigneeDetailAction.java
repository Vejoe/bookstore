package com.bookstore.consignee.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.consignee.interfaces.ConsigneeDaoInterface;
import com.bookstore.consignee.model.Consignee;
import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryConsigneeDetailAction extends ActionSupport{
	@Autowired
	int id;
	Customer customer;
	Consignee consignee;
	CustomerDaoInterface cd;
	ConsigneeDaoInterface csgd;
	public QueryConsigneeDetailAction(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());
		if(csgd.QueryConsigneeDetail(id)!=null){
			consignee=csgd.QueryConsigneeDetail(id);
			return SUCCESS;
		}
		else{
			addFieldError("error","≤È’“ ß∞‹£°");
			return INPUT;
		}
	}
}
