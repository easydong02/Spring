package com.koreait.mvc1223.model.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.mvc1223.domain.Board;
import com.koreait.mvc1223.exception.BoardException;

@Repository
public class MybatisBoardDAO implements BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	

	@Override
	public List selectAll() {
		
		return sessionTemplate.selectList("Board.selectAll");
	}

	@Override
	public Board select(int board_id) {
		
		return sessionTemplate.selectOne("Board.select",board_id);
	}

	@Override
	public void insert(Board board) {
		int result = sessionTemplate.insert("Board.insert",board);
		if(result==0) {
			throw new BoardException("글 등록 실패");
		}
	}

	@Override
	public void update(Board board)  {
		int result = sessionTemplate.update("Board.update",board);
		if(result==0) {
			throw new BoardException("글 수정 실패");
		}
	}

	@Override
	public void delete(int board_id) {
		int result = sessionTemplate.delete("Board.delete",board_id);
		if(result==0) {
			throw new BoardException("글 삭제 실패");
		}
	}

	@Override
	public void updateStep(Board board) throws BoardException {
		int result= sessionTemplate.update("Board.updateStep",board);
	}
 
	@Override
	public void replyInsert(Board board) {
		int result = sessionTemplate.insert("Board.replyInsert",board);
		if(result==0) {
			throw new BoardException("답변 게시판 등록 실패");
		}
	}

}
