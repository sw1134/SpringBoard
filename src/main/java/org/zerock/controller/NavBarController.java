package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/navbar/*")
@Log4j
public class NavBarController {
	@GetMapping("/mail")
	public String mail() {
		log.info("메일시작");
		return "/navbar/mail";
	}
	@GetMapping("/task")
	public String task() {
		return "/navbar/task";
	}
	@GetMapping("/alarm")
	public String alarm() {
      return "/navbar/alarm";
	}
	@GetMapping("/login")
	public String login() {
      return "navbar/login";
	}
	@GetMapping("/loginSetting")
	public String loginSetting() {
      return "navbar/loginSetting";
	}

}//end
