package com.bookstore.manager.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.manager.service.ManagerService;
import com.opensymphony.xwork2.ActionSupport;

import model.Order;
import model.Orderdetail;

public class ManagerOrderAction extends ActionSupport {
	@Autowired
	ManagerService managerService;
	private Order order;
	List<Order> orders;
	private Orderdetail orderdetail;
	List<Orderdetail> orderdetails;
	String mname;
	int id; // ������ʾ���ݵ�����
	private final int pageSize = 5; // ÿҳ��ʾ��¼�ĸ���
	private int pageNo = 1; // ������,�ӵ�1ҳ��ʼ��ʾ
	private int currentPage; // ��ǰҳ
	private int totalPage; // ��ҳ��

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public List<Orderdetail> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	public Orderdetail getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetail(Orderdetail orderdetail) {
		this.orderdetail = orderdetail;
	}

	public List<Orderdetail> getOrdertails() {
		return orderdetails;
	}

	public void setOrdertails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
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

	public String deleteOrder() {
		order = managerService.findOrderById(this.getId());
		managerService.delete(order);
		return SUCCESS;
	}

	public String toOrderdetail() {
		orderdetails = managerService.findOrderdetailById(this.getId());
		order = managerService.findOrderById(this.getId());
		return SUCCESS;
	}

	public String todealOrder() {
		order = managerService.findOrderById(this.getId());
		order.setPoststatus("�ѷ���");
		managerService.update(order);
		return SUCCESS;
	}

	public String todealOrder2() {
		order = managerService.findOrderById(this.getId());
		order.setRecevstatus("���˻�");
		managerService.update(order);
		return SUCCESS;
	}
	
	public String todealOrder3() {
		order = managerService.findOrderById(this.getId());
		order.setRecevstatus("���ջ�");
		managerService.update(order);
		return SUCCESS;
	}

	public String showAllOrder() {
		// ������ж���
		orders = managerService.findAllCaseByClassName("Order");
		// ������ҳ��
		if (orders.size() % pageSize == 0) {
			totalPage = orders.size() / pageSize;
		} else {
			totalPage = orders.size() / pageSize + 1;
		}
		if (pageNo <= 0) {
			pageNo = 1;
		} else if (pageNo > totalPage) {
			pageNo = totalPage;
		}
		// ���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
		orders = managerService.queryByPage(pageNo, pageSize, "Order");
		// ���õ�ǰҳ
		currentPage = pageNo;
		if (orders != null)
			return SUCCESS;
		else
			return INPUT;
	}

	// ģ�����Ҷ�Ӧ�����ŵĶ���
	public String queryAccountOrder() {
		// �Ȼ������
		orders = managerService.findCaseByLikeOneProperty("Order", "orderaccount", this.getMname());
		// ������ҳ��
		if (orders.size() % pageSize == 0) {
			totalPage = orders.size() / pageSize;
		} else {
			totalPage = orders.size() / pageSize + 1;
		}
		if (pageNo <= 0) {
			pageNo = 1;
		} else if (pageNo > totalPage) {
			pageNo = totalPage;
		}
		// ���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
		orders = managerService.queryByPageLikeOneProperty(pageNo, pageSize, "Order", "orderaccount", this.getMname());
		// ���õ�ǰҳ
		currentPage = pageNo;
		if (orders != null)
			return SUCCESS;
		else
			return INPUT;

	}
}
