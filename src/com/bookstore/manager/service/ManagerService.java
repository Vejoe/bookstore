package com.bookstore.manager.service;

import java.util.List;

import com.bookstore.customer.model.Message;
import com.bookstore.manager.model.Manager;


import model.Order;

public interface ManagerService {
	
	/**
	 * 对密码进行md5加密
	 * @param password
	 * @return
	 */
	public String MD5(String password);
	
	
	/**
	 * 查找用户名和密码,判断登录
	 * @param name
	 * @param password
	 * @return
	 */
	public List findByUserIdPwd(Object name,Object password);
	
	
	/**
	 * 增加对象
	 */
	public void save(Object entity);
	
	
	/**
	 * 更新对象
	 */
	public void update(Object entity);
	
	/**
	 * 删除对象
	 */
	public void delete(Object entity);
	
	/**
	 * 根据类名查看该类所有对象
	 */
	public List findAllCaseByClassName(String className);
	
	/**
	 * 分页查询
	 */
	public List queryByPage(int pageNo,int pageSize,String className);
	
	/**
	 * 根据对应ID查找对应Manager信息
	 */
	public Manager findManagerById(Integer objId);
	
	/**
	 * 根据对应ID查找对应Order信息
	 */
	public Order findOrderById(Integer objId);
	
	/**
	 * 根据对应ID查找对应OrderDetail信息
	 */
	public List findOrderdetailById(Integer objId);
	
	/**
	 * 根据对应ID查找对应message信息
	 */
	public Message findMessageById(Integer objId);
	
	/**
	 * 查找用户名是否存在
	 *
	 */
	public boolean findManagerByAccount(Object account);
	
	/**
	 * 根据等级查找对应管理员
	 */
	public List findManagerByAdminflag(Integer obiId);
	
	/**
	 * 根据等级分页查找对应管理员
	 */
	public List queryByPageManagerProperty(int pageNo,int pageSize,String className,String property,Object value);
	
	/**
	 * 根据某个属性模糊查找
	 */
	public List findCaseByLikeOneProperty(String className,String property,Object value);
	
	/**
	 * 根据某个属性分页模糊查找
	 */
	public List queryByPageLikeOneProperty(int pageNo,int pageSize,String className,String property,Object value);
}
