package com.apex.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("error")
public class ErrorController {
	
	@GetMapping
	public String showError() {
		return "error";
	}

}
