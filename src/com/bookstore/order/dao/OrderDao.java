package com.bookstore.order.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Transaction;
import model.Order;
import model.Orderdetail;
import com.bookstore.shoppingcart.model.ShoppingCart;

public class OrderDao {
	@Autowired
	SessionFactory sessionFactory;
	OrderDao(){}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//加入数据到order表
	public boolean AddOrder(Order order){
		Session session=null;
		int num=0;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();
			//获得事物
			Transaction trans=session.beginTransaction();
			//HQL语句, Customer是持久化类
			//保存持久化类的对象,保存在缓存里
			num=Integer.parseInt(session.save(order).toString());
			//提交事物，写入数据库
			trans.commit();
			if(num>0){
				return true;
			}
			else
				return false;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	//通过订单号得到orderid
	public int getOrderidbyId(int orderaccount) {
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Order where orderaccount=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, orderaccount);
			List<Order> list=query.list();
			Order order=list.get(0);
			int i=order.getId();
			return i;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
	}
	
	//通过订单号得到order对象
	public Order getOrderByid(int id) {
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Order where id=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, id);
			List<Order> list=query.list();
			Order order =list.get(0);
			return order;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	public void AddOrderdetail(Orderdetail orderdetail) {
		Session session=null;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();
			//获得事物
			Transaction trans=session.beginTransaction();
			//HQL语句, Customer是持久化类
			//保存持久化类的对象,保存在缓存里
			session.save(orderdetail);
			//提交事物，写入数据库
			trans.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();

		}finally{
			//关闭session
			session.close();
		}
	}
	//得到订单集合
	public List<Order> getOrderByCid(int cid) {
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Order where cid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cid);
			//执行查询获得的结果,list中的每一个元素代表一个ShoppingCart的对象
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
			}finally{
				session.close();
			}
	}
	
	
	//分页查询数组
	public List<Order> queryByPage(int pageNo, int pageSize, int cid) {
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Order where cid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cid);
			//每次获取第一条数据的索引
			query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//这一页显示的记录个数
			query.setMaxResults(pageSize); 

			//每次最多5条记录
			List<Order> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}
	}
	
	//订单详情
	public List<Orderdetail> getOrderdetailByorderid(int id) {
		//得到session
				Session session=null;
				try{
					session=sessionFactory.openSession();
					String queryString="from Orderdetail where orderid=?";
					Query query=session.createQuery(queryString);
					query.setParameter(0, id);
					//执行查询获得的结果,list中的每一个元素代表一个ShoppingCart的对象
					List list=query.list();
					if(list.size()>0)
						return list;
					else{
						return null;
					}
				}catch(Exception e){
					e.printStackTrace();
					return null;
					}finally{
						session.close();
				}
	}
	//分页查询
	public List<Orderdetail> queryOrderdetailByPage(int pageNo, int pageSize, int id) {
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Orderdetail where orderid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, id);
			//每次获取第一条数据的索引
			query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//这一页显示的记录个数
			query.setMaxResults(pageSize); 

			//每次最多5条记录
			List<Orderdetail> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}
	
	}
	
	public int getOrderbycid(int cid) {
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Order where cid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cid);
			List<Order> list=query.list();
			if(list.toString()=="[]")
				return 0;
			Order order=list.get(0);
			int i=order.getId();
			return i;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
	}
	public boolean delorderdetailbyid(int id) {
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="delete from Orderdetail where orderid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, id);
			transaction=session.beginTransaction();
			query.executeUpdate();
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}
	}
	public void deorderbyid(int id) {
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="delete from Order where id=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, id);
			transaction=session.beginTransaction();
			query.executeUpdate();
			transaction.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		
		}finally{//关闭session
			session.close();
		}
	}
	
	//通过id得到orderprice
	public double getOrderpriceById(int id) {
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Order where id=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, id);
			List<Order> list=query.list();
			if(list.toString()=="[]")
				return 0;
			Order order=list.get(0);
			double i=order.getOrderprice();
			return i;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
	}

	//修改order的recevstatus状态
	public void changerecevstatus(String recevstatus,int id) {
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="update Order o set o.recevstatus=? where id=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, recevstatus);
			query.setParameter(1, id);
			transaction=session.beginTransaction();
			query.executeUpdate();
			transaction.commit();
			System.out.println("修改recevstatus成功");
		}catch (Exception e) {
			e.printStackTrace();
		
		}finally{//关闭session
			session.close();
		}
		
	}
	//修改book表的bookdealmount状态
	public void changebookdealmount(int bookid,int bookdealmount) {
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="update Book book set book.bookdealmount=?+book.bookdealmount where id=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, bookdealmount);
			query.setParameter(1, bookid);
			transaction=session.beginTransaction();
			query.executeUpdate();
			transaction.commit();
			System.out.println("修改bookdealmount成功");
		}catch (Exception e) {
			e.printStackTrace();
		
		}finally{//关闭session
			session.close();
		}
	}
	//修改customer的pay_sum状态
	public void changepay_sum(double pay_sum,int cid) {
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="update Customer customer set customer.pay_sum=?+customer.pay_sum where id=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, pay_sum);
			query.setParameter(1, cid);
			transaction=session.beginTransaction();
			query.executeUpdate();
			transaction.commit();
			System.out.println("修改pay_sum成功");
		}catch (Exception e) {
			e.printStackTrace();
		
		}finally{//关闭session
			session.close();
		}

	
	}	
}
