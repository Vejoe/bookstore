package model;

import com.bookstore.product.model.Book;

/**
 * Orderdetail entity. @author MyEclipse Persistence Tools
 */

public class Orderdetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private Book book;
	private Order order;
	private Integer ordermount;
	private Double totalprice;

	// Constructors

	/** default constructor */
	public Orderdetail() {
	}

	/** full constructor */
	public Orderdetail(Book book, Order order, Integer ordermount, Double totalprice) {
		this.book = book;
		this.order = order;
		this.ordermount = ordermount;
		this.totalprice = totalprice;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getOrdermount() {
		return this.ordermount;
	}

	public void setOrdermount(Integer ordermount) {
		this.ordermount = ordermount;
	}

	public Double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

}