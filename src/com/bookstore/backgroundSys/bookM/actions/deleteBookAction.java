package com.bookstore.backgroundSys.bookM.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.backgroundSys.bookM.dao.BookDao;
import com.bookstore.backgroundSys.bookM.dao.impl.BookDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class deleteBookAction extends ActionSupport {
	@Autowired
	BookDao bd;
    private int id;
    public deleteBookAction(){

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public BookDao getBd() {
		return bd;
	}
	public void setBd(BookDao bd) {
		this.bd = bd;
	}
	public String execute()throws Exception{
        if(bd.deleteBookByID(id)){
            return SUCCESS;
        }else{
            return  INPUT;
        }
    }
}
