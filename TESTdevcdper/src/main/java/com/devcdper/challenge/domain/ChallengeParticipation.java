package com.devcdper.challenge.domain;

import com.devcdper.user_admin.domain.CoachUser;
import com.devcdper.user_admin.domain.NormalUser;

public class ChallengeParticipation {

	private String ChallengeParticipantCode;
	private String ChallengeServiceStartDate;
	private String ChallengeServiceEndDate;
	private String ChallengeRegisterDate;
	
	//챌린지 카테고리
	private ChallengeCategory challengeCategory;
	
	//챌린지 
	private Challenge challenge;
	
	//챌린지 참여 회원이메일
	private CoachUser coachUser;
	private NormalUser nomaluser;
	
	//계획상세코드 들어가야함!!
	
	//모든결제상세연결그룹코드 들어가야함!!
	
	
	public String getChallengeParticipantCode() {
		return ChallengeParticipantCode;
	}
	public void setChallengeParticipantCode(String challengeParticipantCode) {
		ChallengeParticipantCode = challengeParticipantCode;
	}
	public String getChallengeServiceStartDate() {
		return ChallengeServiceStartDate;
	}
	public void setChallengeServiceStartDate(String challengeServiceStartDate) {
		ChallengeServiceStartDate = challengeServiceStartDate;
	}
	public String getChallengeServiceEndDate() {
		return ChallengeServiceEndDate;
	}
	public void setChallengeServiceEndDate(String challengeServiceEndDate) {
		ChallengeServiceEndDate = challengeServiceEndDate;
	}
	public String getChallengeRegisterDate() {
		return ChallengeRegisterDate;
	}
	public void setChallengeRegisterDate(String challengeRegisterDate) {
		ChallengeRegisterDate = challengeRegisterDate;
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
	public NormalUser getNomaluser() {
		return nomaluser;
	}
	public void setNomaluser(NormalUser nomaluser) {
		this.nomaluser = nomaluser;
	}
	
	@Override
	public String toString() {
		return "ChallengeParticipation [ChallengeParticipantCode=" + ChallengeParticipantCode
				+ ", ChallengeServiceStartDate=" + ChallengeServiceStartDate + ", ChallengeServiceEndDate="
				+ ChallengeServiceEndDate + ", ChallengeRegisterDate=" + ChallengeRegisterDate + ", challengeCategory="
				+ challengeCategory + ", challenge=" + challenge + ", coachUser=" + coachUser + ", nomaluser="
				+ nomaluser + "]";
	}
	

}
