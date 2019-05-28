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
	//ע����飬�ж��Ƿ������û���
	public boolean checkregister(Customer customer){
		Session session=null;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();
			//HQL���, Customer�ǳ־û���
			String hql="from Customer where caccount=?";
			//���Query����
			Query query=session.createQuery(hql);
			//���ò���,?����Ŵ�0��ʼ
			query.setParameter(0, customer.getCaccount());
			//ִ�в�ѯ
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
			//�ر�session
			session.close();
		}
	}
	//ע��ķ���,������Ӱ������
	public int register(Customer customer){
		Session session=null;
		int num=0;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();
			//�������
			Transaction trans=session.beginTransaction();
			//����־û���Ķ���,�����ڻ�����
			num=Integer.parseInt(session.save(customer).toString());
			//�ύ���д�����ݿ�
			trans.commit();
			return num;
		}catch(Exception ex){
			ex.printStackTrace();
			num=0;
			return num;
		}finally{
			//�ر�session
			session.close();
		}
	}
	//��¼����
	public boolean login(Customer customer){
		Session session=null;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();
			//HQL���, Customer�ǳ־û���
			String hql="from Customer where caccount=? and password=?";
			//���Query����
			Query query=session.createQuery(hql);
			//���ò���,?����Ŵ�0��ʼ
			query.setParameter(0, customer.getCaccount());
			query.setParameter(1, customer.getPassword());
			//ִ�в�ѯ
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
			//�ر�session
			session.close();
		}
	}
	//ͨ���˺Ų��ҵ���Ӧ���û���Ϣ
	public Customer QueryCustomerBycaccount(String caccount){
		Session session=null;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();
			//HQL���, Customer�ǳ־û���
			String hql="from Customer where caccount=?";
			//���Query����
			Query query=session.createQuery(hql);
			//���ò���,?����Ŵ�0��ʼ
			query.setParameter(0, caccount);
			//ִ�в�ѯ
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
			//�ر�session
			session.close();
		}
	}
	//�޸��û���Ϣ
	public boolean ChangeCustomerinformation(Customer customer){
		Session session=null;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.update(customer);//�ڻ����б������ݣ���Ӱ������
			transaction.commit();//д�����ݿ��
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			//�ر�session
			session.close();
		}
	}
	//�������
	public boolean AddMessage(Message message){
		Session session=null;
		int num=0;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();
			//�������
			Transaction trans=session.beginTransaction();
			//HQL���, Customer�ǳ־û���
			//����־û���Ķ���,�����ڻ�����
			num=Integer.parseInt(session.save(message).toString());
			//�ύ���д�����ݿ�
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
			//�ر�session
			session.close();
		}
	}
	//ͨ���˺Ų��ҵ���Ӧ��������Ϣ
	public List<Message> QueryMessageBycaccount(String caccount){
		Session session=null;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();
			//HQL���, Customer�ǳ־û���
			String hql="from Customer where caccount=?";
			//���Query����
			Query query=session.createQuery(hql);
			//���ò���,?����Ŵ�0��ʼ
			query.setParameter(0, caccount);
			//ִ�в�ѯ
			List<Customer> list=query.list();
			int cid=list.get(0).getId();
			String hql1="from Message where cid=?";
			//���Query����
			Query query1=session.createQuery(hql1);
			//���ò���,?����Ŵ�0��ʼ
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
			//�ر�session
			session.close();
		}
	}
	//��ѯÿҳ��Ҫ��ʾ������(ÿ�����2����¼)
	public List<Message> queryMessagesByPage(int pageNo,int pageSize,String caccount){
		//�õ�session
		List<Message> messages=new ArrayList<Message>();
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//HQL���, Customer�ǳ־û���
			String hql="from Customer where caccount=?";
			//���Query����
			Query query=session.createQuery(hql);
			//���ò���,?����Ŵ�0��ʼ
			query.setParameter(0, caccount);
			//ִ�в�ѯ
			List<Customer> list=query.list();
			int cid=list.get(0).getId();
			String hql1="from Message where cid=?";
			//���Query����
			Query query1=session.createQuery(hql1);
			//���ò���,?����Ŵ�0��ʼ
			query1.setParameter(0, cid);
			//ÿ�λ�ȡ��һ�����ݵ�����
			query1.setFirstResult((pageNo-1)*pageSize); //������һҳ��ʾ�ĵ�һ����¼������
			//��һҳ��ʾ�ļ�¼����
			query1.setMaxResults(pageSize); 
			//ÿ�����2����¼
			messages=query1.list();
			return messages;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}	
	}
	//����id�����Message��Ϣ
	public Message QueryMessageDetail(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ�����
			Message message=(Message)session.get(Message.class, id);
			return message;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}
	}
}
