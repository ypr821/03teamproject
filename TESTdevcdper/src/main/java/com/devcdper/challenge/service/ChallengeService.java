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
import com.devcdper.challenge.domain.ChallengeCompensation;
import com.devcdper.challenge.domain.ChallengeParticipation;
import com.devcdper.paging.PageMaker;
import com.devcdper.paging.Pagination;
import com.devcdper.user_admin.dao.CommonMapper;


@Service
public class ChallengeService {
	
	
	//의존성 주입 (생성자 메서드 방식)
	private final ChallengeMapper challengeMapper;
	private final CommonMapper commonMapper;

	public ChallengeService(ChallengeMapper challengeMapper, CommonMapper commonMapper) {
		this.challengeMapper = challengeMapper;
		this.commonMapper = commonMapper;
	}
	
	
	//----------------------------------------------- <관리자 Service> 시작 -----------------------------------------------
	
	
	/*-----------------------------------------------------챌린지 관리 Service 시작-----------------------------------------------------*/
	
	/*------------------------------------------------개설 챌린지 관리 Service 시작-----------------------------------------------------*/
	
	//관리자 페이지 : 개설 챌린지 - 개설 챌린지 전체 리스트 조회
	public Map<String, Object> getChallengeList(Pagination paging){
		
		//PageMaker 객체를 생성함.
		PageMaker pageMaker = new PageMaker();
		
		paging.setRowPerPage(10);
		//currentPage(현재 페이지 번호)와 rowPerPage(한 페이지당 보여줄 게시글 행의 개수)를 세팅해준다.
	    pageMaker.setPaging(paging);
	   
	    //총 게시글 수 세팅 : 챌린지 참여 리스트 총 개수를 세는 쿼리를 호출하여 세팅해줌.
	    pageMaker.setTotalCount(challengeMapper.getChallengeCount());
	    
	    Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("rowStart", paging.getRowStart());
		paramMap.put("rowPerPage", paging.getRowPerPage());
		
		List<Map<String, Challenge>> challengeList = challengeMapper.getChallengeList(paramMap);
	    
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("currentPage", paging.getCurrentPage());
		resultMap.put("challengeList", challengeList);
		resultMap.put("lastPage", pageMaker.getLastPage());
		resultMap.put("pageStartNum", pageMaker.getPageStartNum());
		resultMap.put("pageEndNum", pageMaker.getPageEndNum());
		
		return resultMap;
		
	}
	
	
	public int getChallengeCount() {
		return challengeMapper.getChallengeCount();
	}

	/*------------------------------------------------개설 챌린지 관리 Service 끝-----------------------------------------------------*/

	/*------------------------------------------------ 챌린지 카테고리 관리 Service 시작-----------------------------------------------------*/

	
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
	
	/*------------------------------------------------ 챌린지 카테고리 관리 Service 끝-----------------------------------------------------*/
	
	/*------------------------------------------------챌린지 관리 Service 끝-----------------------------------------------------*/
	
	
	
	/*------------------------------------------------챌린지 참여 관리 Service 시작-----------------------------------------------------*/

	
	//관리자 페이지 : 챌린지 참여 관리 - 참여 챌린지 전체 리스트 조회
	public Map<String, Object> getChallengeParticipationList(Pagination paging) {
		
		
		//PageMaker 객체를 생성함.
		PageMaker pageMaker = new PageMaker();
		
		//currentPage(현재 페이지 번호)와 rowPerPage(한 페이지당 보여줄 게시글 행의 개수)를 세팅해준다.
	    pageMaker.setPaging(paging);
	   
	    //총 게시글 수 세팅 : 챌린지 참여 리스트 총 개수를 세는 쿼리를 호출하여 세팅해줌.
	    pageMaker.setTotalCount(challengeMapper.getChallengeParticipationCount());
	    
	    Map<String, Object> paramMap = new HashMap<String, Object>();
  		paramMap.put("rowStart", paging.getRowStart());
  		paramMap.put("rowPerPage", paging.getRowPerPage());
	  		
  		List<Map<String, ChallengeParticipation>> challengeParticipationList = challengeMapper.getChallengeParticipationList(paramMap);
	  	    
  		Map<String, Object> resultMap = new HashMap<String, Object>();
	  		
  		resultMap.put("currentPage", paging.getCurrentPage());
  		resultMap.put("challengeParticipationList", challengeParticipationList);
  		resultMap.put("lastPage", pageMaker.getLastPage());
  		resultMap.put("pageStartNum", pageMaker.getPageStartNum());
  		resultMap.put("pageEndNum", pageMaker.getPageEndNum());
		
		return resultMap;
	}
	
	/*------------------------------------------------챌린지 참여 관리 Service 끝-----------------------------------------------------*/

	/*------------------------------------------------챌린지 달성율 관리 Service 시작-----------------------------------------------------*/
	
	//관리자 페이지 : 챌린지 달성율 관리 - 챌린지 달성율 전체 리스트 조회(페이징 처리)
	public Map<String, Object> getChallengeAchievementRateList(Pagination paging){
				
		//PageMaker 객체를 생성함.
		PageMaker pageMaker = new PageMaker();
		
		//currentPage(현재 페이지 번호)와 rowPerPage(한 페이지당 보여줄 게시글 행의 개수)를 세팅해준다.
	    pageMaker.setPaging(paging);
	   
	    //총 게시글 수 세팅 : 챌린지 참여 리스트 총 개수를 세는 쿼리를 호출하여 세팅해줌.
	    pageMaker.setTotalCount(challengeMapper.getChallengeAchievementRateCount());
	    
	    Map<String, Object> paramMap = new HashMap<String, Object>();
  		paramMap.put("rowStart", paging.getRowStart());
  		paramMap.put("rowPerPage", paging.getRowPerPage());
		
		List<Map<String, Challenge>> challengeAchievementRateList = challengeMapper.getChallengeAchievementRateList(paramMap);
		
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
  		
  		resultMap.put("currentPage", paging.getCurrentPage());
  		resultMap.put("challengeAchievementRateList", challengeAchievementRateList);
  		resultMap.put("lastPage", pageMaker.getLastPage());
  		resultMap.put("pageStartNum", pageMaker.getPageStartNum());
  		resultMap.put("pageEndNum", pageMaker.getPageEndNum());
		
		return resultMap;
	}
	
	/*------------------------------------------------챌린지 달성율 관리 Service 끝-----------------------------------------------------*/

	/*------------------------------------------------챌린지 보상지급 관리 Service 시작-----------------------------------------------------*/
	
	//관리자 페이지 : 챌린지 보상지급 관리 - 챌린지 보상지급 전체 리스트 조회
	public List<Map<String, ChallengeCompensation>> getChallengeCompensationList(){
		return challengeMapper.getChallengeCompensationList();
	}
	
	/*------------------------------------------------챌린지 보상지급 관리 Service 끝-----------------------------------------------------*/
	
	//----------------------------------------------- <관리자 Service> 끝 -----------------------------------------------

	
	//----------------------------------------------- <일반회원 Service> 시작 -----------------------------------------------

	//------------------------------------------------ 메인 챌린지 Service 시작 ------------------------------------------------
	//------------------------------------------------ 챌린지 탐색하기 Service 시작 ------------------------------------------------

	//메인 챌린지&챌린지 탐색하기 - 전체 챌린지 카드 리스트
	public List<Challenge> getChallengeExplorationList(){
			return challengeMapper.getChallengeExplorationList();
	}
	
	//챌린지 탐색하기 - 상세정보 조회
	//챌린지 참여하기 - 상세정보 조회
	public Challenge getChallengeExplorationDetailInfoByChallengeName(String challengeName) {
		return challengeMapper.getChallengeExplorationDetailInfoByChallengeName(challengeName);
	}
	
	//메인 챌린지&챌린지 탐색하기 - 카테고리별 챌린지 리스트 조회
	public List<Challenge> getChallengeByCategoryExplorationList(String challengeCategoryCode, String categoryBtnName){
		
		System.out.println("챌린지 카테고리 코드 (ChallengeService):"+ challengeCategoryCode);
		List<Challenge> ChallengeByCategoryExplorationList = challengeMapper.getChallengeByCategoryExplorationList(challengeCategoryCode, categoryBtnName);
		System.out.println("ChallengeByCategoryExplorationList (ChallengeService) >>>" + ChallengeByCategoryExplorationList);
		
		return ChallengeByCategoryExplorationList;
	}
	
	//------------------------------------------------ 챌린지 탐색하기 Service 끝 ------------------------------------------------
	//------------------------------------------------ 메인 챌린지 Service 끝 ------------------------------------------------

	
	//------------------------------------------------ 챌린지 개설하기 Service 시작 ------------------------------------------------

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
	
	//------------------------------------------------ 챌린지 개설하기 Service 끝 ------------------------------------------------

	//------------------------------------------------ 챌린지 인증하기 Service 시작 ------------------------------------------------

	//챌린지 인증하기 : 인증가능한 챌린지 전체 리스트 조회
	public ChallengeCertification getChallengeCertificationInfo(String challengeCode, String sessionEmail) {
		return challengeMapper.getChallengeCertificationInfo(challengeCode, sessionEmail);
	}
	
	//챌린지 인증하기 - 인증가능한 챌린지 리스트 조회
	public List<ChallengeCertification> getVerifiableChallengeList(String sessionEmail){
		return challengeMapper.getVerifiableChallengeList(sessionEmail);
	}
	
	//챌린지 인증코드(기본키) 증감
	public String getNewCode2(String tableName) {
		System.out.println("tableName=>"+tableName);
		int codeMaxNum =  Integer.parseInt(commonMapper.getNewCode2(tableName));
		System.out.println("♡♡♡♡♡♡commonMapper.getNewCode2(" + tableName+ "codeMaxNum♡♡==>>"+ codeMaxNum);
		String newCode = tableName + "_code_" + (codeMaxNum+1);
		System.out.println("getNewCode2메서드 newCode=>>" + newCode);
		return newCode;
	}

	//챌린지 인증하기 : 챌린지 인증 등록 처리
	public int addChallengeCertification(Map<String, Object> challengeCertification) {
		
		String newCode2 = getNewCode2("challenge_certification");
		System.out.println("newCode2=>"+newCode2);
		challengeCertification.put("challengeCertificationCode", newCode2);
		
		int result = challengeMapper.addChallengeCertification(challengeCertification);
		return result;
		
	}
	
		//챌린지 인증게시판 : 챌린지 인증등록 후 게시판 전체 리스트 조회
		public Map<String, Object> getChallengeCertificationBoardList(Pagination paging, String challengeCode){
			
			System.out.println("challengeCode ChallengeService : " + challengeCode);
			
			//PageMaker 객체를 생성함.
			PageMaker pageMaker = new PageMaker();
			
			paging.setRowPerPage(10);
			//currentPage(현재 페이지 번호)와 rowPerPage(한 페이지당 보여줄 게시글 행의 개수)를 세팅해준다.
		    pageMaker.setPaging(paging);
		   
		    //총 게시글 수 세팅 : 나의 챌린지 전체 리스트 총 개수를 세는 쿼리를 호출하여 세팅해줌.
		    pageMaker.setTotalCount(challengeMapper.getChallengeCertificationBoardCount(challengeCode));
		    
		    Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("rowStart", paging.getRowStart());
			paramMap.put("rowPerPage", paging.getRowPerPage());
			paramMap.put("challengeCode", challengeCode);
			System.out.println("paramMap ChallengeService : " + paramMap);
			
			List<Map<String, ChallengeCertification>> challengeCertificationBoardList = challengeMapper.getChallengeCertificationBoardList(paramMap);
			System.out.println("challengeCertificationBoardList ChallengeService : >>>> " + challengeCertificationBoardList);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("currentPage", paging.getCurrentPage());
			resultMap.put("challengeCertificationBoardList", challengeCertificationBoardList);
			resultMap.put("lastPage", pageMaker.getLastPage());
			resultMap.put("pageStartNum", pageMaker.getPageStartNum());
			resultMap.put("pageEndNum", pageMaker.getPageEndNum());
			System.out.println("challengeCertificationBoardList resultMap : >>>> " + resultMap);
			
			return resultMap;
		}
		
		//------------------------------------------------ 챌린지 인증하기 Service 끝 ------------------------------------------------

		//------------------------------------------------ 나의 챌린지 Service 시작 ------------------------------------------------
	
		//나의 챌린지 전체 리스트 조회
		public Map<String, Object> getMyChallengeList(Pagination paging, String sessionEmail){
			
			System.out.println("sessionEmail ChallengeService : " + sessionEmail);
			
			//PageMaker 객체를 생성함.
			PageMaker pageMaker = new PageMaker();
			
			paging.setRowPerPage(10);
			//currentPage(현재 페이지 번호)와 rowPerPage(한 페이지당 보여줄 게시글 행의 개수)를 세팅해준다.
		    pageMaker.setPaging(paging);
		   
		    //총 게시글 수 세팅 : 나의 챌린지 전체 리스트 총 개수를 세는 쿼리를 호출하여 세팅해줌.
		    pageMaker.setTotalCount(challengeMapper.getMyChallengeCount(sessionEmail));
		    
		    Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("rowStart", paging.getRowStart());
			paramMap.put("rowPerPage", paging.getRowPerPage());
			paramMap.put("sessionEmail", sessionEmail);
			System.out.println("paramMap ChallengeService : " + paramMap);
			
			List<Map<String, Challenge>> myChallengeList = challengeMapper.getMyChallengeList(paramMap);
			System.out.println("myChallengeList ChallengeService : >>>> " + myChallengeList);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("currentPage", paging.getCurrentPage());
			resultMap.put("myChallengeList", myChallengeList);
			resultMap.put("lastPage", pageMaker.getLastPage());
			resultMap.put("pageStartNum", pageMaker.getPageStartNum());
			resultMap.put("pageEndNum", pageMaker.getPageEndNum());
			System.out.println("myChallengeList resultMap : >>>> " + resultMap);
			
			return resultMap;
		}
		
	//나의 챌린지 : 개설 챌린지 전체 리스트 조회
	public List<Challenge> getMyChallengeInsertList(Map<String, Object> paramMap){
		return challengeMapper.getMyChallengeInsertList(paramMap);
	}
	
	/* 나의 챌린지 : 개설 챌린지 설정(수정) */
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
		
		//------------------------------------------------ 나의 챌린지 Service 끝 ------------------------------------------------

		//----------------------------------------------- <일반회원 Service> 끝 -----------------------------------------------
	
}
