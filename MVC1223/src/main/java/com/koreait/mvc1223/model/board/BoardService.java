package com.koreait.mvc1223.model.board;

import java.util.List;

import com.koreait.mvc1223.domain.Board;

public interface BoardService {
	public List selectAll();
	public Board select(int board_id);
	public void insert(Board board);
	public void update(Board board);
	public void delete(int board_id);
	
	//답변관련
	public void reply(Board board); //답변등록 추상화(스텝+등록)
}
