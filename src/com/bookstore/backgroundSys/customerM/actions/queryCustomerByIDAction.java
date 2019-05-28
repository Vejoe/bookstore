package com.bookstore.backgroundSys.customerM.actions;

import com.bookstore.backgroundSys.customerM.dao.CustomerDao;
import com.bookstore.backgroundSys.customerM.dao.impl.CustomerDaoImpl;
import com.bookstore.customer.model.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class queryCustomerByIDAction extends ActionSupport {
	@Autowired
	CustomerDao cd;
    private int id;
    private List<Customer> customers;
    public  queryCustomerByIDAction(){

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    public CustomerDao getCd() {
		return cd;
	}
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	public void validate(){
    	super.validate();
    	if(id==0){
    		this.addFieldError("id", "修改顾客ID不能为空");
    	}
    }
    
    public String execute(){
        customers=cd.queryCustomerByID(id);
        if(customers!=null){
            Map map=ActionContext.getContext().getSession();
            map.put("Cid",id);
            return SUCCESS;
        }else{
            return INPUT;
        }
    }
}
