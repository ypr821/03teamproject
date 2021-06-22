package ksmart39.mybatis.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart39.mybatis.dao.MemberMapper;
import ksmart39.mybatis.domain.Member;
import ksmart39.mybatis.service.GoodsService;
import ksmart39.mybatis.service.MemberService;

@Controller
public class MemberController {

	/**
	 * 필드 주입방식 (DI)
	 * MemberService memberService = new MemberService();
	 * 
	 * setter 주입방식
	 * setter 메소드 memberService
	 * 
	 * 생성자메소드 주입방식
	 * 생성자메소드 memberService
	 */
	
	/**
	 * 필드주입 방식
	 * @Autowired
	 * private MemberService memberService;
	 * @Autowired
	 * private GoodsService goodsService;;
	 */
	
	/**
	 * setter 메소드 주입방식
	 * private MemberService memberService;
	 * private GoodsService goodsService;
	 *
	 * @Autowired
	 * public void setMemberService(MemberService memberService, GoodsService goodsService) {
	 * 		this.memberService = memberService;
	 *		this.goodsService = goodsService;
	 * }
	 */
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	//생성자 메소드 주입방식
	private final MemberService memberService;
	private final GoodsService goodsService;
	
	//spring framework 4.3이후부터 @Autowired 생략가능
	//@Autowired
	public MemberController(MemberService memberService, GoodsService goodsService) {
		this.memberService = memberService;
		this.goodsService = goodsService;
	}
		
	@PostConstruct
	public void memberControllerInit() {
		log.info("========================================");
		log.info("MemberController 객체 생성");
		log.info("========================================");
		//System.out.println("========================================");
		//System.out.println("MemberController 객체 생성");
		//System.out.println("========================================");
	}
	
	@PostMapping("/memberIdCheck")
	@ResponseBody
	public boolean memberIdCheck(@RequestParam(name="memberId", required = false) String memberId) {
		boolean idCheck = true;
		log.info("memberIdCheck   memberId ::::   {}", memberId);
		//idcheck 중복된 아이디있는 경우에는 false
		Member member = memberService.getMemberInfoById(memberId);
		
		if(member != null) idCheck = false;
		
		return idCheck;
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(value="memberId", required = false) String memberId
					   ,@RequestParam(value="memberPw", required = false) String memberPw
					   ,HttpSession session
					   ,RedirectAttributes reAttr) {
		
		if(memberId != null && !"".equals(memberId) && memberPw != null && !"".equals(memberPw)) {
			Map<String, Object> resultMap = memberService.loginMember(memberId, memberPw);
			
			boolean loginCheck = (boolean) resultMap.get("loginCheck");
			Member loginMember = (Member) resultMap.get("loginMember");
			
			if(loginCheck) {
				session.setAttribute("SID", 	loginMember.getMemberId());
				session.setAttribute("SNAME", 	loginMember.getMemberName());
				session.setAttribute("SLEVEL", 	loginMember.getMemberLevel());
				if("1".equals(loginMember.getMemberLevel())) {
					session.setAttribute("SLEVELNAME", 	"관리자");
				}else if("2".equals(loginMember.getMemberLevel())) {
					session.setAttribute("SLEVELNAME", 	"판매자");
				}else {
					session.setAttribute("SLEVELNAME", 	"구매자");					
				}
				return "redirect:/";
			}
		}
		
		reAttr.addAttribute("loginResult", "등록된 회원이 없습니다.");
		
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(Model model
					   ,@RequestParam(name="loginResult", required = false) String loginResult) {
		model.addAttribute("title", "로그인화면");
		if(loginResult != null) model.addAttribute("loginResult", loginResult);
		
		return "login/login";
	}
	
	@PostMapping("/removeMember")
	public String removeMember(@RequestParam(value="memberId", required = false) String memberId
							  ,@RequestParam(value="memberPw", required = false) String memberPw
							  ,RedirectAttributes redirectAttr) {
		
		log.info("========================================");
		log.info("화면에서 입력받은 값(회원탈퇴) memberId: {}", memberId);
		log.info("화면에서 입력받은 값(회원탈퇴) memberPw: {}", memberPw);
		log.info("========================================");
		
		//System.out.println("========================================");
		//System.out.println("화면에서 입력받은 값(회원탈퇴) memberId: " + memberId);
		//System.out.println("화면에서 입력받은 값(회원탈퇴) memberPw: " + memberPw);
		//System.out.println("========================================");
		
		if(memberPw != null && !"".equals(memberPw)) {			
			boolean result = memberService.removeMember(memberId, memberPw);
			if(result) {
				return "redirect:/memberList";
			}
		}
		
		redirectAttr.addAttribute("memberId", memberId);
		redirectAttr.addAttribute("result", "삭제 실패");
		
		return "redirect:/removeMember";
	}
	
	@GetMapping("/removeMember")
	public String removeMember(@RequestParam(value="memberId", required = false) String memberId
							  ,@RequestParam(value="result", required = false) String result
							  ,Model model) {

		log.info("========================================");
		log.info("화면에서 입력받은 값(회원탈퇴폼) memberId: {}", memberId);
		log.info("========================================");
		//System.out.println("========================================");
		//System.out.println("화면에서 입력받은 값(회원탈퇴폼): " + memberId);
		//System.out.println("========================================");
		
		model.addAttribute("title", "회원탈퇴폼");
		model.addAttribute("memberId", memberId);
		
		if(result != null) model.addAttribute("result", result);
		
		return "member/removeMember";
	}
	
	
	@PostMapping("/modifyMember")
	public String modifyMember(Member member) {
		log.info("========================================");
		log.info("화면에서 입력받은 값(수정화면폼) member: {}", member);
		log.info("========================================");
		//System.out.println("========================================");
		//System.out.println("화면에서 입력받은 값(수정화면폼): " + member);
		//System.out.println("========================================");
		
		memberService.modifyMember(member);
		
		return "redirect:/memberList";
	}
	
	
	/**
	 * @RequestParam(name = "memberId", required = false) = request.getParameter("memberId");
	 * @RequestParam(name = "memberId", required = false) String memberId 
	 *                           == 
	 * String memberId = request.getParameter("memberId");
	 * @return
	 */
	@GetMapping("/modifyMember")
	public String modifyMember(@RequestParam(name = "memberId", required = false) String memberId
							  ,Model model) {
		log.info("========================================");
		log.info("화면에서 입력받은 값(회원수정폼) memberId: {}", memberId);
		log.info("========================================");
		//System.out.println("=================================================");
		//System.out.println("화면에서 입력받은 값(회원수정폼): " + memberId);
		//System.out.println("=================================================");
		
		//1. 회원 아이디로 회원테이블을 조회한 Member객체
		Member member = memberService.getMemberInfoById(memberId);
		
		//2. Model 화면에 전달할 객체 삽입
		model.addAttribute("title", "회원수정폼");
		model.addAttribute("member", member);
		
		return "member/modifyMember";
	}
	
	
	/**
	 * 
	 * @param memberId, memberPw, .... => Member dto의 멤버변수와 이름이 같다면 스프링이 알아서 바인딩해줍니다.
	 *        커맨드객체(Member)
	 * 
	 */
	
	@PostMapping("/addMember")
	public String addMember(Member member) {
		
		log.info("========================================");
		log.info("화면에서 입력받은 값(회원가입) member: {}", member);
		log.info("========================================");
		//System.out.println("============================================");
		//System.out.println("화면에 입력 받은 값(회원가입): " + member);
		//System.out.println("============================================");
		
		memberService.addMember(member);
		
		return "redirect:/memberList";
	}
	
	@GetMapping("/addMember")
	public String addMember(Model model) {
		
		model.addAttribute("title", "회원가입폼");
		
		return "member/addMember";
	}
	
	@GetMapping("/memberList")
	public String getMemberList(Model model
							   ,@RequestParam(name="searchKey", required = false) String searchKey
							   ,@RequestParam(name="searchValue", required = false) String searchValue) {
		
		log.info("========================================");
		log.info("화면에서 입력받은 값(회원목록) searchKey: {}", searchKey);
		log.info("화면에서 입력받은 값(회원목록) searchValue: {}", searchValue);
		log.info("========================================");
		
		//System.out.println("=========================================");
		//System.out.println("searchKey : " + searchKey);
		//System.out.println("searchValue : " + searchValue);
		//System.out.println("=========================================");
		
		//map을 활용해서 검색 키워드 정리
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		
		List<Member> memberList = memberService.getMemberList(paramMap);
		
		log.info("========================================");
		log.info("memberList: {}", memberList);
		log.info("========================================");
		//System.out.println("=========================================");
		//System.out.println("memberList : " + memberList);
		//System.out.println("=========================================");
		
		model.addAttribute("title", "회원목록");
		model.addAttribute("memberList", memberList);
		
		return "member/memberList";
	}
}
