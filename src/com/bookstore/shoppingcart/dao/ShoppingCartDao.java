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
	//采用自动装配
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
	
	//根据用户id得到购物车id
	public int getshoppingcartid(int cid){
		//得到session
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
	

	
	//根据用户id得到购物车
	public ShoppingCart getshoppingcart(int cid){
		//得到session
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
	
	
	
	
	
	//根据购物车id查询购物车详细表里的信息
	public List<ShoppingCartInfo> showshoppingcartInfo(int cartid){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from ShoppingCartInfo where cartid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cartid);
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
	
	//获得相关书籍信息
	public List<Book> getBook(int bookid){
		//得到session
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
	//添加会员商品//添加普通用户商品
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
		}finally{//关闭session
			session.close();
		}
		return num;
	}
	
	//分页显示
	public List<ShoppingCartInfo>queryByPage(int pageNo,int pageSize,int cartid){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from ShoppingCartInfo where cartid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cartid);
			//每次获取第一条数据的索引
			query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//这一页显示的记录个数
			query.setMaxResults(pageSize); 

			//每次最多5条记录
			List<ShoppingCartInfo> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}
	}
	
	//删除购物车
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
		}finally{//关闭session
			session.close();
		}
	}
	
	
	//通过购物车id来删除详细表
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
		}finally{//关闭session
			session.close();
		}
	}
	//删除购物车
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
		
		}finally{//关闭session
			session.close();
		}
	}
	
	
	
	public int queryShoppingcartInfobycartid(int cartid){
		//得到session
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
	
	//查看购物车是否为空
	public List<ShoppingCart> querShoppingCartBycid(int cid){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from ShoppingCart where cid=?";
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
	//查看该商品是否存在购物车
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
		}finally{//关闭session
			session.close();
		}
	}
	
	//存在商品数量+1
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
		}finally{//关闭session
			session.close();
		}
	}
	
	//存在的商品—1
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
		}finally{//关闭session
			session.close();
		}
	}
	//总价格赋值回去
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
		}finally{//关闭session
			session.close();
		}
	}
	
	
	
} 
