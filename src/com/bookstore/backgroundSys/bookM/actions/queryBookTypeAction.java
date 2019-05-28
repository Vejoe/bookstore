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
	private int id; //������ʾ���ݵ�����
	private final int pageSize=5; //ÿҳ��ʾ��¼�ĸ���
	private int pageNo=1; //������,�ӵ�1ҳ��ʼ��ʾ
	private int currentPage; //��ǰҳ
	private int totalPage; //��ҳ��
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
		//����������ݣ��õ����ݵ��ܸ���
		booktypes=bd.queryBookType();
		//������ҳ��
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
		//���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
		booktypes=bd.queryByPage(pageNo,pageSize);
		//���õ�ǰҳ
		currentPage=pageNo;
		if(booktypes!=null)
			return SUCCESS;
		else
			return INPUT;
	}
}
