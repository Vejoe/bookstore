package com.bookstore.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.*;

public class LoginInterceptor extends AbstractInterceptor{
	public String intercept(ActionInvocation ai) throws Exception {
        //获得session会话对象
		Map session = ai.getInvocationContext().getSession();
        //获取当前登录用户名
		String userName = (String)session.get("caccount");
        if(userName != null){ //已经登录 
            return ai.invoke(); //继续调用ShoppingAction
        }else{//尚未登录
        	//获取ActionContext上下文环境
            ActionContext ac = ai.getInvocationContext();
            //自定义错误信息
            ac.put("popedom", "您还没有登录，请登录!");
            return "login";
        }
    }

}
