package kr.co.ezenweb;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestHeader {
	@RequestMapping("/requestHeader")
	public void ezen(HttpServletRequest request) {
		//보이지 않지만 리퀘스트시에 함께 포함 된 정보들 
		
		Enumeration<String> e = request.getHeaderNames();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			System.out.println(name + " : " + request.getHeader(name));
		}
	}
}
