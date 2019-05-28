package com.bookstore.customer.action;

import java.util.Map;


import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.springframework.beans.factory.annotation.Autowired;
public class LoginAction extends ActionSupport{
	@Autowired
	String url;
	public Customer customer;
	String securityCode;
	CustomerDaoInterface cd;
	public LoginAction(){
		
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public CustomerDaoInterface getCd() {
		return cd;
	}
	public void setCd(CustomerDaoInterface cd) {
		this.cd = cd;
	}
	public void validate(){
		Map m=ActionContext.getContext().getSession();
		if(!securityCode.equalsIgnoreCase(m.get("SESSION_SECURITY_CODE").toString())){
			addFieldError("securityCode","—È÷§¬Î¥ÌŒÛ");
		}
	}
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		/*if(url.equals("/ExtiAction")){
			url="bookstore/mainpageAction";
		}*/
		if(cd.login(customer)){
			m.put("caccount",customer.getCaccount());

			customer=cd.QueryCustomerBycaccount(customer.getCaccount());
			m.put("customer",customer);
			m.put("cname",customer.getCname());
			m.put("cid", customer.getId());
			m.put("rank", customer.getRank());
			System.out.println(url);
			return SUCCESS;
		}
		else{
			addFieldError("customer.caccount","’À∫≈ªÚ’ﬂ√‹¬Î¥ÌŒÛ");
			return INPUT;
		}
	}
}
