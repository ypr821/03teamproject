package com.devcdper.challenge.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devcdper.challenge.domain.Challenge;
import com.devcdper.challenge.domain.ChallengeCertification;
import com.devcdper.challenge.domain.ChallengeParticipation;
import com.devcdper.challenge.service.ChallengeService;

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

	
	
	//챌린지 탐색하기 화면
	@GetMapping("/challengeExploration")
	public String challengeExploration(Model model) {
		List<Challenge> challengeExplorationList = challengeService.getChallengeExplorationList();

		model.addAttribute("title", "챌린지 탐색하기");
		model.addAttribute("radioCheck", "challengeExploration");
		model.addAttribute("challengeExplorationList", challengeExplorationList);
		return "challenge/user/challengeExploration";
	}

	//챌린지 탐색하기 - 카테고리별 리스트 화면
	@PostMapping(value = "/byCategory")
	public @ResponseBody List<Challenge> byCategory(@RequestParam(value="challengeCategoryCode") String challengeCategoryCodeValue) {
		
		System.out.println(challengeCategoryCodeValue + "<< challengeCategoryCodeValue");
			List<Challenge> ChallengeByCategoryExplorationList = challengeService.getChallengeByCategoryExplorationList(challengeCategoryCodeValue);
			System.out.println("ChallengeByCategoryExplorationList>>" + ChallengeByCategoryExplorationList);
		
		return ChallengeByCategoryExplorationList;

		/*
		 * Map<String, Object> cateMap = new HashMap<String, Object>();
		 * cateMap.put("categoryVal", categoryVal); List<Challenge>
		 * challengeByCategoryExplorationList =
		 * challengeService.getChallengeByCategoryExplorationList(cateMap);
		 * System.out.println("challengeByCategoryExplorationList" +
		 * challengeByCategoryExplorationList);
		 * 
		 * return challengeByCategoryExplorationList;
		 */

		/*
		 * Map<String, Object> cateMap = (Map<String, Object>)
		 * challengeService.getChallengeByCategoryExplorationList(categoryVal);
		 * ModelAndView categoryAjaxList = new ModelAndView();
		 * categoryAjaxList.setViewName("challengeExploation");
		 * categoryAjaxList.addObject("cateMap", cateMap.get(cateMap));
		 * 
		 * return categoryAjaxList;
		 */

		/*
		 * System.out.println("categoryVal>>>"+ categoryVal); Map<String, Object>
		 * cateMap = new HashMap<String, Object>(); cateMap.put("categoryVal",
		 * categoryVal);
		 * 
		 * List<Challenge> challengeByCategoryExplorationList =
		 * challengeService.getChallengeByCategoryExplorationList(cateMap);
		 * System.out.println("challengeByCategoryExplorationList >>>"+
		 * challengeByCategoryExplorationList);
		 * 
		 * model.addAttribute("categoryVal", categoryVal);
		 * model.addAttribute("challengeByCategoryExplorationList",
		 * challengeByCategoryExplorationList);
		 * 
		 * categoryAjaxList.setViewName("challengeExploation");
		 * categoryAjaxList.addObject("categoryVal", categoryVal);
		 * categoryAjaxList.addObject("challengeByCategoryExplorationList",
		 * challengeByCategoryExplorationList);
		 * 
		 * System.out.println("========================================");
		 * //System.out.println("challengeByCategoryExplorationList 카테고리별 챌린지 리스트: " +
		 * challengeByCategoryExplorationList.toString());
		 * System.out.println("ModelAndView categoryAjaxList: " + model.toString());
		 * System.out.println("============================================");
		 * 
		 * return challengeByCategoryExplorationList;
		 */

	}

	//챌린지 개설하기 화면
	@GetMapping("/challengeInsert")
	public String challengeInsert(Model model, HttpSession session, HttpServletResponse response) {
		
		model.addAttribute("title", "챌린지 개설하기");
		model.addAttribute("radioCheck", "challengeInsert");
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("NEMAIL");
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
			out.println("<script>alert('접근 권한이 없습니다. 로그인을 해주세요.'); </script>");
			out.flush();
			return "login/login";
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
		String sessionEmail = (String) session.getAttribute("NEMAIL");
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
			out.println("<script>alert('접근 권한이 없습니다. 로그인을 해주세요.'); </script>");
			out.flush();
			return "login/login";
		}
		
		List<ChallengeCertification> verifiableChallengeList = challengeService.getVerifiableChallengeList(sessionEmail);

		model.addAttribute("verifiableChallengeList", verifiableChallengeList);
		return "challenge/user/challengeCertification";
	}

	//챌린지 인증하기 등록 페이지 화면
	@GetMapping("/challengeCertificationInsert")
	public String challengeCertificationInsert(@RequestParam(name = "challengeName", required = false) String challengeName,
					Model model, HttpSession session, HttpServletResponse response) {
		
		model.addAttribute("title", "챌린지 인증 등록");
		model.addAttribute("radioCheck", "challengeCertificationInsert");
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("NEMAIL");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		System.out.println("sessionEmail : " + sessionEmail);
		System.out.println("sessionLevel : " + sessionLevel);
				
		if(sessionEmail == null) {
			return "login/login";
		}
		
		System.out.println("============================================");
		System.out.println("화면에 입력 받은 값(챌린지 인증 등록): " + challengeName.toString());
		System.out.println("============================================");
		
		ChallengeParticipation challengeParticipation = challengeService.getChallengeCertificationInfo(challengeName, sessionEmail);
		
		model.addAttribute("challengeParticipation", challengeParticipation);
		return "challenge/user/challengeCertificationInsert";
	}
	
	//챌린지 인증하기 - 등록 처리
	@PostMapping("/challengeCertificationInsert")
	public String challengeCertificationInsert(ChallengeCertification challengeCertification) {

		System.out.println("============================================");
		System.out.println("화면에 입력 받은 값(챌린지 인증하기): " + challengeCertification.toString());
		System.out.println("============================================");

		challengeService.addChallengeCertification(challengeCertification);

		return "challenge/user/challengeCertificationBoard";
	}

	
	//챌린지 인증 게시판 화면
	@GetMapping("/challengeCertificationBoard")
	public String challengeCertificationBoard(Model model) {
		model.addAttribute("title", "챌린지 인증 게시판");
		model.addAttribute("radioCheck", "challengeCertificationBoard");
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
	public String myChallenge(Model model, HttpSession session, HttpServletResponse response) {
		model.addAttribute("title", "나의 챌린지");
		model.addAttribute("radioCheck", "myChallenge");
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("NEMAIL");
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
			out.println("<script>alert('접근 권한이 없습니다. 로그인을 해주세요.'); </script>");
			out.flush();
			return "login/login";
		}
		
		return "challenge/user/myChallenge";
	}
	
	
	//챌린지 탐색하기 상세정보 화면
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

	//챌린지 상세정보 화면
	@GetMapping("/myChallengeDetailInfo")
	public String myChallengeDetailInfo(Model model, HttpSession session) {
		model.addAttribute("title", "챌린지 상세 정보");
		model.addAttribute("radioCheck", "myChallengeDetailInfo");
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("NEMAIL");
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
	public String myChallengeInsertList(Model model, HttpSession session,String challengeName) {
		model.addAttribute("title", "개설한 챌린지 목록");
		model.addAttribute("radioCheck", "myChallengeInsertList");
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("NEMAIL");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		System.out.println("sessionEmail : " + sessionEmail);
		System.out.println("sessionLevel : " + sessionLevel);
		
		if(sessionEmail == null) {
			return "redirect:/login";
		}
		
		List<Challenge> modifyChallengeList = challengeService.getmodifyChallengeList(sessionEmail, challengeName);
		model.addAttribute("modifyChallengeList", modifyChallengeList);
		
		return "challenge/user/myChallengeInsertList";
	}

	//나의 챌린지 - 참여 챌린지 리스트 화면
	@GetMapping("/myChallengeParticipationList")
	public String myChallengeParticipationList(Model model, HttpSession session) {
		model.addAttribute("title", "참여중인 챌린지 목록");
		model.addAttribute("radioCheck", "myChallengeParticipationList");
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("NEMAIL");
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
		model.addAttribute("title", "완료된 챌린지 목록");
		model.addAttribute("radioCheck", "myChallengeCompleteList");
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("NEMAIL");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		System.out.println("sessionEmail : " + sessionEmail);
		System.out.println("sessionLevel : " + sessionLevel);
		
		if(sessionEmail == null) {
			return "redirect:/login";
		}
		
		return "challenge/user/myChallengeCompleteList";
	}
	
	//나의 챌린지 - 개설챌린지 수정화면
	@GetMapping("/myChallengeEdit")
	public String myChallengeEdit(Model model, HttpSession session, String challengeCode) {
		model.addAttribute("title", "챌린지 설정");
		model.addAttribute("radioCheck", "myChallengeEdit");
		
		System.out.println("챌린지 코드 : " + challengeCode);
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("NEMAIL");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		System.out.println("sessionEmail : " + sessionEmail);
		System.out.println("sessionLevel : " + sessionLevel);
		
		if(sessionEmail == null) {
			return "redirect:/login";
		}
		
		Challenge modifyChallengeAttribute = challengeService.getModifyChallengeAttributeList(challengeCode);
		//Challenge modifyChallengePeriod = challengeService.getModifyChallengePeriod(challengeStartDate, challengeEndDate, challengeName);
		System.out.println(modifyChallengeAttribute +"<<<< modifyChallengeAttribute");
		//System.out.println(modifyChallengePeriod +"<<<< modifyChallengePeriod");
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
		System.out.println("챌린지 소개 변경 처리 완료 [modifyChallengeTag] : " + modifyChallengeTag);
		
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
