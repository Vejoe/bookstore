package com.bookstore.consignee.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.consignee.interfaces.ConsigneeDaoInterface;
import com.bookstore.consignee.model.Consignee;
import com.bookstore.customer.model.Customer;
import com.bookstore.customer.model.Message;

public class ConsigneeDao implements ConsigneeDaoInterface{
	@Autowired
	SessionFactory sessionFactory;
	public ConsigneeDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//通过账号查找到对应的收货人信息
	public List<Consignee> QueryCustomerConsigneeBycaccount(String caccount){
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
			String hql1="from Consignee where cid=?";
			//获得Query对象
			Query query1=session.createQuery(hql1);
			//设置参数,?的序号从0开始
			query1.setParameter(0, cid);
			List<Consignee> list1=query1.list();
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
	//添加收货人
	public boolean AddConsignee(Consignee consignee){
		Session session=null;
		int num=0;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();
			//获得事物
			Transaction trans=session.beginTransaction();
			//HQL语句, Customer是持久化类
			//保存持久化类的对象,保存在缓存里
			num=Integer.parseInt(session.save(consignee).toString());
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
	//根据id来删除收货人方法
	public boolean DeleteConsigneeById(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//根据id获取要修改的数据
			Consignee consignee=(Consignee)session.get(Consignee.class, id);
			//删除数据
			Transaction trans=session.beginTransaction();
			session.delete(consignee);
			trans.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}	
	}
	//根据id来获得收货人信息
	public Consignee QueryConsigneeDetail(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//根据id获取要修改的数据
			Consignee consignee=(Consignee)session.get(Consignee.class, id);
			return consignee;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}
	}
	//更新修改收货人信息
	public boolean UpdateConsigneeById(Consignee consignee){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//删除数据
			Transaction trans=session.beginTransaction();
			session.saveOrUpdate(consignee);
			trans.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}	
	}
	//查询每页需要显示的数据(每次最多3条记录)
	public List<Consignee> queryByPage(int pageNo,int pageSize,String caccount){
		//得到session
		List<Consignee> consignees=new ArrayList<Consignee>();
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
			String hql1="from Consignee where cid=?";
			//获得Query对象
			Query query1=session.createQuery(hql1);
			//设置参数,?的序号从0开始
			query1.setParameter(0, cid);
			//每次获取第一条数据的索引
			query1.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//这一页显示的记录个数
			query1.setMaxResults(pageSize); 
			//每次最多3条记录
			consignees=query1.list();
			return consignees;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
}
