package jp.co.sss.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class SessionController {
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		return "session/login";
	}
	
	@RequestMapping(path = "/doLogin", method = RequestMethod.GET)
	public String doLoginGet(Integer userId) {
		System.out.println("ユーザーID:" + userId);
		return "session/login";
	}
	
	@PostMapping("/doLogin")
	public String doLoginPost(Integer userId, String userPassword) {
		//TODO: process POST request
		System.out.println("ユーザーID:" + userId);
		System.out.println("ユーザーPASSWORD:" + userPassword);
		return "session/login";
	}
	
}	
