package com.devcdper.challenge.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devcdper.challenge.domain.Challenge;
import com.devcdper.challenge.domain.ChallengeCategory;
import com.devcdper.challenge.domain.ChallengeCertification;
import com.devcdper.challenge.domain.ChallengeCompensation;
import com.devcdper.challenge.domain.ChallengeParticipation;
import com.devcdper.paging.Pagination;


@Mapper
public interface ChallengeMapper {
	
	
	//-------------------------------- 관리자 Mapper 시작 --------------------------------
	
	//관리자 페이지 : 개설 챌린지 - 개설 챌린지 전체 리스트 조회
	public List<Map<String, Challenge>> getChallengeList(Map<String, Object> paramMap);
	
	//관리자 페이지 : 개설 챌린지 - 챌린지 카테고리 전체 조회
	public List<ChallengeCategory> getChallengeCategoryList();
	
	//관리자 페이지 : 챌린지 참여 관리 - 개설 테이블 행의 개수 조회(페이징 처리)
	public int getChallengeCount();
	
	//관리자 페이지 : 개설 챌린지 - 수정할 카테고리 이름 조회
	public ChallengeCategory getModifyChallengeCategoryInfo(String challengeCategoryCode);
	
	//관리자 페이지 : 개설 챌린지 - 카테고리 추가
	//public int addChallengeCategory(ChallengeCategory challengeCategory);
	
	//관리자 페이지 : 개설 챌린지 - 챌린지 카테고리 이름 수정
	public int modifyChallengeCategoryName(ChallengeCategory challengeCategory);
	
	//관리자 페이지 : 챌린지 참여 관리 - 챌린지 참여 테이블 행의 개수 조회(페이징 처리)
	public int getChallengeParticipationCount();
	
	//관리자 페이지 : 챌린지 참여 관리 - 참여 챌린지 전체 리스트 조회
	public List<Map<String, ChallengeParticipation>> getChallengeParticipationList(Map<String, Object> paramMap);

	//관리자 페이지 : 챌린지 달성율 관리 - 챌린지 달성율 테이블 행의 개수 조회
	public int getChallengeAchievementRateCount();
	
	//관리자 페이지 : 챌린지 달성율 관리 - 챌린지 달성율 전체 리스트 조회
	public List<Map<String, Challenge>> getChallengeAchievementRateList(Map<String, Object> paramMap);
	
	//관리자 페이지 : 챌린지 보상지급 관리 - 챌린지 보상지급 전체 리스트 조회
	public List<Map<String, ChallengeCompensation>> getChallengeCompensationList();
	
	//-------------------------------- 관리자 Mapper 끝 --------------------------------
	
	
	//-------------------------------- 일반회원 Mapper 시작 --------------------------------
	
	//챌린지 탐색하기 - 전체 챌린지 카드 리스트
	public List<Challenge> getChallengeExplorationList();
	
	//챌린지 탐색하기 - 상세정보 조회
	//챌린지 참여하기 - 상세정보 조회
	public Challenge getChallengeExplorationDetailInfoByChallengeCode(String challengeCode);
	
	//챌린지 탐색하기 - 카테고리별 챌린지 리스트 조회
	public List<Challenge> getChallengeByCategoryExplorationList(String challengeCategoryCode, String categoryBtnName);
	
	//챌린지 개설하기 
	public String getChallengeInsertOpenerEmail(String sessionEmail);
	
	//챌린지 개설하기 : 챌린지 개설 등록 처리
	public int addChallenge(Challenge challenge);
	
	//챌린지 인증하기 : 인증가능한 챌린지 전체 리스트 조회
	public ChallengeCertification getChallengeCertificationInfo(String challengeCode, String sessionEmail);
	
	//챌린지 인증하기 - 인증가능한 챌린지 리스트 조회
	public List<ChallengeCertification> getVerifiableChallengeList(String sessionEmail);
	
	//챌린지 인증하기 : 챌린지 인증 등록 처리
	public int addChallengeCertification(Map<String, Object> challengeCertification);
	
	//챌린지 인증게시판 : 챌린지 인증등록 후 게시판 전체 리스트 조회
	public List<Map<String, ChallengeCertification>> getChallengeCertificationBoardList(Map<String, Object> paramMap);
	
	public int getChallengeCertificationBoardCount(String challengeCode);
	
	/* 나의 챌린지 : 개설 챌린지 설정(수정) */
	//나의 챌린지 : 전체 리스트 조회
	public List<Map<String, ChallengeParticipation>> getMyChallengeList(Map<String, Object> paramMap);
	
	//나의 챌린지 : 테이블 행의 개수 조회
	public int getMyChallengeCount(String sessionEmail);
	
	public ChallengeParticipation getMyChallengeDetailInfoByChallengeCode(String challengeCode, String sessionEmail);
	
	//나의 챌린지 : 개설 챌린지 전체 리스트 조회
	public List<Map<String, Challenge>> getMyChallengeInsertList(Map<String, Object> paramMap);
	
	//나의 챌린지 : 개설 챌린지 전체 테이블 행의 개수 조회
	public int getMyChallengeInsertCount(Map<String, Object> paramMap);
	
	//나의 챌린지 : 개설 챌린지 상세정보 조회
	public Challenge getMyChallengeInsertDetailInfoByChallengeCode(String challengeCode, String sessionEmail);
	
	//수정할 개설 챌린지 변경 요소 리스트 조회 (챌린지명/챌린지 기간/챌린지 인증방법/챌린지 소개/챌린지 태그)
	public Challenge getModifyInsertChallengeAttributeList(String challengeCode, String sessionEmail);

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
	  
	  //개설 챌린지 삭제
	  public int removeChallengeByEmailAndCode(String challengeCode, String sessionEmail); 
	 	

	//-------------------------------- 일반회원 Mapper 끝 --------------------------------


}
