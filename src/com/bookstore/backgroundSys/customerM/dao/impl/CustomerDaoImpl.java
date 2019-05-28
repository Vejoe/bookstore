package com.bookstore.backgroundSys.customerM.dao.impl;

import com.bookstore.backgroundSys.customerM.dao.CustomerDao;
import com.bookstore.customer.model.Customer;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class CustomerDaoImpl implements CustomerDao {
	
    @Autowired
	SessionFactory sessionFactory;
    public CustomerDaoImpl(){
    	
    }
	public SessionFactory getSessionfactory() {
		return sessionFactory;
	}

	public void setSessionfactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//查询顾客信息
    public List<Customer> queryCustomer(){
        Session session=null;
        try{
            session=sessionFactory.openSession();
            String queryString="from Customer";
            Query query=session.createQuery(queryString);
            List list=query.list();
            if(list.size()>0)
                return list;
            else{
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
        	session.close();
        }
    }
    
    //分页显示顾客信息
    public List<Customer> queryByPage(int pageNo,int pageSize){
        Session session=null;
        try{
            session=sessionFactory.openSession();
            String queryString="from Customer";
            Query query=session.createQuery(queryString);            
            query.setFirstResult((pageNo-1)*pageSize); 
            query.setMaxResults(pageSize);
            List<Customer> list=query.list();
            return list;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
        	session.close();
        }
    }
   
    //通过id查询顾客信息
    public List<Customer> queryCustomerByID(int id){
        
        Session session=null;
        try{
            session=sessionFactory.openSession();
            String queryString="from Customer where id=?";
            Query query=session.createQuery(queryString);
            query.setParameter(0, id);
            List list=query.list();
            if(list.size()>0){
                return list;
            }else{
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
        	session.close();
        }
    }

    //通过id修改顾客信息
    public boolean changeCustomerByID(Customer ncustomer){
        Session session=null;
        Map m=ActionContext.getContext().getSession();
        try{
            session=sessionFactory.openSession();
            int id=Integer.parseInt(String.valueOf(m.get("Cid")));
            Customer ocustomer=(Customer)session.get(Customer.class, id);
            System.out.println(ncustomer.getCname()+"//"+id);
            ocustomer.setCname(ncustomer.getCname());
            ocustomer.setPassword(ncustomer.getPassword());
            ocustomer.setSex(ncustomer.getSex());
            ocustomer.setEmail(ncustomer.getEmail());
            ocustomer.setPhone_num(ncustomer.getPhone_num());
            ocustomer.setBirthday(ncustomer.getBirthday());
            Transaction trans=session.beginTransaction();
            session.update(ocustomer);
            trans.commit();
            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
        	session.close();
        }
    }


}
