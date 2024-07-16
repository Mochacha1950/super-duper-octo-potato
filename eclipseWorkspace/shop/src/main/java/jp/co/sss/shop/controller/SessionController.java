package jp.co.sss.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jp.co.sss.shop.form.LoginForm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

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
	
	@RequestMapping(path = "/loginUsingForm", method = RequestMethod.GET)
	public String loginUsingForm() {
		return "session/loginUsingForm";
	}
	
	@RequestMapping(path = "/doLoginUsingForm", method = RequestMethod.POST)
	public String doLoginUsingForm(LoginForm form) {
		System.out.println("ユーザーID"+form.getUserId());
		System.out.println("ユーザーパスワード"+form.getUserPassword());
		return "session/loginUsingForm";
	}
	
	
	@RequestMapping(path = "/loginOnRequest", method = RequestMethod.GET)
	public String loginOnRequest() {
		return "session/loginOnRequest";
	}
	
	@RequestMapping(path = "/doLoginOnRequest", method = RequestMethod.POST)
	public String doLoginOnRequest(LoginForm form, Model model) {
		//TODO: process POST request
		model.addAttribute("userId", form.getUserId());
		return "session/loginOnRequest";
	}
	
	
	
	
}	
