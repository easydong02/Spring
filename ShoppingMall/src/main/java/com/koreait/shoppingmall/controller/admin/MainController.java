/**
 * 
 */
package com.koreait.shoppingmall.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.shoppingmall.model.category.CategoryService;
import com.koreait.shoppingmall.model.product.ProductService;

@Controller
public class MainController {
	//공통 로직인 서비스 보유
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public ModelAndView getMain() {
		//카테고리 가져오기
		List categoryList = categoryService.selectAll(); //카테고리 가져오기
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoryList",categoryList);
		
		mav.setViewName("admin/index");
		
		return mav;
	}
}
