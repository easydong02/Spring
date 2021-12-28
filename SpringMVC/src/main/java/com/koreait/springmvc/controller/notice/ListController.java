package com.koreait.springmvc.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc.model.service.notice.NoticeService;

public class ListController implements Controller {
	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계: 일시키기
		List noticeList= noticeService.selectAll();
		
		//4단계: 저장할 것이 있기 때문에 저장
		ModelAndView mav= new ModelAndView();
		mav.addObject("noticeList",noticeList);
		mav.setViewName("notice/list");  // /notice/list.jsp
		return mav;
	}

}
