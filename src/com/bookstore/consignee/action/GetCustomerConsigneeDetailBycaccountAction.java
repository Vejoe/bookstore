package com.bookstore.consignee.action;

import java.util.List;
import java.util.Map;

import com.bookstore.consignee.interfaces.ConsigneeDaoInterface;
import com.bookstore.consignee.model.Consignee;
import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
public class GetCustomerConsigneeDetailBycaccountAction extends ActionSupport{
	@Autowired
	List<Consignee> consignees;
	Customer customer;
	CustomerDaoInterface cd;
	ConsigneeDaoInterface csgd;
	private int id; //界面显示数据的索引
	private final int pageSize=3; //每页显示记录的个数
	private int pageNo=1; //计数器,从第1页开始显示
	private int currentPage; //当前页
	private int totalPage; //总页数
	private String whattodo="nothing";
	private String num="还没有收货人记录，赶紧新建一个吧！";
	public GetCustomerConsigneeDetailBycaccountAction(){
		
	}
	public List<Consignee> getConsignees() {
		return consignees;
	}
	public void setConsignees(List<Consignee> consignees) {
		this.consignees = consignees;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
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
	public String getWhattodo() {
		return whattodo;
	}
	public void setWhattodo(String whattodo) {
		this.whattodo = whattodo;
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
		consignees=csgd.QueryCustomerConsigneeBycaccount(m.get("caccount").toString());
		if(whattodo.equals("add"))
			return "add";
		if(consignees!=null){
			num="共有"+consignees.size()+"条记录";
			if(consignees.size()%pageSize==0){
				totalPage=consignees.size()/pageSize;
			}else{
				totalPage=consignees.size()/pageSize+1;
			}
			if(pageNo<=0){
				pageNo=1;
			}else if(pageNo>totalPage){
				pageNo=totalPage;
			}
			currentPage=pageNo;
			//根据当前页查询要在该页上显示的数据
			consignees=csgd.queryByPage(pageNo, pageSize, m.get("caccount").toString());
			for(Consignee i:consignees){
				if(i.getName().length()>11){
					i.setName(i.getName().substring(0,10)+"...");
				}
				if(i.getPhone_num().length()>11){
					i.setPhone_num(i.getPhone_num().substring(0,10)+"...");
				}
				i.setCity(i.getCity()+"市");
				if(i.getProvince().length()+i.getCity().length()+i.getArea().length()>=10){
					if(i.getProvince().length()+i.getCity().length()>=10){
						i.setCity(i.getCity().substring(0,10-i.getProvince().length())+"...");
						i.setArea("");
					}else{
						i.setArea(i.getArea().substring(0,10-i.getProvince().length()-i.getCity().length())+"...");
					}
				}
			}
				return SUCCESS;
		}
		else{
			return INPUT;
		}
	}
}
