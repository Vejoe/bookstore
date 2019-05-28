package com.bookstore.backgroundSys.customerM.actions;

import com.bookstore.backgroundSys.customerM.dao.CustomerDao;
import com.bookstore.backgroundSys.customerM.dao.impl.CustomerDaoImpl;
import com.bookstore.customer.model.Customer;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class queryCustomerAction extends ActionSupport {
	@Autowired
	CustomerDao cd;
    List<Customer> customers;
    private Customer customer;
    private int id; 
    private final int pageSize=5;
    private int pageNo=1; 
    private int currentPage; 
    private int totalPage; 
    public queryCustomerAction(){

    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPageSize() {
        return pageSize;
    }
    public int getPageNo() {
        return pageNo;
    }
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
    public CustomerDao getCd() {
		return cd;
	}
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	public String execute(){
        customers=cd.queryCustomer();
        if(customers.size()%pageSize==0){
            totalPage=customers.size()/pageSize;
        }else{
            totalPage=customers.size()/pageSize+1;
        }
        if(pageNo<=0){
            pageNo=1;
        }else if(pageNo>totalPage){
            pageNo=totalPage;
        }
        customers=cd.queryByPage(pageNo,pageSize);
        currentPage=pageNo;
        if(customers!=null)
            return SUCCESS;
        else
            return INPUT;
    }
}
