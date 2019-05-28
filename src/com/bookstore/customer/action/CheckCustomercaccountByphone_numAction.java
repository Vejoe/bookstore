package com.bookstore.customer.action;

import java.util.Map;

import com.bookstore.customer.model.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CheckCustomercaccountByphone_numAction extends ActionSupport{
	String phone_num;
	String securityCode;
	Map m;
	public CheckCustomercaccountByphone_numAction(){
		m=ActionContext.getContext().getSession();
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public void validate(){
		if(securityCode.length()==0){
			addFieldError("securityCode","验证码不能为空");
		}
	}
	public String execute(){
		Customer customer=(Customer)m.get("customer");
		if(securityCode.equals(m.get("SESSION_SECURITY_CODE2").toString())){
			m.put("SESSION_SECURITY_CODE2",null);
			m.put("CHECK","ok");
			return SUCCESS;
		}else{
			addFieldError("securityCode","验证码错误");
			return INPUT;
		}
		
	}
}
