package com.prashant.SpringSecurity.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping("/")
	public String main() {
		return "Success!!";
	}
}
