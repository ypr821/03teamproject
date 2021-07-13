package com.devcdper.user_admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devcdper.user_admin.domain.AdminUser;
import com.devcdper.user_admin.service.AdminUserService;

@Controller
public class AdminUserController {
	
	private final AdminUserService adminUserService;
	
	public AdminUserController(AdminUserService adminUserService){
		this.adminUserService = adminUserService;
	}
	

	@PostMapping("/adminForgotEmail")
	public String normalForgotEmail() {
		
		return "";
	}
	@PostMapping("/adminForgotPassword")
	public String normalForgotPassword() {
		
		return "";
	}
	
	
	@GetMapping("/adminForgotPassword")
	public String normalPassword(Model model) {
		
		model.addAttribute("title","회원패스워드찾기");
		
		return "userAdmin/adminForgotPassword";
	}
	
	@PostMapping("/adminEmailCheck")
	@ResponseBody
	public boolean memberIdCheck(@RequestParam(name="adminEmail", required = false) String adminEmail) {
		boolean idCheck = true;
		//idcheck 중복된 아이디있는 경우에는 false
		AdminUser adminUser = adminUserService.getAdminInfoById(adminEmail);
		if(adminUser != null) idCheck = false;
		
		return idCheck;
	}
	
	@PostMapping("/adminLogin") //아직안됨...
	public String adminLogin(@RequestParam(value="adminEmail", required = false) String adminEmail
			   ,@RequestParam(value="adminPassword", required = false) String adminPassword
			   ,HttpSession session
			   ,RedirectAttributes reAttr) {
		if(adminEmail != null && !"".equals(adminEmail) && adminPassword != null && !"".equals(adminPassword)) {
			System.out.println(adminEmail +"" + adminPassword);
			Map<String, Object> resultMap = adminUserService.loginAdminUser(adminEmail, adminPassword);
			
			boolean loginCheck = (boolean) resultMap.get("loginCheck");
			AdminUser adminLogin = (AdminUser) resultMap.get("loginAdminUser");
			System.out.println(resultMap);
			
			if(loginCheck) {
				session.setAttribute("UEMAIL", 	adminLogin.getAdminEmail());
				session.setAttribute("UNAME", 	adminLogin.getAdminName());
				session.setAttribute("ULEVEL", 	"관리자");
				
				return "redirect:/";
			}
		}
		reAttr.addAttribute("loginResultNormal", "등록된 회원이 없습니다.");
		
		return "redirect:/login";
	}
	
	
	//관리자 수정
	@PostMapping("/modifyAdmin")
	public String modifyAdmin(AdminUser adminUser) {
		
		adminUserService.modifyAdminUser(adminUser);
		
		return "redirect:/adminList";
	}
	
	
	//관리자 수정폼까지
	@GetMapping("/modifyAdmin")
	public String getAdminInfoById(@RequestParam(name = "adminEmail", required = false)String adminEmail
									,Model model) {
		AdminUser adminUser = adminUserService.getAdminInfoById(adminEmail);
		
		model.addAttribute("title","관리자 수정");
		model.addAttribute("adminUser", adminUser);
		
		return "userAdmin/modifyAdmin";
	}
	
	//관리자 회원가입
	@PostMapping("/addAdmin")
	public String addAdminUser(AdminUser adminUser) {
		
		adminUserService.addAdminUser(adminUser);
		
		return "redirect:/login";
	}
	
	//관리자 회원가입폼
	@GetMapping("/addAdmin")
	public String addAdminUser(Model model) {
		
		model.addAttribute("title","회원가입폼");
		
		return "userAdmin/addAdmin";
	}
	
	//관리자 리스트
	@GetMapping("/adminList")  
	public String adminList(Model model) {
		List<AdminUser> adminList = adminUserService.getAdminUserList();
		
		model.addAttribute("title","관리자리스트");
		model.addAttribute("adminList", adminList);
		
		return "userAdmin/adminList";
	}

}
