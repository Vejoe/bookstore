package com.bookstore.customer.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import com.bookstore.customer.model.Customer;

//������
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
	//����㣬�������checkLogin����
	@Pointcut("execution(* com.bookstore.customer.dao.CustomerDao.login(..)))")
	public void pointCut() {
	}
	
	//����@before֪ͨ����
	@Before("pointCut() && args(customer)") 
	public boolean validateInput(Customer customer){
		System.out.println(customer.getCaccount()+"���ڽ���������֤.....");
		if(customer.getCaccount()!= null && customer.getPassword()!=null
		&& customer.getCaccount().length()>=6 && customer.getPassword().length()>=6){
			System.out.println("������֤ͨ��");
			return true;
		}else{
			System.out.println("������֤��ͨ��");
			return false;
		}
	}
}