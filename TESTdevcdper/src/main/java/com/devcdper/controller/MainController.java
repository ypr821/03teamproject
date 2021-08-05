package com.devcdper.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/")
	public String main(Model model, HttpSession session) {
		model.addAttribute("title", "DEV-CDPER");
		
		//가정 - 세션 아이디 : park01@hanmail.net (일반 회원)
		String sessionEmail = (String) session.getAttribute("UEMAIL");
		String sessionLevel = (String) session.getAttribute("ULEVEL");
		System.out.println("sessionEmail : " + sessionEmail);
		System.out.println("sessionLevel : " + sessionLevel);
		
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
	//다운로드
	@RequestMapping("/fileDownload")
	@ResponseBody
	public ResponseEntity<Resource> fileDownload(HttpServletResponse response, HttpServletRequest request, HttpSession session) throws IOException {
//		File file = new File(System.getProperty("user.dir") + "/src/main/resources/static/AdminLTE3/dist/completionReport/"+"ksmart39_03team.hwp");
		File file = new File(session.getServletContext().getRealPath("/WEB-INF/classes/static/AdminLTE3/dist/completionReport/"+"ksmart39_통합구현_03team.hwp"));

	        Path path = Paths.get(file.getAbsolutePath());
	        Resource resource = new UrlResource(path.toUri());
	        String contentType = null;
	        contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	        if(contentType == null) {
	            contentType = "application/octet-stream";
	        }
		
		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
		
	}

}
