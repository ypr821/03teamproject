package com.devcdper.challenge.domain;

import com.devcdper.user_admin.domain.NormalUser;

public class Challenge {
	
	private String challengeCode ;
	private String challengeCategoryCode;
	private String challengeOpenerEmail ;
	private String challengeName;
	private String challengeScope;
	private String challengeParticipationPassword;
	private String challengeTag;
	private String challengeIntroduce;
	private int challengeMaximumPeople;
	private int challengeBetAmount;
	private String challengeCertificationMethod;
	private String challengeCertificationContents;
	private String challengeCertificationFrequency;
	private String challengeProgressStatus;
	private String challengeStartDate;
	private String challengeEndDate;
	private String challengeRegisterDate;
	
	private NormalUser normalUser;
	private ChallengeCategory challengeCategory;
	
	
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
	public String getChallengeOpenerEmail() {
		return challengeOpenerEmail;
	}
	public void setChallengeOpenerEmail(String challengeOpenerEmail) {
		this.challengeOpenerEmail = challengeOpenerEmail;
	}
	public String getChallengeName() {
		return challengeName;
	}
	public void setChallengeName(String challengeName) {
		this.challengeName = challengeName;
	}
	public String getChallengeScope() {
		return challengeScope;
	}
	public void setChallengeScope(String challengeScope) {
		this.challengeScope = challengeScope;
	}
	public String getChallengeParticipationPassword() {
		return challengeParticipationPassword;
	}
	public void setChallengeParticipationPassword(String challengeParticipationPassword) {
		this.challengeParticipationPassword = challengeParticipationPassword;
	}
	public String getChallengeTag() {
		return challengeTag;
	}
	public void setChallengeTag(String challengeTag) {
		this.challengeTag = challengeTag;
	}
	public String getChallengeIntroduce() {
		return challengeIntroduce;
	}
	public void setChallengeIntroduce(String challengeIntroduce) {
		this.challengeIntroduce = challengeIntroduce;
	}
	public int getChallengeMaximumPeople() {
		return challengeMaximumPeople;
	}
	public void setChallengeMaximumPeople(int challengeMaximumPeople) {
		this.challengeMaximumPeople = challengeMaximumPeople;
	}
	public int getChallengeBetAmount() {
		return challengeBetAmount;
	}
	public void setChallengeBetAmount(int challengeBetAmount) {
		this.challengeBetAmount = challengeBetAmount;
	}
	public String getChallengeCertificationMethod() {
		return challengeCertificationMethod;
	}
	public void setChallengeCertificationMethod(String challengeCertificationMethod) {
		this.challengeCertificationMethod = challengeCertificationMethod;
	}
	public String getChallengeCertificationContents() {
		return challengeCertificationContents;
	}
	public void setChallengeCertificationContents(String challengeCertificationContents) {
		this.challengeCertificationContents = challengeCertificationContents;
	}
	public String getChallengeCertificationFrequency() {
		return challengeCertificationFrequency;
	}
	public void setChallengeCertificationFrequency(String challengeCertificationFrequency) {
		this.challengeCertificationFrequency = challengeCertificationFrequency;
	}
	public String getChallengeProgressStatus() {
		return challengeProgressStatus;
	}
	public String setChallengeProgressStatus(String challengeProgressStatus) {
		return this.challengeProgressStatus = challengeProgressStatus;
	}
	public String getChallengeStartDate() {
		return challengeStartDate;
	}
	public void setChallengeStartDate(String challengeStartDate) {
		this.challengeStartDate = challengeStartDate;
	}
	public String getChallengeEndDate() {
		return challengeEndDate;
	}
	public void setChallengeEndDate(String challengeEndDate) {
		this.challengeEndDate = challengeEndDate;
	}
	public String getChallengeRegisterDate() {
		return challengeRegisterDate;
	}
	public void setChallengeRegisterDate(String challengeRegisterDate) {
		this.challengeRegisterDate = challengeRegisterDate;
	}
	public NormalUser getNormalUser() {
		return normalUser;
	}
	public void setNormalUser(NormalUser normalUser) {
		this.normalUser = normalUser;
	}
	public ChallengeCategory getChallengeCategory() {
		return challengeCategory;
	}
	public void setChallengeCategory(ChallengeCategory challengeCategory) {
		this.challengeCategory = challengeCategory;
	}
	
	
	@Override
	public String toString() {
		return "Challenge [challengeCode=" + challengeCode + ", challengeCategoryCode=" + challengeCategoryCode
				+ ", challengeOpenerEmail=" + challengeOpenerEmail + ", challengeName=" + challengeName
				+ ", challengeScope=" + challengeScope + ", challengeParticipationPassword="
				+ challengeParticipationPassword + ", challengeTag=" + challengeTag + ", challengeIntroduce="
				+ challengeIntroduce + ", challengeMaximumPeople=" + challengeMaximumPeople + ", challengeBetAmount="
				+ challengeBetAmount + ", challengeCertificationMethod=" + challengeCertificationMethod
				+ ", challengeCertificationContents=" + challengeCertificationContents
				+ ", challengeCertificationFrequency=" + challengeCertificationFrequency + ", challengeProgressStatus="
				+ challengeProgressStatus + ", challengeStartDate=" + challengeStartDate + ", challengeEndDate="
				+ challengeEndDate + ", challengeRegisterDate=" + challengeRegisterDate + ", normalUser=" + normalUser
				+ ", challengeCategory=" + challengeCategory + "]";
	}
	

	
	
	
}
