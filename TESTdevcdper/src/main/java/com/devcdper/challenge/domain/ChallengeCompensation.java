package com.devcdper.challenge.domain;

import com.devcdper.user_admin.domain.CoachUser;
import com.devcdper.user_admin.domain.NormalUser;

public class ChallengeCompensation {
	
	private String challengeCompensationCode;
	private String challengeCode;
	private String challengeCategoryCode;
	private String challengeParticipationCode;
	private String challengeAchievementRateCode;
	private String challengeParticipationEmail;
	private String challengeRewardPrice;
	private String challengeRewardBank;
	private String challengeRewardAccount;
	private String challengeRewardDate;
	
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
	private NormalUser normalUser;
	
	public String getChallengeCompensationCode() {
		return challengeCompensationCode;
	}
	public void setChallengeCompensationCode(String challengeCompensationCode) {
		this.challengeCompensationCode = challengeCompensationCode;
	}
	public String getChallengeCode() {
		return challengeCode;
	}
	public void setChallengeCode(String challengeCode) {
		this.challengeCode = challengeCode;
	}
	public String getChallengeCategoryCode() {
		return challengeCategoryCode;
	}
	public void setChallengeCategoryCode(String challengeCategoryCode) {
		this.challengeCategoryCode = challengeCategoryCode;
	}
	
	public String getChallengeParticipationCode() {
		return challengeParticipationCode;
	}
	public void setChallengeParticipationCode(String challengeParticipationCode) {
		this.challengeParticipationCode = challengeParticipationCode;
	}
	public String getChallengeAchievementRateCode() {
		return challengeAchievementRateCode;
	}
	public void setChallengeAchievementRateCode(String challengeAchievementRateCode) {
		this.challengeAchievementRateCode = challengeAchievementRateCode;
	}
	public String getChallengeParticipationEmail() {
		return challengeParticipationEmail;
	}
	public void setChallengeParticipationEmail(String challengeParticipationEmail) {
		this.challengeParticipationEmail = challengeParticipationEmail;
	}
	public String getChallengeRewardPrice() {
		return challengeRewardPrice;
	}
	public void setChallengeRewardPrice(String challengeRewardPrice) {
		this.challengeRewardPrice = challengeRewardPrice;
	}
	public String getChallengeRewardBank() {
		return challengeRewardBank;
	}
	public void setChallengeRewardBank(String challengeRewardBank) {
		this.challengeRewardBank = challengeRewardBank;
	}
	public String getChallengeRewardAccount() {
		return challengeRewardAccount;
	}
	public void setChallengeRewardAccount(String challengeRewardAccount) {
		this.challengeRewardAccount = challengeRewardAccount;
	}
	public String getChallengeRewardDate() {
		return challengeRewardDate;
	}
	public void setChallengeRewardDate(String challengeRewardDate) {
		this.challengeRewardDate = challengeRewardDate;
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
	public NormalUser getNormalUser() {
		return normalUser;
	}
	public void setNormalUser(NormalUser normalUser) {
		this.normalUser = normalUser;
	}
	
	
	
	@Override
	public String toString() {
		return "ChallengeCompensation [challengeCompensationCode=" + challengeCompensationCode + ", challengeCode="
				+ challengeCode + ", challengeCategoryCode=" + challengeCategoryCode + ", challengeParticipationCode="
				+ challengeParticipationCode + ", challengeAchievementRateCode=" + challengeAchievementRateCode
				+ ", challengeParticipationEmail=" + challengeParticipationEmail + ", challengeRewardPrice="
				+ challengeRewardPrice + ", challengeRewardBank=" + challengeRewardBank + ", challengeRewardAccount="
				+ challengeRewardAccount + ", challengeRewardDate=" + challengeRewardDate + ", challengeCategory="
				+ challengeCategory + ", challenge=" + challenge + ", challengeParticipation=" + challengeParticipation
				+ ", challengeAchievementRate=" + challengeAchievementRate + ", coachUser=" + coachUser
				+ ", normalUser=" + normalUser + "]";
	}
	
	

}
