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
	
	//�������ݵ�order��
	public boolean AddOrder(Order order){
		Session session=null;
		int num=0;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();
			//�������
			Transaction trans=session.beginTransaction();
			//HQL���, Customer�ǳ־û���
			//����־û���Ķ���,�����ڻ�����
			num=Integer.parseInt(session.save(order).toString());
			//�ύ���д�����ݿ�
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
			//�ر�session
			session.close();
		}
	}
	
	//ͨ�������ŵõ�orderid
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
	
	//ͨ�������ŵõ�order����
	public Order getOrderByid(int id) {
		//�õ�session
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
			//����SessionFactory���session
			session=sessionFactory.openSession();
			//�������
			Transaction trans=session.beginTransaction();
			//HQL���, Customer�ǳ־û���
			//����־û���Ķ���,�����ڻ�����
			session.save(orderdetail);
			//�ύ���д�����ݿ�
			trans.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();

		}finally{
			//�ر�session
			session.close();
		}
	}
	//�õ���������
	public List<Order> getOrderByCid(int cid) {
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Order where cid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cid);
			//ִ�в�ѯ��õĽ��,list�е�ÿһ��Ԫ�ش���һ��ShoppingCart�Ķ���
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
	
	
	//��ҳ��ѯ����
	public List<Order> queryByPage(int pageNo, int pageSize, int cid) {
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Order where cid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cid);
			//ÿ�λ�ȡ��һ�����ݵ�����
			query.setFirstResult((pageNo-1)*pageSize); //������һҳ��ʾ�ĵ�һ����¼������
			//��һҳ��ʾ�ļ�¼����
			query.setMaxResults(pageSize); 

			//ÿ�����5����¼
			List<Order> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}
	}
	
	//��������
	public List<Orderdetail> getOrderdetailByorderid(int id) {
		//�õ�session
				Session session=null;
				try{
					session=sessionFactory.openSession();
					String queryString="from Orderdetail where orderid=?";
					Query query=session.createQuery(queryString);
					query.setParameter(0, id);
					//ִ�в�ѯ��õĽ��,list�е�ÿһ��Ԫ�ش���һ��ShoppingCart�Ķ���
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
	//��ҳ��ѯ
	public List<Orderdetail> queryOrderdetailByPage(int pageNo, int pageSize, int id) {
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Orderdetail where orderid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, id);
			//ÿ�λ�ȡ��һ�����ݵ�����
			query.setFirstResult((pageNo-1)*pageSize); //������һҳ��ʾ�ĵ�һ����¼������
			//��һҳ��ʾ�ļ�¼����
			query.setMaxResults(pageSize); 

			//ÿ�����5����¼
			List<Orderdetail> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
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
		}finally{//�ر�session
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
		
		}finally{//�ر�session
			session.close();
		}
	}
	
	//ͨ��id�õ�orderprice
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

	//�޸�order��recevstatus״̬
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
			System.out.println("�޸�recevstatus�ɹ�");
		}catch (Exception e) {
			e.printStackTrace();
		
		}finally{//�ر�session
			session.close();
		}
		
	}
	//�޸�book���bookdealmount״̬
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
			System.out.println("�޸�bookdealmount�ɹ�");
		}catch (Exception e) {
			e.printStackTrace();
		
		}finally{//�ر�session
			session.close();
		}
	}
	//�޸�customer��pay_sum״̬
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
			System.out.println("�޸�pay_sum�ɹ�");
		}catch (Exception e) {
			e.printStackTrace();
		
		}finally{//�ر�session
			session.close();
		}

	
	}	
}
