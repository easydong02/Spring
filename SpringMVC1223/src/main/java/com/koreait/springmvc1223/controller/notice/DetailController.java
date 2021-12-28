package com.koreait.springmvc1223.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc1223.domain.Notice;
import com.koreait.springmvc1223.model.service.notice.NoticeService;

//상세보기 요청을 처리하는 하위 컨트롤러
public class DetailController implements Controller{
	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계: 일시키기
		int notice_id = Integer.parseInt(request.getParameter("notice_id"));
		Notice notice =noticeService.select(notice_id);
		
		//4단계: 리스트 저장
		ModelAndView mav = new ModelAndView();
		mav.addObject("notice",notice);
		mav.setViewName("notice/detail");
		
		return mav;
	}

}
