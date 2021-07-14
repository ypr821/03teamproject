package com.devcdper.challenge.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devcdper.challenge.domain.Challenge;
import com.devcdper.challenge.domain.ChallengeCertification;
import com.devcdper.challenge.domain.ChallengeParticipation;


@Mapper
public interface ChallengeMapper {
	
	
	
	//수정할 챌린지 리스트
	public List<Challenge> getmodifyChallengeList(String sessionEmail, String challengeName);
	
	//수정할 개설 챌린지 조회 (챌린지명/챌린지 기간/챌린지 인증방법/챌린지 소개/챌린지 태그)
	public Challenge getModifyChallengeAttributeList(String challengeCode);

	  //---------------- 나의 챌린지 : 개설 챌린지 설정(수정) 시작-------------------- 
	  //1. 챌린지명 수정
	  public int modifyChallengeName(Challenge challenge);
	  
	  //2. 챌린지 기간 수정 
	  public int modifyChallengePeriod(Challenge challenge);
	  
	  //3. 챌린지 인증방법 수정 
	  public int modifyChallengeCertificationMethod(Challenge challenge);
	  
	  //4. 챌린지 소개 수정 
	  public int modifyChallengeIntroduce(Challenge challenge);
	  
	  //5. 챌린지 태그 수정 
	  public int modifyChallengeTag(Challenge challenge);
	  //---------------- 나의 챌린지 : 개설 챌린지 설정(수정) 끝 --------------------
	 	
	//관리자 페이지 : 챌린지 달성율 - 테이블 행의 개수
	public int getChallengeAchievementRateCount();
	
	//관리자 페이지 : 챌린지 달성율 - 전체 리스트 조회
	public List<Map<String, Challenge>> getChallengeAchievementRateList(Map<String, Object> paramMap);
	
	//챌린지 인증하기 :
	public ChallengeParticipation getChallengeCertificationInfo(String challengeName, String sessionEmail);
	
	//관리자 페이지 : 챌린지 참여 - 테이블 행의 개수
	public int getChallengeCount();
	
	//관리자 페이지 : 개설 챌린지 - 전체 리스트 조회
	public List<Challenge> getChallengeList(String challengeName);
	
	//챌린지 탐색하기 - 메인 박스 리스트
	public List<Challenge> getChallengeExplorationList();
	
	//챌린지 탐색하기 - 상세정보
	//챌린지 참여하기 - 상세정보
	public Challenge getChallengeExplorationDetailInfoByChallengeName(String challengeName);

	//챌린지 개설등록처리
	public int addChallenge(Challenge challenge);
	
	//관리자 페이지 : 챌린지 참여 - 테이블 행의 개수
	public int getChallengeParticipationCount();
	
	//관리자 페이지 : 챌린지 참여 - 전체 리스트 조회
	public List<Map<String, Challenge>> getChallengeParticipationList(Map<String, Object> paramMap);
	
	//챌린지 인증등록처리
	public int addChallengeCertification(ChallengeCertification challengeCertification);
	
	//챌린지 탐색하기 - 카테고리별 챌린지 리스트
	public List<Challenge> getChallengeByCategoryExplorationList(String challengeCategoryCode);
	
	//챌린지 인증하기 - 인증가능한 챌린지 리스트 조회
	public List<ChallengeCertification> getVerifiableChallengeList(String sessionEmail);
	

}
