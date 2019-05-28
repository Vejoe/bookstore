package com.bookstore.backgroundSys.bookM.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.backgroundSys.bookM.dao.BookDao;
import com.bookstore.backgroundSys.bookM.dao.impl.BookDaoImpl;
import com.bookstore.product.model.BookType;
import com.opensymphony.xwork2.ActionSupport;

public class addBookTypeAction extends ActionSupport{
	@Autowired
	BookDao bd;
	BookType booktype;
	public addBookTypeAction(){
		
	}
	public BookType getBooktype() {
		return booktype;
	}
	public void setBooktype(BookType booktype) {
		this.booktype = booktype;
	}
	
	public BookDao getBd() {
		return bd;
	}
	public void setBd(BookDao bd) {
		this.bd = bd;
	}
	public void validate(){
    	super.validate();
    	if(booktype.getType().equals("")){
    		this.addFieldError("booktype.type","图书类别不能为空");
    	}
    }
	
	public String execute() throws Exception{
		if(bd.addBookType(booktype)>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
