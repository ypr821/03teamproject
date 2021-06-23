package com.devcdper.plan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LastController {
	
	
	/*------------------------------------------------최종 스펙 관리 Start-----------------------------------------------------*/
	@GetMapping("/lastSpac")
	public String lastSpac(Model model) {
		model.addAttribute("title", "최종 스펙 관리");
		return "last/lastSpac";
	}
	/*------------------------------------------------최종 스펙 관리 End-----------------------------------------------------*/
	/*------------------------------------------------경력관리서 관리 Start-----------------------------------------------------*/
	@GetMapping("/careerManagement")
	public String careerManagement(Model model) {
		model.addAttribute("title", "경력관리서 관리");
		return "last/careerManagement";
	}
	/*------------------------------------------------경력관리서 관리 End-----------------------------------------------------*/
}
