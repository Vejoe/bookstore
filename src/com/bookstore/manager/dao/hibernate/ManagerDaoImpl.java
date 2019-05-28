package com.bookstore.manager.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;


import com.bookstore.manager.dao.ManagerDao;

import model.Orderdetail;

public class ManagerDaoImpl implements ManagerDao {
	@Autowired
	SessionFactory sessionfactory;
	
	private static final Log log=LogFactory.getLog(ManagerDaoImpl.class);
	
	
	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	//增加对象
	@Override
	public void save(Object entity) {
		Session session=null;
		Transaction transaction=null;
		try{
		session=sessionfactory.openSession();
		transaction=session.beginTransaction();
		session.save(entity);
		transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}

	}

	//更新对象
	@Override
	public void update(Object entity) {
		
		Session session=null;
		Transaction transaction=null;
		try{
		session=sessionfactory.openSession();
		transaction=session.beginTransaction();
		session.saveOrUpdate(entity);
		transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	//删除对象
	@Override
	public void delete(Object entity) {
		Session session=null;
		Transaction transaction=null;
		try{
		session=sessionfactory.openSession();
		transaction=session.beginTransaction();
		session.delete(entity);
		transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}

	}

	//通过类名查找所有实例
	@Override
	public List findAllCaseByClassName(String className) {
		Session session=null;
		Transaction transaction=null;
		try{
		session=sessionfactory.openSession();
		transaction=session.beginTransaction();
		String queryString="From "+className;
		Query query=session.createQuery(queryString);
		List list=query.list();
		transaction.commit();
		return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

	//通过ID查找实例
	@Override
	public Object findCaseById(String className, Integer objId) {
		Session session=null;
		Transaction transaction=null;
		try{
		session=sessionfactory.openSession();
		transaction=session.beginTransaction();
		Object object=session.get(className, objId);
		transaction.commit();
		return object;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

	//通过一个属性值查找实例
	@Override
	public List findCaseByOneProperty(String className, String property, Object value) {
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			String queryString="From "+className+" as model where model."+property+"='"+value+"'";
			Query query=session.createQuery(queryString);
			System.out.println(queryString);
			List list=query.list();
			transaction.commit();
			return list;
		}catch(Exception e){
			return null;
		}finally{
			session.close();
		}
	}

	// 通过两个属性值查找实例
	@Override
	public List findCaseByTwoProperty(String className, String property1, Object value1, String property2,
			Object value2) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			String queryString = "From " + className + " as model where model." + property1 + "='" + value1
					+ "' and model." + property2 + "='" + value2 + "'";
			Query query = session.createQuery(queryString);
			List list=query.list();
			transaction.commit();
			return list;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}
	
	
	//分页查询
	public List queryByPage(int pageNo,int pageSize,String className)
	{
		Session session = null;
		Transaction transaction = null;
		try{
			session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			String queryString="From "+className;
			Query query = session.createQuery(queryString);
			//每次获取第一条数据的索引
			query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//这一页显示的记录个数
			query.setMaxResults(pageSize); 
			List lists=query.list();
			return lists;
		}catch(Exception e)
		{
			return null;
		}finally{
			session.close();
		}
	}
	
	//根据订单主表编号获取订单明细列表
		public List getOrderDetailByOid(Integer orderid){
				Session session = null;
				Transaction transaction = null;
				try{
				session=sessionfactory.openSession();
				transaction=session.beginTransaction();
				Criteria c=session.createCriteria(Orderdetail.class);
				c.add(Restrictions.eq("order.id", orderid));
				return c.list();
				}catch(Exception e){
					return null;
				}finally{
					session.close();
				}
		}
		
		
		// 根据某一种属性分页查找对应管理员
		public List queryByPageManagerProperty(int pageNo,int pageSize,String className,String property,Object value){
			Session session = null;
			Transaction transaction = null;
			try{
				session=sessionfactory.openSession();
				transaction=session.beginTransaction();
				String queryString="From "+className+" as model where model."+property+"='"+value+"'";
				Query query = session.createQuery(queryString);
				//每次获取第一条数据的索引
				query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
				//这一页显示的记录个数
				query.setMaxResults(pageSize); 
				List lists=query.list();
				return lists;
			}catch(Exception e)
			{
				return null;
			}finally{
				session.close();
			}
		}
		
		//通过一个属性值模糊查找实例
		public List findCaseByLikeOneProperty(String className,String property,Object value){
			Session session=null;
			Transaction transaction=null;
			try{
				session=sessionfactory.openSession();
				transaction=session.beginTransaction();
				String queryString="From "+className+" as model where model."+property+" like '%"+value+"%'";
				Query query=session.createQuery(queryString);
				System.out.println(queryString);
				List list=query.list();
				transaction.commit();
				return list;
			}catch(Exception e){
				return null;
			}finally{
				session.close();
			}
		}
		
		// 根据某一种属性分页查找对应管理员
		public List queryByPageLikeOneProperty(int pageNo,int pageSize,String className,String property,Object value){
			Session session = null;
			Transaction transaction = null;
			try{
				session=sessionfactory.openSession();
				transaction=session.beginTransaction();
				String queryString="From "+className+" as model where model."+property+" like '%"+value+"%'";
				Query query = session.createQuery(queryString);
				//每次获取第一条数据的索引
				query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
				//这一页显示的记录个数
				query.setMaxResults(pageSize); 
				List lists=query.list();
				return lists;
			}catch(Exception e)
			{
				return null;
			}finally{
				session.close();
			}
		}
}
