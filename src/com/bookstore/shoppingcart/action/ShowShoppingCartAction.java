package com.bookstore.shoppingcart.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.shoppingcart.dao.ShoppingCartDao;
import com.bookstore.shoppingcart.model.*;
public class ShowShoppingCartAction extends ActionSupport{
	List<ShoppingCartInfo> shoppingcartinfos=new  ArrayList <ShoppingCartInfo>();
	@Autowired
	ShoppingCartDao shoppingcartdao;
	CustomerDaoInterface cd;
	private Customer customer;
	private ShoppingCartInfo shoppingcartinfo;
	private ShoppingCart shoppingcart;
	private int cid;
	private int cartid;
	private int id; //������ʾ���ݵ�����
	private final int pageSize=5; //ÿҳ��ʾ��¼�ĸ���
	private int pageNo=1; //������,�ӵ�1ҳ��ʼ��ʾ
	private int currentPage; //��ǰҳ
	private int totalPage; //��ҳ��
	private int ordermount;//��¼����Ʒ������
	private double price;//��¼����Ʒ���ܼ�
	private double allprice;//��¼�ù��ﳵ�������ܼ�
	
	public ShowShoppingCartAction(){}



	public List<ShoppingCartInfo> getShoppingcartinfos() {
		return shoppingcartinfos;
	}



	public void setShoppingcartinfos(List<ShoppingCartInfo> shoppingcartinfos) {
		this.shoppingcartinfos = shoppingcartinfos;
	}



	public CustomerDaoInterface getCd() {
		return cd;
	}



	public void setCd(CustomerDaoInterface cd) {
		this.cd = cd;
	}



	public ShoppingCartDao getShoppingcartdao() {
		return shoppingcartdao;
	}

	public void setShoppingcartdao(ShoppingCartDao shoppingcartdao) {
		this.shoppingcartdao = shoppingcartdao;
	}

	public ShoppingCartInfo getShoppingcartinfo() {
		return shoppingcartinfo;
	}

	public void setShoppingcartinfo(ShoppingCartInfo shoppingcartinfo) {
		this.shoppingcartinfo = shoppingcartinfo;
	}

	public ShoppingCart getShoppingcart() {
		return shoppingcart;
	}

	public void setShoppingcart(ShoppingCart shoppingcart) {
		this.shoppingcart = shoppingcart;
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

	public int getOrdermount() {
		return ordermount;
	}

	public void setOrdermount(int ordermount) {
		this.ordermount = ordermount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAllprice() {
		return allprice;
	}

	public void setAllprice(double allprice) {
		this.allprice = allprice;
	}

	public int getPageSize() {
		return pageSize;
	}
	
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public String execute()throws Exception{
		System.out.println("!!!!!!!!!!!!!!!!!!");
		Map m=ActionContext.getContext().getSession();//��õ�ǰSession����
		customer=cd.QueryCustomerBycaccount(m.get("caccount").toString());
		/*customer=(Customer)m.get("customer");//�����˺Ż�õ�ǰ�û�
*/		cid=customer.getId();//����û�id
		if(shoppingcartdao.getshoppingcartid(cid)==0)return INPUT;
		cartid=shoppingcartdao.getshoppingcartid(cid);//��ù��ﳵid
		//����������ݣ��õ����ݵ��ܸ���
		shoppingcartinfos=shoppingcartdao.showshoppingcartInfo(cartid);
		//������ҳ��
		if(shoppingcartinfos.size()%pageSize==0){
			totalPage=shoppingcartinfos.size()/pageSize;
		}else{
			totalPage=shoppingcartinfos.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
		shoppingcartinfos=shoppingcartdao.queryByPage(pageNo,pageSize,cartid);
		//���õ�ǰҳ
		currentPage=pageNo;
		shoppingcart=shoppingcartdao.getshoppingcart(cid);
		if(shoppingcartinfos!=null&&shoppingcart!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
