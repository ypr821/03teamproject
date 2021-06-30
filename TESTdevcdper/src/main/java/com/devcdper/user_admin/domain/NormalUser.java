package com.devcdper.user_admin.domain;

public class NormalUser {

	private String userEmail;
	private String userPassword;
	private String userName;
	private String userBirth;
	private String userAddr;
	private String userAddrDetail;
	private String userGender;
	private String userMoblie;
	private String userJob;
	private String userIsReceiveMarketing;
	private String userJoinMotivation;
	private String userJoinPath;
	private String userRecommendEmail;
	private String userJoinDate;
	private String userWithdrawStatus;
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserAddrDetail() {
		return userAddrDetail;
	}
	public void setUserAddrDetail(String userAddrDetail) {
		this.userAddrDetail = userAddrDetail;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserMoblie() {
		return userMoblie;
	}
	public void setUserMoblie(String userMoblie) {
		this.userMoblie = userMoblie;
	}
	public String getUserJob() {
		return userJob;
	}
	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}
	public String getUserIsReceiveMarketing() {
		return userIsReceiveMarketing;
	}
	public void setUserIsReceiveMarketing(String userIsReceiveMarketing) {
		this.userIsReceiveMarketing = userIsReceiveMarketing;
	}
	public String getUserJoinMotivation() {
		return userJoinMotivation;
	}
	public void setUserJoinMotivation(String userJoinMotivation) {
		this.userJoinMotivation = userJoinMotivation;
	}
	public String getUserJoinPath() {
		return userJoinPath;
	}
	public void setUserJoinPath(String userJoinPath) {
		this.userJoinPath = userJoinPath;
	}
	public String getUserRecommendEmail() {
		return userRecommendEmail;
	}
	public void setUserRecommendEmail(String userRecommendEmail) {
		this.userRecommendEmail = userRecommendEmail;
	}
	public String getUserJoinDate() {
		return userJoinDate;
	}
	public void setUserJoinDate(String userJoinDate) {
		this.userJoinDate = userJoinDate;
	}
	public String getUserWithdrawStatus() {
		return userWithdrawStatus;
	}
	public void setUserWithdrawStatus(String userWithdrawStatus) {
		this.userWithdrawStatus = userWithdrawStatus;
	}
	
	@Override
	public String toString() {
		return "AdminNormal [userEmail=" + userEmail + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userBirth=" + userBirth + ", userAddr=" + userAddr + ", userAddrDetail=" + userAddrDetail
				+ ", userGender=" + userGender + ", userMoblie=" + userMoblie + ", userJob=" + userJob
				+ ", userIsReceiveMarketing=" + userIsReceiveMarketing + ", userJoinMotivation=" + userJoinMotivation
				+ ", userJoinPath=" + userJoinPath + ", userRecommendEmail=" + userRecommendEmail + ", userJoinDate="
				+ userJoinDate + ", userWithdrawStatus=" + userWithdrawStatus + "]";
	}
	

}
