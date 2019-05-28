package com.bookstore.shoppingcart.model;

import java.util.HashSet;
import java.util.Set;
import com.bookstore.customer.model.Customer;;
public class ShoppingCart {
	private int id;
	private Customer customer;
	private double allprice;
	
	public ShoppingCart(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public double getAllprice() {
		return allprice;
	}

	public void setAllprice(double allprice) {
		this.allprice = allprice;
	}
	
	
}
