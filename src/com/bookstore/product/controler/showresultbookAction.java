package com.bookstore.product.controler;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bookstore.product.model.Book;
import com.bookstore.product.model.BookType;
import com.bookstore.product.model.Collection;
import com.bookstore.product.service.productService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class showresultbookAction extends ActionSupport {
	private String bookmessage;
	private productService productservice;
	private List<Book> book_list;
	private List<Collection> collection_list;
	private String ErrorMessage;
	private int status;
	private String title;

	private int totalbooknum = 0;// 书的总数
	private int now_page = 1;// 当前页码。
	private final int maxnum = 5;// 一页最大容量
	private int totalnum = 1;// 总页数。

	public int getTotalbooknum() {
		return totalbooknum;
	}

	public void setTotalbooknum(int totalbooknum) {
		this.totalbooknum = totalbooknum;
	}

	public int getNow_page() {
		return now_page;
	}

	public void setNow_page(int now_page) {
		this.now_page = now_page;
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

	public List<Collection> getCollection_list() {
		return collection_list;
	}

	public void setCollection_list(List<Collection> collection_list) {
		this.collection_list = collection_list;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}

	public productService getProductservice() {
		return productservice;
	}

	public void setProductservice(productService productservice) {
		this.productservice = productservice;
	}

	public List<Book> getBook_list() {
		return book_list;
	}

	public void setBook_list(List<Book> book_list) {
		this.book_list = book_list;
	}

	public String getBookmessage() {
		return bookmessage;
	}

	public void setBookmessage(String bookmessage) {
		this.bookmessage = bookmessage;
	}

	public String collect() {
		title = "我的收藏";
		status = 1;
		Map m = ActionContext.getContext().getSession();
		if (!m.containsKey("caccount")) {
			ErrorMessage = "请先登录！";
			return SUCCESS;
		}
		int cid = Integer.parseInt(m.get("cid").toString());
		collection_list = productservice.findcollection(1, 0, cid);
		if (collection_list == null) {
			ErrorMessage = "内容为空！";
			return SUCCESS;
		}
		totalbooknum = collection_list.size();
		if (totalbooknum % maxnum == 0) {
			totalnum = totalbooknum / maxnum;
		} else {
			totalnum = totalbooknum / maxnum + 1;
		}
		System.out.println("now_page:" + now_page + ";totalbooknum:"
				+ totalbooknum + ";totalnum:" + totalnum);
		if (now_page <= 0) {
			now_page = 1;
		} else if (now_page > totalnum) {
			now_page = totalnum;
		}
		collection_list = productservice.findcollection(now_page, maxnum, cid);
		book_list = new ArrayList();
		for (int i = 0; i < collection_list.size(); i++) {
			book_list.add((Book) (collection_list.get(i).getBook()));
			if (book_list.get(i).getAuthor().length() > 13) {
				book_list.get(i).setAuthor(
						book_list.get(i).getAuthor().substring(0, 13) + "....");
			}
			if (book_list.get(i).getProfile().length() > 80) {
				book_list.get(i)
						.setProfile(
								book_list.get(i).getProfile().substring(0, 80)
										+ "....");
			}
		}
		m.put("now_page", now_page);
		m.put("totalnum", totalnum);
		return SUCCESS;
	}

	public String execute() throws Exception {
		title = "搜索结果";
		status = 0;

		book_list = productservice.showAllbookbysousuo(bookmessage);
		if (book_list == null) {
			ErrorMessage = "内容为空！";
			return SUCCESS;
		}
		for (int i = 0; i < book_list.size(); i++) {
			if (book_list.get(i).getAuthor().length() > 13) {
				book_list.get(i).setAuthor(
						book_list.get(i).getAuthor().substring(0, 13) + "....");
			}
			if (book_list.get(i).getProfile().length() > 50) {
				book_list.get(i)
						.setProfile(
								book_list.get(i).getProfile().substring(0, 50)
										+ "....");
			}
		}
		return SUCCESS;
	}
}
