package com.bookstore.consignee.interfaces;

import java.util.List;

import com.bookstore.consignee.model.Consignee;

public interface ConsigneeDaoInterface {
	//ͨ���˺Ų��ҵ���Ӧ���ջ�����Ϣ
	public List<Consignee> QueryCustomerConsigneeBycaccount(String caccount);
	//����ջ���
	public boolean AddConsignee(Consignee consignee);
	//����id��ɾ���ջ��˷���
	public boolean DeleteConsigneeById(int id);
	//����id������ջ�����Ϣ
	public Consignee QueryConsigneeDetail(int id);
	//�����޸��ջ�����Ϣ
	public boolean UpdateConsigneeById(Consignee consignee);
	//��ѯÿҳ��Ҫ��ʾ������(ÿ�����3����¼)
	public List<Consignee> queryByPage(int pageNo,int pageSize,String caccount);
}
