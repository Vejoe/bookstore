package com.bookstore.customer.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.customer.dao.CustomerDao;
import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.*;
import com.opensymphony.xwork2.ActionSupport;
//切面类
@Aspect
public class AfterLogin extends ActionSupport{
	@Autowired
	CustomerDaoInterface cd;
	public AfterLogin(){
		
	}
	public CustomerDaoInterface getCd() {
		return cd;
	}
	public void setCd(CustomerDaoInterface cd) {
		this.cd = cd;
	}
	//切入点，针对所有checkLogin方法
	@Pointcut("execution(* com.bookstore.customer.dao.CustomerDao.login(..)))")
	public void pointCut() { //不需要有方法内部的代码
		//方法体不需要代码
	}
	//定义@AfterReturning通知 方法
	@After("pointCut() && args(customer)") 
	public String check(Customer customer) throws Exception{
		Customer truecustomer=cd.QueryCustomerBycaccount(customer.getCaccount());
		if(truecustomer==null){
			System.out.println(customer.getCaccount()+"登录失败，账号不存在");
			return INPUT;
		}else if(!customer.getPassword().equals(truecustomer.getPassword())){
			System.out.println(customer.getCaccount()+"登录失败，密码错误");
			return INPUT;
		}else{
			System.out.println(customer.getCaccount()+"登录成功");
			return SUCCESS;
		}
	}
}