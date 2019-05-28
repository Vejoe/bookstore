package com.bookstore.backgroundSys.bookM.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.backgroundSys.bookM.dao.BookDao;
import com.bookstore.backgroundSys.bookM.dao.impl.BookDaoImpl;
import com.bookstore.product.model.BookType;
import com.opensymphony.xwork2.ActionSupport;

public class queryBookTypeAction extends ActionSupport {
	@Autowired
	BookDao bd;
	List<BookType> booktypes;
	private BookType booktype;
	private int id; //界面显示数据的索引
	private final int pageSize=5; //每页显示记录的个数
	private int pageNo=1; //计数器,从第1页开始显示
	private int currentPage; //当前页
	private int totalPage; //总页数
	public queryBookTypeAction(){
		
	}
	public List<BookType> getBooktypes() {
		return booktypes;
	}
	public void setBooktypes(List<BookType> booktypes) {
		this.booktypes = booktypes;
	}
	public BookType getBooktype() {
		return booktype;
	}
	public void setBooktype(BookType booktype) {
		this.booktype = booktype;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	
	public BookDao getBd() {
		return bd;
	}
	public void setBd(BookDao bd) {
		this.bd = bd;
	}
	public String execute()throws Exception{
		//获得所有数据，得到数据的总个数
		booktypes=bd.queryBookType();
		//计算总页数
		if(booktypes.size()%pageSize==0){
			totalPage=booktypes.size()/pageSize;
		}else{
			totalPage=booktypes.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//根据当前页查询要在该页上显示的数据
		booktypes=bd.queryByPage(pageNo,pageSize);
		//设置当前页
		currentPage=pageNo;
		if(booktypes!=null)
			return SUCCESS;
		else
			return INPUT;
	}
}
