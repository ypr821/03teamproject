package ksmart39.exmybatis.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart39.exmybatis.domain.Member;
import ksmart39.exmybatis.service.MemberService;

@Controller
public class MemberController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	//DI
	private final MemberService memberService;
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
		
	}
	
	@PostMapping("/idCheck")
	
	public @ResponseBody boolean idCheck(@RequestParam(name = "memberId" ,required = false)String memberId) {
		log.info("=============================");
		log.info("=====memberId: " + memberId);
		//이미 등록된 아이디가 있으면 false, 없으면 true
		boolean idCheck = true;
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
	public String login(@RequestParam(name = "memberId", required = false)String memberId,
			@RequestParam(name="memberPw", required = false)String memberPw,
			HttpSession session, RedirectAttributes redirectAttr){
		System.out.println("로그인 메서드 실행 ");
		if(memberPw != null && !"".equals(memberPw)&& memberId != null && !"".equals(memberId)) {
			
			Map<String, Object> resultMap = memberService.loginMember(memberId, memberPw);
			boolean loginCheck = (boolean) resultMap.get("loginCheck");
			Member loginMember = (Member) resultMap.get("loginMember");

			if(loginCheck) {
				session.setAttribute("SID", memberId);
				session.setAttribute("SNAME", loginMember.getMemberName());
				session.setAttribute("SLEVEL", loginMember.getMemberLevel());
				
				if("1".equals(loginMember.getMemberLevel())) {
					session.setAttribute("SLEVELNAME", "관리자");
				}
				else if("2".equals(loginMember.getMemberLevel())) {
					session.setAttribute("SLEVELNAME", "판매자");
				}
				else{
					session.setAttribute("SLEVELNAME", "구매자");
				}
				return "redirect:/";
			}
		}
		
		redirectAttr.addAttribute("loginResult", "등록된 회원이 없습니다.");
		return "redirect:/login";
		
	}

	@GetMapping("/login")
	public String login(Model model) {

		model.addAttribute("title", "로그인 화면");
		return "login/login";
	}
	
	
	
	
	
	
	
	@PostMapping("/removeMember")
	public String removeMember(@RequestParam(name="memberId", required = false)String memberId
			,@RequestParam(name="memberPw", required = false)String memberPw) {
		
		System.out.println(memberId +" <--삭제화면에서 입력받은 memberId");
		System.out.println(memberPw +" <--삭제화면에서 입력받은 memberPw");
		Member member = memberService.getMemberInfoById(memberId);
		
		System.out.println(member.getMemberPw() +" <--member.getMemberPw()");
		System.out.println(member +" <--member");
		if( !"".equals(memberPw) && member.getMemberPw().equals(memberPw) ) {
			//삭제프로세스 
			System.out.println("삭제프로세스 실행");
			System.out.println(member.getMemberLevel()  + "<--member.getMemberLevel()");
			
			//판매자 - 주문(판매자아이디), 상품, 로그, 멤버 
			if("2".equals(member.getMemberLevel())) {
				System.out.println("판매자 삭제프로세스 실행");
				memberService.removeOrderByGoods(memberId);
				memberService.removeGoodsMember(memberId);
			}
			
			//구매자 - 주문, 로그, 멤버
			if("3".equals(member.getMemberLevel())) {
				System.out.println("구매자 삭제프로세스 실행");
				memberService.removeOrderMember(memberId);
			}
			
			memberService.removeLoinMember(memberId);
			memberService.removeMember(memberId);
						
			return "redirect:/memberList";
			
		}else {
			System.out.println("삭제프로세스 비비비비비 실행");
			return "redirect:/removeMember";
		}
		
	}
	
	
	
	@GetMapping("/removeMember")
	public String removeMember(@RequestParam(name="memberId", required = false)String memberId,
				Model model) {
		
		System.out.println("======삭제겟매핑잘된다❤============");
		System.out.println("화면에서 입력받은 memberId값 : " + memberId);
		
		//Member member = memberService.getMemberInfoById(memberId);
		//System.out.println("getMemberInfoById 사용후 받은 member값 : " + member);
		//model.addAttribute("member", member);
		model.addAttribute("memberId", memberId);
		
		
		return "member/removeMember";
	}
	
	
	
	
	@PostMapping("/modifyMember")
	public String modifyMember(Member member, Model model) {
		
		memberService.modifyMember(member);
		
		return "redirect:/memberList";
	}
	
	
	
	@GetMapping("/modifyMember")
	public String modifyMember(@RequestParam(name = "memberId", required = false)String memberId ,Model model) {
		System.out.println("====================================");
		System.out.println("회원 수정 화면 / 입력받은 아이디값: " +memberId);
		System.out.println("====================================");
		
		model.addAttribute("title", "회원수정화면");
		model.addAttribute("memberId", memberId);
		
		Member member = memberService.getMemberInfoById(memberId);
		System.out.println("🌹🌹🌹member : "+ member);
		
		model.addAttribute("member", member);
		
		
		return "member/modifyMember";
	}
	
	
	
	@PostMapping("/addMember")
	public String addMember(Member member) {
		
	
		System.out.println("====================================");
		System.out.println("회원가입화면에서 입력받은 값: " + member);
		System.out.println("====================================");
		
		memberService.addMember(member);
		
		return "redirect:/memberList";
	}
	
	
	
	@GetMapping("/addMember")
	public String addMember(Model model) {
		System.out.println("====================================");
		System.out.println("회원가입 화면");
		System.out.println("====================================");
		
		model.addAttribute("title", "회원가입화면");

		return "member/addMember";
	}
	
	
	
	@GetMapping("/memberList")
	public String getMemberList(Model model) {
		
		List<Member> memberList = memberService.getMemberList();
		
		System.out.println("====================================");
		System.out.println("memberList : " + memberList);
		System.out.println("====================================");
		
		model.addAttribute("title", "회원목록");
		model.addAttribute("memberList", memberList);
		return "member/memberList";
	}
}














