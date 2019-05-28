package com.bookstore.customer.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.bookstore.customer.model.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddMessageAction extends ActionSupport{
	@Autowired
	Customer customer;
	Message message;
	CustomerDaoInterface cd;
	String url="";
	public AddMessageAction(){
		
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public CustomerDaoInterface getCd() {
		return cd;
	}
	public void setCd(CustomerDaoInterface cd) {
		this.cd = cd;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void validateExecuteIsAnonymous(){
		if(message.getPhone().length()==0){
			addFieldError("message.phone","手机号不能为空");
		}
	}
	public String executeIsAnonymous(){
		if(cd.AddMessage(message)){
			System.out.println(url);
			return SUCCESS;
		}
		else{
			return INPUT;
		}
	}
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());
		message.setCustomer(customer);
		message.setPhone(customer.getPhone_num());
		if(cd.AddMessage(message)){
			return SUCCESS;
		}
		else{
			return INPUT;
		}
	}
}
