package com.bookstore.customer.action;

import com.bookstore.customer.servlet.GetCode;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

public class SecurityCodeAction {
	String phone_num;
	String securityCode;
	public SecurityCodeAction(){
		
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		//���ݻ�ȡ�����ֻ��ŷ�����֤��
		String code=GetCode.getCode(phone_num);
		m.put("SESSION_SECURITY_CODE2", code);
		System.out.println(code);
		return null;
	}
}
