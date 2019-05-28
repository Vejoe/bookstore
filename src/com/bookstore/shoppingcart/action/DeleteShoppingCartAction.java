package com.bookstore.shoppingcart.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.bookstore.shoppingcart.dao.ShoppingCartDao;
import com.bookstore.shoppingcart.model.ShoppingCart;
import com.bookstore.shoppingcart.model.ShoppingCartInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteShoppingCartAction extends ActionSupport{
	private int id;
	private  double price;
	private ShoppingCartInfo shoppingcartinfo;
	private ShoppingCart shoppingcart;
	private Customer customer;
	CustomerDaoInterface cd;
	private int cid;
	private double allprice;
	private int cartid;
	@Autowired
	ShoppingCartDao shoppingcartdao;
	
	public DeleteShoppingCartAction(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public ShoppingCartDao getShoppingcartdao() {
		return shoppingcartdao;
	}
	public void setShoppingcartdao(ShoppingCartDao shoppingcartdao) {
		this.shoppingcartdao = shoppingcartdao;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public ShoppingCartInfo getShoppingcartinfo() {
		return shoppingcartinfo;
	}
	public void setShoppingcartinfo(ShoppingCartInfo shoppingcartinfo) {
		this.shoppingcartinfo = shoppingcartinfo;
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
	
	
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public ShoppingCart getShoppingcart() {
		return shoppingcart;
	}
	public void setShoppingcart(ShoppingCart shoppingcart) {
		this.shoppingcart = shoppingcart;
	}
	public double getAllprice() {
		return allprice;
	}
	public void setAllprice(double allprice) {
		this.allprice = allprice;
	}
	public String execute()throws Exception{
		System.out.println("删除购物车");
		Map m=ActionContext.getContext().getSession();//获得当前Session集合
		customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());
		/*customer=(Customer)m.get("customer");//根据账号获得当前用户
*/		cid=customer.getId();//获得用户id
		shoppingcartinfo=shoppingcartdao.queryShoppingCartInfoById(id);//得到当前
		shoppingcart=shoppingcartdao.getshoppingcart(cid);
		cartid=shoppingcartdao.getshoppingcartid(cid);
		
		price=shoppingcart.getAllprice()-shoppingcartinfo.getPrice();
		if(shoppingcart!=null&&shoppingcartdao.deleteShoppingCartInfoById(id)){
			if(shoppingcartdao.querShoppingCartBycid(cartid)==null)shoppingcartdao.deleteShoppingCartbycid(cid);
			shoppingcartdao.setshoppingcartallprice(cid, price);
			return SUCCESS;
		}
			
			
		else{
			addFieldError("error","删除失败！");
			return INPUT;
		}
	}
}
