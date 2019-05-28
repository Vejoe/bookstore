package com.bookstore.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.*;

public class LoginInterceptor extends AbstractInterceptor{
	public String intercept(ActionInvocation ai) throws Exception {
        //���session�Ự����
		Map session = ai.getInvocationContext().getSession();
        //��ȡ��ǰ��¼�û���
		String userName = (String)session.get("caccount");
        if(userName != null){ //�Ѿ���¼ 
            return ai.invoke(); //��������ShoppingAction
        }else{//��δ��¼
        	//��ȡActionContext�����Ļ���
            ActionContext ac = ai.getInvocationContext();
            //�Զ��������Ϣ
            ac.put("popedom", "����û�е�¼�����¼!");
            return "login";
        }
    }

}
