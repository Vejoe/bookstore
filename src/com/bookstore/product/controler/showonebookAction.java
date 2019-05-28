package com.bookstore.product.controler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.bookstore.customer.model.Customer;
import com.bookstore.product.model.Book;
import com.bookstore.product.model.BookType;
import com.bookstore.product.model.Collection;
import com.bookstore.product.model.Comment;
import com.bookstore.shoppingcart.model.ShoppingCartInfo;
import com.bookstore.product.service.productService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.bookstore.shoppingcart.model.ShoppingCart;

public class showonebookAction extends ActionSupport {
	private productService productservice;
	private int bookid;
	private Book book;
	private String bookjianjie;
	private Collection collection;
	private int collectstatus;
	private Comment comment;
	private List<Comment> list_comment;
	private int Loginstatus;
	private String commentcontent;
	String time;

	private int totalbooknum = 0;// 书的总数
	private int now_page = 1;// 当前页码。
	private final int maxnum = 5;// 一页最大容量
	private int totalnum = 1;// 总页数。

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCommentcontent() {
		return commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}

	public int getLoginstatus() {
		return Loginstatus;
	}

	public void setLoginstatus(int loginstatus) {
		Loginstatus = loginstatus;
	}

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

	public List<Comment> getList_comment() {
		return list_comment;
	}

	public void setList_comment(List<Comment> list_comment) {
		this.list_comment = list_comment;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public int getCollectstatus() {
		return collectstatus;
	}

	public void setCollectstatus(int collectstatus) {
		this.collectstatus = collectstatus;
	}

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	public String getBookjianjie() {
		return bookjianjie;
	}

	public void setBookjianjie(String bookjianjie) {
		this.bookjianjie = bookjianjie;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public productService getProductservice() {
		return productservice;
	}

	public void setProductservice(productService productservice) {
		this.productservice = productservice;
	}

	public void jiazaiziliao() {
		book = productservice.findonebookbyID(bookid);
		bookjianjie = book.getProfile();
		if (bookjianjie.length() > 170) {
			bookjianjie = bookjianjie.substring(0, 170) + "....";
		}
		if (book.getAuthor().length() > 13) {
			book.setAuthor(book.getAuthor().substring(0, 13) + "....");
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		time = format.format(book.getPublisher_year());
	}

	public String collection() {
		Map m = ActionContext.getContext().getSession();
		if (!m.containsKey("cid")) {
			Loginstatus = 0;
			return SUCCESS;
		}
		int cid = Integer.parseInt(m.get("cid").toString());
		if (collectstatus == 1) {
			productservice.deletecollection(bookid, cid);
			collectstatus = 0;
			return SUCCESS;
		} else {
			collection = new Collection();
			collection.setCustomerid(cid);
			Book book = productservice.findonebookbyID(bookid);
			collection.setBook(book);
			Collection Checkcollection = new Collection();
			Checkcollection = productservice.checkcollection(bookid, cid);
			if (Checkcollection == null) {
				productservice.savecollection(collection);
				collectstatus = 1;
			}
			collectstatus = 1;
			return SUCCESS;
		}
	}

	public String addComment() {
		Map m = ActionContext.getContext().getSession();
		if (!m.containsKey("cid")) {
			Loginstatus = 0;
			return SUCCESS;
		}
		comment = new Comment();
		comment.setCommentcontent(commentcontent);
		comment.setBookid(bookid);
		String cname = m.get("cname").toString();
		comment.setCname(cname);
		Date date = new Date();
		int cid = Integer.parseInt(m.get("cid").toString());
		comment.setCid(cid);
		comment.setCommentdate(date);
		productservice.saveCustomerComment(comment);
		return SUCCESS;
	}

	public String execute() throws Exception {
		Map m = ActionContext.getContext().getSession();
		Loginstatus = 1;
		if (!m.containsKey("caccount")) {
			Loginstatus = 0;
		}
		jiazaiziliao();
		productservice.upatebooklookmount(book);
		list_comment = productservice.showAllCommentbybookid(1, 0, bookid);
		if (list_comment != null) {
			totalbooknum = list_comment.size();
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
			list_comment = productservice.showAllCommentbybookid(now_page,maxnum, bookid);
		}

		Collection Checkcollection = new Collection();
		m.put("totalnum", totalnum);
		m.put("now_page", now_page);
		if (m.containsKey("caccount")) {
			int cid = Integer.parseInt(m.get("cid").toString());
			Checkcollection = productservice.checkcollection(bookid, cid);
			if (Checkcollection != null) {
				collectstatus = 1;
				return SUCCESS;
			}
		}

		collectstatus = 0;
		return SUCCESS;
	}

	public String addshoppingcart() {
		Map m = ActionContext.getContext().getSession();
		if (!m.containsKey("cid")) {
			Loginstatus = 0;
			return SUCCESS;
		}
		Customer customer = new Customer();
		customer = (Customer) m.get("customer");
		int cid = Integer.parseInt(m.get("cid").toString());
		int rank = Integer.parseInt(m.get("rank").toString());
		System.out.println("bookid:" + bookid);

		ShoppingCart shoppingcart = productservice
				.findCustomerShoppingcart(customer);
		Book book = productservice.findonebookbyID(bookid);// 寻找改书的整个资
		if (shoppingcart != null) {// 有ShoppingCart
			ShoppingCartInfo shoppingCartInfo = productservice
					.findCustomerShoppingcartInfo(shoppingcart, book);// 当前商品有没有放进购物车
			if (shoppingCartInfo != null) {// 有放进购物车
				productservice.updateCustomerShoppingcartInfo(shoppingCartInfo);
				double allprice = productservice
						.checkCustomerShoppingcartInfoallprice(shoppingcart);
				productservice.updateCustomerShoppingcart(shoppingcart.getId(),
						allprice);
			} else {
				shoppingCartInfo = new ShoppingCartInfo();
				System.out.println(book.getAuthor());
				shoppingCartInfo.setBook(book);
				shoppingCartInfo.setBookname(book.getBookname());
				shoppingCartInfo.setOrdermount(1);
				shoppingCartInfo.setPriceofonebook(book.getPrice());
				shoppingCartInfo.setShoppingcart(shoppingcart);
				if (rank == 1) {
					shoppingCartInfo.setPrice(book.getPrice() * 1);
				} else {
					shoppingCartInfo.setPrice(book.getRank_price() * 1);
				}
				productservice.saveCustomerShoppingcartInfo(shoppingCartInfo);
				double allprice = productservice
						.checkCustomerShoppingcartInfoallprice(shoppingcart);
				productservice.updateCustomerShoppingcart(shoppingcart.getId(),
						allprice);
			}
		} else {// 没有ShoppingCart
			shoppingcart = new ShoppingCart();// 创建shoppingcart对象
			shoppingcart.setCustomer(customer);
			shoppingcart.setAllprice(book.getPrice() * 1);
			productservice.saveCustomerShoppingcart(shoppingcart);// 保存新的shoppingcart进数据库
			shoppingcart = productservice.findCustomerShoppingcart(customer);// 取出shoppingcart，用来取id进ShoppingCartInfo
			System.out
					.println("productservice.saveCustomerShoppingcart(shoppingcart);");
			ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo();
			shoppingCartInfo.setBook(book);
			shoppingCartInfo.setBookname(book.getBookname());
			shoppingCartInfo.setShoppingcart(shoppingcart);
			shoppingCartInfo.setOrdermount(1);
			shoppingCartInfo.setPriceofonebook(book.getPrice());
			if (rank == 1) {
				shoppingCartInfo.setPrice(book.getPrice() * 1);
			} else {
				shoppingCartInfo.setPrice(book.getRank_price() * 1);
			}

			productservice.saveCustomerShoppingcartInfo(shoppingCartInfo);
			System.out
					.println("productservice.saveCustomerShoppingcartInfo(shoppingCartInfo);");
		}
		return SUCCESS;
	}
}
