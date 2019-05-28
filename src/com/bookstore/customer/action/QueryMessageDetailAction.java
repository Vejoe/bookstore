package com.bookstore.customer.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Message;
import com.opensymphony.xwork2.ActionSupport;

public class QueryMessageDetailAction extends ActionSupport{
	@Autowired
	int id;
	Message message;
	CustomerDaoInterface cd;
	public QueryMessageDetailAction(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String execute(){
		if(cd.QueryMessageDetail(id)!=null){
			message=cd.QueryMessageDetail(id);
			return SUCCESS;
		}
		else{
			addFieldError("error","≤È’“ ß∞‹£°");
			return INPUT;
		}
	}
}
