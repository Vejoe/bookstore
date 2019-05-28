package com.bookstore.manager.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.customer.model.Message;
import com.bookstore.manager.service.ManagerService;
import com.opensymphony.xwork2.ActionSupport;


public class ManagerMessageAction extends ActionSupport {
		@Autowired
		ManagerService managerService;
		private Message m;
		private List<Message> messages;
		String mname;
		int id; //������ʾ���ݵ�����
		private final int pageSize=5; //ÿҳ��ʾ��¼�ĸ���
		private int pageNo=1; //������,�ӵ�1ҳ��ʼ��ʾ
		private int currentPage; //��ǰҳ
		private int totalPage; //��ҳ��
		public ManagerService getManagerService() {
			return managerService;
		}
		public void setManagerService(ManagerService managerService) {
			this.managerService = managerService;
		}
		
		
		public String getMname() {
			return mname;
		}
		public void setMname(String mname) {
			this.mname = mname;
		}
		public List<Message> getMessages() {
			return messages;
		}
		public void setMessages(List<Message> messages) {
			this.messages = messages;
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
		
		public String deleteMessage(){
			m=managerService.findMessageById(this.getId());
			managerService.delete(m);
			return SUCCESS;
		}
		
		public String showMessageDetail()
		{
			m=managerService.findMessageById(this.getId());
			return SUCCESS;
		}
		
		public Message getM() {
			return m;
		}
		public void setM(Message m) {
			this.m = m;
		}
		public String showAllMessage(){
			messages=managerService.findAllCaseByClassName("Message");
			if (messages.size() % pageSize == 0) {
				totalPage = messages.size() / pageSize;
			} else {
				totalPage = messages.size() / pageSize + 1;
			}
			if (pageNo <= 0) {
				pageNo = 1;
			} else if (pageNo > totalPage) {
				pageNo = totalPage;
			}
			// ���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
			messages = managerService.queryByPage(pageNo, pageSize, "Message");
			// ���õ�ǰҳ
			currentPage = pageNo;
			if (messages != null)
				return SUCCESS;
			else
				return INPUT;
		}
		
		// ģ�����Ҷ�Ӧ���������
		public String queryMessageTitle() {
			// �Ȼ������
			messages = managerService.findCaseByLikeOneProperty("Message", "title", this.getMname());
			// ������ҳ��
			if (messages.size() % pageSize == 0) {
				totalPage = messages.size() / pageSize;
			} else {
				totalPage = messages.size() / pageSize + 1;
			}
			if (pageNo <= 0) {
				pageNo = 1;
			} else if (pageNo > totalPage) {
				pageNo = totalPage;
			}
			// ���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
			messages = managerService.queryByPageLikeOneProperty(pageNo, pageSize, "Message", "title", this.getMname());
			// ���õ�ǰҳ
			currentPage = pageNo;
			if (messages != null)
				return SUCCESS;
			else
				return INPUT;

		}
}
