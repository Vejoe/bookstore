package com.bookstore.customer.model;

import java.util.Date;

public class Customer {
	private int id;
	private String caccount;
	private String cname=null;
	private String password;
	private String sex=null;
	private String email=null;
	private String phone_num=null;
	private Date birthday=null;
	private double pay_sum=0;
	private int rank=1;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCaccount() {
		return caccount;
	}
	public void setCaccount(String caccount) {
		this.caccount = caccount;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
			this.email = email;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public double getPay_sum() {
		return pay_sum;
	}
	public void setPay_sum(double pay_sum) {
		this.pay_sum = pay_sum;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public Customer(){
		
	}
}
