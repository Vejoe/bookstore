package com.bookstore.order.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.consignee.interfaces.ConsigneeDaoInterface;
import com.bookstore.consignee.model.Consignee;
import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.bookstore.order.dao.OrderDao;
import model.Order;
import model.Orderdetail;

import com.bookstore.product.dao.productDao;
import com.bookstore.product.model.Comment;
import com.bookstore.shoppingcart.dao.ShoppingCartDao;
import com.bookstore.shoppingcart.model.ShoppingCart;
import com.bookstore.shoppingcart.model.ShoppingCartInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddOrderAction  extends ActionSupport{
	@Autowired
	CustomerDaoInterface cd;
	ConsigneeDaoInterface csgd;
	productDao pd;
	ShoppingCartDao sd;
	OrderDao od;
	
	
	Order order;
	Customer customer;
	Consignee consignee;
	ShoppingCart shoppingcart;
	ShoppingCartInfo shoppingcartinfo;
	List<ShoppingCartInfo> shoppingcartinfos;
	List<Orderdetail> Orderdetails;
	List<Consignee> consignees;
	private int id;
	private int cid;
	private String message;//留言
	private String postmethod;//发货方式
	private String paymethod;//支付方式
	private String poststatus="未发货";
	private String recevstatus="未收货";
	private double orderprice;//价钱
	private int orderaccount=0;//订单号
	private int cartid;
	private int orderid; //订单id
	private int consigneeradid;
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}




	public int getConsigneeradid() {
		return consigneeradid;
	}

	public void setConsigneeradid(int consigneeradid) {
		this.consigneeradid = consigneeradid;
	}

	public AddOrderAction(){}
	
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
	
	
	public OrderDao getOd() {
		return od;
	}

	public void setOd(OrderDao od) {
		this.od = od;
	}

	public List<Consignee> getConsignees() {
		return consignees;
	}

	public void setConsignees(List<Consignee> consignees) {
		this.consignees = consignees;
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

	

	public int getOrderaccount() {
		return orderaccount;
	}

	public void setOrderaccount(int orderaccount) {
		this.orderaccount = orderaccount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void validate(){
		Map m=ActionContext.getContext().getSession();
		consignees=csgd.QueryCustomerConsigneeBycaccount(m.get("caccount").toString());
		
	}
	public String execute(){
		Map m=ActionContext.getContext().getSession();//获得当前Session集合
		customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());//根据账号获得当前用户		
		cid=customer.getId();//获得用户id
		shoppingcart=sd.getshoppingcart(cid);//通过用户查询到他的购物车对象
		
		cartid=shoppingcart.getId();//找到它的购物id
		System.out.println("cartid"+cartid);
		shoppingcartinfos=sd.showshoppingcartInfo(cartid);//得到详细表的数组集合
		orderprice=shoppingcart.getAllprice();//获得金额
		Date date=new Date();//获得本地时间
		consignee=csgd.QueryConsigneeDetail(consigneeradid);
		System.out.println("收货人id"+consigneeradid);
		orderaccount=(int)((Math.random()*9+1)*100000);//math.random()范围是[0.0, 1.0)，那么math.random()*9+1一定是小于10的，(Math.random()*9+1)*100000一定是<10*100000=1000000的一个数
		System.out.println(orderaccount);
		Order order1=new Order();
		order1.setOrderaccount(orderaccount);//订单号
		order1.setCustomer(customer);//用户id
		order1.setOrderdate(date);//下单时间
		order1.setMessage(message);//留言
		order1.setPostmethod(postmethod);//快递
		
		System.out.println("收货人"+consignee);
		order1.setConsignee(consignee);//收货人
		order1.setPaymethod(paymethod);//支付方式
		order1.setPoststatus(poststatus);//未发货状态
		order1.setRecevstatus(recevstatus);//未收货状态
		order1.setOrderprice(orderprice);//金额
		
		if(od.AddOrder(order1)){
			System.out.println("添加order成功");
			orderid=od.getOrderidbyId(orderaccount);
			System.out.println("++++"+orderid);
			order=od.getOrderByid(orderid);
			Orderdetail orderdetail=new Orderdetail();
			for(int i=0;i<shoppingcartinfos.size();i++){
				orderdetail.setBook(shoppingcartinfos.get(i).getBook());//得到BookID
				orderdetail.setOrder(order);//得到orderid
				orderdetail.setOrdermount(shoppingcartinfos.get(i).getOrdermount());//得到数量
				orderdetail.setTotalprice(shoppingcartinfos.get(i).getPrice());//得到一行物品的数量
				od.AddOrderdetail(orderdetail);//加入到orderdetail表中
				System.out.println("添加订单详细表成功"+i);
			}
			sd.deleteShoppingCartBycartid(cartid);
			sd.deleteShoppingCartbycid(cid);
			return SUCCESS;
		}
		else {
			return INPUT;
		}
	}

	
}
