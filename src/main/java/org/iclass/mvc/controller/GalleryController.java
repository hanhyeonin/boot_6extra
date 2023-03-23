package org.iclass.mvc.controller;

import org.iclass.mvc.dto.Gallery;
import org.iclass.mvc.service.GalleryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GalleryController {
	
	// 의존성 주입 : 필드주입은 사용x
	private GalleryService service;
	// @Autowired 생략(생성자주입)
	public GalleryController(GalleryService service) {
		this.service=service;
	}

	@GetMapping("/gallery")
	public void gallery() {		// 화면 : 파일명은 gallery.html
		
	}
	
	@PostMapping("/gallery")
	public String save(Gallery vo) {		// gallery.html 에서 받아오는 파라미터는 Gallery 객체로 넘어옴.
		int count = service.save(vo);
		return "redirect:gallery";
	}
}
