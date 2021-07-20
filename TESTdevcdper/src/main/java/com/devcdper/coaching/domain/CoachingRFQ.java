package com.devcdper.coaching.domain;

import com.devcdper.user_admin.domain.NormalUser;

public class CoachingRFQ {
	private String coachingRFQCode;
	private String coachingCategoryCode;
	private String totalPlanCode;
	private String planDetailCode;
	private String coachUserEmail;
	private String userEmail;
	private String coachClassification;
	private String coachingRFQStartDate;
	private String coachingRFQEndDate;
	private String coachingRFQDay;
	private String coachingRFQWishfulThinking;
	private String coachingRFQRequestDate;
	private CoachingRFQResult coachingRFQResult;
	private CoachingApplyAndPayment coachingApplyAndPayment;
	private CoachingUser coachingUser;
	private NormalUser normalUser;
	
	
	public String getCoachingRFQCode() {
		return coachingRFQCode;
	}
	public void setCoachingRFQCode(String coachingRFQCode) {
		this.coachingRFQCode = coachingRFQCode;
	}
	public String getCoachingCategoryCode() {
		return coachingCategoryCode;
	}
	public void setCoachingCategoryCode(String coachingCategoryCode) {
		this.coachingCategoryCode = coachingCategoryCode;
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
	public String getCoachClassification() {
		return coachClassification;
	}
	public void setCoachClassification(String coachClassification) {
		this.coachClassification = coachClassification;
	}
	public String getCoachingRFQStartDate() {
		return coachingRFQStartDate;
	}
	public void setCoachingRFQStartDate(String coachingRFQStartDate) {
		this.coachingRFQStartDate = coachingRFQStartDate;
	}
	public String getCoachingRFQEndDate() {
		return coachingRFQEndDate;
	}
	public void setCoachingRFQEndDate(String coachingRFQEndDate) {
		this.coachingRFQEndDate = coachingRFQEndDate;
	}
	public String getCoachingRFQDay() {
		return coachingRFQDay;
	}
	public void setCoachingRFQDay(String coachingRFQDay) {
		this.coachingRFQDay = coachingRFQDay;
	}
	public String getCoachingRFQWishfulThinking() {
		return coachingRFQWishfulThinking;
	}
	public void setCoachingRFQWishfulThinking(String coachingRFQWishfulThinking) {
		this.coachingRFQWishfulThinking = coachingRFQWishfulThinking;
	}
	public String getCoachingRFQRequestDate() {
		return coachingRFQRequestDate;
	}
	public void setCoachingRFQRequestDate(String coachingRFQRequestDate) {
		this.coachingRFQRequestDate = coachingRFQRequestDate;
	}
	public CoachingRFQResult getCoachingRFQResult() {
		return coachingRFQResult;
	}
	public void setCoachingRFQResult(CoachingRFQResult coachingRFQResult) {
		this.coachingRFQResult = coachingRFQResult;
	}
	public CoachingApplyAndPayment getCoachingApplyAndPayment() {
		return coachingApplyAndPayment;
	}
	public void setCoachingApplyAndPayment(CoachingApplyAndPayment coachingApplyAndPayment) {
		this.coachingApplyAndPayment = coachingApplyAndPayment;
	}
	public CoachingUser getCoachingUser() {
		return coachingUser;
	}
	public void setCoachingUser(CoachingUser coachingUser) {
		this.coachingUser = coachingUser;
	}
	
	
	public NormalUser getNormalUser() {
		return normalUser;
	}
	public void setNormalUser(NormalUser normalUser) {
		this.normalUser = normalUser;
	}
	@Override
	public String toString() {
		return "CoachingRFQ [coachingRFQCode=" + coachingRFQCode + ", coachingCategoryCode=" + coachingCategoryCode
				+ ", totalPlanCode=" + totalPlanCode + ", planDetailCode=" + planDetailCode + ", coachUserEmail="
				+ coachUserEmail + ", userEmail=" + userEmail + ", coachClassification=" + coachClassification
				+ ", coachingRFQStartDate=" + coachingRFQStartDate + ", coachingRFQEndDate=" + coachingRFQEndDate
				+ ", coachingRFQDay=" + coachingRFQDay + ", coachingRFQWishfulThinking=" + coachingRFQWishfulThinking
				+ ", coachingRFQRequestDate=" + coachingRFQRequestDate + ", coachingRFQResult=" + coachingRFQResult
				+ ", coachingApplyAndPayment=" + coachingApplyAndPayment + ", coachingUser=" + coachingUser
				+ ", normalUser=" + normalUser + "]";
	}
	
	

}
