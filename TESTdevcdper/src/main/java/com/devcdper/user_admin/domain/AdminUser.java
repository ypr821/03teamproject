package com.devcdper.user_admin.domain;

public class AdminUser {

	private String adminEmail;
	private String adminPassword;
	private String adminName;
	private String adminLevel;
	private String adminMobile;
	private String adminJoinDate;
	
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminLevel() {
		return adminLevel;
	}
	public void setAdminLevel(String adminLevel) {
		this.adminLevel = adminLevel;
	}
	public String getAdminMobile() {
		return adminMobile;
	}
	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}
	public String getAdminJoinDate() {
		return adminJoinDate;
	}
	public void setAdminJoinDate(String adminJoinDate) {
		this.adminJoinDate = adminJoinDate;
	}
	
	@Override
	public String toString() {
		return "AdminUser [adminEmail=" + adminEmail + ", adminPassword=" + adminPassword + ", adminName=" + adminName
				+ ", adminLevel=" + adminLevel + ", adminMobile=" + adminMobile + ", adminJoinDate=" + adminJoinDate
				+ "]";
	}
	
}
