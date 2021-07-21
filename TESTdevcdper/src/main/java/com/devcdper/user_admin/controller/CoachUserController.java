package com.devcdper.user_admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devcdper.user_admin.domain.CoachUser;
import com.devcdper.user_admin.service.CoachUserService;

@Controller
public class CoachUserController {

	
	private static final Logger log = LoggerFactory.getLogger(CoachUserController.class);
	
	private final CoachUserService coachUserService;
	
	public CoachUserController(CoachUserService coachUserService) {
		this.coachUserService = coachUserService;
	}
	
	@PostMapping("/coachForgotEmail")
	public String coachForgotEmail() {
		
		return "";
	}
	
	@PostMapping("/coachForgotPassword")
	public String coachForgotPassword() {
		
		return "";
	}
	
	@GetMapping("/coachForgotPassword")
	public String coachForgotPassword(Model model) {
		
		model.addAttribute("title","회원패스워드찾기");
		
		return "userAdmin/coachForgotPassword";
	}
	
	@PostMapping("/coachEmailCheck")  //아이디 중복체크
	@ResponseBody
	public boolean coachEmailCheck(@RequestParam(name="coachEmail", required = false) String coachEmail) {
		boolean EmailCheck = true;
		//EmailCheck 중복된 아이디있는 경우에는 false
		CoachUser coachUser = coachUserService.getCoachInfoById(coachEmail);
		if(coachUser != null) EmailCheck = false;
		
		return EmailCheck;
	}
	
	
	@PostMapping("/coachLogin")
	public String coachLogin(@RequestParam(value="coachEmail", required = false) String coachEmail
			   ,@RequestParam(value="coachPassword", required = false) String coachPassword
			   ,HttpSession session
			   ,RedirectAttributes reAttr) {
		System.out.println(coachEmail+ coachPassword);
		if(coachEmail != null && !"".equals(coachEmail) && coachPassword != null && !"".equals(coachPassword)) {
			Map<String, Object> resultMap = coachUserService.loginCoachUser(coachEmail, coachPassword);

			boolean loginCheck = (boolean) resultMap.get("loginCheck");
			System.out.println(loginCheck);
			CoachUser coachLogin = (CoachUser) resultMap.get("loginCoachUser");
			System.out.println(resultMap);
//			
			if(loginCheck) {
				session.setAttribute("UEMAIL",	coachLogin.getCoachEmail());
				session.setAttribute("UNAME", 	coachLogin.getCoachName());
				session.setAttribute("ULEVEL", 	"코치");
				return "redirect:/";
			}
		}
		reAttr.addAttribute("loginResultCoach", "등록된 회원이 없습니다.");

		return "redirect:/login";
	}
	
	@PostMapping("/modifyCoach")
	public String modifyCoachUser(CoachUser coachUser) {
		coachUserService.modifyCoachUser(coachUser);
		
		return  "redirect:/modifyCoach";
	}
	
	@GetMapping("/modifyCoach")
	public String getCoachInfoById(@RequestParam(name="coachEmail", required = false)String coachEmail 
									,Model model) {
		log.info("+++++++++++++++++++++++++++");
		log.info("화면에서 입력받은 값(회원수정폼) coachUserEmail: {}", coachEmail);
		log.info("+++++++++++++++++++++++++++");
		
		CoachUser coachUser = coachUserService.getCoachInfoById(coachEmail);
		
		model.addAttribute("title", "회원수정폼");
		model.addAttribute("coachUser",coachUser);
		
		return "userAdmin/modifyCoach";
		
	}
	
	@PostMapping("/addCoach")
	public String addCoachUser(CoachUser coachUser) {
		
		log.info("화면에서 입력받은 값 coachUser : {}", coachUser);
		coachUserService.addCoachUser(coachUser);
		
		return "redirect:/login";
	}
	
	@GetMapping("/addCoach")
	public String addCoachUser(Model model) {
		
		model.addAttribute("title", "코치회원 가입폼");
		
		return "userAdmin/addCoach";
	}
	
	@GetMapping("/coachList")
	public String coachList(Model model) {
		List<CoachUser> coachUserList = coachUserService.getCoachList();
		
		log.info("★ - 전체회원 조회 결과 : {}"+ coachUserList);
		
		model.addAttribute("title","코치리스트");
		model.addAttribute("coachList",coachUserList);
		
		return "userAdmin/coachList";
	}
	
}
