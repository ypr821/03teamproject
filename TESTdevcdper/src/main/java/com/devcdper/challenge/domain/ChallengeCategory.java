package com.devcdper.challenge.domain;

public class ChallengeCategory {

	private String ChallengeCategoryCode;
	private String ChallengeCategoryName;
	
	
	public String getChallengeCategoryCode() {
		return ChallengeCategoryCode;
	}
	public void setChallengeCategoryCode(String challengeCategoryCode) {
		ChallengeCategoryCode = challengeCategoryCode;
	}
	public String getChallengeCategoryName() {
		return ChallengeCategoryName;
	}
	public void setChallengeCategoryName(String challengeCategoryName) {
		ChallengeCategoryName = challengeCategoryName;
	}
	@Override
	public String toString() {
		return "ChallengeCategory [ChallengeCategoryCode=" + ChallengeCategoryCode + ", ChallengeCategoryName="
				+ ChallengeCategoryName + "]";
	}

}
