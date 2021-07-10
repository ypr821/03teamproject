package com.devcdper.challenge.domain;

import com.devcdper.user_admin.domain.CoachUser;
import com.devcdper.user_admin.domain.NormalUser;

public class ChallengeAchievementRate {

		
		private String challengeAchievementRateCode;
		private String challengeCategoryCode;
		private String challengeCode;
		private String challengeParticipationCode;
		private String challengeParticipationEmail;
		private int challengeAchievementRateSuccesCount;
		private int challengeAchievementRateTotalTimes	;
		private String challengeAchievementRateUpdateDate;

		//챌린지 카테고리
		private ChallengeCategory challengeCategory;
		
		//챌린지
		private Challenge challenge;
		
		//챌린지 참여
		private ChallengeParticipation challengeParticipation;
		
		//챌린지 참여 회원이메일
		private CoachUser coachUser;
		private NormalUser normalUser;
		
		
		public String getChallengeAchievementRateCode() {
			return challengeAchievementRateCode;
		}
		public void setChallengeAchievementRateCode(String challengeAchievementRateCode) {
			this.challengeAchievementRateCode = challengeAchievementRateCode;
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
		public String getChallengeParticipationCode() {
			return challengeParticipationCode;
		}
		public void setChallengeParticipationCode(String challengeParticipationCode) {
			this.challengeParticipationCode = challengeParticipationCode;
		}
		public String getChallengeParticipationEmail() {
			return challengeParticipationEmail;
		}
		public void setChallengeParticipationEmail(String challengeParticipationEmail) {
			this.challengeParticipationEmail = challengeParticipationEmail;
		}
		public int getChallengeAchievementRateSuccesCount() {
			return challengeAchievementRateSuccesCount;
		}
		public void setChallengeAchievementRateSuccesCount(int challengeAchievementRateSuccesCount) {
			this.challengeAchievementRateSuccesCount = challengeAchievementRateSuccesCount;
		}
		public int getChallengeAchievementRateTotalTimes() {
			return challengeAchievementRateTotalTimes;
		}
		public void setChallengeAchievementRateTotalTimes(int challengeAchievementRateTotalTimes) {
			this.challengeAchievementRateTotalTimes = challengeAchievementRateTotalTimes;
		}
		public String getChallengeAchievementRateUpdateDate() {
			return challengeAchievementRateUpdateDate;
		}
		public void setChallengeAchievementRateUpdateDate(String challengeAchievementRateUpdateDate) {
			this.challengeAchievementRateUpdateDate = challengeAchievementRateUpdateDate;
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
			return "ChallengeAchievement [challengeAchievementRateCode=" + challengeAchievementRateCode
					+ ", challengeCategoryCode=" + challengeCategoryCode + ", challengeCode=" + challengeCode
					+ ", challengeParticipationCode=" + challengeParticipationCode + ", challengeParticipationEmail="
					+ challengeParticipationEmail + ", challengeAchievementRateSuccesCount="
					+ challengeAchievementRateSuccesCount + ", challengeAchievementRateTotalTimes="
					+ challengeAchievementRateTotalTimes + ", challengeAchievementRateUpdateDate="
					+ challengeAchievementRateUpdateDate + ", challengeCategory=" + challengeCategory + ", challenge="
					+ challenge + ", challengeParticipation=" + challengeParticipation + ", coachUser=" + coachUser
					+ ", normalUser=" + normalUser + "]";
		}
		
		
		

}
