package com.devcdper.challenge.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.devcdper.challenge.dao.ChallengeMapper;
import com.devcdper.challenge.domain.Challenge;
import com.devcdper.challenge.domain.ChallengeCategory;
import com.devcdper.challenge.domain.ChallengeCertification;
import com.devcdper.challenge.domain.ChallengeParticipation;

@Service
public class ChallengeService {
	
	
	//의존성 주입 (생성자 메서드 방식)
	private final ChallengeMapper challengeMapper;

	public ChallengeService(ChallengeMapper challengeMapper) {
		this.challengeMapper = challengeMapper;
	}
	
	//챌린지 리스트
	public List<Challenge> getChallengeList(int currentPage, String challengeName){
		
		
		/*
		 * //보여줄 행의 갯수 int rowPerPage = 10;
		 * 
		 * //table에서 보여질 행의 시작점 초기화 int rowStart = 0;
		 * 
		 * //페이지 번호 초기화 int pageStartNum = 1; int pageEndNum = 10;
		 * 
		 * //rowStart = 페이지알고리즘(현재페이지 - 1) * 보여줄 행의 갯수 rowStart = (currentPage - 1) *
		 * rowPerPage;
		 * 
		 * Map<String, Object> paramMap = new HashMap<String, Object>();
		 * paramMap.put("rowStart", rowStart); paramMap.put("rowPerPage", rowPerPage);
		 */
		
		List<Challenge> challengeList = challengeMapper.getChallengeList(challengeName);
		
		/*
		 * double rowCount = challengeMapper.getChallengeCount();
		 * 
		 * int lastPage = (int) Math.ceil(rowCount/rowPerPage);
		 * 
		 * if(currentPage > 6) { pageStartNum = currentPage - 5; pageEndNum =
		 * currentPage + 4;
		 * 
		 * if(pageEndNum >= lastPage) { pageStartNum = lastPage - 9; pageEndNum =
		 * lastPage; } }
		 */
		
		/*
		 * Map<String, Object> resultMap = new HashMap<String, Object>();
		 * resultMap.put("challengeList", challengeList); resultMap.put("lastPage",
		 * lastPage); resultMap.put("pageStartNum", pageStartNum);
		 * resultMap.put("pageEndNum", pageEndNum);
		 */
		
		return challengeList;
		
	}
	
	
	/* 나의 챌린지 : 개설 챌린지 설정(수정) */
	
	//0. 수정할 챌린지 리스트
	public List<Challenge> getmodifyChallengeList(String sessionEmail, String challengeName){
		return challengeMapper.getmodifyChallengeList(sessionEmail, challengeName);
	}
	
	//1. 수정할 챌린지명
	public Challenge getModifyChallengeAttributeList(String challengeCode) {
		System.out.println("챌린지 코드 : " + challengeCode);
		return challengeMapper.getModifyChallengeAttributeList(challengeCode);
	}
	
	/*
	 * //2. 수정할 챌린지기간 public Challenge getModifyChallengePeriod(String
	 * challengeStartDate, String challengeEndDate, String challengeName) {
	 * System.out.println(challengeStartDate + "<< challengeStartDate");
	 * System.out.println(challengeEndDate + "<< challengeEndDate"); return
	 * challengeMapper.getModifyChallengePeriod(challengeStartDate,
	 * challengeEndDate, challengeName);
	 * 
	 * }
	 */
	
	
	/* ------------------------- 개설 챌린지 정보 수정 시작 ------------------------- */
	
  //1. 챌린지명 수정 
	public int modifyChallengeName(Challenge challenge) { 
		System.out.println("챌린지 서비스 - modifyChallengeName : " + challenge);
		return challengeMapper.modifyChallengeName(challenge); 
	}
  
  //2. 챌린지 날짜(기간) 수정 
	public int modifyChallengePeriod(Challenge challenge) {
		System.out.println("챌린지 서비스 - modifyChallengePeriod : " + challenge);
		return challengeMapper.modifyChallengePeriod(challenge); 
	}
  
  //3. 챌린지 인증방법 수정 
	public int modifyChallengeCertificationMethod(Challenge challenge) { 
		return challengeMapper.modifyChallengeCertificationMethod(challenge); 
	}
  
  //4. 챌린지 소개 수정 
	public int modifyChallengeIntroduce(Challenge challenge) {
		return challengeMapper.modifyChallengeIntroduce(challenge); 
	}
  
  //5. 챌린지 태그 수정 
	public int modifyChallengeTag(Challenge challenge) { 
		System.out.println("modifyChallengeTag 받아온 값" + challenge);
		return challengeMapper.modifyChallengeTag(challenge); 
	}
	
	/* ------------------------- 개설 챌린지 정보 수정 끝 ------------------------- */

	
	
	
	//챌린지 탐색 리스트
	public List<Challenge> getChallengeExplorationList(){
		return challengeMapper.getChallengeExplorationList();
	}
	
	//챌린지 탐색하기 - 상세정보 조회
	//챌린지 참여하기 - 상세정보 조회
	public Challenge getChallengeExplorationDetailInfoByChallengeName(String challengeName) {
		return challengeMapper.getChallengeExplorationDetailInfoByChallengeName(challengeName);
	}
	
	//챌린지 인증하기 - 인증할 챌린지 정보 조회
	public ChallengeParticipation getChallengeCertificationInfo(String challengeName, String sessionEmail) {
		return challengeMapper.getChallengeCertificationInfo(challengeName, sessionEmail);
	}
	
	//챌린지 개설하기(등록)
	public int addChallenge(Challenge challenge) {
		int result = challengeMapper.addChallenge(challenge);
		return result;
	}
	
	//챌린지 참여 리스트
	public Map<String, Object> getChallengeParticipationList(int currentPage){
		
		//보여줄 행의 갯수
		int rowPerPage = 10;
		
		//table에서 보여질 행의 시작점 초기화
		int rowStart = 0;
		
		//페이지 번호 초기화
		int pageStartNum = 1;
		int pageEndNum = 10;
				
		//rowStart = 페이지알고리즘(현재페이지 - 1) * 보여줄 행의 갯수
		rowStart = (currentPage - 1) * rowPerPage;

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("rowStart", rowStart);
		paramMap.put("rowPerPage", rowPerPage);
		
		List<Map<String, Challenge>> challengeParticipationList = challengeMapper.getChallengeParticipationList(paramMap);
		
		double rowCount = challengeMapper.getChallengeParticipationCount();
		
		int lastPage = (int) Math.ceil(rowCount/rowPerPage);
		
		if(currentPage > 6) {
			pageStartNum = currentPage - 5;
			pageEndNum = currentPage + 4;
			
			if(pageEndNum >= lastPage) {
				pageStartNum = lastPage - 9;
				pageEndNum = lastPage;
			}
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("challengeParticipationList", challengeParticipationList);
		resultMap.put("lastPage", lastPage);
		resultMap.put("pageStartNum", pageStartNum);
		resultMap.put("pageEndNum", pageEndNum);
		
		return resultMap;
	}
	
	
	//챌린지 참여 리스트
		public Map<String, Object> getChallengeAchievementRateList(int currentPage){
			
			//보여줄 행의 갯수
			int rowPerPage = 10;
			
			//table에서 보여질 행의 시작점 초기화
			int rowStart = 0;
			
			//페이지 번호 초기화
			int pageStartNum = 1;
			int pageEndNum = 10;
					
			//rowStart = 페이지알고리즘(현재페이지 - 1) * 보여줄 행의 갯수
			rowStart = (currentPage - 1) * rowPerPage;

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("rowStart", rowStart);
			paramMap.put("rowPerPage", rowPerPage);
			
			List<Map<String, Challenge>> challengeAchievementRateList = challengeMapper.getChallengeAchievementRateList(paramMap);
			
			double rowCount = challengeMapper.getChallengeAchievementRateCount();
			
			int lastPage = (int) Math.ceil(rowCount/rowPerPage);
			
			if(currentPage > 6) {
				pageStartNum = currentPage - 5;
				pageEndNum = currentPage + 4;
				
				if(pageEndNum >= lastPage) {
					pageStartNum = lastPage - 9;
					pageEndNum = lastPage;
				}
			}
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("challengeAchievementRateList", challengeAchievementRateList);
			resultMap.put("lastPage", lastPage);
			resultMap.put("pageStartNum", pageStartNum);
			resultMap.put("pageEndNum", pageEndNum);
			
			return resultMap;
		}
	
	//챌린지 인증하기(등록)
	public int addChallengeCertification(ChallengeCertification challengeCertification) {
		int result = challengeMapper.addChallengeCertification(challengeCertification);
		return result;
		
	}
	
	//챌린지 인증하기 (인증 가능한 챌린지 리스트 조회)
	public List<ChallengeCertification> getVerifiableChallengeList(String sessionEmail){
		
		return challengeMapper.getVerifiableChallengeList(sessionEmail);
	}
	
	//챌린지 카테고리별 리스트
	public List<Challenge> getChallengeByCategoryExplorationList(String challengeCategoryCode){
		
		System.out.println("챌린지 카테고리 코드 (ChallengeService):"+ challengeCategoryCode);
		List<Challenge> ChallengeByCategoryExplorationList = challengeMapper.getChallengeByCategoryExplorationList(challengeCategoryCode);
		System.out.println("ChallengeByCategoryExplorationList (ChallengeService) >>>" + ChallengeByCategoryExplorationList);
		
		return ChallengeByCategoryExplorationList;
	}
	

}
