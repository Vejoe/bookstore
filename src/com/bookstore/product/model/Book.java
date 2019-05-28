package com.bookstore.product.model;

import java.util.Date;

public class Book {
	private int id;
	private String bookname;
	private String profile;
	private String publisher;
	private Date publisher_year;
	private String author;	
	private double price;
	private int stocks;	
	private double rank_price;	
	private int bookdealmount;	
	private int booklookmount;		
	private String bookfilename;
	private BookType booktype;
	
	
	
	public BookType getBooktype() {
		return booktype;
	}
	public void setBooktype(BookType booktype) {
		this.booktype = booktype;
	}
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
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublisher_year() {
		return publisher_year;
	}
	public void setPublisher_year(Date publisher_year) {
		this.publisher_year = publisher_year;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStocks() {
		return stocks;
	}
	public void setStocks(int stocks) {
		this.stocks = stocks;
	}
	public double getRank_price() {
		return rank_price;
	}
	public void setRank_price(double rank_price) {
		this.rank_price = rank_price;
	}
	public int getBookdealmount() {
		return bookdealmount;
	}
	public void setBookdealmount(int bookdealmount) {
		this.bookdealmount = bookdealmount;
	}
	public int getBooklookmount() {
		return booklookmount;
	}
	public void setBooklookmount(int booklookmount) {
		this.booklookmount = booklookmount;
	}
	public String getBookfilename() {
		return bookfilename;
	}
	public void setBookfilename(String bookfilename) {
		this.bookfilename = bookfilename;
	}	
	
}
