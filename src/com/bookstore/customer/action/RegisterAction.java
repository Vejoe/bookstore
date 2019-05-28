package com.bookstore.customer.action;

import java.util.Date;
import java.util.Map;

import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
public class RegisterAction extends ActionSupport{
	@Autowired
	Customer customer;
	CustomerDaoInterface cd;
	String securityCode;
	String password;
	public RegisterAction(){
		
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public void validate(){
		Map m=ActionContext.getContext().getSession();
		Date a=new Date();
		if(cd.checkregister(customer)){
			addFieldError("customer.caccount","账号已被注册");
		}
		if(customer.getBirthday()!=null){
			if(customer.getBirthday().after(a)){
				addFieldError("customer.birthday","不能大于今天");
			}
		}
		if(!securityCode.equalsIgnoreCase(m.get("SESSION_SECURITY_CODE").toString())){
			addFieldError("securityCode","验证码错误");
		}
	}
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		if(customer.getEmail().length()==0){
			customer.setEmail(null);
		}
		if(cd.register(customer)>0){
			m.put("caccount", customer.getCaccount());
			m.put("cname",customer.getCname());
			return SUCCESS;
		}else
			return INPUT;
	}
}
