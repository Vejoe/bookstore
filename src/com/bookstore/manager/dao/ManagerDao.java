package com.bookstore.manager.dao;

import java.util.List;

import com.bookstore.manager.model.Manager;

public interface ManagerDao {
	//����µĶ���
	public void save(Object entity);
	
	//���¶���
	public void update(Object entity);
	
	//ɾ������
	public void delete(Object entity);
	
	//ͨ��������������ʵ��
	public List findAllCaseByClassName(String className);
	
	//ͨ��ID����ʵ��
	public Object findCaseById(String className,Integer objId);
	
	//ͨ��һ������ֵ����ʵ��
	public List findCaseByOneProperty(String className,String property,Object value);
	
	//ͨ����������ֵ����ʵ��
	public List findCaseByTwoProperty(String className,String property1,Object value1,String property2,Object value2);
	
	//��ҳ��ѯ
	public List queryByPage(int pageNo,int pageSize,String className);
	
	//���ݶ��������Ż�ȡ������ϸ�б�
	public List getOrderDetailByOid(Integer orderid);
	
	
	// ����ĳһ�����Է�ҳ���Ҷ�Ӧ����Ա
	public List queryByPageManagerProperty(int pageNo,int pageSize,String className,String property,Object value);
	
	//ͨ��һ������ֵģ������ʵ��
	public List findCaseByLikeOneProperty(String className,String property,Object value);
	
	// ����ĳһ�����Է�ҳ���Ҷ�Ӧ����Ա
	public List queryByPageLikeOneProperty(int pageNo,int pageSize,String className,String property,Object value);
}
