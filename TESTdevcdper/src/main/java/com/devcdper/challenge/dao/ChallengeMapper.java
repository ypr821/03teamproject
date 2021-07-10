package com.devcdper.challenge.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devcdper.challenge.domain.Challenge;
import com.devcdper.challenge.domain.ChallengeCertification;


@Mapper
public interface ChallengeMapper {
	
	
	//관리자 페이지 : 챌린지 달성율 - 테이블 행의 개수
	public int getChallengeAchievementRateCount();
	
	//관리자 페이지 : 챌린지 달성율 - 전체 리스트 조회
	public List<Map<String, Challenge>> getChallengeAchievementRateList(Map<String, Object> paramMap);
	
	//챌린지 인증하기 :
	public Challenge getChallengeCertificationInfoByChallengeName(String challengeName);
	
	//관리자 페이지 : 챌린지 참여 - 테이블 행의 개수
	public int getChallengeCount();
	
	//관리자 페이지 : 개설 챌린지 - 전체 리스트 조회
	public List<Map<String, Challenge>> getChallengeList(Map<String,Object> paramMap);
	
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
	public List<Challenge> getChallengeByCategoryExplorationList(Map<String, Object> cateMap);
	
	//챌린지 인증하기 - 인증가능한 챌린지 리스트 조회
	public List<ChallengeCertification> getVerifiableChallengeList();
	

}
