package com.example.tech.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController {

	@ResponseBody
	String error(HttpServletRequest request) {
		return "<h1>Error occurred</h1>";
	}

	public String getErrorPath() {
		return "/error";
	}

}
