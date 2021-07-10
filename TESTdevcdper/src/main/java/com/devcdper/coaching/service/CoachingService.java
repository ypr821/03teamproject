package com.devcdper.coaching.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.devcdper.coaching.dao.CoachingMapper;
import com.devcdper.coaching.domain.CoachingApplyAndPayment;
import com.devcdper.coaching.domain.CoachingRFQ;
import com.devcdper.coaching.domain.CoachingRFQResult;
import com.devcdper.coaching.domain.CoachingUser;
import com.devcdper.user_admin.dao.CoachUserMapper;



@Service
public class CoachingService {
	private CoachingMapper coachingMapper;
	private CoachUserMapper coachUserMapper;
	
	
	public CoachingService(CoachingMapper coachingMapper,CoachUserMapper coachUserMapper) {
		this.coachingMapper = coachingMapper;
		this.coachUserMapper = coachUserMapper;
		
	}
	
	//코치 프로필 수정처리
	public int coachProfileUpdateProcess(Map<String,Object> profileUpdateInfo) {
		//System.out.println("서비스 profileUpdateInfov 확인: " + profileUpdateInfo);
		int result = coachingMapper.coachProfileUpdateProcess(profileUpdateInfo);
		System.out.println("서비스 프로필 수정 result : "+result);
		return result;
	}
	

	//코치 프로필 화면
	public List<CoachingUser> getCoachProfile(String coachEmail){
		System.out.println("coachEmail ==> " + coachEmail);
	
		List<CoachingUser> coachList = coachingMapper.getCoachList(null, coachEmail);
		System.out.println("coachList ==> " + coachList);
		return coachList;
	}

	//멘토 리스트 (mentoring 화면)
	public List<CoachingUser> getCoachList(String mento){
		List<CoachingUser> coachList = coachingMapper.getCoachList(mento,null);
		
		System.out.println("coachList ==> " + coachList);
		return coachList;
	}
	
	
	//나의 코칭 목록 일반회원 
	
	
	
	
	//진행상태가 신청 및 결제 단계인 내역 조회
	public List<CoachingApplyAndPayment> getCoachingApplyAndPaymentListById(String sessionEmail){
		System.out.println("===서비스=====CoachingService getCoachingApplyAndPaymentListById 메서드 실행==========");
		List<CoachingApplyAndPayment> coachingApplyAndPaymentList = coachingMapper.getCoachingApplyAndPaymentListById(sessionEmail);
		System.out.println("====서비스====coachingApplyAndPaymentList :  "+ coachingApplyAndPaymentList + "==========");
		return coachingApplyAndPaymentList;
	}
	
	
	//진행상태가 견적결과 단계인 내역 조회
	public List<CoachingRFQResult> getCoachingRFQResultListById(String sessionEmail){
		System.out.println("===서비스=====CoachingService getCoachingRFQResultListById 메서드 실행==========");
		List<CoachingRFQResult> coachingRFQResultList = coachingMapper.getCoachingRFQResultListById(sessionEmail);
		System.out.println("====서비스====coachingRFQTotalList :  "+ coachingRFQResultList + "==========");
		return coachingRFQResultList;
	};
	
	
	//진행상태가 견적요청상태 단계인 내역 조회
	public List<CoachingRFQ> getCoachingRFQTotalListById(String sessionEmail) {
		System.out.println("===서비스=====CoachingService getCoachingRFQTotalListById 메서드 실행==========");
		List<CoachingRFQ> coachingRFQTotalList = coachingMapper.getCoachingRFQTotalListById(sessionEmail);
		System.out.println("====서비스====coachingRFQTotalList :  "+ coachingRFQTotalList + "==========");
		return coachingRFQTotalList;
	};
	
	//견적요청 내역 전체
	public List<CoachingRFQ> getCoachingRFQListById(String sessionEmail) {
		System.out.println("========CoachingService getCoachingRFQListById 메서드 실행==========");
		List<CoachingRFQ> coachingRFQList = coachingMapper.getCoachingRFQListById(sessionEmail);
		System.out.println("========coachingRFQList :  "+ coachingRFQList + "==========");
		return coachingRFQList;
	};
	
	//마이 코치 리스트  (client page)
		public List<CoachingRFQ> getMyCoachingList(String userEmail,String coachUserEmail){
			
			List<CoachingRFQ> myCoachingList = coachingMapper.getMyCoachingList(userEmail, null);
			System.out.println("======서비스==myCoachingList :  "+ myCoachingList + "==========");
			
			return myCoachingList;
		};
	
	
	
	
}