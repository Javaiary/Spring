package kr.co.shield;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		if(!loginCheck(request))
			return "redirect:/login/login?toURL=" + request.getRequestURL();
		
		return "boardList";
	}

	private boolean loginCheck(HttpServletRequest request) {

		// 세션을 얻어서
		HttpSession session = request.getSession();
		// 세션에 id가 있는지 확인, 있으면 true 반환
		return session.getAttribute("id")!= null;		//null이 아니면 true, null이면 false
	}
}
