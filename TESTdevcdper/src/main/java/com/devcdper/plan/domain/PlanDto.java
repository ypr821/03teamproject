package com.devcdper.plan.domain;


public class PlanDto {
	/* 공통부분 */	
	private String userEmail;							//회원이메일						
	private String planCode;							//계획코드
	private String planTitle;							//계획제목
	private String planName;							//계획 명
	private String planContents;						//계획내용
	private String startDate;							//계획시작일
	private String endDate;								//계획종료일
	private String planStatus;							//계획상태
	private int planDegree;								//계획차수
	private String degreeChangeReason;					//차수변경사유
	private String registerDate;						//등록일자
	
	/* 통합계획 */
	private String totalPlanDivision;					//통합계획 구분
	
	/* 학력계획 */
	private String planEducationalChoice;				//학력선택
	private String planEducationalSchool;				//학교명
	private String planEducationalDepartment;			//전공학과
	private String planEducationalCredit;				//학점
	
	/* 프로젝트 계획 */
	private String planProjectDevelopmentEnvironment;	//개발환경
	private String planProjectUrl;						//프로젝트URL
	
	/* 자격증 계획 */

	
	/* 공인어학 계획 */
	private String planCertifiedLanguageTestName;		//시험명
	private String planCertifiedLanguageTestDate;		//시험일자
	private String planCertifiedLanguageScore;			//목표점수(등급)
	
	/* 기술스택 계획 */

	
	/* 직종전문교육과정 계획 */
	private String planJobTrainingAcademyName;			//교육원명
	private String planClassificationRadio;				//교육과정 분류
	private int planJobTrainingCost;					//교육과정 비용
	private String planJobTrainingCurriculum;			//커리큘럼
	
	/* 인턴십 계획 */
	private String planInternshipCompanyName;			//회사명
	private String planInternshipPeriod;				//인턴기간(개월수)
	private String planInternshipWorkingHours;			//근무시간(하루)
	private String planInternshipBusinessContents;		//업무내용
	private String planInternshipActiveGoal;			//활동목표
	
	/* 공모전 계획 */
	private String planContestTopic;					//공모주제
	private String planContestField;					//공모전분야
	private String planContestPriodStartDate;			//공모기간 시작일
	private String planContestPriodEndDate;				//공모기간 종료일
	private String planContestHostOrganization;			//주최기관
	
	/* 경력 계획 */
	private String planCareerCompanyName;				//회사명
	private String planCareerOccupation;				//직종(분야)
	private String planCareerDepartment;				//부서
	private String planCareerPosition;					//직책
	private String planCareerEmploumentPeriodStartDate;	//근무기간시작
	private String planCareerEmploumentPeriodEndDate;	//근무기간종료
	private String planCareerJoinTargetDate;			//입사/이직 목표날짜
	
	
	
	
	/* getter & setter */
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPlanCode() {
		return planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	public String getPlanTitle() {
		return planTitle;
	}
	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanContents() {
		return planContents;
	}
	public void setPlanContents(String planContents) {
		this.planContents = planContents;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public int getPlanDegree() {
		return planDegree;
	}
	public void setPlanDegree(int planDegree) {
		this.planDegree = planDegree;
	}
	public String getDegreeChangeReason() {
		return degreeChangeReason;
	}
	public void setDegreeChangeReason(String degreeChangeReason) {
		this.degreeChangeReason = degreeChangeReason;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getTotalPlanDivision() {
		return totalPlanDivision;
	}
	public void setTotalPlanDivision(String totalPlanDivision) {
		this.totalPlanDivision = totalPlanDivision;
	}
	public String getPlanEducationalChoice() {
		return planEducationalChoice;
	}
	public void setPlanEducationalChoice(String planEducationalChoice) {
		this.planEducationalChoice = planEducationalChoice;
	}
	public String getPlanEducationalSchool() {
		return planEducationalSchool;
	}
	public void setPlanEducationalSchool(String planEducationalSchool) {
		this.planEducationalSchool = planEducationalSchool;
	}
	public String getPlanEducationalDepartment() {
		return planEducationalDepartment;
	}
	public void setPlanEducationalDepartment(String planEducationalDepartment) {
		this.planEducationalDepartment = planEducationalDepartment;
	}
	public String getPlanEducationalCredit() {
		return planEducationalCredit;
	}
	public void setPlanEducationalCredit(String planEducationalCredit) {
		this.planEducationalCredit = planEducationalCredit;
	}
	public String getPlanProjectDevelopmentEnvironment() {
		return planProjectDevelopmentEnvironment;
	}
	public void setPlanProjectDevelopmentEnvironment(String planProjectDevelopmentEnvironment) {
		this.planProjectDevelopmentEnvironment = planProjectDevelopmentEnvironment;
	}
	public String getPlanProjectUrl() {
		return planProjectUrl;
	}
	public void setPlanProjectUrl(String planProjectUrl) {
		this.planProjectUrl = planProjectUrl;
	}
	public String getPlanCertifiedLanguageTestName() {
		return planCertifiedLanguageTestName;
	}
	public void setPlanCertifiedLanguageTestName(String planCertifiedLanguageTestName) {
		this.planCertifiedLanguageTestName = planCertifiedLanguageTestName;
	}
	public String getPlanCertifiedLanguageTestDate() {
		return planCertifiedLanguageTestDate;
	}
	public void setPlanCertifiedLanguageTestDate(String planCertifiedLanguageTestDate) {
		this.planCertifiedLanguageTestDate = planCertifiedLanguageTestDate;
	}
	public String getPlanCertifiedLanguageScore() {
		return planCertifiedLanguageScore;
	}
	public void setPlanCertifiedLanguageScore(String planCertifiedLanguageScore) {
		this.planCertifiedLanguageScore = planCertifiedLanguageScore;
	}
	public String getPlanJobTrainingAcademyName() {
		return planJobTrainingAcademyName;
	}
	public void setPlanJobTrainingAcademyName(String planJobTrainingAcademyName) {
		this.planJobTrainingAcademyName = planJobTrainingAcademyName;
	}
	public String getPlanClassificationRadio() {
		return planClassificationRadio;
	}
	public void setPlanClassificationRadio(String planClassificationRadio) {
		this.planClassificationRadio = planClassificationRadio;
	}
	public int getPlanJobTrainingCost() {
		return planJobTrainingCost;
	}
	public void setPlanJobTrainingCost(int planJobTrainingCost) {
		this.planJobTrainingCost = planJobTrainingCost;
	}
	public String getPlanJobTrainingCurriculum() {
		return planJobTrainingCurriculum;
	}
	public void setPlanJobTrainingCurriculum(String planJobTrainingCurriculum) {
		this.planJobTrainingCurriculum = planJobTrainingCurriculum;
	}
	public String getPlanInternshipCompanyName() {
		return planInternshipCompanyName;
	}
	public void setPlanInternshipCompanyName(String planInternshipCompanyName) {
		this.planInternshipCompanyName = planInternshipCompanyName;
	}
	public String getPlanInternshipPeriod() {
		return planInternshipPeriod;
	}
	public void setPlanInternshipPeriod(String planInternshipPeriod) {
		this.planInternshipPeriod = planInternshipPeriod;
	}
	public String getPlanInternshipWorkingHours() {
		return planInternshipWorkingHours;
	}
	public void setPlanInternshipWorkingHours(String planInternshipWorkingHours) {
		this.planInternshipWorkingHours = planInternshipWorkingHours;
	}
	public String getPlanInternshipBusinessContents() {
		return planInternshipBusinessContents;
	}
	public void setPlanInternshipBusinessContents(String planInternshipBusinessContents) {
		this.planInternshipBusinessContents = planInternshipBusinessContents;
	}
	public String getPlanInternshipActiveGoal() {
		return planInternshipActiveGoal;
	}
	public void setPlanInternshipActiveGoal(String planInternshipActiveGoal) {
		this.planInternshipActiveGoal = planInternshipActiveGoal;
	}
	public String getPlanContestTopic() {
		return planContestTopic;
	}
	public void setPlanContestTopic(String planContestTopic) {
		this.planContestTopic = planContestTopic;
	}
	public String getPlanContestField() {
		return planContestField;
	}
	public void setPlanContestField(String planContestField) {
		this.planContestField = planContestField;
	}
	public String getPlanContestPriodStartDate() {
		return planContestPriodStartDate;
	}
	public void setPlanContestPriodStartDate(String planContestPriodStartDate) {
		this.planContestPriodStartDate = planContestPriodStartDate;
	}
	public String getPlanContestPriodEndDate() {
		return planContestPriodEndDate;
	}
	public void setPlanContestPriodEndDate(String planContestPriodEndDate) {
		this.planContestPriodEndDate = planContestPriodEndDate;
	}
	public String getPlanContestHostOrganization() {
		return planContestHostOrganization;
	}
	public void setPlanContestHostOrganization(String planContestHostOrganization) {
		this.planContestHostOrganization = planContestHostOrganization;
	}
	public String getPlanCareerCompanyName() {
		return planCareerCompanyName;
	}
	public void setPlanCareerCompanyName(String planCareerCompanyName) {
		this.planCareerCompanyName = planCareerCompanyName;
	}
	public String getPlanCareerOccupation() {
		return planCareerOccupation;
	}
	public void setPlanCareerOccupation(String planCareerOccupation) {
		this.planCareerOccupation = planCareerOccupation;
	}
	public String getPlanCareerDepartment() {
		return planCareerDepartment;
	}
	public void setPlanCareerDepartment(String planCareerDepartment) {
		this.planCareerDepartment = planCareerDepartment;
	}
	public String getPlanCareerPosition() {
		return planCareerPosition;
	}
	public void setPlanCareerPosition(String planCareerPosition) {
		this.planCareerPosition = planCareerPosition;
	}
	public String getPlanCareerEmploumentPeriodStartDate() {
		return planCareerEmploumentPeriodStartDate;
	}
	public void setPlanCareerEmploumentPeriodStartDate(String planCareerEmploumentPeriodStartDate) {
		this.planCareerEmploumentPeriodStartDate = planCareerEmploumentPeriodStartDate;
	}
	public String getPlanCareerEmploumentPeriodEndDate() {
		return planCareerEmploumentPeriodEndDate;
	}
	public void setPlanCareerEmploumentPeriodEndDate(String planCareerEmploumentPeriodEndDate) {
		this.planCareerEmploumentPeriodEndDate = planCareerEmploumentPeriodEndDate;
	}
	public String getPlanCareerJoinTargetDate() {
		return planCareerJoinTargetDate;
	}
	public void setPlanCareerJoinTargetDate(String planCareerJoinTargetDate) {
		this.planCareerJoinTargetDate = planCareerJoinTargetDate;
	}
	@Override
	public String toString() {
		return "PlanDto [userEmail=" + userEmail + ", planCode=" + planCode + ", planTitle=" + planTitle + ", planName="
				+ planName + ", planContents=" + planContents + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", planStatus=" + planStatus + ", planDegree=" + planDegree + ", degreeChangeReason="
				+ degreeChangeReason + ", registerDate=" + registerDate + ", totalPlanDivision=" + totalPlanDivision
				+ ", planEducationalChoice=" + planEducationalChoice + ", planEducationalSchool="
				+ planEducationalSchool + ", planEducationalDepartment=" + planEducationalDepartment
				+ ", planEducationalCredit=" + planEducationalCredit + ", planProjectDevelopmentEnvironment="
				+ planProjectDevelopmentEnvironment + ", planProjectUrl=" + planProjectUrl
				+ ", planCertifiedLanguageTestName=" + planCertifiedLanguageTestName
				+ ", planCertifiedLanguageTestDate=" + planCertifiedLanguageTestDate + ", planCertifiedLanguageScore="
				+ planCertifiedLanguageScore + ", planJobTrainingAcademyName=" + planJobTrainingAcademyName
				+ ", planClassificationRadio=" + planClassificationRadio + ", planJobTrainingCost="
				+ planJobTrainingCost + ", planJobTrainingCurriculum=" + planJobTrainingCurriculum
				+ ", planInternshipCompanyName=" + planInternshipCompanyName + ", planInternshipPeriod="
				+ planInternshipPeriod + ", planInternshipWorkingHours=" + planInternshipWorkingHours
				+ ", planInternshipBusinessContents=" + planInternshipBusinessContents + ", planInternshipActiveGoal="
				+ planInternshipActiveGoal + ", planContestTopic=" + planContestTopic + ", planContestField="
				+ planContestField + ", planContestPriodStartDate=" + planContestPriodStartDate
				+ ", planContestPriodEndDate=" + planContestPriodEndDate + ", planContestHostOrganization="
				+ planContestHostOrganization + ", planCareerCompanyName=" + planCareerCompanyName
				+ ", planCareerOccupation=" + planCareerOccupation + ", planCareerDepartment=" + planCareerDepartment
				+ ", planCareerPosition=" + planCareerPosition + ", planCareerEmploumentPeriodStartDate="
				+ planCareerEmploumentPeriodStartDate + ", planCareerEmploumentPeriodEndDate="
				+ planCareerEmploumentPeriodEndDate + ", planCareerJoinTargetDate=" + planCareerJoinTargetDate + "]";
	}
}
