package com.devcdper.coaching.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.devcdper.coaching.dao.CoachingMapper;
import com.devcdper.coaching.domain.CoachingApplyAndPayment;
import com.devcdper.coaching.domain.CoachingRFQ;
import com.devcdper.coaching.domain.CoachingRFQResult;
import com.devcdper.coaching.domain.CoachingReview;
import com.devcdper.coaching.domain.CoachingUser;
import com.devcdper.payment.dao.PaymentMapper;
import com.devcdper.payment.domain.Payment;
import com.devcdper.paymentManagement.KakaoPay;
import com.devcdper.paymentManagement.KakaoPayApprovalVO;
import com.devcdper.user_admin.dao.CoachUserMapper;
import com.devcdper.user_admin.dao.CommonMapper;



@Service
public class CoachingService {
	private CoachingMapper coachingMapper;
	private CommonMapper commonMapper;
	private PaymentMapper paymentMapper;
	
	
	public CoachingService(CoachingMapper coachingMapper,CoachUserMapper coachUserMapper,CommonMapper commonMapper,PaymentMapper paymentMapper) {
		this.coachingMapper = coachingMapper;
		this.commonMapper = commonMapper;
		this.paymentMapper = paymentMapper;
		
	}
	
	//결제 준비 처리 
	public String kakaoPayReady(Map<String,Object> result,HttpSession session){
		System.out.println(" service kakaoPayReady메서드 실행 ............................................");
		KakaoPay KakaoPay = new KakaoPay();
		//DB테이블명은 payment_management
		String partner_order_id = getNewCode2("payment_management");
		String partner_user_id = (String) result.get("result[0][userEmail]");
		System.out.println("partner_user_id=>"+partner_user_id);
		String item_name = ((String) result.get("result[0][coachingUser][coachName]")+"님의 코칭");
		System.out.println("item_name=>"+item_name);
		String quantity = "1";
		String total_amount = (String) result.get("result[0][coachingRFQResult][coachingRFQResultCost]");
		System.out.println("total_amount=>"+total_amount);
		 
		session.setAttribute("resultInfo", result);
		session.setAttribute("partner_order_id", partner_order_id);
		String kakaoPayReadyResult =  KakaoPay.kakaoPayReady( partner_order_id,partner_user_id
															  ,item_name,quantity,total_amount);
		return kakaoPayReadyResult;
	}
	
	//결제 승인 처리
	public KakaoPayApprovalVO kakaoPayApproval(String pg_token, HttpSession session){
		System.out.println("코칭 서비스 kakaoPayApproval 메서드 실행!!!!가즈아!!!!");
		KakaoPay KakaoPay = new KakaoPay();
		
		@SuppressWarnings("unchecked")
		Map<String,Object> resultInfo =  (Map<String, Object>) session.getAttribute("resultInfo");
		System.out.println("resultInfo==>"+resultInfo);
		String partner_order_id = "";
		String partner_user_id = "";
		String item_name = "결제 에러입니다";
		String total_amount = "0";
		
		if(! (null == resultInfo)) {
			
			partner_order_id = (String) session.getAttribute("partner_order_id");
			System.out.println("partner_order_id==>"+partner_order_id);
			
			partner_user_id = (String)resultInfo.get("result[0][userEmail]");
			System.out.println("partner_user_id=>"+partner_user_id);
			
			item_name = ((String)resultInfo.get("result[0][coachingUser][coachName]")+"님의 코칭");
			System.out.println("item_name=>"+item_name); 
			total_amount = (String)resultInfo.get("result[0][coachingRFQResult][coachingRFQResultCost]");
			System.out.println("total_amount=>"+total_amount);
		
		}else {
			return null;
		}
		String quantity = "1"; 
		
		
		return KakaoPay.kakaoPayApproval(pg_token,partner_order_id,partner_user_id,total_amount);
	}
	
	//결제코드 insert
	public int insertPayment(Map<String, Object> resultInfo, KakaoPayApprovalVO kakaoPayInfo) {
		
		Payment paymentInfo = new Payment();
		System.out.println("****************************************");
		System.out.println("*kakaoPayInfo*==>" + kakaoPayInfo);
		System.out.println("*resultInfo*==>" + resultInfo);
		System.out.println("****************************************");
		
		paymentInfo.setPaymentManagementCode(kakaoPayInfo.getPartner_order_id());
		paymentInfo.setUserEmail(kakaoPayInfo.getPartner_user_id());
		//paymentInfo.setAllPaymentConnectGroupCode();
		//paymentInfo.setAllPaymentConnectTable(allPaymentConnectTable);
		paymentInfo.setPaymentManagementContentsCode((String) resultInfo.get("result[0][coachingRFQResult][coachingRFQResultCode]"));
		paymentInfo.setPaymentOption(kakaoPayInfo.getPayment_method_type());
		//paymentInfo.setPaymentStatus(paymentStatus);
		paymentInfo.setPaymentPrice( kakaoPayInfo.getAmount().getTotal());
		
		System.out.println("=============================================");
		System.out.println("*데이터 채우고난 paymentInfo*==>" + paymentInfo);
		int insertResult = paymentMapper.insertPayment(paymentInfo);
		
		
		return insertResult;
	};
	
	
	
	
	
	//견적결과 조회
	public List<CoachingRFQ> getCoachingRFQResult(String resultCode) {
		System.out.println("getCoachingRFQResult 서비스 실행");
		List<CoachingRFQ> result = coachingMapper.getCoachingRFQResult(resultCode);
		return result;
	}
	
	//코칭리뷰조회
	public List<CoachingReview> getCoachingReview(String searchKey, String searchValue) {
		System.out.println("service searchKey=>"+searchKey);
		System.out.println("service searchValue=>"+searchValue);
		List<CoachingReview> coachingReviewList = coachingMapper.getCoachingReview(searchKey, searchValue);
		System.out.println("service coachingReviewList=>"+coachingReviewList);
		return coachingReviewList;
	}

	
	//getNewCode
	public String getNewCode(String tableName) {
		System.out.println("tableName=>"+tableName);
		String result = commonMapper.getNewCode(tableName);
		System.out.println("♡♡♡♡♡♡commonMapper.getNewCode("+tableName+"♡♡==>>"+ result);
		return result;
	}
	
	//getNewCode2
	public String getNewCode2(String tableName) {
		System.out.println("tableName=>"+tableName);
		int codeMaxNum =  Integer.parseInt(commonMapper.getNewCode2(tableName));
		System.out.println("♡♡♡♡♡♡commonMapper.getNewCode(" + tableName+ "codeMaxNum♡♡==>>"+ codeMaxNum);
		String newCode = tableName + "_code_" + (codeMaxNum+1);
		System.out.println("getNewCode2메서드 newCode=>>" + newCode);
		return newCode;
	}

	//견적결과 insert
	public int insertCoachingRFQResult(Map<String, Object> coachingRFQResult) {
		System.out.println("insertCoachingRFQResult 서서서서비비비비스스스 실행");
		String newCode = getNewCode("coaching_RFQ_result");
		String newCode2 = getNewCode2("coaching_RFQ_result");
		System.out.println("newCode=>"+newCode);
		System.out.println("newCode2!!!!!!!!!!!!!=>"+newCode2);
		coachingRFQResult.put("coachingRFQResultCode", newCode2);
		//System.out.println("coachingRFQResult===>>>>>"+coachingRFQResult);
		int result = coachingMapper.insertCoachingRFQResult(coachingRFQResult);
		return 0;
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
	public List<CoachingUser> getCoachList(String coach){
		List<CoachingUser> coachList = coachingMapper.getCoachList(coach,null);
		
		System.out.println("coachList ==> " + coachList);
		return coachList;
	}

	
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
	
	//마이 코칭 리스트  (client page)
		public List<CoachingRFQ> getMyCoachingList(String userEmail,String coachUserEmail){
			
			List<CoachingRFQ> myCoachingList = coachingMapper.getMyCoachingList(userEmail, coachUserEmail);
			System.out.println("======서비스==myCoachingList :  "+ myCoachingList + "==========");
			
			return myCoachingList;
		}

	//견적요청 insert
		public int insertCoachingRFQ(CoachingRFQ rfq) {
			System.out.println("서비스단 실행확인!!!!!!!!!!!!!!!!!!");
			int result = coachingMapper.insertCoachingRFQ(rfq);
			return result;
		};
	//견적요청 update
		public int updateCoachingRFQ(CoachingRFQ rfq) {
			System.out.println("서비스단 updateCoachingRFQ실행확인!!!!!!!!!!!!!!!!!!");
			int result = coachingMapper.updateCoachingRFQ(rfq);
			return result;
		}

	




}
