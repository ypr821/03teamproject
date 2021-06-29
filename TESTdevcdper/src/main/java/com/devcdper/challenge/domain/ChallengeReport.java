package com.devcdper.challenge.domain;

import com.devcdper.user_admin.domain.CoachUser;
import com.devcdper.user_admin.domain.NormalUser;

public class ChallengeReport {

	private String ChallengeReportCode;
	private String ChallengeReportContents;
	private String ChallengeReportDate;
	private String ChallengeReportResult;
	
	//챌린지 카테고리
	private ChallengeCategory challengeCategory;
		
	//챌린지
	private Challenge challenge;
	
	//챌린지 참여
	private ChallengeParticipation challengeParticipation;
	
	//챌린지 인증
	private ChallengeCertification challengeCertification;

	//챌린지 참여 회원이메일
	private CoachUser coachUser;
	private NormalUser nomaluser;
	
	public String getChallengeReportCode() {
		return ChallengeReportCode;
	}
	public void setChallengeReportCode(String challengeReportCode) {
		ChallengeReportCode = challengeReportCode;
	}
	public String getChallengeReportContents() {
		return ChallengeReportContents;
	}
	public void setChallengeReportContents(String challengeReportContents) {
		ChallengeReportContents = challengeReportContents;
	}
	public String getChallengeReportDate() {
		return ChallengeReportDate;
	}
	public void setChallengeReportDate(String challengeReportDate) {
		ChallengeReportDate = challengeReportDate;
	}
	public String getChallengeReportResult() {
		return ChallengeReportResult;
	}
	public void setChallengeReportResult(String challengeReportResult) {
		ChallengeReportResult = challengeReportResult;
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
	public ChallengeParticipation getChallengeParticipation() {
		return challengeParticipation;
	}
	public void setChallengeParticipation(ChallengeParticipation challengeParticipation) {
		this.challengeParticipation = challengeParticipation;
	}
	public ChallengeCertification getChallengeCertification() {
		return challengeCertification;
	}
	public void setChallengeCertification(ChallengeCertification challengeCertification) {
		this.challengeCertification = challengeCertification;
	}
	public CoachUser getCoachUser() {
		return coachUser;
	}
	public void setCoachUser(CoachUser coachUser) {
		this.coachUser = coachUser;
	}
	public NormalUser getNomaluser() {
		return nomaluser;
	}
	public void setNomaluser(NormalUser nomaluser) {
		this.nomaluser = nomaluser;
	}
	
	@Override
	public String toString() {
		return "ChallengeReport [ChallengeReportCode=" + ChallengeReportCode + ", ChallengeReportContents="
				+ ChallengeReportContents + ", ChallengeReportDate=" + ChallengeReportDate + ", ChallengeReportResult="
				+ ChallengeReportResult + ", challengeCategory=" + challengeCategory + ", challenge=" + challenge
				+ ", challengeParticipation=" + challengeParticipation + ", challengeCertification="
				+ challengeCertification + ", coachUser=" + coachUser + ", nomaluser=" + nomaluser + "]";
	}
	
	
	
	

}
