package com.koreait.springmvc1223.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//테스트 요청을 처리하는 컨트롤러 
public class TestController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계: 일시킨다
		//4단계: 결과가 있다면 결과저장
		
		//Model: 결과데이터를 담는 객체, view: 결과뷰페이지 졍보를 가진객체
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg","스프링에서 담은 정보"); // = request.setAttribute()
		mav.setViewName("main/result");
		
		//디폴트가 forward이며,
		return mav;
	}

}
