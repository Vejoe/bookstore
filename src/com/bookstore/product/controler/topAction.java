package com.bookstore.product.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bookstore.product.model.BookType;
import com.bookstore.product.model.Collection;
import com.bookstore.product.service.productService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class topAction extends ActionSupport {
	private productService productservice;
	private List<BookType> booktype_list;
	private List<Collection> collection;

	public List<Collection> getCollection() {
		return collection;
	}

	public void setCollection(List<Collection> collection) {
		this.collection = collection;
	}

	public productService getProductservice() {
		return productservice;
	}

	public void setProductservice(productService productservice) {
		this.productservice = productservice;
	}

	public List<BookType> getBooktype_list() {
		return booktype_list;
	}

	public void setBooktype_list(List<BookType> booktype_list) {
		this.booktype_list = booktype_list;
	}

	public String execute() throws Exception {
		collection = new ArrayList();
		Map m = ActionContext.getContext().getSession();
		if (!m.containsKey("booktype_list")) {
			System.out.println("topAction!!!!!!!!!");
			booktype_list = productservice.findBookType();// 主页的书籍的类型。
			m.put("booktype_list", booktype_list);
		}
		if (m.containsKey("cid")) {
			int customerid = Integer.parseInt(m.get("cid").toString());
			collection = productservice.findcollection(1, 5, customerid);
			m.put("collection", collection);
		}
		return SUCCESS;
	}
}
