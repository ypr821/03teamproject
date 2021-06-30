package com.devcdper.challenge.domain;

import com.devcdper.user_admin.domain.*;

public class Challenge {

	private String ChallengeCode ;
	private String ChallengeName;
	private String ChallengeScope;
	private String ChallengeParticipationPassword;
	private String ChallengeTag;
	private int ChallengeMaximumPeople;
	private int ChallengeBetAmount;
	private String ChallengeCertificationMethod;
	private String ChallengeCertificationContents;
	private String ChallengeCertificationFrequency;
	private int ChallengeTotalTimes;
	private int ChallengeTimesPerDays;
	private String ChallengeTimesForCertification;
	private String ChallengeStartDate;
	private String ChallengeEndDate;
	private String ChallengeRegisterDate;
	
	//챌린지 카테고리
	private ChallengeCategory challengeCategory;
	
	//챌린지 참여 회원이메일
	private CoachUser coachUser;
	private NormalUser nomaluser;
	
	
	public String getChallengeCode() {
		return ChallengeCode;
	}
	public void setChallengeCode(String challengeCode) {
		ChallengeCode = challengeCode;
	}
	public String getChallengeName() {
		return ChallengeName;
	}
	public void setChallengeName(String challengeName) {
		ChallengeName = challengeName;
	}
	public String getChallengeScope() {
		return ChallengeScope;
	}
	public void setChallengeScope(String challengeScope) {
		ChallengeScope = challengeScope;
	}
	public String getChallengeParticipationPassword() {
		return ChallengeParticipationPassword;
	}
	public void setChallengeParticipationPassword(String challengeParticipationPassword) {
		ChallengeParticipationPassword = challengeParticipationPassword;
	}
	public String getChallengeTag() {
		return ChallengeTag;
	}
	public void setChallengeTag(String challengeTag) {
		ChallengeTag = challengeTag;
	}
	public int getChallengeMaximumPeople() {
		return ChallengeMaximumPeople;
	}
	public void setChallengeMaximumPeople(int challengeMaximumPeople) {
		ChallengeMaximumPeople = challengeMaximumPeople;
	}
	public int getChallengeBetAmount() {
		return ChallengeBetAmount;
	}
	public void setChallengeBetAmount(int challengeBetAmount) {
		ChallengeBetAmount = challengeBetAmount;
	}
	public String getChallengeCertificationMethod() {
		return ChallengeCertificationMethod;
	}
	public void setChallengeCertificationMethod(String challengeCertificationMethod) {
		ChallengeCertificationMethod = challengeCertificationMethod;
	}
	public String getChallengeCertificationContents() {
		return ChallengeCertificationContents;
	}
	public void setChallengeCertificationContents(String challengeCertificationContents) {
		ChallengeCertificationContents = challengeCertificationContents;
	}
	public String getChallengeCertificationFrequency() {
		return ChallengeCertificationFrequency;
	}
	public void setChallengeCertificationFrequency(String challengeCertificationFrequency) {
		ChallengeCertificationFrequency = challengeCertificationFrequency;
	}
	public int getChallengeTotalTimes() {
		return ChallengeTotalTimes;
	}
	public void setChallengeTotalTimes(int challengeTotalTimes) {
		ChallengeTotalTimes = challengeTotalTimes;
	}
	public int getChallengeTimesPerDays() {
		return ChallengeTimesPerDays;
	}
	public void setChallengeTimesPerDays(int challengeTimesPerDays) {
		ChallengeTimesPerDays = challengeTimesPerDays;
	}
	public String getChallengeTimesForCertification() {
		return ChallengeTimesForCertification;
	}
	public void setChallengeTimesForCertification(String challengeTimesForCertification) {
		ChallengeTimesForCertification = challengeTimesForCertification;
	}
	public String getChallengeStartDate() {
		return ChallengeStartDate;
	}
	public void setChallengeStartDate(String challengeStartDate) {
		ChallengeStartDate = challengeStartDate;
	}
	public String getChallengeEndDate() {
		return ChallengeEndDate;
	}
	public void setChallengeEndDate(String challengeEndDate) {
		ChallengeEndDate = challengeEndDate;
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
		return "Challenge [ChallengeCode=" + ChallengeCode + ", ChallengeName=" + ChallengeName + ", ChallengeScope="
				+ ChallengeScope + ", ChallengeParticipationPassword=" + ChallengeParticipationPassword
				+ ", ChallengeTag=" + ChallengeTag + ", ChallengeMaximumPeople=" + ChallengeMaximumPeople
				+ ", ChallengeBetAmount=" + ChallengeBetAmount + ", ChallengeCertificationMethod="
				+ ChallengeCertificationMethod + ", ChallengeCertificationContents=" + ChallengeCertificationContents
				+ ", ChallengeCertificationFrequency=" + ChallengeCertificationFrequency + ", ChallengeTotalTimes="
				+ ChallengeTotalTimes + ", ChallengeTimesPerDays=" + ChallengeTimesPerDays
				+ ", ChallengeTimesForCertification=" + ChallengeTimesForCertification + ", ChallengeStartDate="
				+ ChallengeStartDate + ", ChallengeEndDate=" + ChallengeEndDate + ", ChallengeRegisterDate="
				+ ChallengeRegisterDate + ", challengeCategory=" + challengeCategory + ", coachUser=" + coachUser
				+ ", nomaluser=" + nomaluser + "]";
	}
	
	
	

}
