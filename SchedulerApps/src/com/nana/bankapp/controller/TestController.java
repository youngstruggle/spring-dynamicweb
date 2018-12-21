package com.nana.bankapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value = { "", "/index", "index*", "view/*" })
	public String testRequestMapping() {
		return "testRequestMapping";
	}

	@RequestMapping(value = "/name")
	public String methodWithParams(
			@RequestParam(value = "userName", required = false, defaultValue = "Guest") String userName, Model model) {
		System.out.println("Page requested by " + userName);

		model.addAttribute("userName", userName);
		return "testRequestMapping";
	}

	@RequestMapping(value = "/dynamic/{categor:[a-z]+}/{userName}")
	public String dynamicUrl(@PathVariable("userName") String userName) {
		return "testRequestMapping";
	}

	@RequestMapping("*")
	public String fallBackPage() {
		System.out.println("fallback in");
		return "fileNotFound";
	}

}
