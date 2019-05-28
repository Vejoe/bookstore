package com.bookstore.order.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.bookstore.order.dao.OrderDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReturnOrderAction  extends ActionSupport{
	
	private int id;//����id
	@Autowired
	OrderDao od;
	Customer customer;
	CustomerDaoInterface cd;
	private String recevstatus="�����˻�";
	private int cid;
	public ReturnOrderAction(){}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public OrderDao getOd() {
		return od;
	}


	public void setOd(OrderDao od) {
		this.od = od;
	}


	public String getRecevstatus() {
		return recevstatus;
	}


	public void setRecevstatus(String recevstatus) {
		this.recevstatus = recevstatus;
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


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String execute(){
		Map m=ActionContext.getContext().getSession();//��õ�ǰSession����
		customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());//�����˺Ż�õ�ǰ�û�		
		cid=customer.getId();//����û�id
		od.changerecevstatus(recevstatus,id);//�޸�recevstatus
		return SUCCESS;
		
	}
}
