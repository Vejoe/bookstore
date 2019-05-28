package com.bookstore.consignee.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.consignee.interfaces.ConsigneeDaoInterface;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteConsigneeAction extends ActionSupport{
	@Autowired
	int id;
	ConsigneeDaoInterface csgd;
	public DeleteConsigneeAction(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ConsigneeDaoInterface getCsgd() {
		return csgd;
	}
	public void setCsgd(ConsigneeDaoInterface csgd) {
		this.csgd = csgd;
	}
	public String execute(){
		if(csgd.DeleteConsigneeById(id))
			return SUCCESS;
		else
			addFieldError("error","É¾³ýÊ§°Ü£¡");
			return INPUT;
	}

}
