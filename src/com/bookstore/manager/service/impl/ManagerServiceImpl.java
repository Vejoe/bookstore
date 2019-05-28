package com.bookstore.manager.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.customer.model.Message;
import com.bookstore.manager.dao.ManagerDao;
import com.bookstore.manager.model.Manager;
import com.bookstore.manager.service.ManagerService;

import model.Order;
import model.Orderdetail;

public class ManagerServiceImpl implements ManagerService {
	//自动装填
	@Autowired
	ManagerDao managerDao;
	
	
	
	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	/**
	 * 对密码进行md5加密
	 */
	public String MD5(String password){
		String resultString = null;
		resultString = new String(password);
		MessageDigest md;// 信息摘要
		try
		{
			md = MessageDigest.getInstance("MD5");// 实例化
			md.update(password.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digest.length; i++)
			{
				sb.append(Integer.toHexString(((int) digest[i]) & 0xFF));
			}
			resultString = sb.toString();
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return resultString;
	}
	
	/**
	 * 查找用户和密码，验证登录
	 */
	public List findByUserIdPwd(Object name, Object password) {
		List lists = managerDao.findCaseByTwoProperty("Manager", "adminaccount", name, "adminpwd", password);
		return lists;
	}
	
	/**
	 * 存储对象
	 */
	public void save(Object entity){
		managerDao.save(entity);
	}
	
	/**
	 * 更新对象
	 */
	public void update(Object entity){
		managerDao.update(entity);
	}
	
	/**
	 * 删除对象
	 */
	public void delete(Object entity){
		managerDao.delete(entity);
	}
	
	/**
	 * 根据类名查看对应所有用例
	 */
	public List findAllCaseByClassName(String className)
	{
		List lists=managerDao.findAllCaseByClassName(className);
		return lists;
	}
	
	/**
	 * 分页查询
	 */
	public List queryByPage(int pageNo,int pageSize,String className)
	{
		List lists=managerDao.queryByPage(pageNo, pageSize, className);
		return lists;
	}
	
	/**
	 * 根据对应ID查找对应Manager信息
	 */
	public Manager findManagerById(Integer objId){
		Manager manager=(Manager)managerDao.findCaseById("com.bookstore.manager.model.Manager", objId);
		return manager;
	}
	
	/**
	 * 根据对应ID查找对应Order信息
	 */
	public Order findOrderById(Integer objId){
		Order order=(Order)managerDao.findCaseById("model.Order", objId);
		return order;
	}
	
	/**
	 * 根据对应ID查找对应OrderDetail信息
	 */
	public List findOrderdetailById(Integer objId){
		List lists=managerDao.getOrderDetailByOid(objId);
		return lists;
	}
	
	/**
	 * 根据对应ID查找对应message信息
	 */
	public Message findMessageById(Integer objId){
		Message message=(Message)managerDao.findCaseById("com.bookstore.customer.model.Message", objId);
		return message;
	}
	
	/**
	 * 查找用户名是否存在
	 *
	 */
	public boolean findManagerByAccount(Object account){
		List list=managerDao.findCaseByOneProperty("Manager", "adminaccount", account);
		if(list.isEmpty())
		return false;
		else
		return true;
	}
	
	/**
	 * 根据等级查找对应管理员
	 */
	public List findManagerByAdminflag(Integer obiId){
		List list=managerDao.findCaseByOneProperty("Manager", "adminflag", obiId);
		return list;
	}
	
	/**
	 * 根据等级分页查找对应管理员
	 */
	public List queryByPageManagerProperty(int pageNo,int pageSize,String className,String property,Object value){
		List lists=managerDao.queryByPageManagerProperty(pageNo,pageSize,className,property,value);
		return lists;
	}
	
	/**
	 * 根据某个属性模糊查找
	 */
	public List findCaseByLikeOneProperty(String className,String property,Object value){
		List list=managerDao.findCaseByLikeOneProperty(className, property, value);
		System.out.println(list.size());
		return list;
	}
	
	/**
	 * 根据某个属性分页模糊查找
	 */
	public List queryByPageLikeOneProperty(int pageNo,int pageSize,String className,String property,Object value){
		List lists=managerDao.queryByPageLikeOneProperty(pageNo,pageSize,className,property,value);
		return lists;
	}
}
