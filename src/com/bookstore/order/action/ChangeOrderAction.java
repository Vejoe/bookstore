package com.bookstore.order.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.consignee.interfaces.ConsigneeDaoInterface;
import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.bookstore.order.dao.OrderDao;

import com.bookstore.product.dao.productDao;
import com.bookstore.product.model.Book;
import com.bookstore.shoppingcart.dao.ShoppingCartDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Order;
import model.Orderdetail;

public class ChangeOrderAction  extends ActionSupport{
	@Autowired
	CustomerDaoInterface cd;
	productDao pd;
	OrderDao od;
	
	Book book;
	Customer customer;
	Order order;
	private String recevstatus="已收货";
	private int bookdealmount;	//销售量
	private double pay_sum;		//顾客存储金额
	private int cid; //用户Id
	private int orderid;//订单id
	private int id;//索引id
	private int bookid;//图书id
	List<Orderdetail> Orderdetails;
	
	public ChangeOrderAction(){}

	public CustomerDaoInterface getCd() {
		return cd;
	}

	public void setCd(CustomerDaoInterface cd) {
		this.cd = cd;
	}

	public productDao getPd() {
		return pd;
	}

	public void setPd(productDao pd) {
		this.pd = pd;
	}

	public OrderDao getOd() {
		return od;
	}

	public void setOd(OrderDao od) {
		this.od = od;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getRecevstatus() {
		return recevstatus;
	}

	public void setRecevstatus(String recevstatus) {
		this.recevstatus = recevstatus;
	}

	public int getBookdealmount() {
		return bookdealmount;
	}

	public void setBookdealmount(int bookdealmount) {
		this.bookdealmount = bookdealmount;
	}

	public double getPay_sum() {
		return pay_sum;
	}

	public void setPay_sum(double pay_sum) {
		this.pay_sum = pay_sum;
	}
	
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Orderdetail> getOrderdetails() {
		return Orderdetails;
	}

	public void setOrderdetails(List<Orderdetail> orderdetails) {
		Orderdetails = orderdetails;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String execute(){
		Map m=ActionContext.getContext().getSession();//获得当前Session集合
		customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());//根据账号获得当前用户		
		cid=customer.getId();//获得用户id
		pay_sum=od.getOrderpriceById(id);//得到价格
		
		Orderdetails=od.getOrderdetailByorderid(id);//几个
		for(int i=0;i<Orderdetails.size();i++){
			bookid=Orderdetails.get(i).getBook().getId();//得到当前bookid
			bookdealmount=Orderdetails.get(i).getOrdermount();//得到当前的书的销售量
			od.changebookdealmount(bookid,bookdealmount);//修改bookdealmount
		}
		
		od.changepay_sum(pay_sum,cid);//修改pay_sum
		od.changerecevstatus(recevstatus,id);//修改recevstatus
		return SUCCESS;
		
	}
}
