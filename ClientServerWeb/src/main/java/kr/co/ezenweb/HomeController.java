package kr.co.ezenweb;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
//		System.out.println("reqest.getScheme() = " + request.getScheme());
//		// 요청 내용의 인코딩
//		System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());
//		// 프로토콜의 종류와 버전
//		System.out.println("request.getProtocol() = " + request.getProtocol());
//		// 요청 방법
//		System.out.println("request.getMethod() = " + request.getMethod());
//		// 서버 이름
//		System.out.println("request.getServerName() = " + request.getServerName());
//		// 서버 포트
//		System.out.println("request.getServerPort() = " + request.getServerPort());
//		// URL
//		System.out.println("request.getRequestURL() = " + request.getRequestURL());
//		// URI
//		System.out.println("request.getRequestURI() = " + request.getRequestURI());
//		// 컨텍스트 경로
//		System.out.println("request.getContextPath() = " + request.getContextPath());
//		// 서블릿 경로
//		System.out.println("request.getServletPath() = " + request.getServletPath());
		return "home";
	}
	
}
