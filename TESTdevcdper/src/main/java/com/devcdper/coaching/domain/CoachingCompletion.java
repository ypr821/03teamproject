package com.devcdper.coaching.domain;

public class CoachingCompletion {

	private String coachingCompletionCode;
	private String coachingCategoryCode;
	private String coachingRFQResultCode;
	private String coachingProgressCode;
	private String totalPlanCode;	
	private String planDetailCode;	
	private String paymentCode;
	private String coachUserEmail;
	private String userEmail;
	private String coachingCompletionFinalResult;	
	private String coachingCompletionRegisterDate;
	
	public String getCoachingCompletionCode() {
		return coachingCompletionCode;
	}
	public void setCoachingCompletionCode(String coachingCompletionCode) {
		this.coachingCompletionCode = coachingCompletionCode;
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
	public String getCoachingCompletionFinalResult() {
		return coachingCompletionFinalResult;
	}
	public void setCoachingCompletionFinalResult(String coachingCompletionFinalResult) {
		this.coachingCompletionFinalResult = coachingCompletionFinalResult;
	}
	public String getCoachingCompletionRegisterDate() {
		return coachingCompletionRegisterDate;
	}
	public void setCoachingCompletionRegisterDate(String coachingCompletionRegisterDate) {
		this.coachingCompletionRegisterDate = coachingCompletionRegisterDate;
	}
	@Override
	public String toString() {
		return "CoachingCompletion [coachingCompletionCode=" + coachingCompletionCode + ", coachingCategoryCode="
				+ coachingCategoryCode + ", coachingRFQResultCode=" + coachingRFQResultCode + ", coachingProgressCode="
				+ coachingProgressCode + ", totalPlanCode=" + totalPlanCode + ", planDetailCode=" + planDetailCode
				+ ", paymentCode=" + paymentCode + ", coachUserEmail=" + coachUserEmail + ", userEmail=" + userEmail
				+ ", coachingCompletionFinalResult=" + coachingCompletionFinalResult
				+ ", coachingCompletionRegisterDate=" + coachingCompletionRegisterDate + "]";
	}

	
	
}
