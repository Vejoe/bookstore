package com.bookstore.product.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bookstore.customer.model.Customer;
import com.bookstore.product.dao.productDao;
import com.bookstore.product.model.Book;
import com.bookstore.product.model.BookType;
import com.bookstore.product.model.Collection;
import com.bookstore.product.model.Comment;
import com.bookstore.shoppingcart.model.ShoppingCart;
import com.bookstore.shoppingcart.model.ShoppingCartInfo;

public class productDaoImpl implements productDao{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//��ȡ�����鼮�����͡�
	public  List<BookType> findBookType(){
		Session session=sessionFactory.openSession();
		try{
			String queryString="from BookType";
			Query query=session.createQuery(queryString);
			List<BookType> list=query.list();
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
	
	//����id��ȡ�鼮��Ϣ��
	public  Book findonebookbyID(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Book where id=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, id);
			List<Book> list=query.list();
			Book book=new Book();
			if(list.size()>0){
				book=(Book)list.get(0);
				return book;}
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
	
	public int getmaxbookid(){
		Session session=null;
		int sum=0;
		try{
			session=sessionFactory.openSession();
			String queryString="select max(id) from Book";
			Query query=session.createQuery(queryString);
			sum=Integer.parseInt(query.list().get(0).toString());
			return sum;
		}catch (Exception e) {
			e.printStackTrace();
			return sum;
		}finally{//�ر�session
			session.close();
		}
	}
	
	public Book queryBookById(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			Book book=(Book)session.get(Book.class, id);
			return book ;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}	
	}
	public List<Book> shownewbook(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Book order by id desc";
			Query query=session.createQuery(queryString);
			query.setFirstResult(0);
			query.setMaxResults(6); 
			List<Book> newbook=query.list();
			if(newbook.size()>0)
				return newbook;
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
	
	public List<Book> showhotbook(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Book order by bookdealmount desc";
			Query query=session.createQuery(queryString);
			query.setFirstResult(0);
			query.setMaxResults(6); 
			List<Book> hotbook=query.list();
			if(hotbook.size()>0)
				return hotbook;
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
	
	//�����鼮���͵�ID��״̬��ȡ��ID�����鼮��״̬��
	public List<Book> showbookbyTypeId(int now_page,int maxnum,int Page_booktype_num,int Page_booktype_id,int Page_bookstatus){
		System.out.println("showbookbyTypeId");
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="";
			List<Book> newbook=new ArrayList();
			if(Page_booktype_num==0){
				queryString=queryString+"from Book ";
				if(Page_bookstatus==1){
					queryString=queryString+"order by bookdealmount desc";	
				}else if(Page_bookstatus==2){
					queryString=queryString+"order by booklookmount desc";		
				}else if(Page_bookstatus==3){
					queryString=queryString+"order by id desc";	
				}
				Query query=session.createQuery(queryString);
				query.setFirstResult(0);
				query.setMaxResults(maxnum); 
				newbook=query.list();
			}else{
				queryString=queryString+"from Book where typeid=? ";
				if(Page_bookstatus==1){
					queryString=queryString+"order by bookdealmount desc";	
				}else if(Page_bookstatus==2){
					queryString=queryString+"order by booklookmount desc";		
				}else if(Page_bookstatus==3){
					queryString=queryString+"order by id desc";	
				}
				Query query=session.createQuery(queryString);
				query.setParameter(0, Page_booktype_id);
				query.setFirstResult(0);
				query.setMaxResults(maxnum);  
				newbook=query.list();
			}
			System.out.println(Page_booktype_id+"!!"+Page_bookstatus+queryString);
			if(newbook.size()>0)
				return newbook;
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
	
	//�����鼮���͵�ID��ȡ��ID�����鼮��
	public List<Book> showAllbookbyTypeId(int now_page,int maxnum,int Page_booktype_num,int Page_booktype_id){
		System.out.println("showAllbookbyTypeId");
		Session session=null;
		List<Book> allbook=new ArrayList();
		try{
			session=sessionFactory.openSession();
			String queryString="";
			if(Page_booktype_num==0){//0�����������͵��鼮��
				queryString=queryString+"from Book";	
				Query query=session.createQuery(queryString);
				query.setFirstResult((now_page-1)*maxnum);
				query.setMaxResults(maxnum); 
				allbook=query.list();
			}else{
				queryString=queryString+"from Book where typeid=?";
				Query query=session.createQuery(queryString);
				query.setParameter(0, Page_booktype_id);
				query.setFirstResult((now_page-1)*maxnum);
				query.setMaxResults(maxnum); 
				allbook=query.list();
			}
			System.out.println("allbook.size():"+allbook.size());
			if(allbook.size()>0)
				return allbook;
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
	public int	showbookbyTypeId_num(int Page_booktype_num,int Page_booktype_id,int Page_bookstatus){
		System.out.println("showbookbyTypeId_num");
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="";
			int totalnum;
			if(Page_booktype_num==0){
				queryString=queryString+"select count(*) from Book ";
				Query query=session.createQuery(queryString);
				System.out.println("showbookbyTypeId_num!!!!!");
				totalnum=Integer.parseInt(query.list().get(0).toString());
			}else{
				queryString=queryString+"select count(*) from Book where typeid=? ";
				Query query=session.createQuery(queryString);
				query.setParameter(0, Page_booktype_id);
				System.out.println("showbookbyTypeId_num!!!!!");
				totalnum=Integer.parseInt(query.list().get(0).toString());
			}
			System.out.println("showbookbyTypeId_num"+totalnum);
				return totalnum;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{//�ر�session
			session.close();
		}
	}
	
	public int showAllbookbyTypeId_num(int Page_booktype_num,int Page_booktype_id){
		System.out.println("showAllbookbyTypeId_num");
		Session session=null;
		int totalnum;
		try{
			session=sessionFactory.openSession();
			String queryString="";
			if(Page_booktype_num==0){//0�����������͵��鼮��
				queryString=queryString+"select count(*) from Book";	
				Query query=session.createQuery(queryString);
				System.out.println("showbookbyTypeId_num!!!!!");
				totalnum=Integer.parseInt(query.list().get(0).toString());
			}else{
				queryString=queryString+"select count(*) from Book where typeid=?";
				Query query=session.createQuery(queryString);
				query.setParameter(0, Page_booktype_id);
				System.out.println("showbookbyTypeId_num!!!!!");
				totalnum=Integer.parseInt(query.list().get(0).toString());
			}
			System.out.println("showbookbyTypeId_num"+totalnum);
			return totalnum;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{//�ر�session
			session.close();
		}
	}
	
	public List<Book> showAllbookbysousuo(String bookmessage){
		System.out.println("showAllbookbysousuo+"+bookmessage);
		Session session=null;
		if(bookmessage==null)
			return null;
		if(bookmessage.length()==0)
			return null;
		String newbookmessage="%";
		for(int i=0;i<bookmessage.length();i++){
			newbookmessage+=bookmessage.substring(i,i+1)+"%";
		}
		System.out.println(newbookmessage);
		try{
			session=sessionFactory.openSession();
			String hql  = " from Book where bookname like '"+newbookmessage+"'"; 
			Query qu = session.createQuery(hql);
			
			List<Book> sousuobook = qu.list();
			if(sousuobook.size()>0){
				System.out.println("sousuobook.size()��"+sousuobook.size());			
				return sousuobook;
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
		
	public ShoppingCart findCustomerShoppingcart(Customer customer){
		System.out.println("findCustomerShoppingcart");
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql  = " from ShoppingCart shoppingcart where shoppingcart.customer.id=?"; 
			Query query = session.createQuery(hql);
			query.setParameter(0, customer.getId());
			List list=query.list();
			ShoppingCart shoppingCart = new ShoppingCart();;
			if(list.size()>0){
				shoppingCart=(ShoppingCart)(list.get(0));
				return shoppingCart;
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
	

	
	
	public ShoppingCartInfo findCustomerShoppingcartInfo(ShoppingCart shoppingcart,Book book){
		System.out.println("findCustomerShoppingcartInfo");
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql  = " from ShoppingCartInfo shoppingCartInfo where shoppingCartInfo.shoppingcart.id=? and shoppingCartInfo.book.id=?"; 
			Query qu = session.createQuery(hql);
			qu.setParameter(0, shoppingcart.getId());
			qu.setParameter(1, book.getId());
			List list = qu.list();
			ShoppingCartInfo shoppingCartInfo=new ShoppingCartInfo();
			if(list.size()>0){
				shoppingCartInfo=(ShoppingCartInfo)list.get(0);
				return shoppingCartInfo;
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
	
	public int saveCustomerShoppingcart(ShoppingCart shoppingCart){
		System.out.println("saveCustomerShoppingcart");
		int num=0;//��ʶע���Ƿ�ɹ�,0��ʾ���ɹ�,>0�ɹ�
		//�õ�session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(shoppingCart).toString());
			transaction.commit(); //д�����ݿ⣬
		}catch (Exception e) {
			e.printStackTrace();
		}finally{//�ر�session
			session.close();//����HibernateSessionFactory�ľ�̬�����ر�Session
		}
		return num;
	}
	
	public int saveCustomerShoppingcartInfo(ShoppingCartInfo shoppingCartInfo){
		System.out.println("saveCustomerShoppingcartInfo");
		int num=0;//��ʶע���Ƿ�ɹ�,0��ʾ���ɹ�,>0�ɹ�
		//�õ�session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(shoppingCartInfo).toString());
			transaction.commit(); //д�����ݿ⣬
		}catch (Exception e) {
			e.printStackTrace();
		}finally{//�ر�session
			session.close();//����HibernateSessionFactory�ľ�̬�����ر�Session
		}
		return num;
	}
	
	public int updateCustomerShoppingcartInfo(ShoppingCartInfo shoppingcartInfo){
		System.out.println("saveCustomerShoppingcartInfo");
		int num=0;//��ʶע���Ƿ�ɹ�,0��ʾ���ɹ�,>0�ɹ�
		//�õ�session
		Session session=null;
		try{	
			session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			String hql="update ShoppingCartInfo shoppingCartInfo set shoppingCartInfo.ordermount=?,shoppingCartInfo.price=? where shoppingCartInfo.id=?";
			Query queryupdate=session.createQuery(hql);
			queryupdate.setParameter(0, shoppingcartInfo.getOrdermount()+1);
			queryupdate.setParameter(1, (shoppingcartInfo.getOrdermount()+1)*shoppingcartInfo.getPriceofonebook());
			queryupdate.setParameter(2, shoppingcartInfo.getId());
			int ret=queryupdate.executeUpdate();
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{//�ر�session
			session.close();//����HibernateSessionFactory�ľ�̬�����ر�Session
		}
		return num;
	}
	
	public double checkCustomerShoppingcartInfoallprice(ShoppingCart shoppingCart){
		Session session=null;
		double sum=0;
		try{
			session=sessionFactory.openSession();
			String queryString="select sum(price) from ShoppingCartInfo shoppingCartInfo where shoppingCartInfo.shoppingcart.id=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, shoppingCart.getId());
			sum=Double.parseDouble(query.list().get(0).toString());
			return sum;
		}catch (Exception e) {
			e.printStackTrace();
			return sum;
		}finally{//�ر�session
			session.close();
		}
	}
	
	public int updateCustomerShoppingcart(int cartid,double allprice){
		System.out.println("updateCustomerShoppingcart");
		int num=0;//��ʶע���Ƿ�ɹ�,0��ʾ���ɹ�,>0�ɹ�
		//�õ�session
		Session session=null;
		try{	
			session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			String hql="update ShoppingCart shoppingCart set shoppingCart.allprice=? where shoppingCart.id=?";
			Query queryupdate=session.createQuery(hql);
			queryupdate.setParameter(0, allprice);
			queryupdate.setParameter(1, cartid);
			int ret=queryupdate.executeUpdate();
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{//�ر�session
			session.close();//����HibernateSessionFactory�ľ�̬�����ر�Session
		}
		return num;
	}
	
	public int saveCustomerComment(Comment comment){
		System.out.println("saveCustomerShoppingcartInfo");
		int num=0;//��ʶע���Ƿ�ɹ�,0��ʾ���ɹ�,>0�ɹ�
		//�õ�session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(comment).toString());
			transaction.commit(); //д�����ݿ⣬
		}catch (Exception e) {
			e.printStackTrace();
		}finally{//�ر�session
			session.close();//����HibernateSessionFactory�ľ�̬�����ر�Session
		}
		return num;
	}
	

	

	public List<Comment> showAllCommentbybookid(int now_page,int maxnum,int bookid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql  = " from Comment where bookid=?"; 
			Query qu = session.createQuery(hql);
			qu.setParameter(0, bookid);
			if(!(now_page==1&&maxnum==0)){
				qu.setFirstResult((now_page-1)*maxnum);
				qu.setMaxResults(maxnum);  
			}
			List<Comment> bookcomment = qu.list();
			
			if(bookcomment.size()>0){
				return bookcomment;
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
	

	public int savecollection(Collection collection){
		int num=0;//��ʶע���Ƿ�ɹ�,0��ʾ���ɹ�,>0�ɹ�
		//�õ�session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(collection).toString());
			transaction.commit(); //д�����ݿ⣬
		}catch (Exception e) {
			e.printStackTrace();
		}finally{//�ر�session
			session.close();//����HibernateSessionFactory�ľ�̬�����ر�Session
		}
		return num;
	}
	
	public Collection checkcollection(int bookid,int customerid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Collection where bookid=? and customerid=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, bookid);
			query.setParameter(1, customerid);
			List list=query.list();
			if(list.size()>0){
				Collection collection=(Collection)list.get(0);
				System.out.println("Collection.size������"+collection.getId());
				return collection;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();//����HibernateSessionFactory�ľ�̬�����ر�Session
		}
	}
	
	
	   public void deletecollection(int bookid,int customerid) { 
		   Session session=null;
		   try{
				session=sessionFactory.openSession();
		        Transaction tran = session.beginTransaction() ;     
		        String hql = "Delete FROM Collection Where bookid=? and customerid=?" ;     
		        Query q = session.createQuery(hql) ;     
		        q.setParameter(0, bookid);  
		        q.setParameter(1, customerid);
		        q.executeUpdate() ;     
		        tran.commit() ;     
		   } catch (Exception e) {
				e.printStackTrace();
			}finally{//�ر�session
				session.close();//����HibernateSessionFactory�ľ�̬�����ر�Session
			}
	   }
	   public List<Collection> findcollection(int now_page,int maxnum,int customerid){
		   Session session=null;
		   System.out.println("now_page:"+now_page+";maxnum:"+maxnum);
		   try{
				session=sessionFactory.openSession();
				String hql  = " from Collection where customerid=?"; 
				Query qu = session.createQuery(hql);
				qu.setParameter(0, customerid);
				if(!(now_page==1&&maxnum==0)){
					qu.setFirstResult((now_page-1)*maxnum);
					qu.setMaxResults(maxnum);  
				}
				
				List<Collection> book_colletion = qu.list();
				if(book_colletion.size()>0){
					System.out.println("findcollection:"+book_colletion.size());
					return book_colletion;
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
	  public void upatebooklookmount(Book book){
		  Session session=null;
		  try{
			  session=sessionFactory.openSession();
				Transaction trans=session.beginTransaction();
				String hql="update Book book set book.booklookmount=? where book.id=?";
				Query queryupdate=session.createQuery(hql);
				queryupdate.setParameter(0, book.getBooklookmount()+1);
				queryupdate.setParameter(1, book.getId());
				int ret=queryupdate.executeUpdate();
				trans.commit();
		  }catch(Exception e){
			  System.out.println("���������ʧ�ܣ�");
			  e.printStackTrace();
		  }
	  }
}
