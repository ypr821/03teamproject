package ksmart39.exmybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "시작페이지");
		mav.setViewName("main");
		return mav;
	}
	
	/*
	 * @GetMapping("/") public String main(Model model) {
	 * model.addAttribute("title", "ksmart39 mybatis"); return "main"; }
	 */
	

}
