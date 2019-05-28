package com.bookstore.customer.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.customer.dao.CustomerDao;
import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.*;
import com.opensymphony.xwork2.ActionSupport;
//������
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
	//����㣬�������checkLogin����
	@Pointcut("execution(* com.bookstore.customer.dao.CustomerDao.login(..)))")
	public void pointCut() { //����Ҫ�з����ڲ��Ĵ���
		//�����岻��Ҫ����
	}
	//����@AfterReturning֪ͨ ����
	@After("pointCut() && args(customer)") 
	public String check(Customer customer) throws Exception{
		Customer truecustomer=cd.QueryCustomerBycaccount(customer.getCaccount());
		if(truecustomer==null){
			System.out.println(customer.getCaccount()+"��¼ʧ�ܣ��˺Ų�����");
			return INPUT;
		}else if(!customer.getPassword().equals(truecustomer.getPassword())){
			System.out.println(customer.getCaccount()+"��¼ʧ�ܣ��������");
			return INPUT;
		}else{
			System.out.println(customer.getCaccount()+"��¼�ɹ�");
			return SUCCESS;
		}
	}
}