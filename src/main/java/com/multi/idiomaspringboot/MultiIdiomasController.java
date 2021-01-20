package com.multi.idiomaspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MultiIdiomasController {

	@GetMapping("/template")
	public String template() {
		return "template";
	}
	@GetMapping("/template2")
	public String template2() {
		return "template2";
	}
	
}
