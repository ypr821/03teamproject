package com.devcdper.challenge.domain;

import com.devcdper.user_admin.domain.CoachUser;
import com.devcdper.user_admin.domain.NormalUser;

public class ChallengeCompensation {

	private String ChallengeCompensationCode;
	private String ChallengeRewarPrice;
	private String ChallengeRewarDate;
	
	//챌린지 카테고리
	private ChallengeCategory challengeCategory;
	
	//챌린지
	private Challenge challenge;
	
	//챌린지 참여
	private ChallengeParticipation challengeParticipation;
	
	//챌린지 달성율
	private ChallengeAchievementRate challengeAchievementRate;
	
	//챌린지 참여 회원이메일
	private CoachUser coachUser;
	private NormalUser nomaluser;
	
	
	
	public String getChallengeCompensationCode() {
		return ChallengeCompensationCode;
	}
	public void setChallengeCompensationCode(String challengeCompensationCode) {
		ChallengeCompensationCode = challengeCompensationCode;
	}
	public String getChallengeRewarPrice() {
		return ChallengeRewarPrice;
	}
	public void setChallengeRewarPrice(String challengeRewarPrice) {
		ChallengeRewarPrice = challengeRewarPrice;
	}
	public String getChallengeRewarDate() {
		return ChallengeRewarDate;
	}
	public void setChallengeRewarDate(String challengeRewarDate) {
		ChallengeRewarDate = challengeRewarDate;
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
	public ChallengeAchievementRate getChallengeAchievementRate() {
		return challengeAchievementRate;
	}
	public void setChallengeAchievementRate(ChallengeAchievementRate challengeAchievementRate) {
		this.challengeAchievementRate = challengeAchievementRate;
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
		return "ChallengeCompensation [ChallengeCompensationCode=" + ChallengeCompensationCode
				+ ", ChallengeRewarPrice=" + ChallengeRewarPrice + ", ChallengeRewarDate=" + ChallengeRewarDate
				+ ", challengeCategory=" + challengeCategory + ", challenge=" + challenge + ", challengeParticipation="
				+ challengeParticipation + ", challengeAchievementRate=" + challengeAchievementRate + ", coachUser="
				+ coachUser + ", nomaluser=" + nomaluser + "]";
	}
	
	
	

}
