package com.lesson.memo.controller;

import java.time.LocalDateTime;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lesson.memo.model.Admin;
import com.lesson.memo.repository.AdminRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/signin")
	public String signin(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "admin-login";
	}
	
	
	@GetMapping("/signup")
	public String signup(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "admin-signup";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute @Valid Admin admin,
            BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "admin-signup";
		}
		
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		admin.setCreatedAt(LocalDateTime.now());
		admin.setUpdatedAt(LocalDateTime.now());
		adminRepository.save(admin);
		
		return "redirect:/admin/signin";
	}
	
}
