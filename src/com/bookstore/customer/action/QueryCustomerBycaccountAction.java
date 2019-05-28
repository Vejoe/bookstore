package com.bookstore.customer.action;

import java.util.Map;

import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
public class QueryCustomerBycaccountAction extends ActionSupport{
	@Autowired
	String caccount;
	String securityCode;
	CustomerDaoInterface cd;
	String phone_num;
	public QueryCustomerBycaccountAction(){
		
	}
	public String getSecurityCode(){
		return securityCode;
	}
	public String getCaccount(){
		return caccount;
	}
	public void setCaccount(String caccount){
		this.caccount = caccount;
	}
	public void setSecurityCode(String securityCode){
		this.securityCode = securityCode;
	}
	public CustomerDaoInterface getCd(){
		return cd;
	}
	public void setCd(CustomerDaoInterface cd){
		this.cd = cd;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public void validate(){
		Map m=ActionContext.getContext().getSession();
		if(caccount.length()==0){
			addFieldError("caccount","�˺Ų���Ϊ��");
		}else if(caccount.length()<6){
			addFieldError("caccount","��������Ϊ6λ");
		}
		if(!securityCode.equalsIgnoreCase(m.get("SESSION_SECURITY_CODE").toString())){
			addFieldError("securityCode","��֤�����");
		}
	}
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		Customer customer=cd.QueryCustomerBycaccount(caccount);
		if(customer!=null){
			m.put("customer", customer);
			phone_num=customer.getPhone_num();
			securityCode="";
			return SUCCESS;
		}
		else{
			addFieldError("caccount","�˺Ų�����");
			return INPUT;
		}
	}
}
