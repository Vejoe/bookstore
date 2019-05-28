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
	int id; // ������ʾ���ݵ�����
	private final int pageSize = 5; // ÿҳ��ʾ��¼�ĸ���
	private int pageNo = 1; // ������,�ӵ�1ҳ��ʼ��ʾ
	private int currentPage; // ��ǰҳ
	private int totalPage; // ��ҳ��

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
		// ��õ�ǰ��¼�û�
		Map map = ActionContext.getContext().getSession();
		manager = (Manager) map.get("manager");
		if (manager.getAdminpwd().equals(this.getOldpwd())) {
			manager.setAdminpwd(this.getNewpwd());
			managerService.update(manager);

			return SUCCESS;
		} else {
			this.addFieldError("updatepasswordfailed", "���������");
			return INPUT;
		}
	}

	public String addManager() {
		if (this.getDegree().toString().equals("�߼�")) {
			manager.setAdminflag(1);
		} else {
			manager.setAdminflag(0);
		}
		if (managerService.findManagerByAccount(manager.getAdminaccount())) {
			this.addFieldError("createfailed", "�û����Ѵ���");
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
		if (this.getDegree().toString().equals("�߼�")) {
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
			this.setDegree("�߼�");
		} else {
			this.setDegree("�ͼ�");
		}
		return SUCCESS;
	}

	public String showAllManager() {
		// �����������
		managers = managerService.findAllCaseByClassName("Manager");
		// ������ҳ��
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
		// ���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
		managers = managerService.queryByPage(pageNo, pageSize, "Manager");
		// ���õ�ǰҳ
		currentPage = pageNo;
		if (managers != null)
			return SUCCESS;
		else
			return INPUT;
	}

	// ��ʾ��Ӧ�ȼ��Ĺ���Ա
	public String showdDegreeManager() {
		// �Ȼ������
		managers = managerService.findManagerByAdminflag(this.getId());
		// ������ҳ��
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
		// ���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
		managers = managerService.queryByPageManagerProperty(pageNo, pageSize, "Manager", "adminflag", this.getId());
		// ���õ�ǰҳ
		currentPage = pageNo;
		if (managers != null)
			return SUCCESS;
		else
			return INPUT;

	}
	
	// ģ�����Ҷ�Ӧ���ֵĹ���Ա
		public String queryNameManager() {
			// �Ȼ������
			managers = managerService.findCaseByLikeOneProperty("Manager","adminname",this.getMname());
			// ������ҳ��
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
			// ���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
			managers = managerService.queryByPageLikeOneProperty(pageNo, pageSize,"Manager","adminname",this.getMname());
			// ���õ�ǰҳ
			currentPage = pageNo;
			if (managers != null)
				return SUCCESS;
			else
				return INPUT;

		}
}
