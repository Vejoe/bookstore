package com.bookstore.backgroundSys.bookM.actions;

import com.bookstore.backgroundSys.bookM.dao.BookDao;
import com.bookstore.backgroundSys.bookM.dao.impl.BookDaoImpl;
import com.bookstore.product.model.Book;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class queryBookByIDAction extends ActionSupport {
	@Autowired
	BookDao bd;
    private int id;
    private List<Book> books;
    public queryBookByIDAction(){

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public BookDao getBd() {
		return bd;
	}
	public void setBd(BookDao bd) {
		this.bd = bd;
	}
	public String execute(){
        books=bd.queryBookByID(id);
        if(books!=null){
            Map map=ActionContext.getContext().getSession();
            map.put("Bid",id);
            return SUCCESS;
        }else{
            return INPUT;
        }
    }

}
