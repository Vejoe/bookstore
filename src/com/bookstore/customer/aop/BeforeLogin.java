package com.bookstore.customer.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import com.bookstore.customer.model.Customer;

//切面类
@Aspect
public class BeforeLogin{
	private Customer customer;
	public BeforeLogin(){
		
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	//切入点，针对所有checkLogin方法
	@Pointcut("execution(* com.bookstore.customer.dao.CustomerDao.login(..)))")
	public void pointCut() {
	}
	
	//定义@before通知方法
	@Before("pointCut() && args(customer)") 
	public boolean validateInput(Customer customer){
		System.out.println(customer.getCaccount()+"正在进行输入验证.....");
		if(customer.getCaccount()!= null && customer.getPassword()!=null
		&& customer.getCaccount().length()>=6 && customer.getPassword().length()>=6){
			System.out.println("输入验证通过");
			return true;
		}else{
			System.out.println("输入验证不通过");
			return false;
		}
	}
}