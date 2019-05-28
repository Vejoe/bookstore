package com.bookstore.product.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bookstore.product.model.Book;
import com.bookstore.product.model.BookType;
import com.bookstore.product.service.productService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class showbookAction extends ActionSupport {
	private productService productservice;
	private int Page_booktype_id = 0;
	private int Page_booktype_num = 0;
	private int Page_bookstatus = 0;

	private int totalbooknum = 0;//
	private int now_page = 1;// 当前页码。
	private final int maxnum = 8;// 一页最大容量
	private int totalnum = 1;// 总页数。

	private List<Book> book_list = new ArrayList();

	public int getNow_page() {
		return now_page;
	}

	public void setNow_page(int now_page) {
		this.now_page = now_page;
	}

	public int getTotalbooknum() {
		return totalbooknum;
	}

	public void setTotalbooknum(int totalbooknum) {
		this.totalbooknum = totalbooknum;
	}

	public int getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}

	public int getMaxnum() {
		return maxnum;
	}

	public List<Book> getBook_list() {
		return book_list;
	}

	public void setBook_list(List<Book> book_list) {
		this.book_list = book_list;
	}

	public int getPage_booktype_id() {
		return Page_booktype_id;
	}

	public void setPage_booktype_id(int page_booktype_id) {
		Page_booktype_id = page_booktype_id;
	}

	public int getPage_booktype_num() {
		return Page_booktype_num;
	}

	public void setPage_booktype_num(int page_booktype_num) {
		Page_booktype_num = page_booktype_num;
	}

	public int getPage_bookstatus() {
		return Page_bookstatus;
	}

	public void setPage_bookstatus(int page_bookstatus) {
		Page_bookstatus = page_bookstatus;
	}

	public productService getProductservice() {
		return productservice;
	}

	public void setProductservice(productService productservice) {
		this.productservice = productservice;
	}

	public String showbook() {
		System.out.println(Page_booktype_id + "!!" + Page_booktype_num + "!!"
				+ Page_bookstatus);
		System.out.println(Page_bookstatus == 0);
		if (Page_bookstatus == 0) {
			totalbooknum = productservice.showAllbookbyTypeId_num(
					Page_booktype_num, Page_booktype_id);
		} else {
			totalbooknum = productservice.showbookbyTypeId_num(
					Page_booktype_num, Page_booktype_id, Page_bookstatus);
		}
		if (totalbooknum % maxnum == 0) {
			totalnum = totalbooknum / maxnum;
		} else {
			totalnum = totalbooknum / maxnum + 1;
		}
		if (now_page <= 0) {
			now_page = 1;
		} else if (now_page > totalnum) {
			now_page = totalnum;
		}
		if (Page_bookstatus == 0) {
			book_list = productservice.showAllbookbyTypeId(now_page, maxnum,
					Page_booktype_num, Page_booktype_id);
		} else {
			book_list = productservice.showbookbyTypeId(now_page, maxnum,
					Page_booktype_num, Page_booktype_id, Page_bookstatus);
		}
		Map m = ActionContext.getContext().getSession();
		m.put("totalnum", totalnum);
		m.put("now_page", now_page);
		return SUCCESS;
	}
}
