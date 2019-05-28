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
	private String recevstatus="���ջ�";
	private int bookdealmount;	//������
	private double pay_sum;		//�˿ʹ洢���
	private int cid; //�û�Id
	private int orderid;//����id
	private int id;//����id
	private int bookid;//ͼ��id
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
		Map m=ActionContext.getContext().getSession();//��õ�ǰSession����
		customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());//�����˺Ż�õ�ǰ�û�		
		cid=customer.getId();//����û�id
		pay_sum=od.getOrderpriceById(id);//�õ��۸�
		
		Orderdetails=od.getOrderdetailByorderid(id);//����
		for(int i=0;i<Orderdetails.size();i++){
			bookid=Orderdetails.get(i).getBook().getId();//�õ���ǰbookid
			bookdealmount=Orderdetails.get(i).getOrdermount();//�õ���ǰ�����������
			od.changebookdealmount(bookid,bookdealmount);//�޸�bookdealmount
		}
		
		od.changepay_sum(pay_sum,cid);//�޸�pay_sum
		od.changerecevstatus(recevstatus,id);//�޸�recevstatus
		return SUCCESS;
		
	}
}
