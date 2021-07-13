package com.devcdper.user_admin.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devcdper.user_admin.domain.NormalUser;
import com.devcdper.user_admin.service.NormalUserService;

@Controller
public class NormalUserController {
	
	
	private static final Logger log = LoggerFactory.getLogger(NormalUserController.class);

	private final NormalUserService normalUserService;
	
	@Autowired
	public NormalUserController(NormalUserService normalUserService) {
		this.normalUserService = normalUserService;
	}
	
	@GetMapping("myPage")
	public String myPage(Model model) {
		
		model.addAttribute("title","마이페이지");
		model.addAttribute("function","myPage");
		return "userAdmin/myPage";
	}
	
	@PostMapping("/normalForgotEmail")
	public String normalForgotEmail() {
		
		return "redirect:/normalForgotPassword";
	}
	@PostMapping("/normalForgotPassword")
	public String normalForgotPassword() {
		
		return "redirect:/normalForgotPassword";
	}
	
	
	@GetMapping("/normalForgotPassword")
	public String normalPassword(Model model) {
		
		model.addAttribute("title","회원패스워드찾기");
		
		return "userAdmin/normalForgotPassword";
	}
	
	@GetMapping("/logout")  //아직안됨...
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@PostMapping("/normalLogin") //아직안됨...
	public String normalLogin(@RequestParam(value="userEmail", required = false) String userEmail
			   ,@RequestParam(value="userPassword", required = false) String userPassword
			   ,HttpSession session
			   ,RedirectAttributes reAttr) {
		if(userEmail != null && !"".equals(userEmail) && userPassword != null && !"".equals(userPassword)) {
			System.out.println(userEmail +"" +userPassword);
			Map<String, Object> resultMap = normalUserService.loginNomalUser(userEmail, userPassword);
			
			boolean loginCheck = (boolean) resultMap.get("loginCheck");
			NormalUser normalLogin = (NormalUser) resultMap.get("loginNormalUser");
			System.out.println(resultMap);
			
			if(loginCheck) {
				session.setAttribute("UEMAIL", 	normalLogin.getUserEmail());
				session.setAttribute("UNAME", 	normalLogin.getUserName());
				session.setAttribute("ULEVEL", 	"일반사용자");
				
				return "redirect:/";
			}
		}
		reAttr.addAttribute("loginResultNormal", "등록된 회원이 없습니다.");
		
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String normalLogin(Model model
						,@RequestParam(name="loginResult", required = false) String loginResult) {
		
		model.addAttribute("title","로그인화면");
		if(loginResult != null) model.addAttribute("loginResult", loginResult);
		
		return "login/login";
	}
	
	@PostMapping("/modifyNormal")
	public String modifyNormal(NormalUser normalUser) {
		log.info("화면에서 입력받은 값(회원수정) normalUser: {}", normalUser);
		
		normalUserService.modifyNormalUser(normalUser);
		return "redirect:/normalList";
	}
	
	@GetMapping("/modifyNormal")
	public String getNormalInfoById(@RequestParam(name ="userEmail", required = false)String userEmail
								, Model model) {
		log.info("========================================");
		log.info("화면에서 입력받은 값(회원수정폼) userEmail: {}", userEmail);
		log.info("========================================");
		
		NormalUser normalUser = normalUserService.getNormalInfoById(userEmail);
		
		model.addAttribute("title", "회원정보수정폼");
		model.addAttribute("normalUser", normalUser);
		
		return "userAdmin/modifyNormal";
	}
	
	@PostMapping("/addNormal")
	public String addMember(NormalUser normalUser) {
		
		log.info("화면에서 입력받은 값 normalUser : {}", normalUser);
		normalUserService.addNormalUser(normalUser);
		
		return "redirect:/login";
	}
	
	@GetMapping("/addNormal")
	public String addMember(Model model) {
		
		model.addAttribute("title", "일반회원 가입폼");
		
		return "userAdmin/addNormal";
	}
	
	@GetMapping("/normalList")
	public String normalList(Model model) {
		List<NormalUser> normalUserList = normalUserService.getNormalUserList();
		
		log.info("★ - 전체회원 조회 결과 : {}"+ normalUserList);
		
		model.addAttribute("title", "일반회원리스트");
		model.addAttribute("normalList", normalUserList);
		
		return "userAdmin/normalList";
	}
	
}
