package ksmart39.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	/**
	 * PSA(Portable Service Abstraction) : 환경의 변화와 관계없이 일관된 방식의 기술 접근 환경을 제공하려는 추상화 구조
	 * 
	 * Service Abstraction(서비스의 추상화)
	 * ex) spring 으로 servlet Application을 만들고 있지만  servlet 코드를 기술하지 않음
	 * Dynamic Web project : model2(mvc)를 구현시  httpServlet 상속클래스에서 Http Request 처리 --> web.xml
	 * spring에서 매핑 작업 없이 Annotation만으로 서블릿 구현
	 * 
	 * Portable (코드를 건들지 않고 다른 기술로 바꿀 수 있음)
	 * ex) 톰캣, 제티, 네티, 언더토우와 같은 아예 다른 기술 Stack을 소스코드 변경이 거의 없이 개발 가능
	 * 
	 * @Controller 안의 Mapping Annotation (@GetMapping, @PostMapping etc)
     * Mapping Annotation은 name, value, path, params, headers 등의 속성
     * 1. 요청에 대한 정보를 보유 -> Handler Mapping을 통해 해당 컨트롤러 선택
     * 2. 이에 맵핑되는 요청일 때만 해당 메소드가 처리 : Handler Adapter
     * 3. 해당 메소드는 view name 반환
     * 4. View Resolver ( "resources/templates/" + {view name} + ".html" ) 사용자가 요청한 것에 대한 
     *    응답 view를 렌더링하는 역할   
     * 5. 해당 뷰 템플릿에서 전달된  model 속 객체 사용가능
	 * 
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main(Model model) {
		//model.addAttribute("title", "ksmart39 mybatis");
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "ksmart39 mybatis");
		mav.setViewName("main");
		return mav;
	}
	
	
	

}
