package com.devcdper.user_admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	
	@PostMapping("/getCoachProfilePicture")
	public String modifyProfilePicture(@RequestParam(name="coachProfilePicture",required = false) MultipartFile file
										, HttpSession session) {

		log.info("프로필 수정에 대한 부분 file: {}", file);
		System.out.println(file.getOriginalFilename());
		try {
			
		   
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            
            InetAddress local = InetAddress.getLocalHost();

            System.out.println(local.getHostAddress());
            
        	
            int random = (int)(Math.random()*100);
            
            //localhost용
           
            Path path = Paths.get(System.getProperty("user.dir") + "/src/main/resources/static/AdminLTE3/dist/img/profilePicture/Coach/"+ random + file.getOriginalFilename());
           
            //cafe24용
//            Path path = Paths.get(session.getServletContext().getRealPath("/WEB-INF/classes/static/AdminLTE3/dist/img/profilePicture/Coach/") + random + file.getOriginalFilename());
            Files.write(path, bytes);
            
            System.out.println(random + file.getOriginalFilename());
    
            coachUserService.modifyProfilePicture(session.getAttribute("UEMAIL"),random+ file.getOriginalFilename());
          
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	
		return "redirect:/myPage";
	}
	
		
	@PostMapping("/coachForgotEmail")
	public String coachForgotEmail(@RequestParam(name="coachName",required = false) String coachName
			,@RequestParam(name="coachMobile",required = false) String coachMobile, Model model) {
		
		CoachUser coachUser = coachUserService.coachForgotEmail(coachName, coachMobile);
		
		if(coachUser != null) model.addAttribute("coachEmail", coachUser.getCoachEmail());
		
		return "userAdmin/coachForgotPassword";
	}
	
	@PostMapping("/coachForgotPassword")
	public String coachForgotPassword(@RequestParam(name="coachEmail",required = false) String coachEmail
									  ,@RequestParam(name="coachPasswordAnswer",required = false) String coachPasswordAnswer
									  , Model model) {
			
			CoachUser coachUser = coachUserService.coachForgotPassword(coachEmail, coachPasswordAnswer);
			
			if(coachUser != null) model.addAttribute("coachPassword", coachUser.getCoachPassword());
			
		return "userAdmin/coachForgotPassword";
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
			   ,RedirectAttributes reAttr)  {
		System.out.println(coachEmail+ coachPassword);
		if(coachEmail != null && !"".equals(coachEmail) && coachPassword != null && !"".equals(coachPassword)) {
			Map<String, Object> resultMap = coachUserService.loginCoachUser(coachEmail, coachPassword);

			boolean loginCheck = (boolean) resultMap.get("loginCheck");
			System.out.println(loginCheck);
			CoachUser coachLogin = (CoachUser) resultMap.get("loginCoachUser");
			System.out.println(resultMap);
			System.out.println(coachLogin + "testsetests");
//			
			if(loginCheck) {
				session.setAttribute("UEMAIL",   coachLogin.getCoachEmail());
				session.setAttribute("UNAME", 	 coachLogin.getCoachName());
				session.setAttribute("UPROFILE", coachLogin.getCoachProfilePicture());
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
		
		return  "redirect:/coachList";
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
