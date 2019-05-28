package com.bookstore.backgroundSys.customerM.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.backgroundSys.customerM.dao.CustomerDao;
import com.bookstore.backgroundSys.customerM.dao.impl.CustomerDaoImpl;
import com.bookstore.customer.model.Customer;
import com.opensymphony.xwork2.ActionSupport;

public class changeCustomerINFAction extends ActionSupport {
	@Autowired
	CustomerDao cd;
    private Customer customer;
    public changeCustomerINFAction(){

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	public void validate(){
    	super.validate();
    	if(customer.getCname().equals("")){
    		this.addFieldError("customer.cname", "用户名不能为空");
    	}
    	if(customer.getPassword().equals("")){
    		this.addFieldError("customer.password", "密码不能为空");
    	}
    	if(customer.getPhone_num().equals("")){
    		this.addFieldError("customer.phone_num", "手机号码不能为空");
    	}
    }
    
    public String execute(){
        if(cd.changeCustomerByID(customer)){
            return SUCCESS;
        }else{
            return INPUT;
        }
    }
}
