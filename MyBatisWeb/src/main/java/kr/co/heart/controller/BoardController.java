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
import org.springframework.web.bind.annotation.PostMapping;
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
	
//	@PostMapping("/remove")
	public String remove(Integer bno, Integer page, Integer pageSize) {
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/read")
	public String read(Integer bno,Integer page, Integer pageSize, Model m) {
		try {
			BoardDto boardDto = boardService.read(bno);
			
			//view에서 출력해주기 위해 모델에 저장
//			m.addAttribute("boardDto", boardDto);
			m.addAttribute(boardDto);
			
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			
		}catch(Exception e) {
			e.printStackTrace();
			//예외발생시 목록으로 리다이렉트 처리
			return "redirect:/board/list";
		}
		return "board";
	}

	@GetMapping("/list") 
	public String list(@RequestParam(defaultValue = "1") Integer page, 
						@RequestParam(defaultValue = "10") Integer pageSize,//parameter는 무조건 문자열로 작성(자동형변환)
						Model m, 
						HttpServletRequest request) {
		if(!loginCheck(request))
			return "redirect:/login/login?toURL=" + request.getRequestURL();
		
		try {
			int totalCnt = boardService.getcount();
			m.addAttribute("totalCnt", totalCnt);
			
			PageResolver pageResolver = new PageResolver(totalCnt, page, pageSize);
			if (page <0 || page > pageResolver.getTotalPage())
				page=1;
			if(pageSize <0 || pageSize >50 )
				pageSize=10;
			
			Map map = new HashMap();
			map.put("offset", (page-1)*pageSize);
			map.put("pageSize", pageSize);

			List<BoardDto> list = boardService.getPage(map);

			m.addAttribute("list", list);
			m.addAttribute("pr", pageResolver);
			
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			
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
