package com.devcdper.challenge.domain;

import com.devcdper.payment.domain.Payment;
import com.devcdper.user_admin.domain.CoachUser;
import com.devcdper.user_admin.domain.NormalUser;

public class ChallengeParticipation {

	private String challengeParticipationCode;
	private String challengeCategoryCode;
	private String challengeCode;
	private String challengeParticipationEmail;
	
	//계획상세코드
	private String planDetailCode;
	private String planEducationalHistoryDetailCode;
	private String planProjectDetailCode;
	private String planCertificateDetailCode;
	private String planCertifiedLanguageDetailCode;
	private String planTechnologyStackDetailCode;
	private String planJobTrainingDetailCode;
	private String planInternshipDetailCode;
	private String planContestDetailCode;
	private String planCareerDetailCode;
	
	//모든결제상세연결그룹코드
	private String allPaymentConnectGroupCode;
	
	private String challengeParticipationDate;
	private String challengeServiceStartDate;
	private String challengeServiceEndDate;
	
	//챌린지 카테고리
	private ChallengeCategory challengeCategory;
	
	//챌린지 
	private Challenge challenge;

	//결제
	private Payment payment;
	
	//계획상세코드 들어가야함!!
	//plan_detail_code
	//plan_educational_history_detail_code
	//plan_project_detail_code
	//plan_certificate_detail_code
	//plan_certified_language_detail_code
	//plan_technology_stack_detail_code
	//plan_job_training_detail_code
	//plan_internship_detail_code
	//plan_contest_detail_code
	//plan_career_detail_code
	
	//모든결제상세연결그룹코드 들어가야함!!
	//all_payment_connect_group_code
	
	//챌린지 참여 회원이메일
	private CoachUser coachUser;
	private NormalUser normalUser;
	public String getChallengeParticipationCode() {
		return challengeParticipationCode;
	}
	public void setChallengeParticipationCode(String challengeParticipationCode) {
		this.challengeParticipationCode = challengeParticipationCode;
	}
	public String getChallengeCategoryCode() {
		return challengeCategoryCode;
	}
	public void setChallengeCategoryCode(String challengeCategoryCode) {
		this.challengeCategoryCode = challengeCategoryCode;
	}
	public String getChallengeCode() {
		return challengeCode;
	}
	public void setChallengeCode(String challengeCode) {
		this.challengeCode = challengeCode;
	}
	public String getChallengeParticipationEmail() {
		return challengeParticipationEmail;
	}
	public void setChallengeParticipationEmail(String challengeParticipationEmail) {
		this.challengeParticipationEmail = challengeParticipationEmail;
	}
	public String getPlanDetailCode() {
		return planDetailCode;
	}
	public void setPlanDetailCode(String planDetailCode) {
		this.planDetailCode = planDetailCode;
	}
	public String getPlanEducationalHistoryDetailCode() {
		return planEducationalHistoryDetailCode;
	}
	public void setPlanEducationalHistoryDetailCode(String planEducationalHistoryDetailCode) {
		this.planEducationalHistoryDetailCode = planEducationalHistoryDetailCode;
	}
	public String getPlanProjectDetailCode() {
		return planProjectDetailCode;
	}
	public void setPlanProjectDetailCode(String planProjectDetailCode) {
		this.planProjectDetailCode = planProjectDetailCode;
	}
	public String getPlanCertificateDetailCode() {
		return planCertificateDetailCode;
	}
	public void setPlanCertificateDetailCode(String planCertificateDetailCode) {
		this.planCertificateDetailCode = planCertificateDetailCode;
	}
	public String getPlanCertifiedLanguageDetailCode() {
		return planCertifiedLanguageDetailCode;
	}
	public void setPlanCertifiedLanguageDetailCode(String planCertifiedLanguageDetailCode) {
		this.planCertifiedLanguageDetailCode = planCertifiedLanguageDetailCode;
	}
	public String getPlanTechnologyStackDetailCode() {
		return planTechnologyStackDetailCode;
	}
	public void setPlanTechnologyStackDetailCode(String planTechnologyStackDetailCode) {
		this.planTechnologyStackDetailCode = planTechnologyStackDetailCode;
	}
	public String getPlanJobTrainingDetailCode() {
		return planJobTrainingDetailCode;
	}
	public void setPlanJobTrainingDetailCode(String planJobTrainingDetailCode) {
		this.planJobTrainingDetailCode = planJobTrainingDetailCode;
	}
	public String getPlanInternshipDetailCode() {
		return planInternshipDetailCode;
	}
	public void setPlanInternshipDetailCode(String planInternshipDetailCode) {
		this.planInternshipDetailCode = planInternshipDetailCode;
	}
	public String getPlanContestDetailCode() {
		return planContestDetailCode;
	}
	public void setPlanContestDetailCode(String planContestDetailCode) {
		this.planContestDetailCode = planContestDetailCode;
	}
	public String getPlanCareerDetailCode() {
		return planCareerDetailCode;
	}
	public void setPlanCareerDetailCode(String planCareerDetailCode) {
		this.planCareerDetailCode = planCareerDetailCode;
	}
	public String getAllPaymentConnectGroupCode() {
		return allPaymentConnectGroupCode;
	}
	public void setAllPaymentConnectGroupCode(String allPaymentConnectGroupCode) {
		this.allPaymentConnectGroupCode = allPaymentConnectGroupCode;
	}
	public String getChallengeParticipationDate() {
		return challengeParticipationDate;
	}
	public void setChallengeParticipationDate(String challengeParticipationDate) {
		this.challengeParticipationDate = challengeParticipationDate;
	}
	public String getChallengeServiceStartDate() {
		return challengeServiceStartDate;
	}
	public void setChallengeServiceStartDate(String challengeServiceStartDate) {
		this.challengeServiceStartDate = challengeServiceStartDate;
	}
	public String getChallengeServiceEndDate() {
		return challengeServiceEndDate;
	}
	public void setChallengeServiceEndDate(String challengeServiceEndDate) {
		this.challengeServiceEndDate = challengeServiceEndDate;
	}
	public ChallengeCategory getChallengeCategory() {
		return challengeCategory;
	}
	public void setChallengeCategory(ChallengeCategory challengeCategory) {
		this.challengeCategory = challengeCategory;
	}
	public Challenge getChallenge() {
		return challenge;
	}
	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}
	public CoachUser getCoachUser() {
		return coachUser;
	}
	public void setCoachUser(CoachUser coachUser) {
		this.coachUser = coachUser;
	}

	
	public NormalUser getNormalUser() {
		return normalUser;
	}
	public void setNormalUser(NormalUser normalUser) {
		this.normalUser = normalUser;
	}
	
	
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	@Override
	public String toString() {
		return "ChallengeParticipation [challengeParticipantionCode=" + challengeParticipationCode
				+ ", challengeCategoryCode=" + challengeCategoryCode + ", challengeCode=" + challengeCode
				+ ", challengeParticipationEmail=" + challengeParticipationEmail + ", planDetailCode=" + planDetailCode
				+ ", planEducationalHistoryDetailCode=" + planEducationalHistoryDetailCode + ", planProjectDetailCode="
				+ planProjectDetailCode + ", planCertificateDetailCode=" + planCertificateDetailCode
				+ ", planCertifiedLanguageDetailCode=" + planCertifiedLanguageDetailCode
				+ ", planTechnologyStackDetailCode=" + planTechnologyStackDetailCode + ", planJobTrainingDetailCode="
				+ planJobTrainingDetailCode + ", planInternshipDetailCode=" + planInternshipDetailCode
				+ ", planContestDetailCode=" + planContestDetailCode + ", planCareerDetailCode=" + planCareerDetailCode
				+ ", allPaymentConnectGroupCode=" + allPaymentConnectGroupCode + ", challengeParticipationDate="
				+ challengeParticipationDate + ", challengeServiceStartDate=" + challengeServiceStartDate
				+ ", challengeServiceEndDate=" + challengeServiceEndDate + ", challengeCategory=" + challengeCategory
				+ ", challenge=" + challenge + ", payment=" + payment + ", coachUser=" + coachUser + ", normalUser="
				+ normalUser + "]";
	}
	
	
	
	
	
	
	
	

}
