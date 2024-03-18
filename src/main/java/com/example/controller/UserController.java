package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.UserDtls;
import com.example.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/")
	public String home()
	{
		return "index";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute UserDtls u,HttpSession session)
	{
		
		
		repo.save(u);
		session.setAttribute("message", "User Register Sucessfully...");
		
		return "redirect:/";
	}

}
