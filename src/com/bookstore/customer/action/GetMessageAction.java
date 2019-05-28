package com.bookstore.customer.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.consignee.model.Consignee;
import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.bookstore.customer.model.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetMessageAction extends ActionSupport{
	@Autowired
	Customer customer;
	List<Message> messages;
	CustomerDaoInterface cd;
	private int id; //������ʾ���ݵ�����
	private final int pageSize=2; //ÿҳ��ʾ��¼�ĸ���
	private int pageNo=1; //������,�ӵ�1ҳ��ʼ��ʾ
	private int currentPage; //��ǰҳ
	private int totalPage; //��ҳ��
	private String num="��û�����Լ�¼��";
	public GetMessageAction(){
		
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public CustomerDaoInterface getCd() {
		return cd;
	}
	public void setCd(CustomerDaoInterface cd) {
		this.cd = cd;
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
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());
		messages=cd.QueryMessageBycaccount(m.get("caccount").toString());
		if(messages!=null){
			num="����"+messages.size()+"����¼";
			if(messages.size()%pageSize==0){
				totalPage=messages.size()/pageSize;
			}else{
				totalPage=messages.size()/pageSize+1;
			}
			if(pageNo<=0){
				pageNo=1;
			}else if(pageNo>totalPage){
				pageNo=totalPage;
			}
			currentPage=pageNo;
			//���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
			messages=cd.queryMessagesByPage(pageNo, pageSize, m.get("caccount").toString());
			for(Message i:messages){
				if(i.getMessage().length()>30){
					i.setMessage(i.getMessage().substring(0,30)+"...");
				}
			}
			return SUCCESS;
		}
		else{
			return INPUT;
		}
	}
}
