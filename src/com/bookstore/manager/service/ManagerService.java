package com.bookstore.manager.service;

import java.util.List;

import com.bookstore.customer.model.Message;
import com.bookstore.manager.model.Manager;


import model.Order;

public interface ManagerService {
	
	/**
	 * ���������md5����
	 * @param password
	 * @return
	 */
	public String MD5(String password);
	
	
	/**
	 * �����û���������,�жϵ�¼
	 * @param name
	 * @param password
	 * @return
	 */
	public List findByUserIdPwd(Object name,Object password);
	
	
	/**
	 * ���Ӷ���
	 */
	public void save(Object entity);
	
	
	/**
	 * ���¶���
	 */
	public void update(Object entity);
	
	/**
	 * ɾ������
	 */
	public void delete(Object entity);
	
	/**
	 * ���������鿴�������ж���
	 */
	public List findAllCaseByClassName(String className);
	
	/**
	 * ��ҳ��ѯ
	 */
	public List queryByPage(int pageNo,int pageSize,String className);
	
	/**
	 * ���ݶ�ӦID���Ҷ�ӦManager��Ϣ
	 */
	public Manager findManagerById(Integer objId);
	
	/**
	 * ���ݶ�ӦID���Ҷ�ӦOrder��Ϣ
	 */
	public Order findOrderById(Integer objId);
	
	/**
	 * ���ݶ�ӦID���Ҷ�ӦOrderDetail��Ϣ
	 */
	public List findOrderdetailById(Integer objId);
	
	/**
	 * ���ݶ�ӦID���Ҷ�Ӧmessage��Ϣ
	 */
	public Message findMessageById(Integer objId);
	
	/**
	 * �����û����Ƿ����
	 *
	 */
	public boolean findManagerByAccount(Object account);
	
	/**
	 * ���ݵȼ����Ҷ�Ӧ����Ա
	 */
	public List findManagerByAdminflag(Integer obiId);
	
	/**
	 * ���ݵȼ���ҳ���Ҷ�Ӧ����Ա
	 */
	public List queryByPageManagerProperty(int pageNo,int pageSize,String className,String property,Object value);
	
	/**
	 * ����ĳ������ģ������
	 */
	public List findCaseByLikeOneProperty(String className,String property,Object value);
	
	/**
	 * ����ĳ�����Է�ҳģ������
	 */
	public List queryByPageLikeOneProperty(int pageNo,int pageSize,String className,String property,Object value);
}
