package com.koreait.mvc1223.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.mvc1223.domain.Board;
import com.koreait.mvc1223.exception.BoardException;
import com.koreait.mvc1223.model.board.BoardService;
import com.koreait.mvc1223.util.Pager;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private Pager pager;
	
	//목록 요청
	@RequestMapping(value="/board/list",method=RequestMethod.GET)
	public ModelAndView getList(HttpServletRequest request) {
		List boardList = boardService.selectAll();
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("boardList",boardList);
		pager.init(boardList, request);
		mav.addObject("pager",pager);
		return mav;
	}
	
	//등록폼
	@RequestMapping(value="/board/write",method=RequestMethod.GET)
	public String registForm() {
		return "board/write";
	}
	
	
	
	//게시물 등록
	@RequestMapping(value="/board/regist",method=RequestMethod.POST)
	public String insert(Board board) {
		boardService.insert(board);
		
		return "redirect:/board/list";
	}
	
	
	//한건 가져오기
	@RequestMapping(value="/board/detail",method=RequestMethod.GET)
	public ModelAndView select(int board_id) {
		Board board =boardService.select(board_id);
		
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board",board);
		return mav;
	}
	
	
	//수정요청
	
	//삭제요청
	
	//답변폼
	@RequestMapping(value="/reply/form" ,method =RequestMethod.POST)
	public ModelAndView replyForm(Board board){
		//답변 제목, 답변 작성자, 답변내용, 내가 본 글의 team,step,depth
		ModelAndView mav = new ModelAndView("board/reply");
		mav.addObject("board",board);
		return mav;
	}
	
	//답변등록
	@RequestMapping(value="/reply/regist" ,method =RequestMethod.POST)
	public String reply(Board board){
		//답변 제목, 답변 작성자, 답변내용, 내가 본 글의 team,step,depth
		boardService.reply(board);//3단계
		System.out.println("내본글 team" + board.getTeam());
		System.out.println("내본글 step" + board.getStep());
		System.out.println("내본글 depth" + board.getDepth());
		return "redirect:/board/list";
	}
	
	//예외처리
	@ExceptionHandler(BoardException.class)
	public ModelAndView handle(BoardException e) {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("e",e);
		return mav;
	}
	
}
