package com.bookstore.product.dao;

import java.util.List;

import com.bookstore.customer.model.Customer;
import com.bookstore.product.model.Book;
import com.bookstore.product.model.BookType;
import com.bookstore.product.model.Collection;
import com.bookstore.product.model.Comment;
import com.bookstore.shoppingcart.model.ShoppingCart;
import com.bookstore.shoppingcart.model.ShoppingCartInfo;


public interface productDao {
	public  List<BookType> findBookType(); 
	public  Book findonebookbyID(int id);
	public int getmaxbookid();
	public Book queryBookById(int id);
	public List<Book> shownewbook();
	public List<Book> showhotbook();
	public int	showbookbyTypeId_num(int Page_booktype_num,int Page_booktype_id,int Page_bookstatus);
	public int showAllbookbyTypeId_num(int Page_booktype_num,int Page_booktype_id);
	public List<Book> showbookbyTypeId(int now_page,int maxnum,int Page_booktype_num,int Page_booktype_id,int Page_bookstatus);
	public List<Book> showAllbookbyTypeId(int now_page,int maxnum,int Page_booktype_num,int Page_booktype_id);
	public List<Book> showAllbookbysousuo(String bookmessage);
	public int savecollection(Collection collection);
	public ShoppingCart findCustomerShoppingcart(Customer customer);
	public ShoppingCartInfo findCustomerShoppingcartInfo(ShoppingCart shoppingcart,Book book);
	public int saveCustomerShoppingcart(ShoppingCart shoppingCart);
	public int saveCustomerShoppingcartInfo(ShoppingCartInfo shoppingCartInfo);
	public double checkCustomerShoppingcartInfoallprice(ShoppingCart shoppingCart);
	public int updateCustomerShoppingcartInfo(ShoppingCartInfo shoppingCartInfo);
	public int updateCustomerShoppingcart(int cartid,double allprice);
	public int saveCustomerComment(Comment comment);
	public List<Comment> showAllCommentbybookid(int now_page,int maxnum,int bookid);
	public Collection checkcollection(int bookid,int customerid);
	public void deletecollection(int bookid,int customerid) ;
	   public List<Collection> findcollection(int now_page,int maxnum,int customerid);
		  public void upatebooklookmount(Book book);
}
