package com.bookstore.shoppingcart.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.shoppingcart.dao.ShoppingCartDao;
import com.bookstore.shoppingcart.model.*;
public class ShowShoppingCartAction extends ActionSupport{
	List<ShoppingCartInfo> shoppingcartinfos=new  ArrayList <ShoppingCartInfo>();
	@Autowired
	ShoppingCartDao shoppingcartdao;
	CustomerDaoInterface cd;
	private Customer customer;
	private ShoppingCartInfo shoppingcartinfo;
	private ShoppingCart shoppingcart;
	private int cid;
	private int cartid;
	private int id; //界面显示数据的索引
	private final int pageSize=5; //每页显示记录的个数
	private int pageNo=1; //计数器,从第1页开始显示
	private int currentPage; //当前页
	private int totalPage; //总页数
	private int ordermount;//记录该商品的数量
	private double price;//记录该商品的总价
	private double allprice;//记录该购物车的所有总价
	
	public ShowShoppingCartAction(){}



	public List<ShoppingCartInfo> getShoppingcartinfos() {
		return shoppingcartinfos;
	}



	public void setShoppingcartinfos(List<ShoppingCartInfo> shoppingcartinfos) {
		this.shoppingcartinfos = shoppingcartinfos;
	}



	public CustomerDaoInterface getCd() {
		return cd;
	}



	public void setCd(CustomerDaoInterface cd) {
		this.cd = cd;
	}



	public ShoppingCartDao getShoppingcartdao() {
		return shoppingcartdao;
	}

	public void setShoppingcartdao(ShoppingCartDao shoppingcartdao) {
		this.shoppingcartdao = shoppingcartdao;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getPageSize() {
		return pageSize;
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

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public String execute()throws Exception{
		System.out.println("!!!!!!!!!!!!!!!!!!");
		Map m=ActionContext.getContext().getSession();//获得当前Session集合
		customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());
		/*customer=(Customer)m.get("customer");//根据账号获得当前用户
*/		cid=customer.getId();//获得用户id
		if(shoppingcartdao.getshoppingcartid(cid)==0)return INPUT;
		cartid=shoppingcartdao.getshoppingcartid(cid);//获得购物车id
		//获得所有数据，得到数据的总个数
		shoppingcartinfos=shoppingcartdao.showshoppingcartInfo(cartid);
		//计算总页数
		if(shoppingcartinfos.size()%pageSize==0){
			totalPage=shoppingcartinfos.size()/pageSize;
		}else{
			totalPage=shoppingcartinfos.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//根据当前页查询要在该页上显示的数据
		shoppingcartinfos=shoppingcartdao.queryByPage(pageNo,pageSize,cartid);
		//设置当前页
		currentPage=pageNo;
		shoppingcart=shoppingcartdao.getshoppingcart(cid);
		if(shoppingcartinfos!=null&&shoppingcart!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
