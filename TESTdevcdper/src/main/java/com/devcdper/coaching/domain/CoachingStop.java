package com.devcdper.coaching.domain;

public class CoachingStop {

	private String coachingStopCode;
	private String coachingCategoryCode;
	private String coachingRFQResultCode;
	private String coachingProgressCode;
	private String totalPlanCode;
	private String planDetailCode;	
	private String paymentCode;
	private String coachUserEmail;	
	private String userEmail;
	private String coachingStopReason;
	private String coachingRemainingPeriod;	
	private String coachingRefundAmount;	
	private String coachingStopDate;
	
	
	public String getCoachingStopCode() {
		return coachingStopCode;
	}
	public void setCoachingStopCode(String coachingStopCode) {
		this.coachingStopCode = coachingStopCode;
	}
	public String getCoachingCategoryCode() {
		return coachingCategoryCode;
	}
	public void setCoachingCategoryCode(String coachingCategoryCode) {
		this.coachingCategoryCode = coachingCategoryCode;
	}
	public String getCoachingRFQResultCode() {
		return coachingRFQResultCode;
	}
	public void setCoachingRFQResultCode(String coachingRFQResultCode) {
		this.coachingRFQResultCode = coachingRFQResultCode;
	}
	public String getCoachingProgressCode() {
		return coachingProgressCode;
	}
	public void setCoachingProgressCode(String coachingProgressCode) {
		this.coachingProgressCode = coachingProgressCode;
	}
	public String getTotalPlanCode() {
		return totalPlanCode;
	}
	public void setTotalPlanCode(String totalPlanCode) {
		this.totalPlanCode = totalPlanCode;
	}
	public String getPlanDetailCode() {
		return planDetailCode;
	}
	public void setPlanDetailCode(String planDetailCode) {
		this.planDetailCode = planDetailCode;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getCoachUserEmail() {
		return coachUserEmail;
	}
	public void setCoachUserEmail(String coachUserEmail) {
		this.coachUserEmail = coachUserEmail;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getCoachingStopReason() {
		return coachingStopReason;
	}
	public void setCoachingStopReason(String coachingStopReason) {
		this.coachingStopReason = coachingStopReason;
	}
	public String getCoachingRemainingPeriod() {
		return coachingRemainingPeriod;
	}
	public void setCoachingRemainingPeriod(String coachingRemainingPeriod) {
		this.coachingRemainingPeriod = coachingRemainingPeriod;
	}
	public String getCoachingRefundAmount() {
		return coachingRefundAmount;
	}
	public void setCoachingRefundAmount(String coachingRefundAmount) {
		this.coachingRefundAmount = coachingRefundAmount;
	}
	public String getCoachingStopDate() {
		return coachingStopDate;
	}
	public void setCoachingStopDate(String coachingStopDate) {
		this.coachingStopDate = coachingStopDate;
	}
	
	@Override
	public String toString() {
		return "CoachingStop [coachingStopCode=" + coachingStopCode + ", coachingCategoryCode=" + coachingCategoryCode
				+ ", coachingRFQResultCode=" + coachingRFQResultCode + ", coachingProgressCode=" + coachingProgressCode
				+ ", totalPlanCode=" + totalPlanCode + ", planDetailCode=" + planDetailCode + ", paymentCode="
				+ paymentCode + ", coachUserEmail=" + coachUserEmail + ", userEmail=" + userEmail
				+ ", coachingStopReason=" + coachingStopReason + ", coachingRemainingPeriod=" + coachingRemainingPeriod
				+ ", coachingRefundAmount=" + coachingRefundAmount + ", coachingStopDate=" + coachingStopDate + "]";
	}

	
	
	
}
