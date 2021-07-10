package com.devcdper.coaching.domain;

public class CoachManagement {
	private String coachManagementCode;
	private String coachUserEmail;
	private String coachingIntroduceSubject;
	private String coachingIntroduceContents;
	private String coachManagementCount;
	private String coachManagementReview;
	private String coachManagementRate;
	private String coachManagementHourlyAveragePrice;
	private String coachRegisterDate;
	private String coachBlogGithubAdress;
	
	public String getCoachManagementCode() {
		return coachManagementCode;
	}
	public void setCoachManagementCode(String coachManagementCode) {
		this.coachManagementCode = coachManagementCode;
	}
	public String getCoachUserEmail() {
		return coachUserEmail;
	}
	public void setCoachUserEmail(String coachUserEmail) {
		this.coachUserEmail = coachUserEmail;
	}
	public String getCoachingIntroduceSubject() {
		return coachingIntroduceSubject;
	}
	public void setCoachingIntroduceSubject(String coachingIntroduceSubject) {
		this.coachingIntroduceSubject = coachingIntroduceSubject;
	}
	public String getCoachingIntroduceContents() {
		return coachingIntroduceContents;
	}
	public void setCoachingIntroduceContents(String coachingIntroduceContents) {
		this.coachingIntroduceContents = coachingIntroduceContents;
	}
	public String getCoachManagementCount() {
		return coachManagementCount;
	}
	public void setCoachManagementCount(String coachManagementCount) {
		this.coachManagementCount = coachManagementCount;
	}
	public String getCoachManagementReview() {
		return coachManagementReview;
	}
	public void setCoachManagementReview(String coachManagementReview) {
		this.coachManagementReview = coachManagementReview;
	}
	public String getCoachManagementRate() {
		return coachManagementRate;
	}
	public void setCoachManagementRate(String coachManagementRate) {
		this.coachManagementRate = coachManagementRate;
	}
	public String getCoachManagementHourlyAveragePrice() {
		return coachManagementHourlyAveragePrice;
	}
	public void setCoachManagementHourlyAveragePrice(String coachManagementHourlyAveragePrice) {
		this.coachManagementHourlyAveragePrice = coachManagementHourlyAveragePrice;
	}
	public String getCoachRegisterDate() {
		return coachRegisterDate;
	}
	public void setCoachRegisterDate(String coachRegisterDate) {
		this.coachRegisterDate = coachRegisterDate;
	}
	public String getCoachBlogGithubAdress() {
		return coachBlogGithubAdress;
	}
	public void setCoachBlogGithubAdress(String coachBlogGithubAdress) {
		this.coachBlogGithubAdress = coachBlogGithubAdress;
	}
	@Override
	public String toString() {
		return "CoachManagement [coachManagementCode=" + coachManagementCode + ", coachUserEmail=" + coachUserEmail
				+ ", coachingIntroduceSubject=" + coachingIntroduceSubject + ", coachingIntroduceContents="
				+ coachingIntroduceContents + ", coachManagementCount=" + coachManagementCount
				+ ", coachManagementReview=" + coachManagementReview + ", coachManagementRate=" + coachManagementRate
				+ ", coachManagementHourlyAveragePrice=" + coachManagementHourlyAveragePrice + ", coachRegisterDate="
				+ coachRegisterDate + ", coachBlogGithubAdress=" + coachBlogGithubAdress + "]";
	}
	

	
}
