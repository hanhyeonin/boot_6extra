package org.iclass.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	// session 값 저장을 위해서 테스트용 로그인
	@GetMapping("/login")	// 실행은 http://localhost:8084/login?id=momo99
	public String login(String id, HttpSession session) {	// 정상적으로는 PostMapping 에서 합니다
		if(id!=null)
			session.setAttribute("id", id);		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
