package com.bookstore.customer.interfaces;

import java.util.List;

import com.bookstore.customer.model.Customer;
import com.bookstore.customer.model.Message;

public interface CustomerDaoInterface {
	//注册检验，判断是否重名用户名
	public boolean checkregister(Customer customer);
	//注册的方法,返回受影响行数
	public int register(Customer customer);
	//登录方法
	public boolean login(Customer customer);
	//通过账号查找到对应的用户信息
	public Customer QueryCustomerBycaccount(String caccount);
	//修改用户信息
	public boolean ChangeCustomerinformation(Customer customer);
	//添加留言
	public boolean AddMessage(Message message);
	//通过账号查找到对应的留言信息
	public List<Message> QueryMessageBycaccount(String caccount);
	//查询每页需要显示的数据(每次最多2条记录)
	public List<Message> queryMessagesByPage(int pageNo,int pageSize,String caccount);
	//根据id来获得Message信息
	public Message QueryMessageDetail(int id);
}
