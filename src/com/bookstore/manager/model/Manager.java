package com.bookstore.manager.model;

/**
 * Manager entity. @author MyEclipse Persistence Tools
 */

public class Manager implements java.io.Serializable {

	// Fields

	private Integer id;
	private String adminaccount;
	private String adminname;
	private String adminpwd;
	private String phone;
	private Integer adminflag;

	// Constructors

	/** default constructor */
	public Manager() {
	}

	/** full constructor */
	public Manager(String adminaccount, String adminname, String adminpwd, String phone, Integer adminflag) {
		this.adminaccount = adminaccount;
		this.adminname = adminname;
		this.adminpwd = adminpwd;
		this.phone = phone;
		this.adminflag = adminflag;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdminaccount() {
		return this.adminaccount;
	}

	public void setAdminaccount(String adminaccount) {
		this.adminaccount = adminaccount;
	}

	public String getAdminname() {
		return this.adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpwd() {
		return this.adminpwd;
	}

	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAdminflag() {
		return this.adminflag;
	}

	public void setAdminflag(Integer adminflag) {
		this.adminflag = adminflag;
	}

}