package kr.co.ezenweb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMessage {
	@RequestMapping("/requestmessage")
	public void ezen(HttpServletRequest request) {
		String requestLine = request.getMethod(); // get또는 post
		requestLine += " " + request.getRequestURI(); // /ezenweb/requestmessage

		String queryString = request.getQueryString(); // year=2022&month=10&day=13
		requestLine += queryString == null ? "" : "?" + queryString;
		requestLine += " " + request.getProtocol(); // HTTP/1.1
		System.out.println(requestLine);

		// requestHeader
		Enumeration<String> e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			System.out.println(name + " : " + request.getHeader(name));
		}
		//request body -- post일 때만 해당, get방식은 body가 없음
		final int CONTENT_LENGTH = request.getContentLength();
		System.out.println("content_length = " + CONTENT_LENGTH);
		
		if(CONTENT_LENGTH > 0) {
			byte[] content = new byte[CONTENT_LENGTH];
			InputStream in = null;
			try {
				request.getInputStream();
				in.read(content, 0, CONTENT_LENGTH);
				
				System.out.println();//empty line
				System.out.println(new String(content, "utf-8"));
			} catch (IOException e1) {e1.printStackTrace();}
		}
	}
}
