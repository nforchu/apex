package com.apex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	/*@Autowired
	AuthenticationProvider authProvider;*/
	

    @GetMapping("login")
    public String form(Model model) {
    	System.out.println("there");
        return "welcome";
    }
	
    @PostMapping("doLogin")
	public String authenticate(Model model) {
		System.out.println("processing");
        return "redirect:/category/list";
    }
}
