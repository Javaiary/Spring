package kr.co.heart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.heart.domain.BoardDto;
import kr.co.heart.domain.PageResolver;
import kr.co.heart.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired //의존성 주입
	BoardService boardService; 

	@GetMapping("/list") 
	public String list(@RequestParam(defaultValue = "1") Integer page, 
						@RequestParam(defaultValue = "10") Integer pageSize,//parameter는 무조건 문자열로 작성(자동형변환)
						Model m, 
						HttpServletRequest request) {
		if(!loginCheck(request))
			return "redirect:/login/login?toURL=" + request.getRequestURL();
		try {
			
			if(page == null) page=1;
			if (pageSize==null) pageSize=10;
			
			int totalCnt = boardService.getcount();
			m.addAttribute("totalCnt", totalCnt);
			
			PageResolver pageResolver = new PageResolver(totalCnt, page, pageSize);
			if (page <0 || page > pageResolver.getTotalPage())
				page=1;
			if(pageSize <0 || pageSize >50 )
				pageSize=10;
			
			Map map = new HashMap();
			map.put("offset", (page-1)*pageSize);

			List<BoardDto> list = boardService.getPage(map);

			m.addAttribute("list", list);
			m.addAttribute("pr", pageResolver);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "boardList";	// 로그인 한 상태, 게시판 목록 화면으로 이동
	}

	private boolean loginCheck(HttpServletRequest request) {
		//1. 세션을 얻어서
		HttpSession session= request.getSession(false); 	//false는 session이 없어도 새로 생성하지 않음. 반환값 null
		
		//2. session에 id가 있는지 확인, 있으면 true(로그인상태) 반환
		return session != null && session.getAttribute("id") != null;
	}
}
