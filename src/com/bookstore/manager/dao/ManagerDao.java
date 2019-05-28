package com.bookstore.manager.dao;

import java.util.List;

import com.bookstore.manager.model.Manager;

public interface ManagerDao {
	//添加新的对象
	public void save(Object entity);
	
	//更新对象
	public void update(Object entity);
	
	//删除对象
	public void delete(Object entity);
	
	//通过类名查找所有实例
	public List findAllCaseByClassName(String className);
	
	//通过ID查找实例
	public Object findCaseById(String className,Integer objId);
	
	//通过一个属性值查找实例
	public List findCaseByOneProperty(String className,String property,Object value);
	
	//通过两个属性值查找实例
	public List findCaseByTwoProperty(String className,String property1,Object value1,String property2,Object value2);
	
	//分页查询
	public List queryByPage(int pageNo,int pageSize,String className);
	
	//根据订单主表编号获取订单明细列表
	public List getOrderDetailByOid(Integer orderid);
	
	
	// 根据某一种属性分页查找对应管理员
	public List queryByPageManagerProperty(int pageNo,int pageSize,String className,String property,Object value);
	
	//通过一个属性值模糊查找实例
	public List findCaseByLikeOneProperty(String className,String property,Object value);
	
	// 根据某一种属性分页查找对应管理员
	public List queryByPageLikeOneProperty(int pageNo,int pageSize,String className,String property,Object value);
}
