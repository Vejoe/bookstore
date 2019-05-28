package com.bookstore.manager.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.manager.model.Manager;
import com.bookstore.manager.service.ManagerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ManagerAction extends ActionSupport {
	@Autowired
	ManagerService managerService;
	private Manager manager;
	private String degree;
	List<Manager> managers;
	String oldpwd;
	String newpwd;
	String mname;
	int id; // 界面显示数据的索引
	private final int pageSize = 5; // 每页显示记录的个数
	private int pageNo = 1; // 计数器,从第1页开始显示
	private int currentPage; // 当前页
	private int totalPage; // 总页数

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public List<Manager> getManagers() {
		return managers;
	}

	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOldpwd() {
		return oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public String ManagerPersonInform() {
		Map map = ActionContext.getContext().getSession();
		manager = (Manager) map.get("manager");
		int id = manager.getId();
		manager = managerService.findManagerById(id);
		return SUCCESS;
	}

	public String updateManagerPersonal() {
		managerService.update(manager);
		return SUCCESS;
	}

	public String ManagerExitAction() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute("manager") != null) {
			session.removeAttribute("manager");
			session.invalidate();
		}
		return SUCCESS;
	}

	public String ChangePassWord() {
		// 获得当前登录用户
		Map map = ActionContext.getContext().getSession();
		manager = (Manager) map.get("manager");
		if (manager.getAdminpwd().equals(this.getOldpwd())) {
			manager.setAdminpwd(this.getNewpwd());
			managerService.update(manager);

			return SUCCESS;
		} else {
			this.addFieldError("updatepasswordfailed", "旧密码错误");
			return INPUT;
		}
	}

	public String addManager() {
		if (this.getDegree().toString().equals("高级")) {
			manager.setAdminflag(1);
		} else {
			manager.setAdminflag(0);
		}
		if (managerService.findManagerByAccount(manager.getAdminaccount())) {
			this.addFieldError("createfailed", "用户名已存在");
			return INPUT;
		} else {
			//String passwordMD5 = managerService.MD5(manager.getAdminpwd());
			manager.setAdminpwd(manager.getAdminpwd());
			managerService.save(manager);
			return SUCCESS;
		}
	}

	public String deleteManager() {
		manager = managerService.findManagerById(this.getId());
		managerService.delete(manager);
		return SUCCESS;
	}

	public String updateManager() {
		if (this.getDegree().toString().equals("高级")) {
			manager.setAdminflag(1);
		} else {
			manager.setAdminflag(0);
		}
		managerService.update(manager);
		return SUCCESS;
	}

	public String queryManagerById() {

		manager = managerService.findManagerById(this.getId());
		if (manager.getAdminflag() == 1) {
			this.setDegree("高级");
		} else {
			this.setDegree("低级");
		}
		return SUCCESS;
	}

	public String showAllManager() {
		// 获得所有数据
		managers = managerService.findAllCaseByClassName("Manager");
		// 计算总页数
		if (managers.size() % pageSize == 0) {
			totalPage = managers.size() / pageSize;
		} else {
			totalPage = managers.size() / pageSize + 1;
		}
		if (pageNo <= 0) {
			pageNo = 1;
		} else if (pageNo > totalPage) {
			pageNo = totalPage;
		}
		// 根据当前页查询要在该页上显示的数据
		managers = managerService.queryByPage(pageNo, pageSize, "Manager");
		// 设置当前页
		currentPage = pageNo;
		if (managers != null)
			return SUCCESS;
		else
			return INPUT;
	}

	// 显示对应等级的管理员
	public String showdDegreeManager() {
		// 先获得数据
		managers = managerService.findManagerByAdminflag(this.getId());
		// 计算总页数
		if (managers.size() % pageSize == 0) {
			totalPage = managers.size() / pageSize;
		} else {
			totalPage = managers.size() / pageSize + 1;
		}
		if (pageNo <= 0) {
			pageNo = 1;
		} else if (pageNo > totalPage) {
			pageNo = totalPage;
		}
		// 根据当前页查询要在该页上显示的数据
		managers = managerService.queryByPageManagerProperty(pageNo, pageSize, "Manager", "adminflag", this.getId());
		// 设置当前页
		currentPage = pageNo;
		if (managers != null)
			return SUCCESS;
		else
			return INPUT;

	}
	
	// 模糊查找对应名字的管理员
		public String queryNameManager() {
			// 先获得数据
			managers = managerService.findCaseByLikeOneProperty("Manager","adminname",this.getMname());
			// 计算总页数
			if (managers.size() % pageSize == 0) {
				totalPage = managers.size() / pageSize;
			} else {
				totalPage = managers.size() / pageSize + 1;
			}
			if (pageNo <= 0) {
				pageNo = 1;
			} else if (pageNo > totalPage) {
				pageNo = totalPage;
			}
			// 根据当前页查询要在该页上显示的数据
			managers = managerService.queryByPageLikeOneProperty(pageNo, pageSize,"Manager","adminname",this.getMname());
			// 设置当前页
			currentPage = pageNo;
			if (managers != null)
				return SUCCESS;
			else
				return INPUT;

		}
}
