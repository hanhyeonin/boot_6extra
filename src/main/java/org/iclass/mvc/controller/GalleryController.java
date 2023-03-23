package org.iclass.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GalleryController {

	@GetMapping("/gallery")
	public void gallery() {		// 화면 : 파일명은 gallery.html
		
	}
	
	@PostMapping("/gallery")
	public String save() {		// 저장
		
		return "redirect:gallery";
	}
}
