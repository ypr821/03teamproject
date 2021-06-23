package com.devcdper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("title", "DEV-CDPER");
		return "main";
	}
	
	@GetMapping("/introduce")
	public String introduce(Model model) {
		model.addAttribute("title", "DEV-CDPER 소개");
		return "devcdper/introduce";
	}
	
	@GetMapping("/guide")
	public String guide(Model model) {
		model.addAttribute("title", "DEV-CDPER 가이드");
		return "devcdper/guide";
	}
	

}
