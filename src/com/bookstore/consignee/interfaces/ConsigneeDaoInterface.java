package com.bookstore.consignee.interfaces;

import java.util.List;

import com.bookstore.consignee.model.Consignee;

public interface ConsigneeDaoInterface {
	//通过账号查找到对应的收货人信息
	public List<Consignee> QueryCustomerConsigneeBycaccount(String caccount);
	//添加收货人
	public boolean AddConsignee(Consignee consignee);
	//根据id来删除收货人方法
	public boolean DeleteConsigneeById(int id);
	//根据id来获得收货人信息
	public Consignee QueryConsigneeDetail(int id);
	//更新修改收货人信息
	public boolean UpdateConsigneeById(Consignee consignee);
	//查询每页需要显示的数据(每次最多3条记录)
	public List<Consignee> queryByPage(int pageNo,int pageSize,String caccount);
}
