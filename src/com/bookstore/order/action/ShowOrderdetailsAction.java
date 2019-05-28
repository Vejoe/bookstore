package com.bookstore.order.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.consignee.interfaces.ConsigneeDaoInterface;
import com.bookstore.consignee.model.Consignee;
import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.bookstore.order.dao.OrderDao;
import model.Order;
import model.Orderdetail;
import com.bookstore.product.dao.productDao;
import com.bookstore.shoppingcart.dao.ShoppingCartDao;
import com.bookstore.shoppingcart.model.ShoppingCart;
import com.bookstore.shoppingcart.model.ShoppingCartInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowOrderdetailsAction  extends ActionSupport{
	@Autowired
	CustomerDaoInterface cd;
	ConsigneeDaoInterface csgd;
	productDao pd;
	ShoppingCartDao sd;
	OrderDao od;
	
	Order order;
	Orderdetail orderdetail;

	List<Orderdetail> Orderdetails;


	private int cid;

	public ShowOrderdetailsAction(){}
	
	private int id; //界面显示数据的索引//订单id
	private final int pageSize=5; //每页显示记录的个数
	private int pageNo=1; //计数器,从第1页开始显示
	private int currentPage; //当前页
	private int totalPage; //总页数

	public CustomerDaoInterface getCd() {
		return cd;
	}
	public void setCd(CustomerDaoInterface cd) {
		this.cd = cd;
	}
	public ConsigneeDaoInterface getCsgd() {
		return csgd;
	}
	public void setCsgd(ConsigneeDaoInterface csgd) {
		this.csgd = csgd;
	}
	public productDao getPd() {
		return pd;
	}
	public void setPd(productDao pd) {
		this.pd = pd;
	}
	public ShoppingCartDao getSd() {
		return sd;
	}
	public void setSd(ShoppingCartDao sd) {
		this.sd = sd;
	}
	public OrderDao getOd() {
		return od;
	}
	public void setOd(OrderDao od) {
		this.od = od;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Orderdetail getOrderdetail() {
		return orderdetail;
	}
	public void setOrderdetail(Orderdetail orderdetail) {
		this.orderdetail = orderdetail;
	}
	public List<Orderdetail> getOrderdetails() {
		return Orderdetails;
	}
	public void setOrderdetails(List<Orderdetail> orderdetails) {
		Orderdetails = orderdetails;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	public String execute(){
		Map m=ActionContext.getContext().getSession();//获得当前Session集合
		Orderdetails=od.getOrderdetailByorderid(id);//得到订单集合
		
		//计算总页数
		if(Orderdetails.size()%pageSize==0){
			totalPage=Orderdetails.size()/pageSize;
		}else{
			totalPage=Orderdetails.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//根据当前页查询要在该页上显示的数据
		Orderdetails=od.queryOrderdetailByPage(pageNo,pageSize,id);
		//设置当前页
		currentPage=pageNo;
		
		
		if(Orderdetails!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	
	
	
	}
	
	
	
}
