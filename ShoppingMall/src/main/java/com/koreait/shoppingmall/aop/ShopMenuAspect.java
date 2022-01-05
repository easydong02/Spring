package com.koreait.shoppingmall.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.shoppingmall.model.category.CategoryService;

public class ShopMenuAspect {
	@Autowired
	private CategoryService categoryService;	
	
	//내가 원하는 처리...
	public Object getCategoryList( ProceedingJoinPoint joinPoint) throws Throwable {
		
		Class target= joinPoint.getTarget().getClass(); //어떤 클래스에 요청을 하려고 했는지...
		//컨트롤러에 요청객체가 있는지 여부를 판단해보자!!
		Object[] args= joinPoint.getArgs();//지금 이 요청을 처리하는 메서드의 매개변수들을 추출 
		
		HttpServletRequest resquest=null;//무언가를 담기 위한 요청객체
		
		System.out.println("너가 요청을 하려던 클래스는 "+ target.getName());
		
		for(Object arg : args) {
			
			if(arg instanceof HttpServletRequest) {
				resquest=(HttpServletRequest)arg;
			}
			System.out.println("너가 호출하는 메서드의 매개변수는 "+ arg);
		}
		
		//공통 로직 호출
		List categoryList = categoryService.selectAll();
		
		//원래의 요청을 그대로 진행을 시키자~
		Object returnObj= joinPoint.proceed();//즉 본래의 메소드 호출진행
		ModelAndView mav =null;
		//리턴값이 ModelAndView일 때 결과를 심어버리겠음..
		if(returnObj instanceof ModelAndView) {
			mav = (ModelAndView)returnObj;
			mav.addObject("categoryList",categoryList);
		}
		
		
		//저장
		
		
		return mav;
	}
}
