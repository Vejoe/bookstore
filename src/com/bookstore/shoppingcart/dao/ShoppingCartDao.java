package com.bookstore.shoppingcart.dao;

import java.util.Map;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bookstore.consignee.model.Consignee;
import com.bookstore.product.model.Book;
import com.bookstore.shoppingcart.model.*;




public class ShoppingCartDao {
	//�����Զ�װ��
	@Autowired
	//@Resource
	SessionFactory sessionFactory;
	
	public ShoppingCartDao(){}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//�����û�id�õ����ﳵid
	public int getshoppingcartid(int cid){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from ShoppingCart where cid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cid);
			List<ShoppingCart> list=query.list();
			if(list.toString()=="[]")
				return 0;
			ShoppingCart shoppingcart=list.get(0);
			int i=shoppingcart.getId();
			return i;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
	}
	

	
	//�����û�id�õ����ﳵ
	public ShoppingCart getshoppingcart(int cid){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from ShoppingCart where cid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cid);
			List<ShoppingCart> list=query.list();
			ShoppingCart shoppingcart =list.get(0);
			return shoppingcart;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}	
	
	
	
	
	
	//���ݹ��ﳵid��ѯ���ﳵ��ϸ�������Ϣ
	public List<ShoppingCartInfo> showshoppingcartInfo(int cartid){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from ShoppingCartInfo where cartid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cartid);
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
	
	//�������鼮��Ϣ
	public List<Book> getBook(int bookid){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Book where id=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, bookid);
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
	//��ӻ�Ա��Ʒ//�����ͨ�û���Ʒ
	public int addshoppingcart(ShoppingCartInfo shoppingcartinfo){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(shoppingcartinfo).toString());
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{//�ر�session
			session.close();
		}
		return num;
	}
	
	//��ҳ��ʾ
	public List<ShoppingCartInfo>queryByPage(int pageNo,int pageSize,int cartid){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from ShoppingCartInfo where cartid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cartid);
			//ÿ�λ�ȡ��һ�����ݵ�����
			query.setFirstResult((pageNo-1)*pageSize); //������һҳ��ʾ�ĵ�һ����¼������
			//��һҳ��ʾ�ļ�¼����
			query.setMaxResults(pageSize); 

			//ÿ�����5����¼
			List<ShoppingCartInfo> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}
	}
	
	//ɾ�����ﳵ
	public boolean deleteShoppingCartInfoById(int id){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			ShoppingCartInfo shoppingcartInfo=(ShoppingCartInfo)session.get(ShoppingCartInfo.class, id);
			transaction=session.beginTransaction();
			session.delete(shoppingcartInfo);
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//�ر�session
			session.close();
		}
	}
	
	
	//ͨ�����ﳵid��ɾ����ϸ��
	public boolean deleteShoppingCartBycartid(int cartid){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="delete from ShoppingCartInfo where cartid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cartid);
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
	//ɾ�����ﳵ
	public void deleteShoppingCartbycid(int cid){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="delete from ShoppingCart where cid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cid);
			transaction=session.beginTransaction();
			query.executeUpdate();
			transaction.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		
		}finally{//�ر�session
			session.close();
		}
	}
	
	
	
	public int queryShoppingcartInfobycartid(int cartid){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from ShoppingCartInfo where cid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cartid);
			List<ShoppingCart> list=query.list();
			if(list.toString()=="[]")
				return 0;
			ShoppingCart shoppingcart=list.get(0);
			int i=shoppingcart.getId();
			return i;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
		
	}
	
	//�鿴���ﳵ�Ƿ�Ϊ��
	public List<ShoppingCart> querShoppingCartBycid(int cid){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from ShoppingCart where cid=?";
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
	//�鿴����Ʒ�Ƿ���ڹ��ﳵ
	public ShoppingCartInfo queryShoppingCartInfoById(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from ShoppingCartInfo where id=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, id);
			List<ShoppingCartInfo> list=query.list();
			ShoppingCartInfo shoppingcartinfo =list.get(0);
			return shoppingcartinfo;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}
	}
	
	//������Ʒ����+1
	public boolean addShoppingcartbook(int id,int ordermount, double price){
		Session session=null;
		Transaction transaction=null;
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			String queryString="update ShoppingCartInfo sc set sc.ordermount=?+1,sc.price=?+sc.priceofonebook where id=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, ordermount);
			query.setParameter(1, price);
			query.setParameter(2, id);
			query.executeUpdate();
			int num=query.executeUpdate();
			session.getTransaction();
			transaction.commit();
			if(num==1){
				return true;
			}else{
				return false;
			}
	
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//�ر�session
			session.close();
		}
	}
	
	//���ڵ���Ʒ��1
	public boolean delShoppingcartbook(int id,int ordermount, double price){
		Session session=null;
		Transaction transaction=null;
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			String queryString="update ShoppingCartInfo sc set sc.ordermount=?-1,sc.price=?-sc.priceofonebook where id=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, ordermount);
			query.setParameter(1, price);
			query.setParameter(2, id);
			query.executeUpdate();
			int num=query.executeUpdate();
			session.getTransaction();
			transaction.commit();
			if(num==1){
				return true;
			}else{
				return false;
			}
	
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//�ر�session
			session.close();
		}
	}
	//�ܼ۸�ֵ��ȥ
	public boolean setshoppingcartallprice(int cid,double price){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			String queryString="update ShoppingCart shoppingcart set shoppingcart.allprice=? where cid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, price);
			query.setParameter(1, cid);
			query.executeUpdate();
			int num=query.executeUpdate();
			session.getTransaction();
			transaction.commit();
			if(num==1){
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//�ر�session
			session.close();
		}
	}
	
	
	
} 
