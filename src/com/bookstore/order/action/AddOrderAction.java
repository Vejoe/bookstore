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
	private String message;//����
	private String postmethod;//������ʽ
	private String paymethod;//֧����ʽ
	private String poststatus="δ����";
	private String recevstatus="δ�ջ�";
	private double orderprice;//��Ǯ
	private int orderaccount=0;//������
	private int cartid;
	private int orderid; //����id
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
		Map m=ActionContext.getContext().getSession();//��õ�ǰSession����
		customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());//�����˺Ż�õ�ǰ�û�		
		cid=customer.getId();//����û�id
		shoppingcart=sd.getshoppingcart(cid);//ͨ���û���ѯ�����Ĺ��ﳵ����
		
		cartid=shoppingcart.getId();//�ҵ����Ĺ���id
		System.out.println("cartid"+cartid);
		shoppingcartinfos=sd.showshoppingcartInfo(cartid);//�õ���ϸ������鼯��
		orderprice=shoppingcart.getAllprice();//��ý��
		Date date=new Date();//��ñ���ʱ��
		consignee=csgd.QueryConsigneeDetail(consigneeradid);
		System.out.println("�ջ���id"+consigneeradid);
		orderaccount=(int)((Math.random()*9+1)*100000);//math.random()��Χ��[0.0, 1.0)����ômath.random()*9+1һ����С��10�ģ�(Math.random()*9+1)*100000һ����<10*100000=1000000��һ����
		System.out.println(orderaccount);
		Order order1=new Order();
		order1.setOrderaccount(orderaccount);//������
		order1.setCustomer(customer);//�û�id
		order1.setOrderdate(date);//�µ�ʱ��
		order1.setMessage(message);//����
		order1.setPostmethod(postmethod);//���
		
		System.out.println("�ջ���"+consignee);
		order1.setConsignee(consignee);//�ջ���
		order1.setPaymethod(paymethod);//֧����ʽ
		order1.setPoststatus(poststatus);//δ����״̬
		order1.setRecevstatus(recevstatus);//δ�ջ�״̬
		order1.setOrderprice(orderprice);//���
		
		if(od.AddOrder(order1)){
			System.out.println("���order�ɹ�");
			orderid=od.getOrderidbyId(orderaccount);
			System.out.println("++++"+orderid);
			order=od.getOrderByid(orderid);
			Orderdetail orderdetail=new Orderdetail();
			for(int i=0;i<shoppingcartinfos.size();i++){
				orderdetail.setBook(shoppingcartinfos.get(i).getBook());//�õ�BookID
				orderdetail.setOrder(order);//�õ�orderid
				orderdetail.setOrdermount(shoppingcartinfos.get(i).getOrdermount());//�õ�����
				orderdetail.setTotalprice(shoppingcartinfos.get(i).getPrice());//�õ�һ����Ʒ������
				od.AddOrderdetail(orderdetail);//���뵽orderdetail����
				System.out.println("��Ӷ�����ϸ��ɹ�"+i);
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
