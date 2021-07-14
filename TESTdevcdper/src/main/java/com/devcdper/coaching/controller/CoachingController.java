package com.devcdper.coaching.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.devcdper.coaching.domain.CoachingRFQ;
import com.devcdper.coaching.domain.CoachingUser;
import com.devcdper.coaching.service.CoachingService;
import com.devcdper.plan.domain.PlanDto;
import com.devcdper.plan.service.PlanService;


@Controller
public class CoachingController {
	private CoachingService coachingService;
	private PlanService planService;
	
	public CoachingController(CoachingService coachingService,PlanService planService) {
		this.coachingService = coachingService;
		this.planService = planService;
	}
	
	//private static final Logger log = LoggerFactory.getLogger(CoachingController.class);
	@PostConstruct
	public void coachingControllerInit() {
		//System.out.println("========================================");
		//System.out.println("CoachingController.java 객체 생성");
		//System.out.println("========================================");
		System.out.println("========================================");
		System.out.println("CoachingController.java 객체 생성");
		System.out.println("========================================");
		
	}
	
	//코칭 일반회원 신청 및 결제 화면
	@GetMapping("/coachingApplyAndPayment")
	public String coachingApplyAndPayment(Model model) {
		System.out.println("=========================================");
		System.out.println("======coachingApplyAndPayment 메서드 실행==========");
		//System.out.println("========================================");
		//System.out.println("=======coachingApplyAndPayment 메서드 실행=================");
		model.addAttribute("title", "코칭 신청 및 결제 페이지 ");
		model.addAttribute("radioCheck", "myCoachingClient");
		return "coaching/coachingApplyAndPayment";
	}
	
	//코칭 관리자 화면
	@GetMapping("/coachingAdminPage")
	public String coachingAdminPage(Model model) {
		System.out.println("=========================================");
		System.out.println("======coachingAdminPage 메서드 실행==========");
		//System.out.println("========================================");
		//System.out.println("=======myCoachingCoach 메서드 실행=================");
		model.addAttribute("title", "코칭관리자페이지 ");
		model.addAttribute("radioCheck", "coachingAdminPage");
		return "coaching/coachingAdminPage";
	}
	
	
	//코치 프로필 수정 처리
	@PostMapping("/coachProfileUpdate")
	@ResponseBody
	public int coachProfileUpdateProcess(@RequestParam Map<String,Object> profileUpdateInfo){
		//System.out.println(session.getAttribute("NEMAIL"));
		System.out.println("profileUpdateInfo ==> "+profileUpdateInfo);
		int result = coachingService.coachProfileUpdateProcess(profileUpdateInfo);
		System.out.println("컨트롤러 프로필 update result : "+result);
		
		
		return result;
	}
	
	
	//코치  프로필 수정 화면
	@GetMapping("/coachProfileUpdate")
	public String coachProfileUpdate(Model model, HttpSession session
			,@RequestParam(value="coachEmail", required = false) String coachEmail) {
		System.out.println("=========================================");
		System.out.println("=====CoachingController==coachProfile 메서드 실행==========");
		model.addAttribute("title", "코치  프로필 ");
		
		//가정 - 세션 아이디 park01@hanmail.net 권한 일반 전달
		String sessionEmail = (String) session.getAttribute("NEMAIL");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		
		System.out.println("coachEmail ==> "+ sessionEmail);
		List<CoachingUser> coachList = coachingService.getCoachProfile(sessionEmail);
		System.out.println("coachList ==> "+ coachList);
		model.addAttribute("coachList", coachList);
		return "coaching/coachProfileUpdate";
	}
	//코치  프로필 화면
	@GetMapping("/coachProfile")
	public String coachProfile(Model model
								,@RequestParam(value="coachEmail", required = false) String coachEmail) {
		System.out.println("=========================================");
		System.out.println("=====CoachingController==coachProfile 메서드 실행==========");
		//System.out.println("========================================");
		//System.out.println("=======myCoachingCoach 메서드 실행=================");
		model.addAttribute("title", "코치  프로필 ");
		
		
		System.out.println("coachEmail ==> "+ coachEmail);
		List<CoachingUser> coachList = coachingService.getCoachProfile(coachEmail);
		System.out.println("coachList ==> "+ coachList);
		model.addAttribute("coachList", coachList);
		return "coaching/coachProfile";
	}
	//나의 코칭(코치) 화면
	@GetMapping("/myCoachingCoach")
	public String myCoaching(Model model) {
		System.out.println("=========================================");
		System.out.println("======myCoachingCoach 메서드 실행==========");
		//System.out.println("========================================");
		//System.out.println("=======myCoachingCoach 메서드 실행=================");
		model.addAttribute("title", "나의 코칭 화면");
		model.addAttribute("radioCheck", "myCoachingCoach");
		return "coaching/myCoachingCoach";
	}
	
	//코칭 통합계획 선택
	@PostMapping("/coachingTotalPlan")
	@ResponseBody
	public List<PlanDto> getCoachingTotalPlan(@RequestBody String totalPlanCode) {

		//변수로 totalPlanCode=total_plan_code_01 형태로 넘어와서 '='기준으로 잘라서 값 구함
		String totalPlanCodeValue = totalPlanCode.split("=")[1];
		
		List<PlanDto> totalPlan = planService.getTotalPlan("total_plan_code", totalPlanCodeValue);
		//연결은 시킴 이후 토탈플랜 리스트 넘겨주고 받아서 화면단에 뿌려주는 작업필요
		System.out.println("totalPlan:::"+totalPlan);
		
		return totalPlan;
	}
	
	
	
	//나의 코칭 사용자 페이지 화면
	@GetMapping("/myCoachingClient")
	public String myCoachingClient(Model model, HttpSession session) {
		System.out.println("=========================================");
		System.out.println("======myCoachingClient 메서드 실행==========");
		//System.out.println("========================================");
		//System.out.println("=======myCoachingClient 메서드 실행=================");
		model.addAttribute("title", "나의 코칭 화면");
		model.addAttribute("radioCheck", "myCoachingClient");
		
		//가정 - 세션 아이디 park01@hanmail.net 권한 일반 전달
		String sessionEmail = (String) session.getAttribute("NEMAIL");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		System.out.println("sessionEmail : " + sessionEmail);
		System.out.println("sessionLevel : " + sessionLevel);
		
		List<CoachingRFQ> myCoachingList = coachingService.getMyCoachingList(sessionEmail,null);
		System.out.println("======컨트롤==myCoachingList :  "+ myCoachingList + "==========");
		
		
	
		model.addAttribute("myCoachingList", myCoachingList);
		
		return "coaching/myCoachingClient";
	}
	
	
	
	
	//코칭 견적결과 등록 화면
	@GetMapping("/coachingRFQResult")
	public String coachingRFQResult(Model model) {
		System.out.println("=========================================");
		System.out.println("======coachingRFQResult 메서드 실행==========");
		//System.out.println("========================================");
		//System.out.println("=======coachingRFQ 메서드 실행=================");
		model.addAttribute("title", "코칭 견적결과 화면");
		return "coaching/coachingRFQResult";
	}
	
	//코칭 견적요청 update 처리
	@PostMapping("/updateCoachingRFQ")
	@ResponseBody
	public String updateCoachingRFQ(Model model, HttpSession session
				,CoachingRFQ rfq) {
		System.out.println("=========================================");
		System.out.println("======insertCoachingRFQ 메서드 실행==========");
		System.out.println(session.getAttribute("NEMAIL"));
		rfq.setUserEmail((String) session.getAttribute("NEMAIL"));
		System.out.println("rfq => "+ rfq);
		int result = coachingService.updateCoachingRFQ(rfq);
		model.addAttribute("title", "견적요청 등록 화면");
		return "coaching/coachingRFQ";
	}	

	
	//코칭 견적요청 insert 처리
	@PostMapping("/coachingRFQ")
	@ResponseBody
	public String insertCoachingRFQ(Model model, HttpSession session
				,CoachingRFQ rfq) {
		System.out.println("=========================================");
		//System.out.println("coachEmail==>"+coachEmail);
		System.out.println("======insertCoachingRFQ 메서드 실행==========");
		System.out.println(session.getAttribute("NEMAIL"));
		rfq.setUserEmail((String) session.getAttribute("NEMAIL"));
		System.out.println("rfq => "+ rfq);
		int result = coachingService.insertCoachingRFQ(rfq);
		model.addAttribute("title", "견적요청 등록 화면");
		return "coaching/coachingRFQ";
	}
	//코칭 견적요청화면
	@GetMapping("/coachingRFQ")
	public String coachingRFQ(Model model, HttpSession session
			,@RequestParam(value="coachEmail", required = false) String coachEmail) {
		System.out.println("=========================================");
		System.out.println("coachEmail==>"+coachEmail);
		System.out.println("======coachingRFQ 메서드 실행==========");
		//System.out.println("========================================");
		//System.out.println("=======coachingRFQ 메서드 실행=================");
		model.addAttribute("coachEmail", coachEmail);
		model.addAttribute("title", "멘토링 관리 화면");
		return "coaching/coachingRFQ";
	}
	
	//멘토 리스트 화면 연결
	@GetMapping("/mentoring")
	public String mentoring(Model model) {
		System.out.println("==================================");
		System.out.println("======mentoring 메서드 실행==========");
		//System.out.println("========================================");
		//System.out.println("=======coachAdmin 메서드 실행=================");
		model.addAttribute("title", "멘토링 관리 화면");
		model.addAttribute("radioCheck", "mentoring");
		
		List<CoachingUser> coachList = coachingService.getCoachList("멘토");
		System.out.println("coachList ==> "+ coachList);
		model.addAttribute("coachList", coachList);
		
		return "coaching/mentoring";
	}
	
	//컨설턴트 리스트 화면 연결
	@GetMapping("/consulting")
	public String consulting(Model model) {
		System.out.println("===================================");
		System.out.println("======consulting 메서드 실행==========");
		//System.out.println("========================================");
		//System.out.println("=======coachAdmin 메서드 실행=================");
		model.addAttribute("title", "컨설팅 관리 화면");
		model.addAttribute("radioCheck", "consulting");
		
		List<CoachingUser > coachList = coachingService.getCoachList("컨설턴트");
		System.out.println("coachList ==> "+ coachList);
		model.addAttribute("coachList", coachList);
		
		return "coaching/consulting";
	}
	
	//코치 관리화면 연결
	@GetMapping("/coachAdmin")
	public String coachAdmin(Model model) {
		System.out.println("===================================");
		System.out.println("======coachAdmin 메서드 실행==========");
		//System.out.println("========================================");
		//System.out.println("=======coachAdmin 메서드 실행=================");
		model.addAttribute("title", "코치 관리 화면");
		return "coaching/coachAdmin";
	}
	
	//코칭 리뷰 화면
	@GetMapping("/coachingReview")
	public String coachingReview(Model model) {
		System.out.println("====================================");
		System.out.println("======coachingReview 메서드 실행=======");
		//System.out.println("========================================");
		//System.out.println("=======coachingReview 메서드 실행=================");
		model.addAttribute("title", "코칭 리뷰 화면");
		return "coaching/coachingReview";
	}
	
	//메인코칭 화면 연결
	@GetMapping("/mainCoaching")
	public String mainCoaching(Model model) {
		System.out.println("====================================");
		System.out.println("======mainCoaching 메서드 실행=========");
		//System.out.println("========================================");
		//System.out.println("=======getmainCoaching 메서드 실행=================");
		model.addAttribute("title", "코칭 메인 화면");
		return "coaching/mainCoaching";
	}
}
