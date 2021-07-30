package com.devcdper.user_admin.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	
	@PostMapping("/getProfilePicture")
	public String modifyProfilePicture(@RequestParam(name="userProfilePicture",required = false) MultipartFile file
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
           
            	Path path = Paths.get(System.getProperty("user.dir") + "/src/main/resources/static/AdminLTE3/dist/img/profilePicture/Normal/"+ random + file.getOriginalFilename());
           
            //cafe24용
//            Path path = Paths.get(session.getServletContext().getRealPath("/WEB-INF/classes/static/AdminLTE3/dist/img/profilePicture/") + file.getOriginalFilename());
            Files.write(path, bytes);
            
            System.out.println(random + file.getOriginalFilename());
    
        	normalUserService.modifyProfilePicture(session.getAttribute("UEMAIL"),random+ file.getOriginalFilename());
          
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	
		return "redirect:/myPage";
	}
	
	@GetMapping("/myPage")
	public String myPage(Model model, HttpSession session) {
		
		model.addAttribute("title","마이페이지");
		model.addAttribute("function","myPage");
		
		
		return "userAdmin/myPage";
	}
	
	
	@PostMapping("/normalForgotEmail")
	public String normalForgotEmail(@RequestParam(name="userName",required = false) String userName
									,@RequestParam(name="userMoblie",required = false) String userMoblie, Model model) {
		
		NormalUser normalUser = normalUserService.normalForgotEmail(userName, userMoblie);
		
		if(normalUser != null) model.addAttribute("userEmail",normalUser.getUserEmail());
		
		return "userAdmin/normalForgotPassword";
	}
	
	
	@PostMapping("/normalForgotPassword")
	public String normalForgotPassword(@RequestParam(name="userEmail",required = false) String userEamil
									  ,@RequestParam(name="userPasswordAnswer",required = false) String userPasswordAnswer
									  , Model model) {
		
		NormalUser normalUser = normalUserService.normalForgotPassword(userEamil, userPasswordAnswer);

		if(normalUser != null) model.addAttribute("userPassword",normalUser.getUserPassword());
		
		return "userAdmin/normalForgotPassword";
	}
	
	@GetMapping("/normalForgotPassword")
	public String normalForgotPassword(Model model) {
		
		model.addAttribute("title","회원패스워드찾기");
		
		return "userAdmin/normalForgotPassword";
	}
	
	@GetMapping("/logout")  
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@PostMapping("/normalEmailCheck")  //아이디 중복체크
	@ResponseBody
	public boolean normalEmailCheck(@RequestParam(name="normalEmail", required = false) String normalEmail) {
		boolean EmailCheck = true;
		//idcheck 중복된 아이디있는 경우에는 false
		NormalUser normalUser = normalUserService.getNormalInfoById(normalEmail);
		if(normalUser != null) EmailCheck = false;
		
		return EmailCheck;
	}
	
	
	@PostMapping("/normalLogin") 
	public String normalLogin(@RequestParam(value="userEmail", required = false) String userEmail
			   ,@RequestParam(value="userPassword", required = false) String userPassword
			   ,HttpSession session ,RedirectAttributes reAttr)
		{
		if(userEmail != null && !"".equals(userEmail) && userPassword != null && !"".equals(userPassword)) {
			System.out.println(userEmail +"" +userPassword);
			
			Map<String, Object> resultMap = normalUserService.loginNomalUser(userEmail, userPassword);
			
			boolean loginCheck = (boolean) resultMap.get("loginCheck");
			
			NormalUser normalLogin = (NormalUser) resultMap.get("loginNormalUser");
			
			System.out.println(resultMap);
			
			if(loginCheck) {
				session.setAttribute("UEMAIL",		normalLogin.getUserEmail());
				session.setAttribute("UNAME", 		normalLogin.getUserName());
				session.setAttribute("UPROFILE", 	normalLogin.getUserProfilePicture());
				session.setAttribute("ULEVEL", 		"일반");
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
		List<NormalUser> normalList = normalUserService.getNormalUserList();
		
		log.info("★ - 전체회원 조회 결과 : {}"+ normalList);
		
		model.addAttribute("title", "일반회원리스트");
		model.addAttribute("normalList", normalList);
		
		return "userAdmin/normalList";
	}
	
}
