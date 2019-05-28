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
	//ͨ���˺Ų��ҵ���Ӧ���ջ�����Ϣ
	public List<Consignee> QueryCustomerConsigneeBycaccount(String caccount){
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
			String hql1="from Consignee where cid=?";
			//���Query����
			Query query1=session.createQuery(hql1);
			//���ò���,?����Ŵ�0��ʼ
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
			//�ر�session
			session.close();
		}
	}
	//����ջ���
	public boolean AddConsignee(Consignee consignee){
		Session session=null;
		int num=0;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();
			//�������
			Transaction trans=session.beginTransaction();
			//HQL���, Customer�ǳ־û���
			//����־û���Ķ���,�����ڻ�����
			num=Integer.parseInt(session.save(consignee).toString());
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
	//����id��ɾ���ջ��˷���
	public boolean DeleteConsigneeById(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ�����
			Consignee consignee=(Consignee)session.get(Consignee.class, id);
			//ɾ������
			Transaction trans=session.beginTransaction();
			session.delete(consignee);
			trans.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//�ر�session
			session.close();
		}	
	}
	//����id������ջ�����Ϣ
	public Consignee QueryConsigneeDetail(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ�����
			Consignee consignee=(Consignee)session.get(Consignee.class, id);
			return consignee;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}
	}
	//�����޸��ջ�����Ϣ
	public boolean UpdateConsigneeById(Consignee consignee){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//ɾ������
			Transaction trans=session.beginTransaction();
			session.saveOrUpdate(consignee);
			trans.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//�ر�session
			session.close();
		}	
	}
	//��ѯÿҳ��Ҫ��ʾ������(ÿ�����3����¼)
	public List<Consignee> queryByPage(int pageNo,int pageSize,String caccount){
		//�õ�session
		List<Consignee> consignees=new ArrayList<Consignee>();
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
			String hql1="from Consignee where cid=?";
			//���Query����
			Query query1=session.createQuery(hql1);
			//���ò���,?����Ŵ�0��ʼ
			query1.setParameter(0, cid);
			//ÿ�λ�ȡ��һ�����ݵ�����
			query1.setFirstResult((pageNo-1)*pageSize); //������һҳ��ʾ�ĵ�һ����¼������
			//��һҳ��ʾ�ļ�¼����
			query1.setMaxResults(pageSize); 
			//ÿ�����3����¼
			consignees=query1.list();
			return consignees;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}	
	}
}
