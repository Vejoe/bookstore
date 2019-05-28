package model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.bookstore.consignee.model.Consignee;
import com.bookstore.customer.model.Customer;
import com.bookstore.product.model.Comment;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer id;
	private Consignee consignee;
	private Customer customer;
	private Integer orderaccount;
	private Date orderdate;
	private String message;
	private String postmethod;
	private String paymethod;
	private String poststatus;
	private String recevstatus;
	private Double orderprice;

	// Constructors

	/** default constructor */
	public Order() {
	}

	
	

	/** full constructor */
	public Order(Comment comment, Consignee consignee, Customer customer, int orderaccount, Timestamp orderdate,
			String message, String postmethod, String paymethod, String poststatus, String recevstatus,
			Double orderprice, Set orderdetails) {
		
		this.consignee = consignee;
		this.customer = customer;
		this.orderaccount = orderaccount;
		this.orderdate = orderdate;
		this.message = message;
		this.postmethod = postmethod;
		this.paymethod = paymethod;
		this.poststatus = poststatus;
		this.recevstatus = recevstatus;
		this.orderprice = orderprice;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Consignee getConsignee() {
		return this.consignee;
	}

	public void setConsignee(Consignee consignee) {
		this.consignee = consignee;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	

	public Integer getOrderaccount() {
		return orderaccount;
	}




	public void setOrderaccount(Integer orderaccount) {
		this.orderaccount = orderaccount;
	}




	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPostmethod() {
		return this.postmethod;
	}

	public void setPostmethod(String postmethod) {
		this.postmethod = postmethod;
	}

	public String getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getPoststatus() {
		return this.poststatus;
	}

	public void setPoststatus(String poststatus) {
		this.poststatus = poststatus;
	}

	public String getRecevstatus() {
		return this.recevstatus;
	}

	public void setRecevstatus(String recevstatus) {
		this.recevstatus = recevstatus;
	}

	public Double getOrderprice() {
		return this.orderprice;
	}

	public void setOrderprice(Double orderprice) {
		this.orderprice = orderprice;
	}



}