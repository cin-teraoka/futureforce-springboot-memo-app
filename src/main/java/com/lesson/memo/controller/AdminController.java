package com.lesson.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lesson.memo.repository.AdminRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@PostMapping("/signin")
	public String signin() {
		return "";
	}
	
	@PostMapping("/signup")
	public String signup() {
		
		return "";
	}	
	
}
