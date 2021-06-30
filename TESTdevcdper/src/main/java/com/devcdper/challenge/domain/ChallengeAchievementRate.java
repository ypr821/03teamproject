package com.devcdper.challenge.domain;

import com.devcdper.user_admin.domain.CoachUser;
import com.devcdper.user_admin.domain.NormalUser;

public class ChallengeAchievementRate {

		
		private String ChallengeAchievementRateCode; 
		private String ChallengeAchievementRateSuccesCount;
		private String ChallengeAchievementRateTotalTimes	;
		private String ChallengeAchievementRateUpdateDate;

		//챌린지 카테고리
		private ChallengeCategory challengeCategory;
		
		//챌린지
		private Challenge challenge;
		
		//챌린지 참여
		private ChallengeParticipation challengeParticipation;
		
		//챌린지 참여 회원이메일
		private CoachUser coachUser;
		private NormalUser nomaluser;
		
		
		public String getChallengeAchievementRateCode() {
			return ChallengeAchievementRateCode;
		}
		public void setChallengeAchievementRateCode(String challengeAchievementRateCode) {
			ChallengeAchievementRateCode = challengeAchievementRateCode;
		}
		public String getChallengeAchievementRateSuccesCount() {
			return ChallengeAchievementRateSuccesCount;
		}
		public void setChallengeAchievementRateSuccesCount(String challengeAchievementRateSuccesCount) {
			ChallengeAchievementRateSuccesCount = challengeAchievementRateSuccesCount;
		}
		public String getChallengeAchievementRateTotalTimes() {
			return ChallengeAchievementRateTotalTimes;
		}
		public void setChallengeAchievementRateTotalTimes(String challengeAchievementRateTotalTimes) {
			ChallengeAchievementRateTotalTimes = challengeAchievementRateTotalTimes;
		}
		public String getChallengeAchievementRateUpdateDate() {
			return ChallengeAchievementRateUpdateDate;
		}
		public void setChallengeAchievementRateUpdateDate(String challengeAchievementRateUpdateDate) {
			ChallengeAchievementRateUpdateDate = challengeAchievementRateUpdateDate;
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
		public NormalUser getNomaluser() {
			return nomaluser;
		}
		public void setNomaluser(NormalUser nomaluser) {
			this.nomaluser = nomaluser;
		}
		
		@Override
		public String toString() {
			return "ChallengeAchievementRate [ChallengeAchievementRateCode=" + ChallengeAchievementRateCode
					+ ", ChallengeAchievementRateSuccesCount=" + ChallengeAchievementRateSuccesCount
					+ ", ChallengeAchievementRateTotalTimes=" + ChallengeAchievementRateTotalTimes
					+ ", ChallengeAchievementRateUpdateDate=" + ChallengeAchievementRateUpdateDate
					+ ", challengeCategory=" + challengeCategory + ", challenge=" + challenge
					+ ", challengeParticipation=" + challengeParticipation + ", coachUser=" + coachUser + ", nomaluser="
					+ nomaluser + "]";
		}
		
		
	

}
