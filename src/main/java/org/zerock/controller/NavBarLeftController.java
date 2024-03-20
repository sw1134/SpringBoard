package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/navbarleft/*")
@AllArgsConstructor
public class NavBarLeftController {
	@GetMapping("/dashboard")
	public String dashboard() {
		return "/navbarleft/dashboard";
	}
	
	@GetMapping("/flot")
	   public String flot() {
	      return "/navbarleft/flot";
	   }
	   
	   @GetMapping("/table")
	   public String table() {
	      return "/navbarleft/table";
	   }
	   
	   @GetMapping("/forms")
	   public String forms() {
	      return "/navbarleft/forms";
	   }
	   
	   @GetMapping("/panelswells")
	   public String panelswells() {
	      return "/navbarleft/panelswells";
	   }
	   
	   @GetMapping("/multi")
	   public String multi() {
	      return "/navbarleft/multi";
	   }
	   
	   @GetMapping("/blank")
	   public String blank() {
	      return "/navbarleft/blank";
	   }
	   }