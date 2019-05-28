package com.bookstore.manager.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.manager.dao.ManagerDao;
import com.bookstore.manager.model.Manager;
import com.bookstore.manager.service.ManagerService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ManagerLoginAction extends ActionSupport implements ServletResponseAware{
	 private javax.servlet.http.HttpServletResponse response;
	Manager manager;
	//采用自动装配
	@Autowired
	ManagerService managerService;

	
	
	
	public ManagerService getManagerService() {
		return managerService;
	}
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public ManagerLoginAction(){
		
	}
	
	/*public void validate(){
		String passwordMD5=managerService.MD5(manager.getAdminpwd());
		if(managerService.findByUserIdPwd(manager.getAdminaccount(), manager.getAdminpwd()).isEmpty()){
			addActionError("用户名或密码错误");
		}
	}*/
	
	public String execute() throws Exception{
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
        PrintWriter out = response.getWriter();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String passwordMD5=managerService.MD5(manager.getAdminpwd());
		if(managerService.findByUserIdPwd(manager.getAdminaccount(), manager.getAdminpwd()).isEmpty()){
			this.addFieldError("loginfailed", "用户名或者密码错误");
			return INPUT;
		}else{
		manager=(Manager)managerService.findByUserIdPwd(manager.getAdminaccount(), manager.getAdminpwd()).get(0);
		session.setAttribute("manager", manager);
		session.setAttribute("adimflag", manager.getAdminflag());
		System.out.println(manager.getAdminflag());
		return SUCCESS;
		}
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
}
