package com.devcdper.challenge.domain;

import com.devcdper.user_admin.domain.CoachUser;
import com.devcdper.user_admin.domain.NormalUser;

public class ChallengeCertification {

		private String challengeCertificationCode;
		private String challengeCategoryCode;
		private String challengeCode;
		private String challengeParticipationCode;
		private String challengeParticipationEmail;
		private String challengeCertificationTitle;
		private String challengeCertificationMethod;
		private String challengeCertificationContents;
		private String challengeCertificationAttachedFile;
		private String challengeCertificationStatus;
		private String challengeCertificationDate;
		
		//챌린지 카테고리
		private ChallengeCategory challengeCategory;
		
		//챌린지
		private Challenge challenge;
		
		//챌린지 참여
		private ChallengeParticipation challengeParticipation;
		
		//챌린지 참여 회원이메일
		private CoachUser coachUser;
		private NormalUser normalUser;
		
		public String getChallengeCertificationCode() {
			return challengeCertificationCode;
		}
		public void setChallengeCertificationCode(String challengeCertificationCode) {
			this.challengeCertificationCode = challengeCertificationCode;
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
		
		public String getChallengeCertificationTitle() {
			return challengeCertificationTitle;
		}
		public void setChallengeCertificationTitle(String challengeCertificationTitle) {
			this.challengeCertificationTitle = challengeCertificationTitle;
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
		public String getChallengeCertificationAttachedFile() {
			return challengeCertificationAttachedFile;
		}
		public void setChallengeCertificationAttachedFile(String challengeCertificationAttachedFile) {
			this.challengeCertificationAttachedFile = challengeCertificationAttachedFile;
		}
		public String getChallengeCertificationStatus() {
			return challengeCertificationStatus;
		}
		public void setChallengeCertificationStatus(String challengeCertificationStatus) {
			this.challengeCertificationStatus = challengeCertificationStatus;
		}
		public String getChallengeCertificationDate() {
			return challengeCertificationDate;
		}
		public void setChallengeCertificationDate(String challengeCertificationDate) {
			this.challengeCertificationDate = challengeCertificationDate;
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
			return "ChallengeCertification [challengeCertificationCode=" + challengeCertificationCode
					+ ", challengeCategoryCode=" + challengeCategoryCode + ", challengeCode=" + challengeCode
					+ ", challengeParticipationCode=" + challengeParticipationCode + ", challengeParticipationEmail="
					+ challengeParticipationEmail + ", challengeCertificationTitle=" + challengeCertificationTitle
					+ ", challengeCertificationMethod=" + challengeCertificationMethod
					+ ", challengeCertificationContents=" + challengeCertificationContents
					+ ", challengeCertificationAttachedFile=" + challengeCertificationAttachedFile
					+ ", challengeCertificationStatus=" + challengeCertificationStatus + ", challengeCertificationDate="
					+ challengeCertificationDate + ", challengeCategory=" + challengeCategory + ", challenge="
					+ challenge + ", challengeParticipation=" + challengeParticipation + ", coachUser=" + coachUser
					+ ", normalUser=" + normalUser + "]";
		}
		
		

}
