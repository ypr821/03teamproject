package com.devcdper.challenge.domain;

import com.devcdper.user_admin.domain.CoachUser;
import com.devcdper.user_admin.domain.NormalUser;

public class ChallengeCertification {

		private String ChallengeCertificationCode;
		
		private ChallengeCategory challengeCategory;
		private Challenge challenge;
		private ChallengeParticipation challengeParticipation;
		
		//챌린지 참여 회원이메일
		private CoachUser coachUser;
		private NormalUser nomaluser;
		
		private String ChallengeCertificationMethod;
		private String ChallengeCertificationContents;
		private String ChallengeCertificationAttachedFile;
		private String ChallengeCertificationStatus;
		private String ChallengeCertificationDate;
		
		
		public String getChallengeCertificationCode() {
			return ChallengeCertificationCode;
		}
		public void setChallengeCertificationCode(String challengeCertificationCode) {
			ChallengeCertificationCode = challengeCertificationCode;
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
		public String getChallengeCertificationAttachedFile() {
			return ChallengeCertificationAttachedFile;
		}
		public void setChallengeCertificationAttachedFile(String challengeCertificationAttachedFile) {
			ChallengeCertificationAttachedFile = challengeCertificationAttachedFile;
		}
		public String getChallengeCertificationStatus() {
			return ChallengeCertificationStatus;
		}
		public void setChallengeCertificationStatus(String challengeCertificationStatus) {
			ChallengeCertificationStatus = challengeCertificationStatus;
		}
		public String getChallengeCertificationDate() {
			return ChallengeCertificationDate;
		}
		public void setChallengeCertificationDate(String challengeCertificationDate) {
			ChallengeCertificationDate = challengeCertificationDate;
		}
		
		
		@Override
		public String toString() {
			return "ChallengeCertification [ChallengeCertificationCode=" + ChallengeCertificationCode
					+ ", challengeCategory=" + challengeCategory + ", challenge=" + challenge
					+ ", challengeParticipation=" + challengeParticipation + ", coachUser=" + coachUser + ", nomaluser="
					+ nomaluser + ", ChallengeCertificationMethod=" + ChallengeCertificationMethod
					+ ", ChallengeCertificationContents=" + ChallengeCertificationContents
					+ ", ChallengeCertificationAttachedFile=" + ChallengeCertificationAttachedFile
					+ ", ChallengeCertificationStatus=" + ChallengeCertificationStatus + ", ChallengeCertificationDate="
					+ ChallengeCertificationDate + "]";
		}
	

}
