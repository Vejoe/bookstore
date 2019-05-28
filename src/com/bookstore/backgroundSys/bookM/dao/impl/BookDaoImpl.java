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
	//���ͼ�����
	public int addBookType(BookType booktype){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from BookType where type=?";
			//������ѯ
			Query query=session.createQuery(queryString);
			query.setParameter(0,booktype.getType());
			List list = query.list();
			if(list.size()>0){
				return num;
			}else{
				transaction=session.beginTransaction();
				num=Integer.parseInt(session.save(booktype).toString());
				transaction.commit(); //д�����ݿ�
			}
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{//�ر�session
			session.close();
		}
		return num;
	}
	//���ͼ��
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
				//������ѯ
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
					transaction.commit(); //д�����ݿ�
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{//�ر�session
			session.close();
			}
		return num;
	}
	//��ѯͼ�����
	public List<BookType> queryBookType(){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//hql���
			String queryString="from BookType";
			//������ѯ
			Query query=session.createQuery(queryString);
			//ִ�в�ѯ��õĽ��
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}
	}
	//��ҳ��ʾͼ�����
	public List<BookType> queryByPage(int pageNo,int pageSize){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from BookType";
			Query query=session.createQuery(queryString);
			//ÿ�λ�ȡ��һ�����ݵ�����
			query.setFirstResult((pageNo-1)*pageSize); //������һҳ��ʾ�ĵ�һ����¼������
			//��һҳ��ʾ�ļ�¼����
			query.setMaxResults(pageSize); 
			//ÿ�����5����¼
			List<BookType> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}	
	}
	//��ѯͼ����Ϣ
	public List<Book> queryBook(){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//hql���,
			String queryString="from Book";
			//������ѯ
			Query query=session.createQuery(queryString);
			//ִ�в�ѯ��õĽ��
			List<Book> list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}
	}
	//��ҳ��ʾͼ����Ϣ
	public List<Book> queryByPageFBook(int pageNo,int pageSize){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Book";
			Query query=session.createQuery(queryString);
			//ÿ�λ�ȡ��һ�����ݵ�����
			query.setFirstResult((pageNo-1)*pageSize); //������һҳ��ʾ�ĵ�һ����¼������
			//��һҳ��ʾ�ļ�¼����
			query.setMaxResults(pageSize); 
			//ÿ�����5����¼
			List<Book> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}	
	}

	//ɾ��ͼ��
	public boolean deleteBookByID(int id){
        Session session=null;
        try{
            session=sessionFactory.openSession();
            //����id��ȡҪ�޸ĵ�ͼ������
            Book book=(Book)session.get(Book.class, id);
            //ɾ��Book����
            Transaction trans=session.beginTransaction();
            session.delete(book);
            trans.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{//�ر�session
        	session.close();
        }
    }

    //����ID����ͼ��
	public List<Book> queryBookByID(int id){
		//�õ�session
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
		}finally{//�ر�session
			session.close();
		}
	}
	//�޸�ͼ����Ϣ
	public boolean changeBookByID(Book newbook){
		Session session=null;
		Map m=ActionContext.getContext().getSession();
		try{
			session=sessionFactory.openSession();
			int id=Integer.parseInt(String.valueOf(m.get("Bid")));
			//����id��ȡҪ�޸ĵ�ͼ������
			Book oldbook=(Book)session.get(Book.class, id);
			//�����µ�����
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
			//����oldbook���ݻ����ݿ�
			Transaction trans=session.beginTransaction();
			session.update(oldbook);
			trans.commit();
			return true;

		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//�ر�session
			session.close();
		}
	}
}
