package com.bookstore.customer.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChangepasswordByMtself_m3 extends ActionSupport{
	@Autowired
	Customer customer;
	String password1;
	String password2;
	CustomerDaoInterface cd;
	public ChangepasswordByMtself_m3(){
		
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public CustomerDaoInterface getCd() {
		return cd;
	}
	public void setCd(CustomerDaoInterface cd) {
		this.cd = cd;
	}
	public void validate(){
		if(customer.getPassword().length()==0){
			addFieldError("customer.password","旧密码不能为空");
		}else if(password1.length()==0){
			addFieldError("password1","新密码不能为空");
		}else if(password1.length()<6){
			addFieldError("password1","长度必须大于6位");
		}else if(!password2.equals(password1)){
			addFieldError("password2","两次密码不相同");
		}
	}
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		Customer oldcustomer=cd.QueryCustomerBycaccount(customer.getCaccount());
		if(password1.equals(oldcustomer.getPassword())){
			addFieldError("password1","不能与旧密码相同");
			return INPUT;
		}else if(!customer.getPassword().equals(oldcustomer.getPassword())){
			if(m.get("errornum")==null)
				m.put("errornum","1");
			else if(m.get("errornum").equals("1"))
				m.put("errornum","2");
			else{
				return "errornumIsThree";
			}
			addFieldError("customer.password","旧密码错误");
			return INPUT;
		}
		oldcustomer.setPassword(password1);
		if(cd.ChangeCustomerinformation(oldcustomer)){
			m.put("errornum",null);
			return SUCCESS;
		}
		else{
			addFieldError("customer.password","修改失败");
			return INPUT;
		}
	}
}
