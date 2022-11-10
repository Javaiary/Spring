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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.heart.domain.BoardDto;
import kr.co.heart.domain.PageResolver;
import kr.co.heart.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired // 의존성 주입
	BoardService boardService;
	
	@PostMapping("/modify")
	public String modify(BoardDto boardDto, Integer page, Integer pageSize, 
							RedirectAttributes rattr, Model m, HttpSession session) {
		String writer = (String) session.getAttribute("id");
		boardDto.setWriter(writer);	//세션에 저장되어있는 writer
	
		try {if(boardService.modify(boardDto)!=1)
			throw new Exception("Modify failed");
		
		rattr.addAttribute("page", page);
		rattr.addAttribute("pageSize", pageSize);
		rattr.addFlashAttribute("msg", "MOD_OK");
		

			return "redirect:/board/list";
		}catch (Exception e) {
			e.printStackTrace();
			m.addAttribute(boardDto);
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			m.addAttribute("msg", "MOD_OK");
			return "board";	//수정등록하려던 내용을 보여줌
			
		}
	}
	
	@PostMapping("/write")
	public String write(BoardDto boardDto, RedirectAttributes rattr,Model m , HttpSession session) {
		String writer = (String) session.getAttribute("id");
		boardDto.setWriter(writer);
		
		try {
			if(boardService.write(boardDto) !=1)
				throw new Exception("Write failed");
			
			rattr.addFlashAttribute("msg", "WRT_OK");
			return "redirect:/board/list";
		}catch(Exception e){
			e.printStackTrace();
			m.addAttribute("mode", "new");					//글쓰기 모드
			m.addAttribute("boardDto", boardDto);			//등록하려던 내용을 보여줘야 함
			m.addAttribute("msg", "WRT_ERR");
			
			return "board";
		}
	}

	@GetMapping("/write")
	public String write(Model m) {
		m.addAttribute("mode", "new");

		return "board"; // board.jsp에 읽기와 쓰기에 사용. 쓰기에 사용할때는 모드를 new로 사용하겠다.
	}

	@PostMapping("/remove")
	public String remove(Integer bno, Integer page, Integer pageSize, RedirectAttributes rattr, HttpSession session) {
		String writer = (String) session.getAttribute("id");
		String msg = "DEL_OK";

		try {
			if (boardService.remove(bno, writer) != 1) {
				throw new Exception("Delete failed.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "DEL_ERR";
		}
		// 삭제 후 메시지가 한 번만 나와야 함(model(데이터공유) 역할을 해주는 redirectAttributes사용)
		// redirectAttributes에 저장하면 메시지가 한 번만 나옴
		// addFlashAtttibute() : 한 번 저장 후 소멸. 세션에 잠깐 저장
		rattr.addAttribute("page", page);
		rattr.addAttribute("pageSize", pageSize);
		rattr.addFlashAttribute("msg", msg);

		return "redirect:/board/list";
	}

	@GetMapping("/read")
	public String read(Integer bno, Integer page, Integer pageSize, Model m) {
		try {
			BoardDto boardDto = boardService.read(bno);

			// view에서 출력해주기 위해 모델에 저장
//			m.addAttribute("boardDto", boardDto);
			m.addAttribute(boardDto);

			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);

		} catch (Exception e) {
			e.printStackTrace();
			// 예외발생시 목록으로 리다이렉트 처리
			return "redirect:/board/list";
		}
		return "board";
	}

	@GetMapping("/list")
	public String list(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer pageSize, // parameter는 무조건 문자열로 작성(자동형변환)
			Model m, HttpServletRequest request) {
		if (!loginCheck(request))
			return "redirect:/login/login?toURL=" + request.getRequestURL();

		try {
			int totalCnt = boardService.getcount();
			m.addAttribute("totalCnt", totalCnt);

			PageResolver pageResolver = new PageResolver(totalCnt, page, pageSize);
			if (page < 0 || page > pageResolver.getTotalPage())
				page = 1;
			if (pageSize < 0 || pageSize > 50)
				pageSize = 10;

			Map map = new HashMap();
			map.put("offset", (page - 1) * pageSize);
			map.put("pageSize", pageSize);

			List<BoardDto> list = boardService.getPage(map);

			m.addAttribute("list", list);
			m.addAttribute("pr", pageResolver);

			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "boardList"; // 로그인 한 상태, 게시판 목록 화면으로 이동
	}

	private boolean loginCheck(HttpServletRequest request) {
		// 1. 세션을 얻어서
		HttpSession session = request.getSession(false); // false는 session이 없어도 새로 생성하지 않음. 반환값 null

		// 2. session에 id가 있는지 확인, 있으면 true(로그인상태) 반환
		return session != null && session.getAttribute("id") != null;
	}
}
