package kr.co.heart;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.heart.dao.BoardDao;
import kr.co.heart.domain.BoardDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
	public class BoardDaoImplTest {
	
	@Autowired
	private BoardDao boardDao;
	
	
	//각각의 boardDto : 글 목록(1줄) 
	//truncate 후 데이터 1줄 있는 상태에서 실행
//	@Test
	public void selectTest() throws Exception{
		assertTrue(boardDao != null);
		System.out.println("boardDao =" + boardDao);
		
		
		//dao를 통해 db에 있는 bno가 1인 데이터를 dto에 저장
		//dto의 bno가 1과 같으면 true
		BoardDto boardDto = boardDao.select(1);
		System.out.println("boardDto= " + boardDto);
		assertTrue(boardDto.getBno().equals(1));
		
		//모두 지우고 dto에 새 데이터 넣기
		//bno 1번이 지워지고 새로 입력되었으니 bno가 2이면 True
		boardDao.deleteAll();
		boardDto = new BoardDto("Pioneering", "Ready for Action", "ezen" );
		boardDao.insert(boardDto);
		
		boardDto = boardDao.select(2);
		System.out.println("boardDto= " + boardDto);
		assertTrue(boardDto.getBno().equals(2));
		
		
	}
	@Test 	//전부 지우고 새 데이터 10개(for문) 넣기
	public void selectPageTest() throws Exception{
		boardDao.deleteAll();
		
		for(int i =1; i <=10; i++) {
			BoardDto boardDto = new BoardDto("Pioneering"+i, "헐 취업준비"+i, "kim");
			boardDao.insert(boardDto);
			
		}
		
		Map map = new HashMap();
		map.put("offset", 0);
		map.put("pageSize", 3);
		
		List<BoardDto> list= boardDao.selectPage(map);
		assertTrue(list.get(0).getTitle().equals("Pioneering10"));
//		assertTrue(list.get(1).getTitle().equals("Pioneering9"));
//		assertTrue(list.get(9).getTitle().equals("Pioneering1"));
		
		for(BoardDto bd : list) {
			System.out.println(bd);
		}
	}
	
	

	
}
