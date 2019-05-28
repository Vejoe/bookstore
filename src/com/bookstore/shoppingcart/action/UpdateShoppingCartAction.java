package com.bookstore.shoppingcart.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.shoppingcart.dao.ShoppingCartDao;
import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.*;
import com.bookstore.shoppingcart.model.ShoppingCart;
import com.bookstore.shoppingcart.model.ShoppingCartInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateShoppingCartAction extends ActionSupport{
	List<ShoppingCartInfo> shoppingcartinfos;
	@Autowired
	ShoppingCartDao shoppingcartdao;
	CustomerDaoInterface cd;
	
	private int cartid;
	private Customer customer;
	private int cid;
	private ShoppingCartInfo shoppingcartinfo;//���ﳵ��ϸ�����
	private ShoppingCartInfo newshoppingcartinfo;//���ﳵ��ϸ�����
	private ShoppingCart shoppingcart;//���ﳵ�����
	private int id; //������ʾ���ݵ�����
	private int ordermount;
	private double price;
	private double allprice=0;
	
	public UpdateShoppingCartAction(){}
	
	public List<ShoppingCartInfo> getShoppingcartinfos() {
		return shoppingcartinfos;
	}

	public void setShoppingcartinfos1(List<ShoppingCartInfo> shoppingcartinfos) {
		this.shoppingcartinfos = shoppingcartinfos;
	}

	public ShoppingCartDao getShoppingcartdao() {
		return shoppingcartdao;
	}

	public void setShoppingcartdao(ShoppingCartDao shoppingcartdao) {
		this.shoppingcartdao = shoppingcartdao;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
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

	public ShoppingCartInfo getShoppingcartinfo() {
		return shoppingcartinfo;
	}

	public void setShoppingcartinfo(ShoppingCartInfo shoppingcartinfo) {
		this.shoppingcartinfo = shoppingcartinfo;
	}

	public ShoppingCartInfo getNewshoppingcartinfo() {
		return newshoppingcartinfo;
	}

	public void setNewshoppingcartinfo(ShoppingCartInfo newshoppingcartinfo) {
		this.newshoppingcartinfo = newshoppingcartinfo;
	}

	public ShoppingCart getShoppingcart() {
		return shoppingcart;
	}

	public void setShoppingcart(ShoppingCart shoppingcart) {
		this.shoppingcart = shoppingcart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrdermount() {
		return ordermount;
	}

	public void setOrdermount(int ordermount) {
		this.ordermount = ordermount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAllprice() {
		return allprice;
	}

	public void setAllprice(double allprice) {
		this.allprice = allprice;
	}

	public CustomerDaoInterface getCd() {
		return cd;
	}

	public void setCd(CustomerDaoInterface cd) {
		this.cd = cd;
	}

	public String execute(){
		System.out.println("++++++++++++");
		Map m=ActionContext.getContext().getSession();//��õ�ǰSession����
		customer=(Customer)m.get("customer");//�����˺Ż�õ�ǰ�û�
		customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());
		cid=customer.getId();//����û�id
		cartid=shoppingcartdao.getshoppingcartid(cid);//��ù��ﳵid
		shoppingcartinfo=shoppingcartdao.queryShoppingCartInfoById(id);//�õ���ǰ
		ordermount=shoppingcartinfo.getOrdermount();//��õ�ǰ����
		price=shoppingcartinfo.getPrice();//��ǰ���ܼ۸�
		if(shoppingcartdao.addShoppingcartbook(id,ordermount,price)){
			shoppingcartinfos=shoppingcartdao.showshoppingcartInfo(cartid);//�õ����ﳵ����		
			for(int i=0;i<shoppingcartinfos.size();i++){
				allprice+=shoppingcartinfos.get(i).getPrice();
				
			}
			System.out.println(allprice);
			shoppingcartdao.setshoppingcartallprice(cid,allprice);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
