package com.bookstore.backgroundSys.bookM.actions;

import com.bookstore.backgroundSys.bookM.dao.BookDao;
import com.bookstore.backgroundSys.bookM.dao.impl.BookDaoImpl;
import com.bookstore.product.model.Book;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


import static org.hibernate.internal.util.io.StreamCopier.BUFFER_SIZE;

public class addBookAction extends ActionSupport{
	@Autowired
	BookDao bd;
	Book book;
	private File upload;				
	private String uploadConteneType;	
	private String uploadFileName;     
	private String savePath;           
	public addBookAction(){
		
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
    public File getUpload() {
        return upload;
    }
    public void setUpload(File upload) {
        this.upload = upload;
    }
    public String getUploadConteneType() {
        return uploadConteneType;
    }
    public void setUploadConteneType(String uploadConteneType) {
        this.uploadConteneType = uploadConteneType;
    }
    public String getUploadFileName() {
        return uploadFileName;
    }
    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }
    public String getSavePath() {
        return savePath;
    }
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
    public BookDao getBd() {
		return bd;
	}
	public void setBd(BookDao bd) {
		this.bd = bd;
	}
	private static void copy(File source,File target){
    	try{
			FileInputStream fis=new FileInputStream(source);
			DataInputStream dis=new DataInputStream(fis);

			FileOutputStream fos=new FileOutputStream(target);
			DataOutputStream dos=new DataOutputStream(fos);
			int temp;

			while((temp=dis.read())!=-1){

				dos.write(temp);
			}

			fis.close();
			dis.close();
			fos.close();
			dos.close();

		}catch(FileNotFoundException ex1){
			ex1.printStackTrace();
		}catch(IOException ex2){
			ex2.printStackTrace();
		}
    }
    
    public void validate(){
    	super.validate();
    	if(book.getBooktype().getId()==0){
    		this.addFieldError("book.booktype.id","图书类别ID不能为空");
    	}
    	if(book.getBookname().equals("")){
    		this.addFieldError("book.bookname","图书名称不能为空");
    	}
		if(book.getAuthor().equals("")){
			this.addFieldError("book.author","图书作者不能为空");
		}
		if(book.getPrice()==0){
			this.addFieldError("book.price","图书价格不能为空");
		}
		if(book.getStocks()==0){
			this.addFieldError("book.stocks","图书库存不能为空");
		}
    }

    public String execute() throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssS");
		String Rname=sdf.format(new Date());
		String name=uploadFileName;
		int i=name.lastIndexOf(".");
		String ext=name.substring(i+1);
		name=Rname+"."+ext;

    	book.setBookfilename(name);
    	String filePath=ServletActionContext.getServletContext().getRealPath("/BookImg")+"\\"+name;
		File target =new File(filePath);
	    copy(upload,target);
		if(book.getRank_price()==0){
			book.setRank_price(book.getPrice());
		}
		if(bd.addBook(book)>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
