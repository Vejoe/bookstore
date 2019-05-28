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
	//�Զ�װ��
	@Autowired
	ManagerDao managerDao;
	
	
	
	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	/**
	 * ���������md5����
	 */
	public String MD5(String password){
		String resultString = null;
		resultString = new String(password);
		MessageDigest md;// ��ϢժҪ
		try
		{
			md = MessageDigest.getInstance("MD5");// ʵ����
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
	 * �����û������룬��֤��¼
	 */
	public List findByUserIdPwd(Object name, Object password) {
		List lists = managerDao.findCaseByTwoProperty("Manager", "adminaccount", name, "adminpwd", password);
		return lists;
	}
	
	/**
	 * �洢����
	 */
	public void save(Object entity){
		managerDao.save(entity);
	}
	
	/**
	 * ���¶���
	 */
	public void update(Object entity){
		managerDao.update(entity);
	}
	
	/**
	 * ɾ������
	 */
	public void delete(Object entity){
		managerDao.delete(entity);
	}
	
	/**
	 * ���������鿴��Ӧ��������
	 */
	public List findAllCaseByClassName(String className)
	{
		List lists=managerDao.findAllCaseByClassName(className);
		return lists;
	}
	
	/**
	 * ��ҳ��ѯ
	 */
	public List queryByPage(int pageNo,int pageSize,String className)
	{
		List lists=managerDao.queryByPage(pageNo, pageSize, className);
		return lists;
	}
	
	/**
	 * ���ݶ�ӦID���Ҷ�ӦManager��Ϣ
	 */
	public Manager findManagerById(Integer objId){
		Manager manager=(Manager)managerDao.findCaseById("com.bookstore.manager.model.Manager", objId);
		return manager;
	}
	
	/**
	 * ���ݶ�ӦID���Ҷ�ӦOrder��Ϣ
	 */
	public Order findOrderById(Integer objId){
		Order order=(Order)managerDao.findCaseById("model.Order", objId);
		return order;
	}
	
	/**
	 * ���ݶ�ӦID���Ҷ�ӦOrderDetail��Ϣ
	 */
	public List findOrderdetailById(Integer objId){
		List lists=managerDao.getOrderDetailByOid(objId);
		return lists;
	}
	
	/**
	 * ���ݶ�ӦID���Ҷ�Ӧmessage��Ϣ
	 */
	public Message findMessageById(Integer objId){
		Message message=(Message)managerDao.findCaseById("com.bookstore.customer.model.Message", objId);
		return message;
	}
	
	/**
	 * �����û����Ƿ����
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
	 * ���ݵȼ����Ҷ�Ӧ����Ա
	 */
	public List findManagerByAdminflag(Integer obiId){
		List list=managerDao.findCaseByOneProperty("Manager", "adminflag", obiId);
		return list;
	}
	
	/**
	 * ���ݵȼ���ҳ���Ҷ�Ӧ����Ա
	 */
	public List queryByPageManagerProperty(int pageNo,int pageSize,String className,String property,Object value){
		List lists=managerDao.queryByPageManagerProperty(pageNo,pageSize,className,property,value);
		return lists;
	}
	
	/**
	 * ����ĳ������ģ������
	 */
	public List findCaseByLikeOneProperty(String className,String property,Object value){
		List list=managerDao.findCaseByLikeOneProperty(className, property, value);
		System.out.println(list.size());
		return list;
	}
	
	/**
	 * ����ĳ�����Է�ҳģ������
	 */
	public List queryByPageLikeOneProperty(int pageNo,int pageSize,String className,String property,Object value){
		List lists=managerDao.queryByPageLikeOneProperty(pageNo,pageSize,className,property,value);
		return lists;
	}
}
