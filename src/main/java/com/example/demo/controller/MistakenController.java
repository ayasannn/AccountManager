package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MistakenController {
	@GetMapping("AccountManager")
	public String loginView() {
		return "login";
	}
	@GetMapping("newmember")
	public String showView() {
		return "register";
	}
}
