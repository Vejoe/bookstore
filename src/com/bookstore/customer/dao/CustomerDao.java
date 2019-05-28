package com.bookstore.customer.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bookstore.consignee.model.Consignee;
import com.bookstore.customer.interfaces.CustomerDaoInterface;
import com.bookstore.customer.model.Customer;
import com.bookstore.customer.model.Message;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomerDao implements CustomerDaoInterface{
	@Autowired
	SessionFactory sessionFactory;
	public CustomerDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//注册检验，判断是否重名用户名
	public boolean checkregister(Customer customer){
		Session session=null;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();
			//HQL语句, Customer是持久化类
			String hql="from Customer where caccount=?";
			//获得Query对象
			Query query=session.createQuery(hql);
			//设置参数,?的序号从0开始
			query.setParameter(0, customer.getCaccount());
			//执行查询
			List list=query.list();
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			//关闭session
			session.close();
		}
	}
	//注册的方法,返回受影响行数
	public int register(Customer customer){
		Session session=null;
		int num=0;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();
			//获得事物
			Transaction trans=session.beginTransaction();
			//保存持久化类的对象,保存在缓存里
			num=Integer.parseInt(session.save(customer).toString());
			//提交事物，写入数据库
			trans.commit();
			return num;
		}catch(Exception ex){
			ex.printStackTrace();
			num=0;
			return num;
		}finally{
			//关闭session
			session.close();
		}
	}
	//登录方法
	public boolean login(Customer customer){
		Session session=null;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();
			//HQL语句, Customer是持久化类
			String hql="from Customer where caccount=? and password=?";
			//获得Query对象
			Query query=session.createQuery(hql);
			//设置参数,?的序号从0开始
			query.setParameter(0, customer.getCaccount());
			query.setParameter(1, customer.getPassword());
			//执行查询
			List list=query.list();
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			//关闭session
			session.close();
		}
	}
	//通过账号查找到对应的用户信息
	public Customer QueryCustomerBycaccount(String caccount){
		Session session=null;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();
			//HQL语句, Customer是持久化类
			String hql="from Customer where caccount=?";
			//获得Query对象
			Query query=session.createQuery(hql);
			//设置参数,?的序号从0开始
			query.setParameter(0, caccount);
			//执行查询
			List<Customer> list=query.list();
			if(list.size()>0){
				return list.get(0);
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	//修改用户信息
	public boolean ChangeCustomerinformation(Customer customer){
		Session session=null;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.update(customer);//在缓存中保存数据，受影响行数
			transaction.commit();//写入数据库表
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			//关闭session
			session.close();
		}
	}
	//添加留言
	public boolean AddMessage(Message message){
		Session session=null;
		int num=0;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();
			//获得事物
			Transaction trans=session.beginTransaction();
			//HQL语句, Customer是持久化类
			//保存持久化类的对象,保存在缓存里
			num=Integer.parseInt(session.save(message).toString());
			//提交事物，写入数据库
			trans.commit();
			if(num>0){
				return true;
			}
			else
				return false;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			//关闭session
			session.close();
		}
	}
	//通过账号查找到对应的留言信息
	public List<Message> QueryMessageBycaccount(String caccount){
		Session session=null;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();
			//HQL语句, Customer是持久化类
			String hql="from Customer where caccount=?";
			//获得Query对象
			Query query=session.createQuery(hql);
			//设置参数,?的序号从0开始
			query.setParameter(0, caccount);
			//执行查询
			List<Customer> list=query.list();
			int cid=list.get(0).getId();
			String hql1="from Message where cid=?";
			//获得Query对象
			Query query1=session.createQuery(hql1);
			//设置参数,?的序号从0开始
			query1.setParameter(0, cid);
			List<Message> list1=null;
			list1=query1.list();
			if(list1.size()>0){
				return list1;
			}
			else
				return null;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	//查询每页需要显示的数据(每次最多2条记录)
	public List<Message> queryMessagesByPage(int pageNo,int pageSize,String caccount){
		//得到session
		List<Message> messages=new ArrayList<Message>();
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//HQL语句, Customer是持久化类
			String hql="from Customer where caccount=?";
			//获得Query对象
			Query query=session.createQuery(hql);
			//设置参数,?的序号从0开始
			query.setParameter(0, caccount);
			//执行查询
			List<Customer> list=query.list();
			int cid=list.get(0).getId();
			String hql1="from Message where cid=?";
			//获得Query对象
			Query query1=session.createQuery(hql1);
			//设置参数,?的序号从0开始
			query1.setParameter(0, cid);
			//每次获取第一条数据的索引
			query1.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//这一页显示的记录个数
			query1.setMaxResults(pageSize); 
			//每次最多2条记录
			messages=query1.list();
			return messages;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	//根据id来获得Message信息
	public Message QueryMessageDetail(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//根据id获取要修改的数据
			Message message=(Message)session.get(Message.class, id);
			return message;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}
	}
}
