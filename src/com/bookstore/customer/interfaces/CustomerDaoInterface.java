package com.bookstore.customer.interfaces;

import java.util.List;

import com.bookstore.customer.model.Customer;
import com.bookstore.customer.model.Message;

public interface CustomerDaoInterface {
	//ע����飬�ж��Ƿ������û���
	public boolean checkregister(Customer customer);
	//ע��ķ���,������Ӱ������
	public int register(Customer customer);
	//��¼����
	public boolean login(Customer customer);
	//ͨ���˺Ų��ҵ���Ӧ���û���Ϣ
	public Customer QueryCustomerBycaccount(String caccount);
	//�޸��û���Ϣ
	public boolean ChangeCustomerinformation(Customer customer);
	//�������
	public boolean AddMessage(Message message);
	//ͨ���˺Ų��ҵ���Ӧ��������Ϣ
	public List<Message> QueryMessageBycaccount(String caccount);
	//��ѯÿҳ��Ҫ��ʾ������(ÿ�����2����¼)
	public List<Message> queryMessagesByPage(int pageNo,int pageSize,String caccount);
	//����id�����Message��Ϣ
	public Message QueryMessageDetail(int id);
}
