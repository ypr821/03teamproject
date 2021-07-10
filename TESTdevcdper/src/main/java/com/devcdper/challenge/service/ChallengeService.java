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
	public Map<String, Object> getChallengeList(int currentPage){
		
		
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
		
		List<Map<String, Challenge>> challengeList = challengeMapper.getChallengeList(paramMap);
		
		double rowCount = challengeMapper.getChallengeCount();
		
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
		resultMap.put("challengeList", challengeList);
		resultMap.put("lastPage", lastPage);
		resultMap.put("pageStartNum", pageStartNum);
		resultMap.put("pageEndNum", pageEndNum);
		
		return resultMap;
		
	}
	
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
	public Challenge getChallengeCertificationInfoByChallengeName(String challengeName) {
		return challengeMapper.getChallengeCertificationInfoByChallengeName(challengeName);
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
	public List<ChallengeCertification> getVerifiableChallengeList(){
		return challengeMapper.getVerifiableChallengeList();
	}
	
	//챌린지 카테고리 리스트
	public List<Challenge> getChallengeByCategoryExplorationList(Map<String, Object> cateMap){
		
		System.out.println("CateMap:"+cateMap);
		
		/*
		 * String cateName = cateMap.toString().split("=")[1]; System.out.println("}: "+
		 * cateName.substring(0,cateName.indexOf("}"))); String realName =
		 * (cateName.substring(0,cateName.indexOf("}")).trim());
		 */
		
		
		//챌린지 탐색하기 - 카테고리별 리스트 
		return challengeMapper.getChallengeByCategoryExplorationList(cateMap);
	}
	

}
