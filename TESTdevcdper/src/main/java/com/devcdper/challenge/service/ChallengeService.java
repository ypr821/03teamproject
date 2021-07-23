package com.devcdper.challenge.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.devcdper.challenge.dao.ChallengeMapper;
import com.devcdper.challenge.domain.Challenge;
import com.devcdper.challenge.domain.ChallengeCategory;
import com.devcdper.challenge.domain.ChallengeCertification;
import com.devcdper.challenge.domain.ChallengeParticipation;
import com.devcdper.paging.Pagination;

@Service
public class ChallengeService {
	
	
	//의존성 주입 (생성자 메서드 방식)
	private final ChallengeMapper challengeMapper;

	public ChallengeService(ChallengeMapper challengeMapper) {
		this.challengeMapper = challengeMapper;
	}
	
	
	//-------------------------------- 관리자 Service 시작 --------------------------------
	
	
	//관리자 페이지 : 개설 챌린지 - 개설 챌린지 전체 리스트 조회
	public List<Map<String, Challenge>> getChallengeList(Pagination paging){
		return challengeMapper.getChallengeList(paging);
	}
	
	public int getChallengeCount() {
		return challengeMapper.getChallengeCount();
	}
	
	//관리자 페이지 : 개설 챌린지 - 챌린지 카테고리 전체 조회
	public List<ChallengeCategory> getChallengeCategoryList() {
		return challengeMapper.getChallengeCategoryList();
	}
	
	//관리자 페이지 : 개설 챌린지 - 수정할 카테고리 이름 조회
	public ChallengeCategory getModifyChallengeCategoryInfo(String challengeCategoryCode){
		System.out.println("챌린지 서비스 challengeCategoryCode >>>> : " + challengeCategoryCode);
		return challengeMapper.getModifyChallengeCategoryInfo(challengeCategoryCode);
	}
	
	/*
	 * //관리자 페이지 : 개설 챌린지 - 카테고리 추가 public int
	 * addChallengeCategory(ChallengeCategory challengeCategory) { return
	 * challengeMapper.addChallengeCategory(challengeCategory); }
	 */
	
	//관리자 페이지 : 개설 챌린지 - 챌린지 카테고리 이름 수정
	public int modifyChallengeCategoryName(ChallengeCategory challengeCategory) {
		return challengeMapper.modifyChallengeCategoryName(challengeCategory);
	}
	
	
	//관리자 페이지 : 챌린지 참여 관리 - 참여 챌린지 전체 리스트 조회
	public List<Map<String, Challenge>> getChallengeParticipationList(Pagination paging) {
		return challengeMapper.getChallengeParticipationList(paging);
	}
	
	//관리자 페이지 : 챌린지 참여 관리 - 참여 챌린지 전체 행 개수 조회
	public int getChallengeParticipationCount(){
		return challengeMapper.getChallengeParticipationCount();
	}
	
	
	//관리자 페이지 : 챌린지 달성율 관리 - 챌린지 달성율 전체 리스트 조회(페이징 처리)
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
	
	//-------------------------------- 관리자 Service 끝 --------------------------------

	//-------------------------------- 일반회원 Service 시작 --------------------------------

	//챌린지 탐색하기 - 전체 챌린지 카드 리스트
	public List<Challenge> getChallengeExplorationList(){
			return challengeMapper.getChallengeExplorationList();
	}
	
	//챌린지 탐색하기 - 상세정보 조회
	//챌린지 참여하기 - 상세정보 조회
	public Challenge getChallengeExplorationDetailInfoByChallengeName(String challengeName) {
		return challengeMapper.getChallengeExplorationDetailInfoByChallengeName(challengeName);
	}
	
	//챌린지 탐색하기 - 카테고리별 챌린지 리스트 조회
	public List<Challenge> getChallengeByCategoryExplorationList(String challengeCategoryCode){
		
		System.out.println("챌린지 카테고리 코드 (ChallengeService):"+ challengeCategoryCode);
		List<Challenge> ChallengeByCategoryExplorationList = challengeMapper.getChallengeByCategoryExplorationList(challengeCategoryCode);
		System.out.println("ChallengeByCategoryExplorationList (ChallengeService) >>>" + ChallengeByCategoryExplorationList);
		
		return ChallengeByCategoryExplorationList;
	}
	
	//챌린지 개설하기 : 챌린지 개설 등록 처리
	public int addChallenge(Challenge challenge)  {
		
		Calendar cal = Calendar.getInstance();
		Date toDate = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String toDateformat = formatter.format(toDate);
		Date formatTodayDate = null;
		
		String[] startArray = challenge.getChallengeStartDate().split("-");
		String[] endArray = challenge.getChallengeEndDate().split("-");
		
		cal.set(Integer.parseInt(startArray[0]), Integer.parseInt(startArray[1])-1, Integer.parseInt(startArray[2]));
		Date startDate = cal.getTime();
		String startDateformat = formatter.format(startDate);
		Date formatStartDate = null;
		
		cal.set(Integer.parseInt(endArray[0]), Integer.parseInt(endArray[1])-1, Integer.parseInt(endArray[2]));
		Date endDate = cal.getTime();
		String endDateformat = formatter.format(endDate);
		Date formatEndDate = null;
		
		try {
			formatTodayDate = formatter.parse(toDateformat);
			System.out.println("현재일 : " + formatTodayDate); 
			formatStartDate = formatter.parse(startDateformat);
			System.out.println("시작일 : " + formatStartDate);
			formatEndDate = formatter.parse(endDateformat);
			System.out.println("종료일 : " + formatEndDate);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(formatStartDate.after(formatTodayDate));
		System.out.println(formatStartDate.before(formatTodayDate) && formatEndDate.after(formatTodayDate));
		System.out.println(formatEndDate.before(formatTodayDate));
		
		if(formatStartDate.after(formatTodayDate) == true) {
			challenge.setChallengeProgressStatus("진행예정");
			System.out.println("상태 : " + challenge.getChallengeProgressStatus());
		}else if(formatStartDate.before(formatTodayDate) && formatEndDate.after(formatTodayDate) == true) {
			challenge.setChallengeProgressStatus("진행중");
			System.out.println("상태 : " + challenge.getChallengeProgressStatus());
		}else if(formatEndDate.before(formatTodayDate) == true) {
			challenge.setChallengeProgressStatus("완료");
			System.out.println("상태 : " + challenge.getChallengeProgressStatus());
		}
		
		int result = challengeMapper.addChallenge(challenge);
		return result;
	}
	
	//챌린지 인증하기 : 인증가능한 챌린지 전체 리스트 조회
	public ChallengeParticipation getChallengeCertificationInfo(String challengeName, String sessionEmail) {
		return challengeMapper.getChallengeCertificationInfo(challengeName, sessionEmail);
	}
	
	//챌린지 인증하기 - 인증가능한 챌린지 리스트 조회
	public List<ChallengeCertification> getVerifiableChallengeList(String sessionEmail){
		
		return challengeMapper.getVerifiableChallengeList(sessionEmail);
	}
	
	//챌린지 인증하기 : 챌린지 인증 등록 처리
	public int addChallengeCertification(ChallengeCertification challengeCertification) {
		int result = challengeMapper.addChallengeCertification(challengeCertification);
		return result;
		
	}
	
	/* 나의 챌린지 : 개설 챌린지 설정(수정) */
	
	//0. 수정할 챌린지 리스트
	public List<Challenge> getInsertChallengeList(Map<String, Object> paramMap){
		return challengeMapper.getInsertChallengeList(paramMap);
	}
	
	//1. 수정할 챌린지 정보 리스트 - 챌린지명, 챌린지 시작일, 챌린지 종료일, 챌린지 인증방법, 챌린지 소개, 챌린지 태그 
	public Challenge getModifyInsertChallengeAttributeList(String challengeCode) {
		System.out.println("챌린지 코드 : " + challengeCode);
		return challengeMapper.getModifyInsertChallengeAttributeList(challengeCode);
	}
	
	
		//---------------- 나의 챌린지 : 개설 챌린지 설정 정보 수정 시작-------------------- 
	
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
	
		//---------------- 나의 챌린지 : 개설 챌린지 설정 정보 수정 끝-------------------- 

	//-------------------------------- 일반회원 Service 끝 --------------------------------
	
}
