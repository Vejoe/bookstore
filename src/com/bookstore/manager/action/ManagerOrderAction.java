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
	int id; // 界面显示数据的索引
	private final int pageSize = 5; // 每页显示记录的个数
	private int pageNo = 1; // 计数器,从第1页开始显示
	private int currentPage; // 当前页
	private int totalPage; // 总页数

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
		order.setPoststatus("已发货");
		managerService.update(order);
		return SUCCESS;
	}

	public String todealOrder2() {
		order = managerService.findOrderById(this.getId());
		order.setRecevstatus("已退货");
		managerService.update(order);
		return SUCCESS;
	}
	
	public String todealOrder3() {
		order = managerService.findOrderById(this.getId());
		order.setRecevstatus("已收货");
		managerService.update(order);
		return SUCCESS;
	}

	public String showAllOrder() {
		// 获得所有订单
		orders = managerService.findAllCaseByClassName("Order");
		// 计算总页数
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
		// 根据当前页查询要在该页上显示的数据
		orders = managerService.queryByPage(pageNo, pageSize, "Order");
		// 设置当前页
		currentPage = pageNo;
		if (orders != null)
			return SUCCESS;
		else
			return INPUT;
	}

	// 模糊查找对应订单号的订单
	public String queryAccountOrder() {
		// 先获得数据
		orders = managerService.findCaseByLikeOneProperty("Order", "orderaccount", this.getMname());
		// 计算总页数
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
		// 根据当前页查询要在该页上显示的数据
		orders = managerService.queryByPageLikeOneProperty(pageNo, pageSize, "Order", "orderaccount", this.getMname());
		// 设置当前页
		currentPage = pageNo;
		if (orders != null)
			return SUCCESS;
		else
			return INPUT;

	}
}
