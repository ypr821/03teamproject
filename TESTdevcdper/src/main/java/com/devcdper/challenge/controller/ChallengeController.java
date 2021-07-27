package com.devcdper.challenge.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devcdper.challenge.domain.Challenge;
import com.devcdper.challenge.domain.ChallengeCertification;
import com.devcdper.challenge.service.ChallengeService;
import com.devcdper.paging.Pagination;

@Controller
public class ChallengeController {

	// 의존성 주입 (생성자 메서드 방식)
	private final ChallengeService challengeService;

	public ChallengeController(ChallengeService challengeService) {
		this.challengeService = challengeService;
	}

	
	/*-------------------------------------ChallengeControllerInit 메서드 시작----------------------------------------*/
	@PostConstruct
	public void ChallengeControllerInit() {
		// log.info("========================================");
		// log.info("ChallengeControllerInit.java 객체 생성");
		// log.info("========================================");
		System.out.println("========================================");
		System.out.println("ChallengeController.java 객체 생성");
		System.out.println("========================================");
	}
	/*-------------------------------------ChallengeControllerInit 메서드 끝----------------------------------------*/

	
	/*------------------------------------------------두배러 챌린지 메인화면 시작-----------------------------------------------------*/
	@GetMapping("/mainChallenge")
	public String mainChallenge(Model model) {
		
		
		List<Challenge> challengeExplorationList = challengeService.getChallengeExplorationList();
		
		model.addAttribute("title", "챌린지 메인");
		model.addAttribute("radioCheck", "mainChallenge");
		model.addAttribute("challengeExplorationList", challengeExplorationList);
		return "challenge/mainChallenge";
	}
	/*------------------------------------------------두배러 챌린지 메인화면 끝-----------------------------------------------------*/
	
	
	/*------------------------------------------------챌린지 탐색하기 화면 시작-----------------------------------------------------*/
	@GetMapping("/challengeExploration")
	public String challengeExploration(Model model) {
		List<Challenge> challengeExplorationList = challengeService.getChallengeExplorationList();

		model.addAttribute("title", "챌린지 탐색하기");
		model.addAttribute("radioCheck", "challengeExploration");
		model.addAttribute("challengeExplorationList", challengeExplorationList);
		return "challenge/user/challengeExploration";
	}
	/*------------------------------------------------챌린지 탐색하기 화면 끝-----------------------------------------------------*/

	//챌린지 탐색하기 - 카테고리별 리스트 화면
	@RequestMapping(value = "/byCategory", method = RequestMethod.POST)
	@ResponseBody
	public List<Challenge> byCategory(@RequestParam(value="challengeCategoryCode") String challengeCategoryCodeValue,
			@RequestParam(value="challengeCategoryName") String categoryBtnName) {
		
		System.out.println("challengeCategoryCode >>>" + challengeCategoryCodeValue);
		System.out.println("categoryBtnName >>>" + categoryBtnName);
		
			System.out.println(challengeCategoryCodeValue + "<< challengeCategoryCodeValue");
			List<Challenge> ChallengeByCategoryExplorationList = challengeService.getChallengeByCategoryExplorationList(challengeCategoryCodeValue, categoryBtnName);
			System.out.println("ChallengeByCategoryExplorationList>>" + ChallengeByCategoryExplorationList);
		
		return ChallengeByCategoryExplorationList;
	}
	
	//챌린지 탐색하기 - 상세정보 화면
		@GetMapping("/challengeExplorationDetailInfo")
		public String challengeExplorationDetailInfo(
				@RequestParam(name = "challengeName", required = false) String challengeName, Model model) {

			System.out.println("============================================");
			System.out.println("화면에 입력 받은 값(챌린지 탐색 : 상세정보): " + challengeName.toString());
			System.out.println("============================================");

			Challenge challenge = challengeService.getChallengeExplorationDetailInfoByChallengeName(challengeName);

			model.addAttribute("challenge", challenge);
			model.addAttribute("title", "챌린지 상세 정보");
			model.addAttribute("radioCheck", "challengeExplorationDetailInfo");
			return "challenge/user/challengeExplorationDetailInfo";
		}

	//챌린지 개설하기 화면
	@GetMapping("/challengeInsert")
	public String challengeInsert(Model model, HttpSession session, HttpServletResponse response) {
		
		model.addAttribute("title", "챌린지 개설하기");
		model.addAttribute("radioCheck", "challengeInsert");
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("UEMAIL");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		System.out.println("sessionEmail : " + sessionEmail);
		System.out.println("sessionLevel : " + sessionLevel);		
		
		if(sessionEmail == null) {
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			out.println("<script>alert('접근 권한이 없습니다. 로그인을 해주세요.'); location.href='/login';</script>");
			out.flush();
			
		}
		
		return "challenge/user/challengeInsert";
	}

	//챌린지 개설하기 - 등록 처리
	@PostMapping("/challengeInsert")
	public String challengeInsert(Challenge challenge) {

		System.out.println("============================================");
		System.out.println("화면에 입력 받은 값(챌린지 개설): " + challenge.toString());
		System.out.println("============================================");

		challengeService.addChallenge(challenge);

		return "challenge/user/myChallenge";
	}
	
	

	//챌린지 참여하기 화면
	@GetMapping("/challengeParticipation")
	public String challengeParticipation(@RequestParam(name = "challengeName", required = false) String challengeName, Model model) {
		
		System.out.println("============================================");
		System.out.println("화면에 입력 받은 값(챌린지 참여하기 : 상세정보): " + challengeName.toString());
		System.out.println("============================================");
		
		Challenge challenge = challengeService.getChallengeExplorationDetailInfoByChallengeName(challengeName);
		
		model.addAttribute("challenge", challenge);
		model.addAttribute("title", "챌린지 참여하기");
		model.addAttribute("radioCheck", "challengeParticipation");
		return "challenge/user/challengeParticipation";
	}

	//챌린지 인증하기 화면
	@GetMapping("/challengeCertification")
	public String challengeCertification(Model model, HttpSession session, HttpServletResponse response) {

		model.addAttribute("title", "챌린지 인증하기");
		model.addAttribute("radioCheck", "challengeCertification");
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("UEMAIL");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		System.out.println("sessionEmail : " + sessionEmail);
		System.out.println("sessionLevel : " + sessionLevel);
				
		if(sessionEmail == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			out.println("<script>alert('접근 권한이 없습니다. 로그인을 해주세요.'); location.href='/login';</script>");
			out.flush();
		}
		
		List<ChallengeCertification> verifiableChallengeList = challengeService.getVerifiableChallengeList(sessionEmail);

		model.addAttribute("verifiableChallengeList", verifiableChallengeList);
		return "challenge/user/challengeCertification";
	}

	//챌린지 인증하기 등록 페이지 화면
	@GetMapping("/challengeCertificationInsert")
	public String challengeCertificationInsert(@RequestParam(name = "challengeCode", required = false) String challengeCode,
					Model model, HttpSession session) {
		
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("UEMAIL");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		System.out.println("sessionEmail : " + sessionEmail);
		System.out.println("sessionLevel : " + sessionLevel);
				
		if(sessionEmail == null) {
			return "login/login";
		}
		
		System.out.println("============================================");
		System.out.println("화면에 입력 받은 값(챌린지 인증 등록): " + challengeCode.toString());
		System.out.println("============================================");
		
		ChallengeCertification challengeCertificationInfo = challengeService.getChallengeCertificationInfo(challengeCode, sessionEmail);
		
		model.addAttribute("title", "챌린지 인증 등록");
		model.addAttribute("radioCheck", "challengeCertificationInsert");
		model.addAttribute("challengeCertificationInfo", challengeCertificationInfo);
		return "challenge/user/challengeCertificationInsert";
	}
	
	//챌린지 인증하기 - 등록 처리
	@PostMapping("/challengeCertificationInsert")
	public String challengeCertificationInsert(@RequestParam Map<String, Object> challengeCertification) {

		System.out.println("============================================");
		System.out.println("화면에 입력 받은 값(챌린지 인증하기): " + challengeCertification.toString());
		System.out.println("============================================");

		challengeService.addChallengeCertification(challengeCertification);
		return "challenge/user/challengeCertificationBoard";

	}

	
	//챌린지 인증 게시판 화면
	@GetMapping("/challengeCertificationBoard")
	public String challengeCertificationBoard(Model model, String challengeCode) {
		
		List<ChallengeCertification> challengeCertificationBoardList = challengeService.getChallengeCertificationBoardList(challengeCode);
		
		model.addAttribute("title", "챌린지 인증 게시판");
		model.addAttribute("radioCheck", "challengeCertificationBoard");
		model.addAttribute("challengeCertificationBoardList", challengeCertificationBoardList);
		return "challenge/user/challengeCertificationBoard";
	}

	//
	@GetMapping("/challengeCertificationBoardView")
	public String challengeCertificationBoardView(Model model) {
		model.addAttribute("title", "챌린지 인증 게시판");
		model.addAttribute("radioCheck", "challengeCertificationBoardView");
		return "challenge/user/challengeCertificationBoardView";
	}
	
	//나의 챌린지 화면
	@GetMapping("/myChallenge")
	public String myChallenge(Model model, HttpSession session, HttpServletResponse response, Pagination paging) {
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("UEMAIL");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		System.out.println("sessionEmail : " + sessionEmail);
		System.out.println("sessionLevel : " + sessionLevel);
				
		if(sessionEmail == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			out.println("<script>alert('접근 권한이 없습니다. 로그인을 해주세요.'); location.href='/login';</script>");
			out.flush();
		}
		
		model.addAttribute("title", "나의 챌린지");
		model.addAttribute("radioCheck", "myChallenge");
		
		Map<String, Object> resultMap = challengeService.getMyChallengeList(paging, sessionEmail);
		System.out.println("resultMap >>>>>>>>>> : " + resultMap);
		
		model.addAttribute("myChallengeList", 				resultMap.get("myChallengeList"));
		model.addAttribute("currentPage", 					resultMap.get("currentPage"));
		model.addAttribute("lastPage", 						resultMap.get("lastPage"));
		model.addAttribute("pageStartNum", 					resultMap.get("pageStartNum"));
		model.addAttribute("pageEndNum", 					resultMap.get("pageEndNum"));
		model.addAttribute("sessionEmail", 					resultMap.get("sessionEmail"));
		
		
		return "challenge/user/myChallenge";
	}
	

	//나의 챌린지 - 상세정보 화면
	@GetMapping("/myChallengeDetailInfo")
	public String myChallengeDetailInfo(Model model, HttpSession session) {
		model.addAttribute("title", "챌린지 상세 정보");
		model.addAttribute("radioCheck", "myChallengeDetailInfo");
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("UEMAIL");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		System.out.println("sessionEmail : " + sessionEmail);
		System.out.println("sessionLevel : " + sessionLevel);
		
		if(sessionEmail == null) {
			return "redirect:/login";
		}
		
		return "challenge/user/myChallengeDetailInfo";
	}

	//나의 챌린지 - 개설 챌린지 리스트 화면
	@GetMapping("/myChallengeInsertList")
	public String myChallengeInsertList(Model model, HttpSession session,
			@RequestParam(name="categorySearchOption", required = false) String categorySearchOption,
			@RequestParam(name="startDateSearchOption", required = false) String startDateSearchOption,
			@RequestParam(name="endDateSearchOption", required = false) String endDateSearchOption,
			@RequestParam(name="termSortOption", required = false) String termSortOption,
			@RequestParam(name="sortOption", required = false) String sortOption,
			@RequestParam(name="certificationFrequencySearchOption", required = false) String certificationFrequencySearchOption,
			@RequestParam(name="myChallengeSearchKey", required = false) String myChallengeSearchKey,
			@RequestParam(name="myChallengeSearchValue", required = false) String myChallengeSearchValue
			) {
		
		model.addAttribute("title", "나의 개설한 챌린지");
		model.addAttribute("radioCheck", "myChallengeInsertList");
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("UEMAIL");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		System.out.println("sessionEmail : " + sessionEmail);
		System.out.println("sessionLevel : " + sessionLevel);
		
		if(sessionEmail == null) {
			return "redirect:/login";
		}
		
		System.out.println("categorySearchOption :" + categorySearchOption);
		System.out.println("startDateSearchOption :" + startDateSearchOption);
		System.out.println("endDateSearchOption :" + endDateSearchOption);
		System.out.println("termSortOption" + termSortOption);
		System.out.println("sortOption" + sortOption);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sessionEmail", sessionEmail);
		paramMap.put("categorySearchOption", categorySearchOption);
		paramMap.put("startDateSearchOption", startDateSearchOption);
		paramMap.put("endDateSearchOption", endDateSearchOption);
		paramMap.put("sortOption", sortOption);
		paramMap.put("certificationFrequencySearchOption", certificationFrequencySearchOption);
		paramMap.put("myChallengeSearchKey", myChallengeSearchKey);
		paramMap.put("myChallengeSearchKey", myChallengeSearchKey);
		paramMap.put("myChallengeSearchValue", myChallengeSearchValue);
		
		List<Challenge> myChallengeInsertList = challengeService.getMyChallengeInsertList(paramMap);
		model.addAttribute("myChallengeInsertList", myChallengeInsertList);
		
		return "challenge/user/myChallengeInsertList";
	}

	//나의 챌린지 - 참여 챌린지 리스트 화면
	@GetMapping("/myChallengeParticipationList")
	public String myChallengeParticipationList(Model model, HttpSession session) {
		model.addAttribute("title", "나의 참여중 챌린지");
		model.addAttribute("radioCheck", "myChallengeParticipationList");
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("UEMAIL");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		System.out.println("sessionEmail : " + sessionEmail);
		System.out.println("sessionLevel : " + sessionLevel);
		
		if(sessionEmail == null) {
			return "redirect:/login";
		}
		
		return "challenge/user/myChallengeParticipationList";
	}

	//나의 챌린지 - 완료 챌린지 리스트 화면
	@GetMapping("/myChallengeCompleteList")
	public String myChallengeCompleteList(Model model, HttpSession session) {
		model.addAttribute("title", "나의 완료된 챌린지");
		model.addAttribute("radioCheck", "myChallengeCompleteList");
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("UEMAIL");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		System.out.println("sessionEmail : " + sessionEmail);
		System.out.println("sessionLevel : " + sessionLevel);
		
		if(sessionEmail == null) {
			return "redirect:/login";
		}
		
		return "challenge/user/myChallengeCompleteList";
	}
	
	//나의 챌린지 - 개설 챌린지 수정 화면 
	@GetMapping("/myChallengeEdit")
	public String myChallengeEdit(Model model, HttpSession session, String challengeCode) {
		
		System.out.println("챌린지 코드 : " + challengeCode);
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("UEMAIL");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		System.out.println("sessionEmail : " + sessionEmail);
		System.out.println("sessionLevel : " + sessionLevel);
		
		if(sessionEmail == null) {
			return "redirect:/login";
		}
		
		Challenge modifyChallengeAttribute = challengeService.getModifyInsertChallengeAttributeList(challengeCode);
		//Challenge modifyChallengePeriod = challengeService.getModifyChallengePeriod(challengeStartDate, challengeEndDate, challengeName);
		System.out.println(modifyChallengeAttribute +"<<<< modifyChallengeAttribute");
		//System.out.println(modifyChallengePeriod +"<<<< modifyChallengePeriod");
		model.addAttribute("title", "챌린지 설정");
		model.addAttribute("radioCheck", "myChallengeEdit");
		model.addAttribute("modifyChallengeAttribute", modifyChallengeAttribute);
		//model.addAttribute("modifyChallengePeriod", modifyChallengePeriod);
				
		return "challenge/user/myChallengeEdit";
	}
	
	//나의 챌린지 - 개설챌린지 수정처리
	@PostMapping("/myChallengeEdit")
	@ResponseBody
	public String myChallengeEdit(Model model, @RequestParam(name = "challengeCode", required = false) String challengeCode, Challenge challenge) {
		
		
		System.out.println("========================================");
		System.out.println("챌린지 설정 [challengeCode]: " + challengeCode);
		System.out.println("========================================");
		
		//챌린지명 변경 처리
		int modifyChallengeName = challengeService.modifyChallengeName(challenge);
		System.out.println("챌린지명 변경 처리 완료 [modifyChallengeName] : " + modifyChallengeName);
		
		//챌린지 인증방법 변경 처리
		int modifyChallengeCertificationMethod = challengeService.modifyChallengeCertificationMethod(challenge);
		System.out.println("챌린지 인증방법 변경 처리 완료 [modifyChallengeCertificationMethod] : " + modifyChallengeCertificationMethod );

		//챌린지 기간 변경 처리
		int modifyChallengePeriod = challengeService.modifyChallengePeriod(challenge);
		System.out.println("챌린지 기간 변경 처리 완료 [modifyChallengePeriod] : " + modifyChallengePeriod);
		
		//챌린지 소개 변경 처리
		int modifyChallengeIntroduce = challengeService.modifyChallengeIntroduce(challenge);
		System.out.println("챌린지 소개 변경 처리 완료 [modifyChallengeIntroduce] : " + modifyChallengeIntroduce);
		
		//챌린지 태그 변경 처리
		int modifyChallengeTag = challengeService.modifyChallengeTag(challenge);
		System.out.println("챌린지 태그 변경 처리 완료 [modifyChallengeTag] : " + modifyChallengeTag);
		
		//return "redirect:challenge/user/myChallengeInsertList";
		return "challenge/user/myChallengeInsertList";
		
	}
	
	//결제 화면
	@GetMapping("/payment")
	public String payment(Model model) {
		model.addAttribute("title", "챌린지 결제 관리");
		return "paymentRefund/payment";
	}
	
	//환불 화면
	@GetMapping("/refund")
	public String refund(Model model) {
		model.addAttribute("title", "챌린지 환불 관리");
		return "paymentRefund/refund";
	}

}
