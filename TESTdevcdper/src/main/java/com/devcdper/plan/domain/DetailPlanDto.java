package com.devcdper.plan.domain;

public class DetailPlanDto {
	/*공통 상세 계획 필드 Start*/
	private String userEmail;      //회원 이메일(FK)
	private String totalPlanCode;  //통합계획 코드(FK)
	private String planCode;	   //계획 코드(FK)
	private String planDetailCode; //계획_상세_코드(PK)
	private String planDetailTitle;//계획_상세_제목
	private String planDetailContents;//계획_상세_내용
	private String planDetailStartDate;//계획_상세_시작일
	private String planDetailEndDate;//계획_상세_종료일
	private String planDetailStatus;//계획_상세_(진행)상태
	private int planDetailDegree;//계획_상세_차수
	private String planDetailDegreeChangeReason;//계획_상세_차수_변경_사유
	private String planDetailCreatedDate;//계획_상세_작성일자
	/*공통 상세 계획 필드 End*/
	
	
	
	/*자격증 상세 계획 필드 Start*/
	private String planCertificateDetailType;						//계획_자격증_시험유형
	private String planCertificateDetailTestDate;					//계획_자격증_상세_시험일자	
	/*자격증 상세 계획 필드 End*/
	
	
	/*getter & setter Start*/
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getTotalPlanCode() {
		return totalPlanCode;
	}
	public void setTotalPlanCode(String totalPlanCode) {
		this.totalPlanCode = totalPlanCode;
	}
	public String getPlanCode() {
		return planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	public String getPlanDetailCode() {
		return planDetailCode;
	}
	public void setPlanDetailCode(String planDetailCode) {
		this.planDetailCode = planDetailCode;
	}
	public String getPlanDetailTitle() {
		return planDetailTitle;
	}
	public void setPlanDetailTitle(String planDetailTitle) {
		this.planDetailTitle = planDetailTitle;
	}
	public String getPlanDetailContents() {
		return planDetailContents;
	}
	public void setPlanDetailContents(String planDetailContents) {
		this.planDetailContents = planDetailContents;
	}
	public String getPlanDetailStartDate() {
		return planDetailStartDate;
	}
	public void setPlanDetailStartDate(String planDetailStartDate) {
		this.planDetailStartDate = planDetailStartDate;
	}
	public String getPlanDetailEndDate() {
		return planDetailEndDate;
	}
	public void setPlanDetailEndDate(String planDetailEndDate) {
		this.planDetailEndDate = planDetailEndDate;
	}
	public String getPlanDetailStatus() {
		return planDetailStatus;
	}
	public void setPlanDetailStatus(String planDetailStatus) {
		this.planDetailStatus = planDetailStatus;
	}
	public int getPlanDetailDegree() {
		return planDetailDegree;
	}
	public void setPlanDetailDegree(int planDetailDegree) {
		this.planDetailDegree = planDetailDegree;
	}
	public String getPlanDetailDegreeChangeReason() {
		return planDetailDegreeChangeReason;
	}
	public void setPlanDetailDegreeChangeReason(String planDetailDegreeChangeReason) {
		this.planDetailDegreeChangeReason = planDetailDegreeChangeReason;
	}
	public String getPlanDetailCreatedDate() {
		return planDetailCreatedDate;
	}
	public void setPlanDetailCreatedDate(String planDetailCreatedDate) {
		this.planDetailCreatedDate = planDetailCreatedDate;
	}
	public String getPlanCertificateDetailType() {
		return planCertificateDetailType;
	}
	public void setPlanCertificateDetailType(String planCertificateDetailType) {
		this.planCertificateDetailType = planCertificateDetailType;
	}
	public String getPlanCertificateDetailTestDate() {
		return planCertificateDetailTestDate;
	}
	public void setPlanCertificateDetailTestDate(String planCertificateDetailTestDate) {
		this.planCertificateDetailTestDate = planCertificateDetailTestDate;
	}
	/*getter & setter End*/
	
	/*toString Start*/
	@Override
	public String toString() {
		return "DetailPlanDto [userEmail=" + userEmail + ", totalPlanCode=" + totalPlanCode + ", planCode=" + planCode
				+ ", planDetailCode=" + planDetailCode + ", planDetailTitle=" + planDetailTitle
				+ ", planDetailContents=" + planDetailContents + ", planDetailStartDate=" + planDetailStartDate
				+ ", planDetailEndDate=" + planDetailEndDate + ", planDetailStatus=" + planDetailStatus
				+ ", planDetailDegree=" + planDetailDegree + ", planDetailDegreeChangeReason="
				+ planDetailDegreeChangeReason + ", planDetailCreatedDate=" + planDetailCreatedDate
				+ ", planCertificateDetailType=" + planCertificateDetailType + ", planCertificateDetailTestDate="
				+ planCertificateDetailTestDate + "]";
	}
	/*toString End*/
	
}



