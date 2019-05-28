package com.bookstore.shoppingcart.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.shoppingcart.dao.ShoppingCartDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.bookstore.customer.model.*;
import com.bookstore.customer.dao.*;
import com.bookstore.customer.interfaces.CustomerDaoInterface;
public class DelAllShoppingCartAction extends ActionSupport{
	private int id;
	@Autowired
	ShoppingCartDao scd;
	CustomerDaoInterface cd;
	private Customer customer;
	private int cartid;
	private int cid;
	public DelAllShoppingCartAction(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ShoppingCartDao getScd() {
		return scd;
	}

	public void setScd(ShoppingCartDao scd) {
		this.scd = scd;
	}
	
	public CustomerDaoInterface getCd() {
		return cd;
	}

	public void setCd(CustomerDaoInterface cd) {
		this.cd = cd;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String execute()throws Exception{
		Map m=ActionContext.getContext().getSession();//��õ�ǰSession����
		customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());
		cid=customer.getId();//����û�id
		cartid=scd.getshoppingcartid(cid);//�õ���ǰ�Ĺ��ﳵid
		
		if(scd.deleteShoppingCartBycartid(cartid)){
			scd.deleteShoppingCartbycid(cid);
			return SUCCESS;
		}
			
		else
			addFieldError("error","ɾ��ʧ�ܣ�");
			return INPUT;
	}
}
