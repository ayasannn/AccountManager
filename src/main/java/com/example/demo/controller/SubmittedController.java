package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class SubmittedController {
	@GetMapping("login")
	public String showView() {
		return "login";
	}
}
