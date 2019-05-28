package com.bookstore.customer.action;

import java.util.Map;

import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
public class ChangepassowrdAction extends ActionSupport{
	@Autowired
	String newpassword;
	String newpassword2;
	CustomerDaoInterface cd;
	public ChangepassowrdAction(){
		
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getNewpassword2() {
		return newpassword2;
	}
	public void setNewpassword2(String newpassword2) {
		this.newpassword2 = newpassword2;
	}
	public CustomerDaoInterface getCd() {
		return cd;
	}
	public void setCd(CustomerDaoInterface cd) {
		this.cd = cd;
	}
	public void validate(){
		if(newpassword.length()==0){
			addFieldError("newpassword","新密码不能为空");
		}else if(newpassword.length()<6){
			addFieldError("newpassword","长度必须大于6位");
		}else if(!newpassword2.equals(newpassword)){
			addFieldError("newpassword2","两次密码不相同");
		}
	}
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		Customer customer=(Customer)m.get("customer");
		if(newpassword.equals(customer.getPassword())){
			addFieldError("newpassword","不能与旧密码相同");
			return INPUT;
		}
		customer.setPassword(newpassword);
		if(cd.ChangeCustomerinformation(customer)){
			return SUCCESS;
		}
		else{
			addFieldError("newpassword","修改失败");
			return INPUT;
		}
	}
}
