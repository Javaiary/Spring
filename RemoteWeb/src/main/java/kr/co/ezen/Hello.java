package kr.co.ezen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 원격호출 가능한 프로그램으로 등록
@Controller
public class Hello {
	int iv = 10;			// 인스턴스 변수
	static int cv = 20;		// static 변수
	
	// 2. URL과 메서드를 연결 => 홈페이지 주소에 /hello 추가로 이동할 페이지
	@RequestMapping("/hello")
	private void main1() {	// 인스턴스 메서드 - 인스턴스변수, 스태틱 변수 둘 다 사용 가능
		System.out.println("Hello - private (콘솔 출력)");
		System.out.println(iv);
		System.out.println(cv);
	}
	
	
	
}
