package com.bookstore.customer.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ExtiAction extends ActionSupport{
	Map m;
	String url;
	public ExtiAction(){
		m=ActionContext.getContext().getSession();
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String execute(){
		m.clear();
		return SUCCESS;
	}
}
