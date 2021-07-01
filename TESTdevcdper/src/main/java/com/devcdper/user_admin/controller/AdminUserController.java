package com.devcdper.user_admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	
	@GetMapping("/adminList")  
	public String adminList(Model model) {
		List<AdminUser> adminList = adminUserService.getAdminUserList();
		
		model.addAttribute("title","관리자리스트");
		model.addAttribute("adminList", adminList);
		
		return "userAdmin/adminList";
	}

}
