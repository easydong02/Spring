package com.koreait.shoppingmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//관리자 인증과 관련된 요청을 처리하는 하위 컨트롤러
@Controller
public class AdminController {
	
	//로그인 폼 요청 처리
	@GetMapping("/login/form")
	public String getLoginForm() {
		return "admin/login/loginForm";
	}

}
