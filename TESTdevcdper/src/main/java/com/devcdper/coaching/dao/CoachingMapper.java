package com.devcdper.coaching.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devcdper.coaching.domain.CoachingApplyAndPayment;
import com.devcdper.coaching.domain.CoachingRFQ;
import com.devcdper.coaching.domain.CoachingRFQResult;
import com.devcdper.coaching.domain.CoachingUser;
import com.devcdper.user_admin.domain.CoachUser;

@Mapper
public interface CoachingMapper {
	

	//코치 리스트  (mentoring page)
	public List<CoachingUser> getCoachList(String coachAuthority,String coachUserEmail);
	
	//진행상태가 신청 및 결제 단계인 내역 조회
	public List<CoachingApplyAndPayment> getCoachingApplyAndPaymentListById(String sessionEmail);
	
	//진행상태가 견적결과 단계인 내역 조회
	public List<CoachingRFQResult> getCoachingRFQResultListById(String sessionEmail);
	
	//진행상태가 견적요청상태 단계인 내역 조회
	public List<CoachingRFQ> getCoachingRFQListById(String sessionEmail);
	
	//견적요청 내역 전체
	public List<CoachingRFQ> getCoachingRFQTotalListById(String sessionEmail);

	// 마이 코치 리스트  (mentoring page)
	public List<CoachingRFQ> getMyCoachingList(String userEmail,String coachUserEmail);

	//코치 프로링 수정 처리
	public int coachProfileUpdateProcess(Map<String, Object> profileUpdateInfo);

	//견적요청 insert
	public int insertCoachingRFQ(CoachingRFQ rfq);

	//견적요청 update
	public int updateCoachingRFQ(CoachingRFQ rfq);
	
	
	//견적결과 insert
	public int insertCoachingRFQResult(Map<String, Object> coachingRFQResult);
	
	
	
	
	
	
	
	
	
	
}
