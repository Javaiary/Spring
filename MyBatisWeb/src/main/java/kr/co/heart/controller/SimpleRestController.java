package kr.co.heart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.heart.domain.Person;

@Controller
public class SimpleRestController {
	
	@GetMapping("/ajax")
	public String ajax() {
		return "ajax";
	}
	@GetMapping("/test")
	public String test() {
		return "test";	//url을 요청했을 때 view를 리턴하고 view에서 댓글을 보여줌
	}
	@ResponseBody //응답 바디
	@PostMapping("/send")	// ajax url과 맞춰줌
	public Person test(@RequestBody Person p) {
						//요청 바디
		
		System.out.println("p = " + p);
		p.setName("ezen0111");
		p.setAge(p.getAge()+ 2023);
		return p;		//객체 반환
	}
}
