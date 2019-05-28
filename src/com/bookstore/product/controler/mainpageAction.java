package com.bookstore.product.controler;

import java.util.*;

import com.bookstore.product.model.Book;
import com.bookstore.product.model.BookType;
import com.bookstore.product.service.productService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class mainpageAction extends ActionSupport {
	private BookType booktype;
	private productService productservice;
	private List<Book> lunbo_book;
	private List<Book> new_book;
	private List<Book> hot_book;

	public BookType getBooktype() {
		return booktype;
	}

	public void setBooktype(BookType booktype) {
		this.booktype = booktype;
	}

	public productService getProductservice() {
		return productservice;
	}

	public void setProductservice(productService productservice) {
		this.productservice = productservice;
	}

	public List<Book> getLunbo_book() {
		return lunbo_book;
	}

	public void setLunbo_book(List<Book> lunbo_book) {
		this.lunbo_book = lunbo_book;
	}

	public List<Book> getHot_book() {
		return hot_book;
	}

	public void setHot_book(List<Book> hot_book) {
		this.hot_book = hot_book;
	}

	public List<Book> getNew_book() {
		return new_book;
	}

	public void setNew_book(List<Book> new_book) {
		this.new_book = new_book;
	}

	public void lunbo() {// 主页书籍的轮播。
		int maxid = productservice.getmaxbookid();
		int a[] = new int[5];
		boolean check;
		Book book = new Book();
		lunbo_book = new ArrayList();
		Random random = new Random();
		System.out.println(maxid);
		for (int i = 0; i < 5; i++) {
			check = false;
			while (book == null || !check) {
				check = true;
				int randomNumber1 = random.nextInt(maxid) + 1;
				System.out.println("1-----------------------" + randomNumber1);
				for (int j = 0; j <= i; j++) {
					if (randomNumber1 == a[j]) {
						System.out.println("2-----------------------");
						check = false;
						break;
					}
				}
				if (check) {
					book = productservice.queryBookById(randomNumber1);
					System.out.println("3-----------------------");
					if (book == null) {
						System.out.println("4-----------------------");
						continue;
					}
					lunbo_book.add(book);
					a[i] = randomNumber1;
				}
			}
		}
	}

	public String execute() throws Exception {
		lunbo();// 主页书籍的轮播。
		new_book = productservice.shownewbook();
		hot_book = productservice.showhotbook();
		return SUCCESS;

	}

}
