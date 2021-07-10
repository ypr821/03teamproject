package com.devcdper.challenge.domain;

public class ChallengeCategory {

	private String challengeCategoryCode;
	private String challengeCategoryName;
	
	
	public String getChallengeCategoryCode() {
		return challengeCategoryCode;
	}
	public void setChallengeCategoryCode(String challengeCategoryCode) {
		this.challengeCategoryCode = challengeCategoryCode;
	}
	public String getChallengeCategoryName() {
		return challengeCategoryName;
	}
	public void setChallengeCategoryName(String challengeCategoryName) {
		this.challengeCategoryName = challengeCategoryName;
	}
	
	@Override
	public String toString() {
		return "ChallengeCategory [challengeCategoryCode=" + challengeCategoryCode + ", challengeCategoryName="
				+ challengeCategoryName + "]";
	}
	
	
	
}
