package com.alan.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegController {
	@RequestMapping("/reg")
	public String reg(){
		return "reg";
	}
}
