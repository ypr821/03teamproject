package com.devcdper.user_admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devcdper.user_admin.domain.CoachUser;
import com.devcdper.user_admin.service.CoachUserService;

import groovy.util.logging.Log;

@Controller
public class CoachUserController {

	
	private static final Logger log = LoggerFactory.getLogger(CoachUserController.class);
	
	private final CoachUserService coachUserService;
	
	public CoachUserController(CoachUserService coachUserService) {
		this.coachUserService = coachUserService;
	}
	@GetMapping("/modifyCoach")
	public String getCoachInfoById(@RequestParam(name="coachUserEmail", required = false)String coachUserEmail 
									,Model model) {
		log.info("+++++++++++++++++++++++++++");
		log.info("화면에서 입력받은 값(회원수정폼) coachUserEmail: {}", coachUserEmail);
		log.info("+++++++++++++++++++++++++++");
		CoachUser coachUser = coachUserService.getCoachInfoById(coachUserEmail);
		
		model.addAttribute("title", "회원수정폼");
		model.addAttribute("coachUser",coachUser);
		
		return "userAdmin/modifyCoach";
		
	}
	
	@PostMapping("/addCoach")
	public String addCoach(CoachUser coachUser) {
		
		log.info("화면에서 입력받은 값 coachUser : {}", coachUser);
		coachUserService.addCoahUser(coachUser);
		
		return "redirect:/coachList";
	}
	
	@GetMapping("/addCoach")
	public String addCoach(Model model) {
		
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
