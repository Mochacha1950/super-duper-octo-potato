package jp.co.sss.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import jp.co.sss.shop.form.LoginForm;
import jp.co.sss.shop.form.LoginFormWithAnnotation;
import jp.co.sss.shop.form.LoginFormWithValidation;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


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
	
	@RequestMapping(path = "/loginOnSession", method = RequestMethod.GET)
	public String loginOnSession() {
		return "session/loginOnSession";
	}
	
	@RequestMapping(path = "/doLoginOnSession", method = RequestMethod.POST)
	public String doLoginOnSession(LoginForm form, HttpSession session) {
		if(form.getUserId()==123) {
			//入力したユーザIDをセッション属性userIdとしてセッションスコープに保存
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
		} else {
			return "session/loginOnSession";
		}
	}
	
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		//セッションの破棄
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(path = "/loginWithValidation", method = RequestMethod.GET)
	public String loginWithValidation(@ModelAttribute LoginFormWithValidation form) {
		return "session/loginWithValidation";
	}
	
	@RequestMapping(path = "/loginWithValidation", method = RequestMethod.POST)
	public String doLoginWithValidation(@Valid @ModelAttribute LoginFormWithValidation form, BindingResult result, HttpSession session){
		if(result.hasErrors()) {
			return "/session/loginWithValidation";
		}
		
		if(form.getUserId() == 123) {
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
			
		} else {
			return "/session/loginWithValidation";
		}
		
	}
	
	@RequestMapping(path = "/loginWithAnnotation" , method = RequestMethod.GET)
	public String loginWithAnnotation(@ModelAttribute LoginFormWithAnnotation form) {
		return "session/loginWithAnnotation";
	}
	
	@RequestMapping(path = "/loginWithAnnotation" , method = RequestMethod.POST)
	public String doLoginWithAnnotation(@Valid @ModelAttribute LoginFormWithAnnotation form, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "session/loginWithAnnotation";
		}
		
		if(form.getUserId() == 123) {
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
		} else {
			return "session/loginWithAnnotation";
		}
		
	}
	
}	
