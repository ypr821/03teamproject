package com.devcdper.user_admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		return "redirect:/normalList";
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
