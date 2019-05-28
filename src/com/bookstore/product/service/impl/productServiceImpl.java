package com.bookstore.product.service.impl;

import java.util.List;

import com.bookstore.customer.model.Customer;
import com.bookstore.product.dao.productDao;
import com.bookstore.product.model.Book;
import com.bookstore.product.model.BookType;
import com.bookstore.product.model.Collection;
import com.bookstore.product.model.Comment;
import com.bookstore.shoppingcart.model.ShoppingCart;
import com.bookstore.shoppingcart.model.ShoppingCartInfo;
import com.bookstore.product.service.productService;

public class productServiceImpl implements productService{
	productDao productdao;
	
	public productDao getProductdao() {
		return productdao;
	}

	public void setProductdao(productDao productdao) {
		this.productdao = productdao;
	}

	public List<BookType> findBookType(){
		return productdao.findBookType();
	}
	public int getmaxbookid(){
		return productdao.getmaxbookid();
	}
	public Book queryBookById(int id){
		return productdao.queryBookById(id);
	}
	public List<Book> shownewbook(){
		return productdao.shownewbook();
	}
	public List<Book> showhotbook(){
		return productdao.showhotbook();
	}
	public List<Book> showbookbyTypeId(int now_page,int maxnum,int Page_booktype_num,int Page_booktype_id,int Page_bookstatus){
		return productdao.showbookbyTypeId(now_page,maxnum,Page_booktype_num,Page_booktype_id,Page_bookstatus);
	}
	public List<Book> showAllbookbyTypeId(int now_page,int maxnum,int Page_booktype_num,int Page_booktype_id){
		return productdao.showAllbookbyTypeId(now_page,maxnum,Page_booktype_num,Page_booktype_id);
	}
	public int	showbookbyTypeId_num(int Page_booktype_num,int Page_booktype_id,int Page_bookstatus){
		return productdao.showbookbyTypeId_num(Page_booktype_num,Page_booktype_id,Page_bookstatus);
	}
	public int showAllbookbyTypeId_num(int Page_booktype_num,int Page_booktype_id){
		return productdao.showAllbookbyTypeId_num(Page_booktype_num, Page_booktype_id);
	}
	public  Book  findonebookbyID(int id){
		return productdao.findonebookbyID(id);
	}
	public List<Book> showAllbookbysousuo(String bookmessage){
		return productdao.showAllbookbysousuo(bookmessage);
	}
	public int savecollection(Collection collection){
		return productdao.savecollection(collection);
	}
	public ShoppingCart findCustomerShoppingcart(Customer customer){
		return productdao.findCustomerShoppingcart(customer);
	}
	public ShoppingCartInfo findCustomerShoppingcartInfo(ShoppingCart shoppingcart,Book book){
		return productdao.findCustomerShoppingcartInfo(shoppingcart, book);
	}
	public int saveCustomerShoppingcart(ShoppingCart shoppingCart){
		return productdao.saveCustomerShoppingcart(shoppingCart);
	}
	public int saveCustomerShoppingcartInfo(ShoppingCartInfo shoppingCartInfo){
		return productdao.saveCustomerShoppingcartInfo(shoppingCartInfo);
	}
	public int updateCustomerShoppingcartInfo(ShoppingCartInfo shoppingCartInfo){
		return productdao.updateCustomerShoppingcartInfo(shoppingCartInfo);
	}
	public double checkCustomerShoppingcartInfoallprice(ShoppingCart shoppingCart){
		return productdao.checkCustomerShoppingcartInfoallprice(shoppingCart);
	}
	public int updateCustomerShoppingcart(int cartid,double allprice){
		return productdao.updateCustomerShoppingcart(cartid,allprice);
	}
	public int saveCustomerComment(Comment comment){
		return productdao.saveCustomerComment(comment);
	}
	public List<Comment> showAllCommentbybookid(int now_page,int maxnum,int bookid){
		return productdao.showAllCommentbybookid(now_page, maxnum, bookid);
	}
	public Collection checkcollection(int bookid,int customerid){
		return productdao.checkcollection(bookid, customerid);
	}
	public void deletecollection(int bookid,int customerid) {
		productdao.deletecollection(bookid, customerid);
	}
	   public List<Collection> findcollection(int now_page,int maxnum,int customerid){
		   return productdao.findcollection(now_page,maxnum,customerid);
	   }
		  public void upatebooklookmount(Book book){
			  productdao.upatebooklookmount(book);
		  }
}
