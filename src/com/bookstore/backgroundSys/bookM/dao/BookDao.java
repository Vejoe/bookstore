package com.bookstore.backgroundSys.bookM.dao;

import java.util.List;

import com.bookstore.product.model.Book;
import com.bookstore.product.model.BookType;



public interface BookDao {
	public int addBookType(BookType booktype);
	public int addBook(Book book);
	public List<BookType> queryBookType();
	public List<BookType> queryByPage(int pageNo,int pageSize);
	public List<Book> queryBook();
	public List<Book> queryByPageFBook(int pageNo,int pageSize);
	public boolean deleteBookByID(int id);
	public List<Book> queryBookByID(int id);
	public boolean changeBookByID(Book newbook);
}
