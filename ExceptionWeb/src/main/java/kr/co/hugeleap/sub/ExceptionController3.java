package kr.co.hugeleap.sub;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController3 {
	//ExceptionController와 url이 같으면 안되므로 수정
	
	
	// 핸들러 모델과 리퀘스트매핑 모델은 별개의 모델임(msg를 받아올 수 없음)
	@RequestMapping("/ex5")
	public void ezen(Model m ) throws Exception {
		m.addAttribute("msg", "message from ExceptionController2.ezen()");
			throw new Exception("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex6")
	public String ezen2(Model m ) throws Exception {
		try {
			throw new Exception("예외가 발생했습니다.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error" ;
	} 
	
	@RequestMapping("/ex7")
	public String ezen3(Model m ) throws Exception {

			throw new NullPointerException("널포인터 예외가 발생했습니다.");

	} 
	
	@RequestMapping("/ex8")
	public void ezen4(Model m) throws FileNotFoundException {
		throw new FileNotFoundException("파일 부재 예외가 발생했습니다. ");
	}
	

}

