package com.bookstore.backgroundSys.bookM.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.backgroundSys.bookM.dao.BookDao;
import com.bookstore.product.model.Book;
import com.bookstore.product.model.BookType;



public class BookDaoImpl implements BookDao {
	@Autowired
	SessionFactory sessionFactory;
	public BookDaoImpl(){
		
	}
	public SessionFactory getSessionfactory() {
		return sessionFactory;
	}

	public void setSessionfactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//添加图书类别
	public int addBookType(BookType booktype){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from BookType where type=?";
			//创建查询
			Query query=session.createQuery(queryString);
			query.setParameter(0,booktype.getType());
			List list = query.list();
			if(list.size()>0){
				return num;
			}else{
				transaction=session.beginTransaction();
				num=Integer.parseInt(session.save(booktype).toString());
				transaction.commit(); //写入数据库
			}
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{//关闭session
			session.close();
		}
		return num;
	}
	//添加图书
	public int addBook(Book book){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString1="from BookType where id=?";
			Query query1=session.createQuery(queryString1);
			query1.setParameter(0,book.getBooktype().getId());
			List list1= query1.list();
			if(list1.size()==0) {
				return num;
			}else{
				String queryString = "from Book where bookname=? and publisher=? and publisher_year=? and author=?";
				//创建查询
				Query query = session.createQuery(queryString);
				query.setParameter(0, book.getBookname());
				query.setParameter(1, book.getPublisher());
				query.setParameter(2, book.getPublisher_year());
				query.setParameter(3, book.getAuthor());
				List list = query.list();
				if (list.size() > 0) {
					return num;
				} else {
					transaction = session.beginTransaction();
					num = Integer.parseInt(session.save(book).toString());
					transaction.commit(); //写入数据库
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{//关闭session
			session.close();
			}
		return num;
	}
	//查询图书类别
	public List<BookType> queryBookType(){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//hql语句
			String queryString="from BookType";
			//创建查询
			Query query=session.createQuery(queryString);
			//执行查询获得的结果
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}
	}
	//分页显示图书类别
	public List<BookType> queryByPage(int pageNo,int pageSize){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from BookType";
			Query query=session.createQuery(queryString);
			//每次获取第一条数据的索引
			query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//这一页显示的记录个数
			query.setMaxResults(pageSize); 
			//每次最多5条记录
			List<BookType> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	//查询图书信息
	public List<Book> queryBook(){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//hql语句,
			String queryString="from Book";
			//创建查询
			Query query=session.createQuery(queryString);
			//执行查询获得的结果
			List<Book> list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}
	}
	//分页显示图书信息
	public List<Book> queryByPageFBook(int pageNo,int pageSize){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Book";
			Query query=session.createQuery(queryString);
			//每次获取第一条数据的索引
			query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//这一页显示的记录个数
			query.setMaxResults(pageSize); 
			//每次最多5条记录
			List<Book> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}

	//删除图书
	public boolean deleteBookByID(int id){
        Session session=null;
        try{
            session=sessionFactory.openSession();
            //根据id获取要修改的图书数据
            Book book=(Book)session.get(Book.class, id);
            //删除Book数据
            Transaction trans=session.beginTransaction();
            session.delete(book);
            trans.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{//关闭session
        	session.close();
        }
    }

    //根据ID查找图书
	public List<Book> queryBookByID(int id){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Book where id=?";
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
		}finally{//关闭session
			session.close();
		}
	}
	//修改图书信息
	public boolean changeBookByID(Book newbook){
		Session session=null;
		Map m=ActionContext.getContext().getSession();
		try{
			session=sessionFactory.openSession();
			int id=Integer.parseInt(String.valueOf(m.get("Bid")));
			//根据id获取要修改的图书数据
			Book oldbook=(Book)session.get(Book.class, id);
			//设置新的数据
			oldbook.setBookname(newbook.getBookname());
			oldbook.setBooktype(newbook.getBooktype());
			oldbook.setProfile(newbook.getProfile());
			oldbook.setPublisher(newbook.getPublisher());
			oldbook.setPublisher_year(newbook.getPublisher_year());
			oldbook.setAuthor(newbook.getAuthor());
			oldbook.setPrice(newbook.getPrice());
			oldbook.setStocks(newbook.getStocks());
			oldbook.setRank_price(newbook.getRank_price());
			oldbook.setBookfilename(newbook.getBookfilename());
			//保存oldbook数据回数据库
			Transaction trans=session.beginTransaction();
			session.update(oldbook);
			trans.commit();
			return true;

		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}
	}
}
