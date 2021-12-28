/**
 * 
 */
package com.koreait.shoppingmall.controller.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.shoppingmall.model.product.ProductService;


/* 쇼핑몰 메인의 요청을 처리하는 하위 컨트롤러*/
@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public ModelAndView getMain() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/index");
		
		
		return mav;
	}
}
