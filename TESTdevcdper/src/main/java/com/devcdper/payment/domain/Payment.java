package com.devcdper.payment.domain;

import com.devcdper.user_admin.domain.NormalUser;

public class Payment {
	
	String paymentManagementCode;
	String userEmail;
	String allPaymentConnectGroupCode;
	String allPaymentConnectTable;
	String paymentManagementContentsCode;
	String paymentOption;
	String paymentStatus;
	Integer paymentPrice;
	String paymentDate;
	
	private NormalUser normalUser;


	
	public String getPaymentManagementCode() {
		return paymentManagementCode;
	}

	public void setPaymentManagementCode(String paymentManagementCode) {
		this.paymentManagementCode = paymentManagementCode;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getAllPaymentConnectGroupCode() {
		return allPaymentConnectGroupCode;
	}

	public void setAllPaymentConnectGroupCode(String allPaymentConnectGroupCode) {
		this.allPaymentConnectGroupCode = allPaymentConnectGroupCode;
	}

	public String getAllPaymentConnectTable() {
		return allPaymentConnectTable;
	}

	public void setAllPaymentConnectTable(String allPaymentConnectTable) {
		this.allPaymentConnectTable = allPaymentConnectTable;
	}

	public String getPaymentManagementContentsCode() {
		return paymentManagementContentsCode;
	}

	public void setPaymentManagementContentsCode(String paymentManagementContentsCode) {
		this.paymentManagementContentsCode = paymentManagementContentsCode;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Integer getPaymentPrice() {
		return paymentPrice;
	}

	public void setPaymentPrice(Integer integer) {
		this.paymentPrice = integer;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public NormalUser getNormalUser() {
		return normalUser;
	}

	public void setNormalUser(NormalUser normalUser) {
		this.normalUser = normalUser;
	}

	@Override
	public String toString() {
		return "Payment [paymentManagementCode=" + paymentManagementCode + ", userEmail=" + userEmail
				+ ", allPaymentConnectGroupCode=" + allPaymentConnectGroupCode + ", allPaymentConnectTable="
				+ allPaymentConnectTable + ", paymentManagementContentsCode=" + paymentManagementContentsCode
				+ ", paymentOption=" + paymentOption + ", paymentStatus=" + paymentStatus + ", paymentPrice="
				+ paymentPrice + ", paymentDate=" + paymentDate + ", normalUser=" + normalUser + "]";
	}

	
	
	
	
	
}
