package com.bookstore.shoppingcart.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.consignee.interfaces.ConsigneeDaoInterface;
import com.bookstore.consignee.model.Consignee;
import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.bookstore.order.dao.OrderDao;
import com.bookstore.product.dao.productDao;
import com.bookstore.shoppingcart.dao.ShoppingCartDao;
import com.bookstore.shoppingcart.model.ShoppingCart;
import com.bookstore.shoppingcart.model.ShoppingCartInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BuildOrderAtion  extends ActionSupport{
	@Autowired
	ShoppingCartDao sc;
	CustomerDaoInterface cd;
	ConsigneeDaoInterface csgd;
	productDao pd;
	ShoppingCartDao sd;
	OrderDao od;
	
	Consignee consignee;
	Customer customer;
	ShoppingCartInfo shoppingcartinfo;
	ShoppingCart shoppingcart;
	List<Consignee> consignees;
	List<ShoppingCartInfo> shoppingcartinfos;
	private int cid;
	private int cartid;
	public ShoppingCartDao getSc() {
		return sc;
	}
	public void setSc(ShoppingCartDao sc) {
		this.sc = sc;
	}
	public CustomerDaoInterface getCd() {
		return cd;
	}
	public void setCd(CustomerDaoInterface cd) {
		this.cd = cd;
	}
	public ConsigneeDaoInterface getCsgd() {
		return csgd;
	}
	public void setCsgd(ConsigneeDaoInterface csgd) {
		this.csgd = csgd;
	}
	public productDao getPd() {
		return pd;
	}
	public void setPd(productDao pd) {
		this.pd = pd;
	}
	public ShoppingCartDao getSd() {
		return sd;
	}
	public void setSd(ShoppingCartDao sd) {
		this.sd = sd;
	}
	public OrderDao getOd() {
		return od;
	}
	public void setOd(OrderDao od) {
		this.od = od;
	}
	public Consignee getConsignee() {
		return consignee;
	}
	public void setConsignee(Consignee consignee) {
		this.consignee = consignee;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public ShoppingCartInfo getShoppingcartinfo() {
		return shoppingcartinfo;
	}
	public void setShoppingcartinfo(ShoppingCartInfo shoppingcartinfo) {
		this.shoppingcartinfo = shoppingcartinfo;
	}
	public ShoppingCart getShoppingcart() {
		return shoppingcart;
	}
	public void setShoppingcart(ShoppingCart shoppingcart) {
		this.shoppingcart = shoppingcart;
	}
	public List<Consignee> getConsignees() {
		return consignees;
	}
	public void setConsignees(List<Consignee> consignees) {
		this.consignees = consignees;
	}
	public List<ShoppingCartInfo> getShoppingcartinfos() {
		return shoppingcartinfos;
	}
	public void setShoppingcartinfos(List<ShoppingCartInfo> shoppingcartinfos) {
		this.shoppingcartinfos = shoppingcartinfos;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	
	
	public String execute()throws Exception{
		System.out.println("跳转到订单");
		Map m=ActionContext.getContext().getSession();//获得当前Session集合
		customer=(Customer)m.get("customer");//根据账号获得当前用户
		/*customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());*/
		cid=customer.getId();//获得用户id
		cartid=sc.getshoppingcartid(cid);//获得购物车id
		//获得所有数据，得到数据的总个数
		shoppingcartinfos=sc.showshoppingcartInfo(cartid);
		shoppingcart=sc.getshoppingcart(cid);
		
		consignees=csgd.QueryCustomerConsigneeBycaccount(m.get("caccount").toString());//当前账号的所有收货人
		if(consignees!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
