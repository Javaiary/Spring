package kr.co.heart.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.heart.dao.BoardDao;
import kr.co.heart.domain.BoardDto;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDao boardDao;

	@Override
	public List<BoardDto> getPage(Map map) throws Exception {
		//(select)
		return boardDao.selectPage(map);
	}

	@Override
	public int getcount() throws Exception {
		//(select)
		return boardDao.count();
	}

	@Override
	public BoardDto read(Integer bno) throws Exception {
		//게시글 조회 (select문)
		BoardDto boardDto = boardDao.select(bno);
		
		//비즈니스 로직 추가 (조회수 증가)
		boardDao.increaseViewCnt(bno);
		
		return boardDto;
	}
}
