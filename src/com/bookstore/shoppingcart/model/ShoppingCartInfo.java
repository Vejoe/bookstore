package com.bookstore.shoppingcart.model;

import java.util.HashSet;
import java.util.Set;
import com.bookstore.customer.model.Customer;
import com.bookstore.product.model.Book;
public class ShoppingCartInfo {
	private int id;
	private ShoppingCart shoppingcart;
	private String bookname;
	private double priceofonebook;
	private double price;
	private Book book;
	private int ordermount;
		
	public ShoppingCartInfo(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public double getPriceofonebook() {
		return priceofonebook;
	}

	public void setPriceofonebook(double priceofonebook) {
		this.priceofonebook = priceofonebook;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



	public int getOrdermount() {
		return ordermount;
	}

	public void setOrdermount(int ordermount) {
		this.ordermount = ordermount;
	}



	public ShoppingCart getShoppingcart() {
		return shoppingcart;
	}

	public void setShoppingcart(ShoppingCart shoppingcart) {
		this.shoppingcart = shoppingcart;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	
	
}
