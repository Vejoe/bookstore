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

public class ShowOrderAction extends ActionSupport{
	@Autowired
	CustomerDaoInterface cd;
	ConsigneeDaoInterface csgd;
	productDao pd;
	ShoppingCartDao sd;
	OrderDao od;
	
	Order order;
	Orderdetail orderdetail;
	Customer customer;
	Consignee consignee;
	ShoppingCart shoppingcart;
	ShoppingCartInfo shoppingcartinfo;
	List<ShoppingCartInfo> shoppingcartinfos;
	List<Orderdetail> Orderdetails;
	List<Consignee> consignees;
	List<Order> orders;
	private int cid;
	private String message;//留言
	private String postmethod;//发货方式
	private String paymethod;//支付方式
	private String poststatus="未发货";
	private String recevstatus="未发货";
	private double orderprice;//价钱
	private int orderaccount=0;//订单号
	private int cartid;
	private int orderid; //订单id
	public ShowOrderAction(){}
	
	private int id; //界面显示数据的索引
	private final int pageSize=7; //每页显示记录的个数
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Consignee getConsignee() {
		return consignee;
	}

	public void setConsignee(Consignee consignee) {
		this.consignee = consignee;
	}

	public ShoppingCart getShoppingcart() {
		return shoppingcart;
	}

	public void setShoppingcart(ShoppingCart shoppingcart) {
		this.shoppingcart = shoppingcart;
	}

	public ShoppingCartInfo getShoppingcartinfo() {
		return shoppingcartinfo;
	}

	public void setShoppingcartinfo(ShoppingCartInfo shoppingcartinfo) {
		this.shoppingcartinfo = shoppingcartinfo;
	}

	public List<ShoppingCartInfo> getShoppingcartinfos() {
		return shoppingcartinfos;
	}

	public void setShoppingcartinfos(List<ShoppingCartInfo> shoppingcartinfos) {
		this.shoppingcartinfos = shoppingcartinfos;
	}

	public List<Orderdetail> getOrderdetails() {
		return Orderdetails;
	}

	public void setOrderdetails(List<Orderdetail> orderdetails) {
		Orderdetails = orderdetails;
	}

	public List<Consignee> getConsignees() {
		return consignees;
	}

	public void setConsignees(List<Consignee> consignees) {
		this.consignees = consignees;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPostmethod() {
		return postmethod;
	}

	public void setPostmethod(String postmethod) {
		this.postmethod = postmethod;
	}

	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getPoststatus() {
		return poststatus;
	}

	public void setPoststatus(String poststatus) {
		this.poststatus = poststatus;
	}

	public String getRecevstatus() {
		return recevstatus;
	}

	public void setRecevstatus(String recevstatus) {
		this.recevstatus = recevstatus;
	}

	public double getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(double orderprice) {
		this.orderprice = orderprice;
	}

	public int getOrderaccount() {
		return orderaccount;
	}

	public void setOrderaccount(int orderaccount) {
		this.orderaccount = orderaccount;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
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
		customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());
		cid=customer.getId();//获得用户id
		
		if(od.getOrderbycid(cid)==0)return INPUT;
		//获得所有数据，得到数据的总个数
		orders=od.getOrderByCid(cid);
		

		//计算总页数
		if(orders.size()%pageSize==0){
			totalPage=orders.size()/pageSize;
		}else{
			totalPage=orders.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//根据当前页查询要在该页上显示的数据
		orders=od.queryByPage(pageNo,pageSize,cid);
		//设置当前页
		currentPage=pageNo;
		
		
		if(orders!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
		
		
		
	}
	
}
